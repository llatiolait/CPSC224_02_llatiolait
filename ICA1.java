import java.util.Scanner;

public class ConvertDistance {
    public static double meters;

    public static void main(String[] args) {
        System.out.println("Enter a distance in meters");
        Scanner scnr = new Scanner(System.in);
        meters = scnr.nextDouble();
        menu();
    }

    public static void menu() {
        System.out.println("1. Convert to kilometers");
        System.out.println("2. Convert to inches");
        System.out.println("3. Convert to feet");
        System.out.println("4. Quit program");
        System.out.println("Enter your choice:");
        Scanner scnr = new Scanner(System.in);
        int choice = scnr.nextInt();
        double returnV;
        while (choice != 4) {

            if (choice == 1) {
                returnV = Kilometers(meters);
                System.out.println(meters + " in kilometers is " + returnV);
            }
            if (choice == 2) {
                returnV = Inches(meters);
                System.out.println(meters + " in inches is " + returnV);
            }
            if (choice == 1) {
                returnV = Feet(meters);
                System.out.println(meters + " in feet is " + returnV);
            }
            menu();
        }
        scnr.close();
    }

    public static double Kilometers(double meters) {
        return (meters * 0.001);
    }

    public static double Inches(double meters) {
        return (meters * 39.37);
    }

    public static double Feet(double meters) {
        return (meters * 3.281);
    }

}