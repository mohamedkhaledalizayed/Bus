package bus.itgds.khadametdz.model;

public class ModelFragBusTicket {
    private String ticketStation;
    private String ticketSourceName;
    private String ticketDestinationName;
    private String ticketPrice;
    private String ticketStatus;
    private String ticketColor;

    public ModelFragBusTicket(String ticketStation,String ticketSourceName, String ticketDestinationName, String ticketPrice, String ticketStatus,String ticketColor) {
        this.ticketStation=ticketStation;
        this.ticketSourceName = ticketSourceName;
        this.ticketDestinationName = ticketDestinationName;
        this.ticketPrice = ticketPrice;
        this.ticketStatus = ticketStatus;
        this.ticketColor=ticketColor;
    }

    public String getTicketStation() {
        return ticketStation;
    }

    public void setTicketStation(String ticketStation) {
        this.ticketStation = ticketStation;
    }

    public String getTicketColor() {
        return ticketColor;
    }

    public void setTicketColor(String ticketColor) {
        this.ticketColor = ticketColor;
    }

    public String getTicketSourceName() {
        return ticketSourceName;
    }

    public void setTicketSourceName(String ticketSourceName) {
        this.ticketSourceName = ticketSourceName;
    }

    public String getTicketDestinationName() {
        return ticketDestinationName;
    }

    public void setTicketDestinationName(String ticketDestinationName) {
        this.ticketDestinationName = ticketDestinationName;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
