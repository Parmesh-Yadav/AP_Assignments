package Assignment_2;

import java.util.ArrayList;
import java.util.Scanner;

interface User {
    void viewLectureNotes(ArrayList<LectureMaterial> lectureMaterials);

    void viewAssessments(ArrayList<Assessments> assessments);

    void viewComments();

    void addComments();
}

interface LectureMaterial {
    void addMaterial();

    void viewMaterial();
}

interface Assessments {
    // char type = 'A';
    void closeAssessment(Instructor cI);

    void viewAssessment();

    boolean checkStd(String stdName);

    void doAssessment(Student S);

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
        for (LectureMaterial lm : lectureMaterials) {
            lm.viewMaterial();
            System.out.println();
        }

    }

    @Override
    public void viewAssessments(ArrayList<Assessments> assessments) {
        for (int i = 0; i < assessments.size(); i++) {
            System.out.print("ID: " + (i) + " ");
            assessments.get(i).viewAssessment();
            System.out.println("--------------------");
        }

    }

    public void closeAssessments(ArrayList<Assessments> oAssessments, ArrayList<Assessments> cAssessments,
            Instructor cI) {
        Scanner s = new Scanner(System.in);
        System.out.println("List of Open Assessments: ");
        viewAssessments(oAssessments);
        System.out.println("Enter ID of Assignment to close: ");
        int ID = s.nextInt();
        oAssessments.get(ID).closeAssessment(cI);
        cAssessments.add(oAssessments.get(ID));
        oAssessments.remove(ID);

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
        for (LectureMaterial lm : lectureMaterials) {
            lm.viewMaterial();
            System.out.println();
        }

    }

    @Override
    public void viewAssessments(ArrayList<Assessments> assessments) {
        for (int i = 0; i < assessments.size(); i++) {
            System.out.print("ID: " + (i) + " ");
            assessments.get(i).viewAssessment();
            System.out.println("--------------------");
        }

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

    public boolean submitAssessment(ArrayList<Assessments> oAssessments, Assignments A, Quizzes Q) {
        boolean check = false;
        System.out.println("List of open & pending assignments -->>");
        for (int i = 0; i < oAssessments.size(); i++) {
            if (oAssessments.get(i).getClass().equals(A.getClass())) {
                if (!oAssessments.get(i).checkStd(this.stdName)) {
                    System.out.print("ID: " + (i) + " ");
                    oAssessments.get(i).viewAssessment();
                    System.out.println("--------------------");
                    check = true;
                }
            } else if (oAssessments.get(i).getClass().equals(Q.getClass())) {
                if (!oAssessments.get(i).checkStd(this.stdName)) {
                    System.out.print("ID: " + (i) + " ");
                    oAssessments.get(i).viewAssessment();
                    System.out.println("--------------------");
                    check = true;
                }
            }
        }
        return check;
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
        System.out.println("Title: " + this.sName);
        for (int i = 0; i < this.sContent.size(); i++) {
            System.out.println("Slide " + (i + 1) + ": " + this.sContent.get(i));
        }
        System.out.println("Number of slides: " + this.noOfSlides);
        // date time here
        System.out.println("Uploaded by: " + this.I.instrName);

    }

}

class LectureVideos implements LectureMaterial {
    String vName;
    String fileName;// -->> with extension .mp4
    Instructor I;
    // date time left

    public LectureVideos(String vName, String fileName, Instructor I) {
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
        System.out.println("Title of video: " + this.vName);
        System.out.println("Video File: " + this.fileName);
        // date time here
        System.out.println("Uploaded by: " + this.I.instrName);

    }

}

class Assignments implements Assessments {
    String pStatement;
    int maxMarks;
    char status;
    Instructor aI;
    Instructor cI;
    Instructor gI;
    ArrayList<Student> stdAssDone = new ArrayList<>();
    ArrayList<Asubmissions> stdWrkDone = new ArrayList<>();
    // final static char type = 'A';

    public Assignments(String pStatement, int maxMarks, Instructor aI) {
        this.pStatement = pStatement;
        this.maxMarks = maxMarks;
        this.status = 'O';
        this.aI = aI;
    }

    @Override
    public void closeAssessment(Instructor cI) {
        this.status = 'C';
        this.cI = cI;
    }

    @Override
    public void viewAssessment() {
        System.out.println("Assignment: " + this.pStatement + " Max Marks: " + this.maxMarks);

    }

    @Override
    public boolean checkStd(String stdName) {
        for (Student S : this.stdAssDone) {
            if (S.stdName == stdName) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void doAssessment(Student S) {
        Scanner s = new Scanner(System.in);
        System.out.println(this.pStatement);
        String ans = s.nextLine(); //-->> check if its in .zip format only
        stdAssDone.add(S);
        stdWrkDone.add(new Asubmissions(ans));
        
    }

}

class Quizzes implements Assessments {
    String question;
    int maxMarks;// -->> by default 1. {polymorphism} {method overloading}
    char status;
    Instructor aI;
    Instructor cI;
    Instructor gI;
    ArrayList<Student> stdQuizDone = new ArrayList<>();
    ArrayList<Qsubmission> stdWrkDone = new ArrayList<>();
    // final static char type = 'Q';

    public Quizzes(String question, int maxMarks, Instructor aI) {
        this.question = question;
        this.maxMarks = maxMarks;
        this.status = 'O';
        this.aI = aI;
    }

    public Quizzes(String question, Instructor aI) {
        this.question = question;
        this.maxMarks = 1;
        this.status = 'O';
        this.aI = aI;
    }

    @Override
    public void closeAssessment(Instructor cI) {
        this.cI = cI;
        this.status = 'C';

    }

    @Override
    public void viewAssessment() {
        System.out.println("Question: " + this.question);

    }

    @Override
    public boolean checkStd(String stdName) {
        for (Student S : this.stdQuizDone) {
            if (S.stdName == stdName) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void doAssessment(Student S) {
        Scanner s = new Scanner(System.in);
        System.out.println(this.question);
        String ans = s.next(); //-->> One Word Answer
        stdQuizDone.add(S);
        stdWrkDone.add(new Qsubmission(ans));
        
    }

}

class Asubmissions implements Submission {
    String filename; // -->> filename with extension .zip

    public Asubmissions(String filename) {
        this.filename = filename;
    }

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

    public Qsubmission(String oneWord) {
        this.oneWord = oneWord;
    }

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
        // ds for assessments
        ArrayList<Assessments> oAssessments = new ArrayList<>();
        ArrayList<Assessments> cAssessments = new ArrayList<>();
        Assignments A = new Assignments("Dummt", 0, new Instructor("Dummy"));
        Quizzes Q = new Quizzes("Dummy", 0, new Instructor("Dummy"));
        // ArrayList<Assignments> oAssignments = new ArrayList<>();
        // ArrayList<Quizzes> oQuizzes = new ArrayList<>();
        // menu driven starts from here
        char choice = 'y';
        while (choice == 'y') {
            genInstr();
            int ch = s.nextInt();
            s.nextLine();
            switch (ch) {
                case 1: // -->> As INSTRUCTOR
                    Instructor.printInstructors(instructors);
                    System.out.println("Choose ID");
                    int ID = s.nextInt();
                    s.nextLine();
                    char Choice = 'y';
                    while (Choice == 'y') {
                        System.out.println("Welcome " + instructors.get(ID).instrName);
                        instrMenu();
                        int Ch = s.nextInt();
                        s.nextLine();
                        switch (Ch) {
                            case 1:// -->> Add Class Material
                                clsMatChoice();
                                int cH = s.nextInt();
                                s.nextLine();
                                switch (cH) {
                                    case 1:// -->> Add Lecture Slides
                                        System.out.println("Enter Topic of Slides:");
                                        String stopic = s.nextLine();
                                        System.out.println("Enter number of slides: ");
                                        int nos = s.nextInt();
                                        s.nextLine();
                                        lectureMaterials.add(new LectureSlides(stopic, nos, instructors.get(ID)));
                                        break;
                                    case 2:// -->> Add Lecture Videos
                                        System.out.println("Enter Topic of Video: ");
                                        String vtopic = s.nextLine();
                                        System.out.println("Enter Filename of Video: ");
                                        String vFilename = s.nextLine();
                                        lectureMaterials.add(new LectureVideos(vtopic, vFilename, instructors.get(ID)));
                                        break;
                                }
                                break;
                            case 2:// -->> Add Assessments
                                assChoice();
                                int CH = s.nextInt();
                                s.nextLine();
                                switch (CH) {
                                    case 1:// -->> Add Assignment
                                        System.out.println("Enter Problem Statement: ");
                                        String ps = s.nextLine();
                                        System.out.println("Enter Max Marks: ");
                                        int mm = s.nextInt();
                                        s.nextLine();
                                        oAssessments.add(new Assignments(ps, mm, instructors.get(ID)));
                                        break;
                                    case 2:// -->> Add Quiz
                                        System.out.println("Enter Quiz Question: ");
                                        String qq = s.nextLine();
                                        System.out.println("Enter Max Marks");
                                        int mM = s.nextInt();
                                        s.nextLine();
                                        if (mM != 1) {
                                            oAssessments.add(new Quizzes(qq, mM, instructors.get(ID)));
                                        } else {
                                            oAssessments.add(new Quizzes(qq, instructors.get(ID)));
                                        }
                                        break;
                                }
                                break;
                            case 3:// -->> View Lecture Materials
                                instructors.get(ID).viewLectureNotes(lectureMaterials);
                                break;
                            case 4:// -->> View Assessments
                                instructors.get(ID).viewAssessments(oAssessments);
                                break;
                            case 5:// -->> Grade Assessments
                                break;
                            case 6:// -->> Close Assessments
                                instructors.get(ID).closeAssessments(oAssessments, cAssessments, instructors.get(ID));
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
                    int Id = s.nextInt();
                    s.nextLine();
                    char CHoice = 'y';
                    while (CHoice == 'y') {
                        System.out.println("Welcome " + students.get(Id).stdName);
                        stdMenu();
                        int Ch = s.nextInt();
                        s.nextLine();
                        switch (Ch) {
                            case 1:// -->> View lecture materials
                                students.get(Id).viewLectureNotes(lectureMaterials);
                                break;
                            case 2:// -->> View assessments
                                students.get(Id).viewAssessments(oAssessments);
                                break;
                            case 3:// -->> Submit assessments
                                boolean check = students.get(Id).submitAssessment(oAssessments,A,Q);
                                if(check == true){
                                    System.out.println("Enter ID of assessment: ");
                                    int aid = s.nextInt(); s.nextLine();
                                    oAssessments.get(aid).doAssessment(students.get(Id));
                                }
                                else{
                                    System.out.println("No open assignments are pending for student "+students.get(Id).stdName);
                                }
                                
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

    public static void assChoice() {
        System.out.println("1. Add Assignment");
        System.out.println("2. Add Quiz");
    }
}
