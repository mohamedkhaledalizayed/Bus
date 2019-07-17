package bus.itgds.khadametdz.model;

public class ModelBusDetail {
    private String busSourceName;
    private String busDestinationName;
    private String busTimeFrom;
    private String busTimeTo;
    private String busPrice;

    public ModelBusDetail(String busSourceName, String busDestinationName, String busTimeFrom, String busTimeTo, String busPrice) {
        this.busSourceName = busSourceName;
        this.busDestinationName = busDestinationName;
        this.busTimeFrom = busTimeFrom;
        this.busTimeTo = busTimeTo;
        this.busPrice = busPrice;
    }

    public String getBusSourceName() {
        return busSourceName;
    }

    public void setBusSourceName(String busSourceName) {
        this.busSourceName = busSourceName;
    }

    public String getBusDestinationName() {
        return busDestinationName;
    }

    public void setBusDestinationName(String busDestinationName) {
        this.busDestinationName = busDestinationName;
    }

    public String getBusTimeFrom() {
        return busTimeFrom;
    }

    public void setBusTimeFrom(String busTimeFrom) {
        this.busTimeFrom = busTimeFrom;
    }

    public String getBusTimeTo() {
        return busTimeTo;
    }

    public void setBusTimeTo(String busTimeTo) {
        this.busTimeTo = busTimeTo;
    }

    public String getBusPrice() {
        return busPrice;
    }

    public void setBusPrice(String busPrice) {
        this.busPrice = busPrice;
    }
}
