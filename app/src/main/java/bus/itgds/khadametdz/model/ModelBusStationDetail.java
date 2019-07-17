package bus.itgds.khadametdz.model;

public class ModelBusStationDetail {
    private String busStationNumber;
    private String busStationNames;
    private Double busStationLatitude;
    private Double busStationLongitude;

    public ModelBusStationDetail(String busStationNumber, String busStationNames, Double busStationLatitude, Double busStationLongitude) {
        this.busStationNumber = busStationNumber;
        this.busStationNames = busStationNames;
        this.busStationLatitude = busStationLatitude;
        this.busStationLongitude = busStationLongitude;
    }

    public String getBusStationNumber() {
        return busStationNumber;
    }

    public void setBusStationNumber(String busStationNumber) {
        this.busStationNumber = busStationNumber;
    }

    public String getBusStationNames() {
        return busStationNames;
    }

    public void setBusStationNames(String busStationNames) {
        this.busStationNames = busStationNames;
    }

    public Double getBusStationLatitude() {
        return busStationLatitude;
    }

    public void setBusStationLatitude(Double busStationLatitude) {
        this.busStationLatitude = busStationLatitude;
    }

    public Double getBusStationLongitude() {
        return busStationLongitude;
    }

    public void setBusStationLongitude(Double busStationLongitude) {
        this.busStationLongitude = busStationLongitude;
    }
}
