import java.util.Scanner;
/**
 * Project 2 -- TimeKeeper
 *
 * This project is about lab management application.
 * It will track lab reservations for three labs
 * to help the CS department allocate space effectively.
 *
 * @author Advit Bhullar, lab L-24
 *
 * @version October 14, 2021
 *
 */
public class TimeKeeper {

    private static String welcomePrompt = "Welcome to the TimeKeeper application!";
    private static String invalidInput = "Invalid input. Please try again.";
    private static String enterLabCapacity = "Enter the capacity for Lab ";
    private static String enterLabLocation = "Enter the location for Lab ";
    private static String labLocationPrompt = "Enter the location of the lab:";
    private static String reservationTimePrompt = "Enter the time of the reservation:";
    private static String reservationNamePrompt = "Enter the name of the reservation:";
    private static String reservationEnrollmentPrompt = "Enter the expected enrollment:";
    private static String reservationNameUpdate = "Enter the updated name of the reservation:";
    private static String reservationEnrollmentUpdate = "Enter the updated enrollment:";
    private static String totalCapacity = "Total Capacity: ";
    private static String totalUtilization = "Total Utilization: ";
    private static String availableSeats = "Available seats: ";


    private static String initializeMenu = "1. Initialize Application\n" +
            "2. Exit";
    private static String ongoingMenu = "1. View Current Lab Schedule\n" +
            "2. List Labs by Availability\n" +
            "3. List Labs by Reservation\n" +
            "4. Add a Reservation\n" +
            "5. Remove a Reservation\n" +
            "6. Modify a Reservation\n" +
            "7. Calculate Statistics\n" +
            "8. Exit";
    private static String statisticsMenu = "1. Total Capacity\n" +
            "2. Total Utilization\n" +
            "3. Available seats\n" +
            "4. Return to main menu";
    private static String exitMessage = "Thank you for using TimeKeeper!";


    public static void main(String[] args) {
        int selectedOption1;
        int selectedOption2;
        int selectedOption3;
        int lab1Capacity;
        String lab1Location;
        int lab2Capacity;
        String lab2Location;
        int lab3Capacity;
        String lab3Location;
        String labLocation;
        String labTime;
        String labName;
        int labEnrollment;

        Scanner scan = new Scanner(System.in);
        System.out.println(welcomePrompt);
        do {
            System.out.println(initializeMenu);
            selectedOption1 = scan.nextInt();
            scan.nextLine();
            if (selectedOption1 != 1 && selectedOption1 != 2)
                System.out.println(invalidInput);
            if (selectedOption1 == 2) {
                break;
            }
        } while(selectedOption1 != 1 && selectedOption1 != 2);
        if (selectedOption1 == 1) {
            System.out.println(enterLabCapacity + "1:");
            lab1Capacity = scan.nextInt();
            scan.nextLine();
            System.out.println(enterLabLocation + "1:");
            lab1Location = scan.nextLine();
            System.out.println(enterLabCapacity + "2:");
            lab2Capacity = scan.nextInt();
            scan.nextLine();
            System.out.println(enterLabLocation + "2:");
            lab2Location = scan.nextLine();
            System.out.println(enterLabCapacity + "3:");
            lab3Capacity = scan.nextInt();
            scan.nextLine();
            System.out.println(enterLabLocation + "3:");
            lab3Location = scan.nextLine();
            Lab lab1 = new Lab(lab1Capacity, lab1Location);
            Lab lab2 = new Lab(lab2Capacity, lab2Location);
            Lab lab3 = new Lab(lab3Capacity, lab3Location);
            LabManager l = new LabManager(lab1, lab2, lab3);
            do {
                System.out.println(ongoingMenu);
                selectedOption2 = scan.nextInt();
                scan.nextLine();
                if (selectedOption2 == 1) {
                    System.out.printf(lab1.toString() + "\n" + lab2.toString() + "\n" + lab3.toString() + "\n");
                } else if (selectedOption2 == 2) {
                    System.out.println(l.listAvailableLabs());
                } else if (selectedOption2 == 3) {
                    System.out.println(l.listReservedLabs());
                } else if (selectedOption2 == 4) {
                    System.out.println(labLocationPrompt);
                    labLocation = scan.nextLine();
                    System.out.println(reservationTimePrompt);
                    labTime = scan.nextLine();
                    System.out.println(reservationNamePrompt);
                    labName = scan.nextLine();
                    System.out.println(reservationEnrollmentPrompt);
                    labEnrollment = scan.nextInt();
                    scan.nextLine();
                    String s = l.addReservation(labLocation, labTime, labName, labEnrollment);
                    System.out.println(s);
                } else if (selectedOption2 == 5) {
                    System.out.println(labLocationPrompt);
                    labLocation = scan.nextLine();
                    System.out.println(reservationTimePrompt);
                    labTime = scan.nextLine();
                    String s = l.removeReservation(labLocation, labTime);
                    System.out.println(s);
                } else if (selectedOption2 == 6) {
                    System.out.println(labLocationPrompt);
                    labLocation = scan.nextLine();
                    System.out.println(reservationTimePrompt);
                    labTime = scan.nextLine();
                    System.out.println(reservationNameUpdate);
                    labName = scan.nextLine();
                    System.out.println(reservationEnrollmentUpdate);
                    labEnrollment = scan.nextInt();
                    scan.nextLine();
                    String s = l.modifyReservation(labLocation, labTime, labName, labEnrollment);
                    if (s.equals("Reservation modified!")) {
                        System.out.println("Reservation updated!");
                    } else
                        System.out.println((l.modifyReservation(labLocation, labTime, labName, labEnrollment)));
                } else if (selectedOption2 == 7) {
                    do {
                        System.out.println(statisticsMenu);
                        selectedOption3 = scan.nextInt();
                        scan.nextLine();
                        if (selectedOption3 == 1) {
                            System.out.println(totalCapacity + l.calculateTotalCapacity());
                        } else if (selectedOption3 == 2) {
                            System.out.printf(totalUtilization + "%.2f\n", l.calculateTotalUtilization());
                        } else if (selectedOption3 == 3) {
                            System.out.println(availableSeats + l.calculateAvailableSeats());
                        } else if (selectedOption3 == 4) {
                            continue;
                        } else {
                            System.out.println(invalidInput);
                        }
                    } while(selectedOption3 != 4);
                } else if (selectedOption2 == 8) {
                    break;
                } else {
                    System.out.println(invalidInput);
                }


            } while(selectedOption2 != 8);
        }
        System.out.println(exitMessage);
    }


}