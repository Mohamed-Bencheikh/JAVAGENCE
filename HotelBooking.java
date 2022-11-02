import java.io.Serializable;
import java.util.Random;

public class HotelBooking implements Serializable{
    // Attributes:
    private int room_number;
    private Date start;
    private Date end;
    private int num_nights;
    private RoomType rtype;
    protected boolean smoking; 
    private double roomPrice;
    private boolean[] is_room_reserved = new boolean[99];
    // Hotel Constructor:
    public HotelBooking(int nn,RoomType rt,boolean sm) {
        this.num_nights = nn;
        this.rtype = rt;
        this.smoking = sm;
    }
    // Setting number of nights:
    // public void setNbrNights() {
    //     num_nights = (end.getYear()*365 + end.getMonth()*30 + end.getDay()) - (start.getYear()*365 + start.getMonth()*30 + start.getDay());
    // }
    // Getting free room number:
    public int getRoom(int a,int b){
        int rn;
        do {
            rn = new Random().nextInt(a,b);
        } while (is_room_reserved[rn]); 
        is_room_reserved[rn] = true;
        return rn;
    }
    // Setting room:
    public void setRoom() {
        switch (rtype) {
            case SINGLE:
                roomPrice = 150;
                room_number = getRoom(1,34);             
                break;
            case DOUBLE: 
                roomPrice = 200;
                room_number = getRoom(34,67);
                break;
            case FAMILY: 
                roomPrice = 300;
                room_number = getRoom(67,99);
                break;
        }
    }
    public int getNbrNights(){
        return num_nights;}
    public double getRoomPrice() {
        return roomPrice;
    }
    public void showRoomInfo(){
        System.out.println("N° Room : "+room_number);
        System.out.println("Room Type : "+rtype);
        System.out.println("number of nights : "+num_nights);
    }
    
}