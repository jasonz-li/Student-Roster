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
                else{
                    System.out.println("Command '" + input + "' not supported!");
                }
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
        if (command.hasMoreTokens() == false){
            System.out.println("Missing data in command line.");
        }
        else {
            String name = command.nextToken();
            String major = command.nextToken();
            if (input.equals("R")) {
                Student target = roster.findStudent(name, major);
                if (target != null) {
                    roster.remove(target);
                    System.out.println("Student removed from the roster.");
                } else {
                    System.out.println("Student not in the roster.");
                }
            } else if (input.equals("S")) { // set abroad status me
                if (command.hasMoreTokens() == false) {
                    System.out.println("Missing data in command line.");
                }
                else {
                    if (roster.findStudent(name, major) != null) {
                        boolean bool = Boolean.parseBoolean(command.nextToken());
                        International.class.cast(roster.findStudent(name, major)).studyingAbroad = bool;
                        if (International.class.cast(roster.findStudent(name, major)).getCreditHours() > 12
                            && International.class.cast(roster.findStudent(name, major)).studyingAbroad == true) {
                            roster.findStudent(name, major).setCreditHours(0);
                            roster.findStudent(name, major).getDate().setDateCleared(true);
                            roster.findStudent(name, major).tuitionDue();
                            System.out.println("Tuition updated.");
                        }
                    }
                    else {
                        System.out.println("Couldn't find international student.");
                    }
                }

            }

            else if (input.equals("F")) { // set financial aid

            }

            else if (input.equals("T")) { // pay tuition

            }
        }
    }


    private void calculate(Roster roster){ // ???????????
        for (int i = 0; i < roster.getSize(); i++){
            roster.getRoster()[i].tuitionDue();
        }
        System.out.println("Calculation completed.");
    }
}

