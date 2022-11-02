import java.io.Serializable;

public class Stay implements Serializable {
    // Attributes:
    private static long res_id = 0;
    protected Date start;
    protected Date end;
    protected TicketPlane ticket;
    protected HotelBooking reserveHotel;
    // Stay Constructor:
    public Stay(Date s,Date e) {
        ++res_id;
        this.start = s;
        this.end = e;
    }
    // get reservation id:
    public long getResId(){ return res_id ; }
    // Method calculatePrice:
    public double calculatePrice(){
        double price = reserveHotel.getRoomPrice()*reserveHotel.getNbrNights() + ticket.getTicketPrice();
        if (reserveHotel.smoking) price += 50 ;
        return price;
    }
    // Displaying reservation info:
    public void showStayInfo() {
        System.out.println("Reservation id: "+ res_id); 
        System.out.println("Start date: "+start); 
        System.out.println("End date: "+end);
        System.out.println("Price: "+calculatePrice()+" DHs");
        reserveHotel.showRoomInfo();
    }
}