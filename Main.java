import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
public class Main {
        public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Voyage V = new Voyage();
        try (ObjectOutputStream fos = new ObjectOutputStream(new FileOutputStream("voyage.ser"))){
            fos.writeObject(V.clients);
            fos.writeObject(V.reservations);
} catch(IOException e){
    e.printStackTrace();
}
       int exit=0;     
        do {
               switch (menu()) {
            case 1:
                V.add();          
                Thread.sleep(2000);
                System.out.println("Added.");
                Thread.sleep(1000);
                break;  
            case 2: 
                V.remove();
                Thread.sleep(2000);
                System.out.println("Removed.");
                Thread.sleep(1000);
                break;
            case 3: 
                V.display();               
                Thread.sleep(1000);
                System.out.print("Do you want to return back to the menu [YES|NO] ? ");
                String ch = sc.next();
                if (ch.equalsIgnoreCase("NO")) 
                    System.exit(1);
                else 
                break;
            case 4: 
                System.exit(1);
                exit=1;
                break;
        }
        } while (exit==0);
     
        } 
    
    public static int menu(){
            Scanner sc = new Scanner(System.in);
            System.out.println("\033[H\033\033[2J");
            System.out.println(" ---------------| Welcome to JAVAGENCE |---------------- ");
            System.out.println("| Add a reservation  ................................ 1 |");
            System.out.println("| Remove a reservation .............................. 2 |");
            System.out.println("| Display a reservation info ........................ 3 |");
            System.out.println("| Quit .............................................. 4 |");
            System.out.println(" ------------------------------------------------------- ");
            System.out.print("Choose your operation : ");
            int choice = sc.nextInt();
            return choice;
        }
    }
