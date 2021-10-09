import java.util.StringTokenizer;
import java.util.Scanner;

public class TuitionManager {
    public void run(){
        System.out.println("Tuition manager starts running.");
        Scanner scanner = new Scanner(System.in);
        Roster collection = new Roster();
        while (true){
            String cmdInput = scanner.nextLine();
            if (cmdInput.equals("") != true) {
                StringTokenizer command = new StringTokenizer(cmdInput);
                String input = command.nextToken(",");
                if (input.equals("Q")) {
                    System.out.println("Collection Manager terminated.");
                    break;
                }
                else if (input.equals("P") || input.equals("PD") || input.equals("PG")) {
                    handlePrint(input, collection);
                }
                else if(input.equals("A")){
                    handleA(command, collection);

                }
                else if (input.equals("L") || input.equals("R") || input.equals("D")){
                    handleLRD(input, command, collection);
                }
                else {
                    System.out.println("Invalid command!");
                }
            }
            else {
                System.out.println("Invalid command!");
            }
        }
        scanner.close();
    }

    }
}
