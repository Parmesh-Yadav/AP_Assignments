package Assignment_2;

import java.util.Scanner;

interface User{

}

interface LectureMaterial{

}

interface Assessments{

}

class Instructor implements User {

}

class Student implements User{

}

class LectureSlides implements LectureMaterial{

}

class LectureVideos implements LectureMaterial{

}

class Assignments implements Assessments{

}

class Quizzes implements Assessments{
    
}

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
                            case 1:// -->> Add Class Material
                                break;
                            case 2:// -->> Add Assessments
                                break;
                            case 3:// -->> View Lecture Materials
                                break;
                            case 4:// -->> View Assessments
                                break;
                            case 5:// -->> Grade Assessments
                                break;
                            case 6:// -->> Close Assessments
                                break;
                            case 7:// -->> View Comments
                                break;
                            case 8:// -->> Add comments
                                break;
                            case 9:// -->> Logout
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
                        case 1:// -->> View lecture materials
                            break;
                        case 2:// -->> View assessments
                            break;
                        case 3:// -->> Submit assessments
                            break;
                        case 4:// -->> View grades
                            break;
                        case 5:// -->> View comments
                            break;
                        case 6:// -->> Add comments
                            break;
                        case 7:// -->> Logout
                            CHoice = 'n';
                            break;
                    }
                }
                    break;
                case 3: // -->> Exit
                    choice = 'n';
                    break;
            }
        s.close();
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
