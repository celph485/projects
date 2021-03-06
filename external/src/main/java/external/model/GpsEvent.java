package external.model;

public class GpsEvent {
    private String imeiNo;
    private String lattitude;
    private String longitude;
    private String speed;
    private String time;
    private String batteryVoltage;

    public String getImeiNo() {
        return imeiNo;
    }

    public void setImeiNo(String imeiNo) {
        this.imeiNo = imeiNo;
    }

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(String batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("GpsEvent [imeiNo=");
        builder.append(imeiNo);
        builder.append(", lattitude=");
        builder.append(lattitude);
        builder.append(", longitude=");
        builder.append(longitude);
        builder.append(", speed=");
        builder.append(speed);
        builder.append(", time=");
        builder.append(time);
        builder.append(", batteryVoltage=");
        builder.append(batteryVoltage);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GpsEvent gpsEvent = (GpsEvent) o;

        if (!imeiNo.equals(gpsEvent.imeiNo)) return false;
        if (!lattitude.equals(gpsEvent.lattitude)) return false;
        if (!longitude.equals(gpsEvent.longitude)) return false;
        if (!speed.equals(gpsEvent.speed)) return false;
        if (!time.equals(gpsEvent.time)) return false;
        return batteryVoltage.equals(gpsEvent.batteryVoltage);
    }

    @Override
    public int hashCode() {
        int result = imeiNo.hashCode();
        result = 31 * result + lattitude.hashCode();
        result = 31 * result + longitude.hashCode();
        result = 31 * result + speed.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + batteryVoltage.hashCode();
        return result;
    }
}
