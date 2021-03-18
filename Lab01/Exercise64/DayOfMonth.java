package Exercise64;

import java.util.Scanner;

public class DayOfMonth {
    
    public static void main(String[] args) {
        
        String[] months = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
                        "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December",
                        "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec",
                        "Jan.", "Feb.", "Mar.", "Apr.", "May.", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."};
        int[] commonYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] leapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        Scanner scan = new Scanner(System.in);
        

        boolean validInput = false;
        while (!(validInput)) {

            System.out.print("Input a month followed by a year: ");
            String mon = scan.next();
            int year = scan.nextInt();

            

            int indexMonth;
            for (indexMonth = 0; indexMonth < 48; indexMonth ++) {
                if (months[indexMonth].equals(mon)) {
                    break;
                }  
            }
            if (indexMonth < 48 && year > 0) {
                validInput = true;
                indexMonth %= 12;

                if (!(year % 400 == 0) && (year % 100 == 0) && !(year % 4 == 0)) {
                    System.out.println(commonYear[indexMonth]);
                }
                else {
                    System.out.println(leapYear[indexMonth]);
                }
            }
        }
    }
        
}