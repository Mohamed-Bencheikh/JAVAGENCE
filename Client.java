import java.io.Serializable;
import java.util.ArrayList;
public class Client implements Serializable{
    // Attributes:
    private String name;
    private String address;
    private long id;
    protected ArrayList<Stay> res = new ArrayList<>() ;

    // Constructor:
    public Client(Long id,String n,String a){
        this.id = id;
        this.name = n;
        this.address = a;
    }
    // Name setter & getter:
    public String getName(){return name;}
    public void setName(String n){this.name = n;}

    // Address setter & getter:
    public String getAddr(){return address;}
    public void setAddr(String a){this.address = a;}

    // Id setter & getter:
    public long getId(){return id;}
    public void setId(int id){this.id = id;}

    // Displaying Client Info:
    public void showClientInfo() {
        System.out.println("----------------------------------");
        System.out.println("           Client Info            ");
        System.out.println("----------------------------------");
        System.out.println("Client id: "+id);
        System.out.println("Name:"+name);
        System.out.println("Address: "+address); 
        System.out.println("Reservations : "+res.size());
        double total_price = 0;
        for (Stay stay : res) {
            total_price += stay.calculatePrice(); 
        }
        System.out.println("Total Price: "+total_price+" DHs");
        int i=0;
        for (Stay stay : res) {
            System.out.println("-------reservation n°"+(i+1)+"------");
            stay.showStayInfo();
            i++ ;
        }       
    }

}