package Assignment_2;

import java.util.Scanner;

public class AP_assignment2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //menu driven starts from here
        char choice = 'y';
        while(choice == 'y'){
            genInstr();
            int ch = s.nextInt();
            switch (ch) {
                case 1: // -->> As INSTRUCTOR
                    char Choice = 'y';
                    while (Choice == 'y') {
                        instrMenu();
                        int Ch = s.nextInt();
                        switch (Ch) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                break;
                            case 8:
                                break;
                            case 9:
                                Choice = 'n';
                                break;
                        }
                    }
                    break;
                case 2: // -->> As STUDENT
                char CHoice = 'y';
                while (CHoice == 'y') {
                    instrMenu();
                    int Ch = s.nextInt();
                    switch (Ch) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        case 7:
                            CHoice = 'n';
                            break;
                    }
                }
                    break;
                case 3: // -->> Exit
                    choice = 'n';
                    break;
            }
        }
        
    }

    public static void genInstr() {
        System.out.println("Welcome to BackPack");
        System.out.println("1. Enter as Instructor");
        System.out.println("1. Enter as Student");
        System.out.println("3. Exit");
    }

    public static void instrMenu() {
        System.out.println("1. Add Class Material");
        System.out.println("2. Add Assessments");
        System.out.println("3. View Lecture Material");
        System.out.println("4. View Assessments");
        System.out.println("5. Grade Assessments");
        System.out.println("6. Close Assessments");
        System.out.println("7. View Comments");
        System.out.println("8. Add Comments");
        System.out.println("9. Logout");
    }
    public static void stdMenu() {
        System.out.println("1. View Lecture Materials");
        System.out.println("2. View Assessments");
        System.out.println("3. Submit Assessments");
        System.out.println("4. View Grades");
        System.out.println("5. View Comments");
        System.out.println("6. Add Comments");
        System.out.println("7. Logout");
    }
}
