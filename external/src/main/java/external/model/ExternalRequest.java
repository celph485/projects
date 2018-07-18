package external.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalRequest {
    private String imeiNo;
    private String lattitude;
    private String longitude;
    private String lattitudeDirection;
    private String longitudeDirection;
    private String speed;
    private String digitalPort1;
    private String digitalPort2;
    private String digitalPort3;
    private String digitalPort4;
    private String analogPort1;
    private String analogPort2;
    private String angle;
    private String satellite;
    private String time;
    private String batteryVoltage;
    private String gpsValidity;

    public ExternalRequest(){}

    public ExternalRequest(String imeiNo,
                           String lattitude,
                           String longitude,
                           String lattitudeDirection,
                           String longitudeDirection,
                           String speed,
                           String digitalPort1,
                           String digitalPort2,
                           String digitalPort3,
                           String digitalPort4,
                           String analogPort1,
                           String analogPort2,
                           String angle,
                           String satellite,
                           String time,
                           String batteryVoltage,
                           String gpsValidity) {
        this.imeiNo = imeiNo;
        this.lattitude = lattitude;
        this.longitude = longitude;
        this.lattitudeDirection = lattitudeDirection;
        this.longitudeDirection = longitudeDirection;
        this.speed = speed;
        this.digitalPort1 = digitalPort1;
        this.digitalPort2 = digitalPort2;
        this.digitalPort3 = digitalPort3;
        this.digitalPort4 = digitalPort4;
        this.analogPort1 = analogPort1;
        this.analogPort2 = analogPort2;
        this.angle = angle;
        this.satellite = satellite;
        this.time = time;
        this.batteryVoltage = batteryVoltage;
        this.gpsValidity = gpsValidity;
    }

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

    public String getLattitudeDirection() {
        return lattitudeDirection;
    }

    public void setLattitudeDirection(String lattitudeDirection) {
        this.lattitudeDirection = lattitudeDirection;
    }

    public String getLongitudeDirection() {
        return longitudeDirection;
    }

    public void setLongitudeDirection(String longitudeDirection) {
        this.longitudeDirection = longitudeDirection;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDigitalPort1() {
        return digitalPort1;
    }

    public void setDigitalPort1(String digitalPort1) {
        this.digitalPort1 = digitalPort1;
    }

    public String getDigitalPort2() {
        return digitalPort2;
    }

    public void setDigitalPort2(String digitalPort2) {
        this.digitalPort2 = digitalPort2;
    }

    public String getDigitalPort3() {
        return digitalPort3;
    }

    public void setDigitalPort3(String digitalPort3) {
        this.digitalPort3 = digitalPort3;
    }

    public String getDigitalPort4() {
        return digitalPort4;
    }

    public void setDigitalPort4(String digitalPort4) {
        this.digitalPort4 = digitalPort4;
    }

    public String getAnalogPort1() {
        return analogPort1;
    }

    public void setAnalogPort1(String analogPort1) {
        this.analogPort1 = analogPort1;
    }

    public String getAnalogPort2() {
        return analogPort2;
    }

    public void setAnalogPort2(String analogPort2) {
        this.analogPort2 = analogPort2;
    }

    public String getAngle() {
        return angle;
    }

    public void setAngle(String angle) {
        this.angle = angle;
    }

    public String getSatellite() {
        return satellite;
    }

    public void setSatellite(String satellite) {
        this.satellite = satellite;
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

    public String getGpsValidity() {
        return gpsValidity;
    }

    public void setGpsValidity(String gpsValidity) {
        this.gpsValidity = gpsValidity;
    }

    @Override
    public String toString() {
        return "ExternalRequest{" +
                "imeiNo='" + imeiNo + '\'' +
                ", lattitude='" + lattitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", lattitudeDirection='" + lattitudeDirection + '\'' +
                ", longitudeDirection='" + longitudeDirection + '\'' +
                ", speed='" + speed + '\'' +
                ", digitalPort1='" + digitalPort1 + '\'' +
                ", digitalPort2='" + digitalPort2 + '\'' +
                ", digitalPort3='" + digitalPort3 + '\'' +
                ", digitalPort4='" + digitalPort4 + '\'' +
                ", analogPort1='" + analogPort1 + '\'' +
                ", analogPort2='" + analogPort2 + '\'' +
                ", angle='" + angle + '\'' +
                ", satellite='" + satellite + '\'' +
                ", time='" + time + '\'' +
                ", batteryVoltage='" + batteryVoltage + '\'' +
                ", gpsValidity='" + gpsValidity + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExternalRequest request = (ExternalRequest) o;

        if (!imeiNo.equals(request.imeiNo)) return false;
        if (!lattitude.equals(request.lattitude)) return false;
        if (!longitude.equals(request.longitude)) return false;
        if (!lattitudeDirection.equals(request.lattitudeDirection)) return false;
        if (!longitudeDirection.equals(request.longitudeDirection)) return false;
        if (!speed.equals(request.speed)) return false;
        if (!digitalPort1.equals(request.digitalPort1)) return false;
        if (!digitalPort2.equals(request.digitalPort2)) return false;
        if (!digitalPort3.equals(request.digitalPort3)) return false;
        if (!digitalPort4.equals(request.digitalPort4)) return false;
        if (!analogPort1.equals(request.analogPort1)) return false;
        if (!analogPort2.equals(request.analogPort2)) return false;
        if (!angle.equals(request.angle)) return false;
        if (!satellite.equals(request.satellite)) return false;
        if (!time.equals(request.time)) return false;
        if (!batteryVoltage.equals(request.batteryVoltage)) return false;
        return gpsValidity.equals(request.gpsValidity);
    }

    @Override
    public int hashCode() {
        int result = imeiNo.hashCode();
        result = 31 * result + lattitude.hashCode();
        result = 31 * result + longitude.hashCode();
        result = 31 * result + lattitudeDirection.hashCode();
        result = 31 * result + longitudeDirection.hashCode();
        result = 31 * result + speed.hashCode();
        result = 31 * result + digitalPort1.hashCode();
        result = 31 * result + digitalPort2.hashCode();
        result = 31 * result + digitalPort3.hashCode();
        result = 31 * result + digitalPort4.hashCode();
        result = 31 * result + analogPort1.hashCode();
        result = 31 * result + analogPort2.hashCode();
        result = 31 * result + angle.hashCode();
        result = 31 * result + satellite.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + batteryVoltage.hashCode();
        result = 31 * result + gpsValidity.hashCode();
        return result;
    }
}
