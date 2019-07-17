package bus.itgds.khadametdz.view.activity;

public class Seat{
    int seatNumber;
    boolean isSelected;
    boolean isBooked;

    public Seat(int seatNumber, boolean isSelected, boolean isBooked) {
        this.seatNumber = seatNumber;
        this.isSelected = isSelected;
        this.isBooked = isBooked;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
