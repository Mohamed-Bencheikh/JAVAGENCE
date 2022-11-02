import java.io.Serializable;
import java.util.Scanner;
import java.util.Vector;
public class Voyage implements Serializable{
    protected Vector<Stay> reservations = new Vector<>(); 
    protected Vector<Client> clients = new Vector<>();
    Scanner sc = new Scanner(System.in);
    // Adding a client|reservation:   
    public void add(){
        Client C = null;
        while(C == null){ 
        System.out.print("New client  [1]      client already existed  [2]  ");
        int ch = sc.nextInt();
        if (ch == 1){
            System.out.println("----------------------------------");
            System.out.println("       Enter client data          ");
            System.out.println("----------------------------------");
            System.out.print("Identifiant : ");
            long id = sc.nextLong();
            System.out.print("Name : ");
            String name = sc.next();
            System.out.print("Address :");
            String addr = sc.next();
            clients.addElement(C = new Client(id, name, addr));
        }
        else if (ch == 2){  
          C = checkClient();
        }
        // Stay info getting:
        System.out.println("---------------------------------");
        System.out.println("    Reservation registration     ");
        System.out.println("---------------------------------");
        System.out.print("start date: ");
        int ds = sc.nextInt();
        int ms = sc.nextInt();
        int ys = sc.nextInt();
        System.out.print("End date  : ");
        int de = sc.nextInt();
        int me = sc.nextInt();
        int ye = sc.nextInt();
        // Adding Stay info to Stay's and Client's objects: 
        Stay newRes = new Stay(new Date(ds, ms, ys), new Date(de, me, ye));
        reservations.addElement(newRes);
        C.res.add(newRes);
        //  Hotel info getting:
        System.out.println("----------------------------------");
        System.out.println("    Hotel Booking registration    ");
        System.out.println("----------------------------------");
        System.out.println("Number of nights: ");
        int nn = sc.nextInt();
        System.out.print("Room type [Single | Double | Family] ");
        String rt = sc.next().toUpperCase();
        System.out.print("Do the client smoke  [True | False] ? ");
        String sm = sc.next().toLowerCase();
        boolean smoke = (sm == "true") ? true:false; 
        // Saving hotel info in HotelBooking object:
        newRes.reserveHotel = new HotelBooking(nn,RoomType.valueOf(rt) , smoke);
        newRes.reserveHotel.setRoom();
        // newRes.reserveHotel.setNbrNights();
        // Plane ticket info getting:
        System.out.println("----------------------------------");
        System.out.println("     Plane ticket registration    ");
        System.out.println("----------------------------------");
        newRes.ticket = new TicketPlane();  
        newRes.ticket.setTicketPrice();
        System.out.print("Ticket reference : ");
        String pt = sc.next(); 
        // Saving ticket reference:
        newRes.ticket.setReference(pt);
    }          
        }
    // Display Info:
    public void display(){
        System.out.print("Client Info  [1]      Reservation Info  [2] ");
        int ch = sc.nextInt();
        if (ch == 1) {
            Client cl = checkClient();
            cl.showClientInfo();
        } 
        else if (ch == 2){
            Stay st = checkStay();    
        System.out.println("----------------------------------");
        System.out.println("         Reservation Info         ");
        System.out.println("----------------------------------");
            st.showStayInfo();
        } 
    } 
    // Deleting an existing reservation:
    public void remove(){      
        System.out.println("Remove Client   [1]      Remove Reservation  [2]");
        int ch = sc.nextInt();
        if(ch == 1){
            Client C = checkClient();
            clients.remove(C);
        } 
        else if (ch == 2) {
            Stay S = checkStay();
            reservations.remove(S);
        }
    }
    // Checking for Client existence:
    public Client checkClient(){
        Client C = null ;
        do {
            System.out.print("Enter client id : ");
            long id = sc.nextLong();
            for (Client client : clients) {
            if(client.getId() == id) 
                C =  client;
            else {
                System.out.println("Client not found!");
                C = null ;
            }             
        } 
        } while (C == null);      
        return C;
    }    
    // Checking for Reservation existence:
    public Stay checkStay(){
        Stay S = null;
        do {
            System.out.print("Enter reservation id : ");
            long id = sc.nextLong();
            for (Stay reserv : reservations) {
                if (reserv.getResId() == id) {
                    S = reserv;                    
                } else {
                   System.out.println("Reservation not found!");
                   S = null; 
                }
            }
        } while (S == null);
        return S;
    }
}

    
