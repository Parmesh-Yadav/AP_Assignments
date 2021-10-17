package Assignment_2;

import java.util.ArrayList;
import java.util.Scanner;

interface User {
    void viewLectureNotes(ArrayList<LectureMaterial> lectureMaterials);

    void assessments();

    void viewComments();

    void addComments();
}

interface LectureMaterial {
    void addMaterial();

    void viewMaterial();
}

interface Assessments {
    void closeAssessment();
}

interface Submission {
    void checkStatus();

    void getMarkRecieved();
}

class Instructor implements User {
    static int noOfInstr = 0;
    int instrID;
    String instrName;

    public Instructor(String instrName) {
        this.instrName = instrName;
        this.instrID = noOfInstr++;
    }

    @Override
    public void viewLectureNotes(ArrayList<LectureMaterial> lectureMaterials) {
        for(LectureMaterial lm: lectureMaterials){
            lm.viewMaterial();
            System.out.println();
        }

    }

    @Override
    public void assessments() {
        // TODO Auto-generated method stub

    }

    @Override
    public void viewComments() {
        // TODO Auto-generated method stub

    }

    @Override
    public void addComments() {
        // TODO Auto-generated method stub

    }

    public static void printInstructors(ArrayList<Instructor> instructors) {
        for (int i = 0; i < instructors.size(); i++) {
            System.out.println(instructors.get(i).instrID + ". " + instructors.get(i).instrName);
        }
    }

}

class Student implements User {
    static int noOfStd = 0;
    int stdID;
    String stdName;

    public Student(String stdName) {
        this.stdName = stdName;
        this.stdID = noOfStd++;
    }

    @Override
    public void viewLectureNotes(ArrayList<LectureMaterial> lectureMaterials) {
        for(LectureMaterial lm: lectureMaterials){
            lm.viewMaterial();
            System.out.println();
        }

    }

    @Override
    public void assessments() {
        // TODO Auto-generated method stub

    }

    @Override
    public void viewComments() {
        // TODO Auto-generated method stub

    }

    @Override
    public void addComments() {
        // TODO Auto-generated method stub

    }

    public static void printStudents(ArrayList<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).stdID + ". " + students.get(i).stdName);
        }
    }

}

class LectureSlides implements LectureMaterial {
    String sName;
    int noOfSlides;
    ArrayList<String> sContent = new ArrayList<>();
    Instructor I;
    // date time left

    public LectureSlides(String sName, int noOfSlides, Instructor I) {
        this.sName = sName;
        this.noOfSlides = noOfSlides;
        this.I = I;
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < noOfSlides; i++) {
            System.out.println("Content of slide " + (i + 1));
            String content = s.nextLine();
            this.sContent.add(content);
        }
    }

    @Override
    public void addMaterial() {
        // TODO Auto-generated method stub

    }

    @Override
    public void viewMaterial() {
        System.out.println("Title: "+this.sName);
        for(int i=0;i<this.sContent.size();i++){
            System.out.println("Slide "+(i+1)+": "+this.sContent.get(i));
        }
        System.out.println("Number of slides: "+this.noOfSlides);
        //date time here
        System.out.println("Uploaded by: "+this.I.instrName);

    }

}

class LectureVideos implements LectureMaterial {
    String vName; 
    String fileName;// -->> with extension .mp4
    Instructor I;
    //date time left

    public LectureVideos(String vName,String fileName,Instructor I){
        this.vName = vName;
        this.fileName = fileName;
        this.I = I;
    }

    @Override
    public void addMaterial() {
        // TODO Auto-generated method stub

    }

    @Override
    public void viewMaterial() {
        System.out.println("Title of video: "+this.vName);
        System.out.println("Video File: "+this.fileName);
        //date time here
        System.out.println("Uploaded by: "+this.I.instrName);

    }

}

class Assignments implements Assessments {
    String pStatement;
    int maxMarks;
    char status;

    @Override
    public void closeAssessment() {
        // TODO Auto-generated method stub

    }

}

class Quizzes implements Assessments {
    String question;
    int maxMarks;// -->> by default 1. {polymorphism}
    char status;

    @Override
    public void closeAssessment() {
        // TODO Auto-generated method stub

    }

}

class Asubmissions implements Submission {
    String filename; // -->> filename with extension .zip

    @Override
    public void checkStatus() {
        // TODO Auto-generated method stub

    }

    @Override
    public void getMarkRecieved() {
        // TODO Auto-generated method stub

    }
}

class Qsubmission implements Submission {
    String oneWord; // -->> oneword solution to the question.

    @Override
    public void checkStatus() {
        // TODO Auto-generated method stub

    }

    @Override
    public void getMarkRecieved() {
        // TODO Auto-generated method stub

    }
}

public class AP_assignment2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // dummy instructors
        Instructor I0 = new Instructor("I0");
        Instructor I1 = new Instructor("I1");
        ArrayList<Instructor> instructors = new ArrayList<>();
        instructors.add(I0);
        instructors.add(I1);
        // dummy students
        Student S0 = new Student("S0");
        Student S1 = new Student("S1");
        Student S2 = new Student("S2");
        ArrayList<Student> students = new ArrayList<>();
        students.add(S0);
        students.add(S1);
        students.add(S2);
        // ds for lecture materials
        ArrayList<LectureMaterial> lectureMaterials = new ArrayList<>();
        // menu driven starts from here
        char choice = 'y';
        while (choice == 'y') {
            genInstr();
            int ch = s.nextInt(); s.nextLine();
            switch (ch) {
                case 1: // -->> As INSTRUCTOR
                    Instructor.printInstructors(instructors);
                    System.out.println("Choose ID");
                    int ID = s.nextInt(); s.nextLine();
                    
                    // Instructor I;
                    char Choice = 'y';
                    while (Choice == 'y') {
                        System.out.println("Welcome " + instructors.get(ID).instrName);
                        instrMenu();
                        int Ch = s.nextInt(); s.nextLine();
                        switch (Ch) {
                            case 1:// -->> Add Class Material
                                clsMatChoice();
                                int cH = s.nextInt(); s.nextLine();
                                switch (cH) {
                                    case 1:
                                        System.out.println("Enter Topic of Slides:");
                                        String stopic = s.nextLine();
                                        System.out.println("Enter number of slides: ");
                                        int nos = s.nextInt(); s.nextLine();
                                        lectureMaterials.add(new LectureSlides(stopic, nos, instructors.get(ID)));
                                        break;
                                    case 2:
                                        System.out.println("Enter Topic of Video: ");
                                        String vtopic = s.nextLine();
                                        System.out.println("Enter Filename of Video: ");
                                        String vFilename = s.nextLine();
                                        lectureMaterials.add(new LectureVideos(vtopic, vFilename, instructors.get(ID)));
                                        break;
                                }
                                break;
                            case 2:// -->> Add Assessments
                                break;
                            case 3:// -->> View Lecture Materials
                                instructors.get(ID).viewLectureNotes(lectureMaterials);
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
                    Student.printStudents(students);
                    System.out.println("Choose ID");
                    int Id = s.nextInt(); s.nextLine();
                    char CHoice = 'y';
                    while (CHoice == 'y') {
                        System.out.println("Welcome " + students.get(Id).stdName);
                        stdMenu();
                        int Ch = s.nextInt(); s.nextLine();
                        switch (Ch) {
                            case 1:// -->> View lecture materials
                                students.get(Id).viewLectureNotes(lectureMaterials);
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
        }

    }

    public static void genInstr() {
        System.out.println("Welcome to BackPack");
        System.out.println("1. Enter as Instructor");
        System.out.println("2. Enter as Student");
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

    public static void clsMatChoice() {
        System.out.println("1. Add Lecture Slide");
        System.out.println("2. Add Lecture Video");
    }
}
