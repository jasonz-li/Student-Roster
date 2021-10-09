import java.util.StringTokenizer;
import java.util.Scanner;

public class TuitionManager {
    public void run(){
        System.out.println("Tuition manager starts running.");
        Scanner scanner = new Scanner(System.in);
        Roster roster = new Roster();
        while (true){
            String cmdInput = scanner.nextLine();
            if (cmdInput.equals("") != true) {
                StringTokenizer command = new StringTokenizer(cmdInput);
                String input = command.nextToken(",");
                if (input.equals("Q")) {
                    System.out.println("Tuition Manager terminated.");
                    break;
                } else if (input.equals("P") || input.equals("PN") || input.equals("PT")) {
                    handlePrint(input, roster);
                } else if (input.equals("AR") || input.equals("AN") || input.equals("AT") || input.equals("AI")) {
                    handleAdd(command, roster);

                } else if (input.equals("R") || input.equals("S") || input.equals("F") || input.equals("T")) {
                    handleRSFT(input, command, roster);
                }
                else if (input.equals("C")){
                    calculate(roster);
                }
                System.out.println("Command '" + input + "' not supported!");
            }
            else{
                ; // do nothing if no input
            }
        }
        scanner.close();
    }

    private void handlePrint(String input, Roster roster){

    }

    private void handleAdd(StringTokenizer command, Roster roster){

    }

    private void handleRSFT(String input, StringTokenizer command, Roster roster){

    }

    private void calculate(Roster roster){ // ???????????

    }
}

