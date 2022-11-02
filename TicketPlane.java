import java.io.Serializable;
import java.util.Formatter;
import java.util.Scanner;
public class TicketPlane implements Serializable{
    private String reference;
    private  double ticket_price;
    // ticket reference setter & getter:
    public void setReference(String ref) {reference = ref;}    
    public String getReference() { return reference; }

    // ticket price getter & setter:
    public double getTicketPrice(){ return ticket_price;}
    public void setTicketPrice(){
        Scanner sc = new Scanner(System.in);
        String[][] fly = { 
         {"1","Agadir -> Paris","9800"},
         {"2","Fes -> Marseille","9000"},
         {"3","Marrakech -> Bruxelle","10000"},
         {"4","Tangier -> Madrid","4550"},
         {"5","Laayoune -> Rabat","700"},
         {"6","Casablanca -> Miami","45000"},
         {"7","Oujda -> Lisbonne","7000"},
         {"8","Rabat -> Dubai","30000"},
         {"9","Agadir -> Yaoundi","2300"},
         {"10","Marrakech -> Dakhla","600"}

};
        Formatter format = new Formatter();
        format.format("\n%3s | %12s | %8s %s","N°","      fly        ","price","\n.....................................\n");
        for (int i = 0; i < fly.length; i++) {
            format.format("%3s %20s %8s\n", fly[i][0],fly[i][1],fly[i][2]);
        }        
        format.format("...................................."); 
        System.out.println(format);
        int ch;
        do {   
            System.out.print("Choose n° fly: ");
            ch = sc.nextInt();
        } while (ch <= 0 || ch > fly.length);
        for (int i = 0; i < fly.length; i++) {
            if(ch == Double.valueOf(fly[i][0]))
             ticket_price = Double.valueOf(fly[i][2]);
        }
        }
    }
