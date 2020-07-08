from config_file import config, mapping_config
from log_config import LogConfig
import stomp
import time
import requests

log = LogConfig(__name__).get_logger()

log.info('Starting application {}'.format(config['APP_NAME']))
log.debug('Listing all the config variables.')
for key in config:
    log.debug('{} = {}'.format(key, config[key]))


HOST_AND_PORTS = [(config['MQ_HOST'], config['MQ_PORT'])]
QUEUE = config['MQ_DESTINATION']


def can_send_data_out(message):
    msg_dict = eval(message)
    imei = msg_dict['imei_no']
    return imei in mapping_config.values()


def send_data_to_ws(message):
    log.info('Sending data to API: {}'.format(message))
    resp = requests.post(config['TARGET_WS_URL'], data=message)
    log.info('response from API: {}'.format(resp.text))


class SampleListener(stomp.ConnectionListener):
    def __init__(self, conn):
        self.conn = conn

    def on_error(self, frame):
        log.error('received an error "%s"' % frame.body)

    def on_message(self, headers, message):
        log.info('received a message \n %s' % message)

    def on_disconnected(self):
        log.warn('MQ disconnected')
        conn.connect(config['MQ_USER'], config['MQ_PASS'], wait=True)
        conn.subscribe(destination=config['MQ_DESTINATION'], id=1, ack='auto')


conn = stomp.Connection(host_and_ports=HOST_AND_PORTS, heartbeats=(4000, 4000))
conn.set_listener('SampleListener', SampleListener(conn))
conn.connect(config['MQ_USER'], config['MQ_PASS'], wait=True)
conn.subscribe(destination=config['MQ_DESTINATION'], id=1, ack='auto')
time.sleep(60)
conn.disconnect()
