import com.cwgl.society;
import java.io.IOException;
import java.util.Scanner; 


public class ground {
	
    public static void main(String[] args)  throws IOException, InterruptedException {

        Scanner uinput = new Scanner(System.in);
		
        long started  = System.currentTimeMillis();
        long run_at = started;
        long capture;

        System.out.println("Conway's Game of Life");
        System.out.println("____________________");

        System.out.print("Enter X dim: ");
        int field_x_dimention = uinput.nextInt();
        System.out.print("Enter Y dim: ");
        int field_y_dimention = uinput.nextInt();
        System.out.print("Enter init pop: ");
        int init_pop          = uinput.nextInt();
        System.out.print("Enter rendering time (millisecond): ");
        int timestep          = uinput.nextInt();

        society pt = new society(field_x_dimention,field_y_dimention,init_pop);
        pt.printSociety();

        while(true){
            capture = System.currentTimeMillis();
            if(capture - run_at > timestep){
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Conway's Game of Life: " + run_at);
				System.out.println("____________________");
                pt.evolve();
                pt.printSociety();
                run_at = capture;
            }
        }
		
    }
}
