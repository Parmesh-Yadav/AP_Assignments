import java.util.ArrayList;
import java.util.Scanner;

class Slot {
    int dayOfSlot;
    Vaccine VaccineGiven;
    int availableQuantity;

    Slot(int dayOfSlot, Vaccine VaccineGiven, int availableQuantity) {
        this.dayOfSlot = dayOfSlot;
        this.VaccineGiven = VaccineGiven;
        this.availableQuantity = availableQuantity;
    }
}

class Vaccine {
    String nameOfVaccine;
    int noOfDoses;
    int gap;

    Vaccine(String nameOfVaccine, int noOfDoses, int gap) {
        this.nameOfVaccine = nameOfVaccine;
        this.noOfDoses = noOfDoses;
        this.gap = gap;
    }

    public void printVaccineInfo(Vaccine v) {
        System.out.println("Vaccine name: " + v.nameOfVaccine + ", Number of Doses: " + v.noOfDoses
                + ", Gap between doses: " + v.gap);
    }
}

class Hospital {
    static int noOfHospitals = 0;
    String nameOfHosptital;
    int pincode;
    int uniqueID_H;
    ArrayList<Slot> slots = new ArrayList<>();

    Hospital(String nameOfHospital, int pincode) {
        this.nameOfHosptital = nameOfHospital;
        this.pincode = pincode;
        this.uniqueID_H = Hospital.noOfHospitals++;
    }

    public void printHospitalInfo(Hospital h) {
        System.out.println("Hospital Name: " + h.nameOfHosptital);
        System.out.println("Pincode: " + h.pincode);
        System.out.println("Unique ID: " + h.uniqueID_H);
    }

    public void printSlotDetails(Slot s, Hospital h) {
        System.out.println("Slot added by " + h.uniqueID_H + " for day " + s.dayOfSlot + ",available quantity: "
                + s.availableQuantity + " of vaccine " + s.VaccineGiven);
    }
}

class Citizen {
    static int noOfCitizens = 0;
    String nameOfCitizen;
    int age;
    int uniqueID_C;
    String vaccinationStatus;
    Vaccine vaccineGiven;
    int noOfDosesGiven;
    int nextDueDate;

    Citizen(String nameOfCitizen, int age, int uniqueID_C) {
        this.nameOfCitizen = nameOfCitizen;
        this.age = age;
        this.uniqueID_C = uniqueID_C;
        Citizen.noOfCitizens++;
        this.vaccinationStatus = "REGISTERED";
        this.noOfDosesGiven = 0;
        this.nextDueDate = 0;
    }

    public void printCitizenInfo(Citizen c) {
        System.out.println("Citizen Name: " + c.nameOfCitizen);
        System.out.println("Age: " + c.age);
        System.out.println("Unique ID: " + c.uniqueID_C);
    }

}

public class AP_assignment1 {
    public static void main(String[] args) {

        ArrayList<Vaccine> vaccines = new ArrayList<>();
        ArrayList<Citizen> citizens = new ArrayList<>();
        ArrayList<Hospital> hospitals = new ArrayList<>();

        Scanner s = new Scanner(System.in);

        char choice = 'y';
        int ch;

        while (choice == 'y') {
            MenuOptions();
            ch = s.nextInt();
            switch (ch) {
                case 1:// add vaccine
                    System.out.println("Vaccine Name: ");
                    String nameOfVaccine = s.next();
                    System.out.println("No. of Doses: ");
                    int doses = s.nextInt();
                    System.out.println("Gap between Doses:");
                    int gap = s.nextInt();
                    Vaccine v = new Vaccine(nameOfVaccine, doses, gap);
                    v.printVaccineInfo(v);
                    vaccines.add(v);
                    // System.out.println(vaccines.get(0).nameOfVaccine);
                    break;
                case 2:// register Hospital
                    System.out.println("Hospital Name: ");
                    String nameOfHospital = s.next();
                    System.out.println("Pincode: ");
                    int pincode = s.nextInt();
                    Hospital h = new Hospital(nameOfHospital, pincode);
                    h.printHospitalInfo(h);
                    hospitals.add(h);

                    break;
                case 3:// Register Citizen
                    System.out.println("Citizen Name: ");
                    String nameOfCitizen = s.next();
                    System.out.println("Age: ");
                    int age = s.nextInt();
                    System.out.println("Unique ID: ");
                    int uniqueID_C = s.nextInt();
                    Citizen c = new Citizen(nameOfCitizen, age, uniqueID_C);
                    c.printCitizenInfo(c);
                    citizens.add(c);
                    break;
                case 4:// Add slot for vaccination
                    System.out.println("Hospital ID: ");
                    int hospitalID = s.nextInt();
                    System.out.println("No. of slots: ");
                    int noOfSlots = s.nextInt();
                    for (int j = 0; j < noOfSlots; j++) {
                        System.out.println("Enter Day Number: ");
                        int dayNumber = s.nextInt();
                        System.out.println("Enter Quantity: ");
                        int quantity = s.nextInt();
                        System.out.println("Select Vaccine: ");
                        for (int i = 0; i < vaccines.size(); i++) {
                            System.out.println(i + ". " + vaccines.get(i).nameOfVaccine);
                        }
                        int vaccine = s.nextInt();
                        Slot S = new Slot(dayNumber, vaccines.get(vaccine), quantity);
                        hospitals.get(hospitalID).slots.add(S);
                        hospitals.get(hospitalID).printSlotDetails(S, hospitals.get(hospitalID));
                    }
                    break;
                case 5:// Book slot for vaccination
                    System.out.println("Enter patient Unique ID: ");
                    int uniqueIDC = s.nextInt();
                    System.out.println("1. Search by Area");
                    System.out.println("2. Search by Vaccine");
                    System.out.println("3. Exit");
                    System.out.println("Enter Option:");
                    int C = s.nextInt();
                    switch (C) {
                        case 1:
                            System.out.println("Enter Pincode:");
                            int pc = s.nextInt();
                            for (Hospital H : hospitals) {
                                if (H.pincode == pc) {
                                    System.out.println(H.uniqueID_H + ". " + H.nameOfHosptital);
                                }
                            }
                            System.out.println("Enter Hospital ID: ");
                            int o = s.nextInt();
                            Hospital hospital = hospitals.get(o);
                            int a = 0;
                            // ArrayList<Slot> booking = new ArrayList<>();
                            for (Slot S : hospital.slots) {
                                System.out.println((a++) + " --> " + "Day: " + S.dayOfSlot + " Avalaible Qty: "
                                        + S.availableQuantity + " Vaccine: " + S.VaccineGiven);
                                // booking.add(S);
                            }
                            System.out.println("Choose Slot: ");
                            int slot = s.nextInt();
                            hospitals.get(o).slots.get(slot).availableQuantity--;
                            int noOfdose = hospitals.get(o).slots.get(slot).VaccineGiven.noOfDoses;
                            int gp = hospitals.get(o).slots.get(slot).VaccineGiven.gap;
                            int d = hospitals.get(o).slots.get(slot).dayOfSlot;

                            // int Z;
                            for (int z = 0; z < citizens.size(); z++) {
                                if (citizens.get(z).uniqueID_C == uniqueIDC) {
                                    if (noOfdose == 1) {
                                        citizens.get(z).vaccinationStatus = "Fully Vaccinated";
                                        citizens.get(z).noOfDosesGiven++;
                                        break;
                                    } else {
                                        citizens.get(z).vaccinationStatus = "Partially Vaccinated";
                                        citizens.get(z).noOfDosesGiven++;
                                        if (citizens.get(z).noOfDosesGiven == 1) {
                                            citizens.get(z).nextDueDate = d + gp;
                                        }
                                        break;
                                    }
                                }
                            }

                            break;
                        case 2:
                            System.out.println("Enter Vaccine Name:");
                            String vn = s.next();

                            break;
                        case 3:
                            break;
                    }
                    break;
                case 6:// List all slots for a hospital
                    System.out.println("Enter Hospital ID: ");
                    int hospitalid = s.nextInt();
                    Hospital H = hospitals.get(hospitalid);
                    for (Slot S : H.slots) {
                        System.out.println("Day " + S.dayOfSlot + " " + S.VaccineGiven + " Vaccine Available " + "Qty: "
                                + S.availableQuantity);
                    }
                    break;
                case 7:// Check Vaccination Status
                    System.out.println("Enter patientID: ");
                    int pID = s.nextInt();
                    for (Citizen citizen : citizens) {
                        if (citizen.uniqueID_C == pID) {
                            if (citizen.vaccinationStatus == "Fully Vaccinated") {
                                System.out.println("Vaccine Given: " + citizen.vaccineGiven.nameOfVaccine);
                                System.out.println("No of Doses Given: " + citizen.noOfDosesGiven);
                            } else if (citizen.vaccinationStatus == "Partially Vaccinated") {
                                System.out.println("Vaccine Given: " + citizen.vaccineGiven.nameOfVaccine);
                                System.out.println("No of Doses Given: " + citizen.noOfDosesGiven);
                                System.out.println("Next dose due date: " + citizen.nextDueDate);
                            } else if (citizen.vaccinationStatus == "REGISTERED") {
                                System.out.println("Vaccine Given: " + citizen.vaccineGiven.nameOfVaccine);
                                System.out.println("No of Doses Given: " + citizen.noOfDosesGiven);
                            }
                            break;
                        }
                    }

                    break;
                case 8:// exit
                    choice = 'n';
                    break;
            }

        }
        s.close();

    }

    public static void MenuOptions() {
        System.out.println("1. Add Vaccine");
        System.out.println("2. Register Hospital");
        System.out.println("3. Register Citizen");
        System.out.println("4. Add Slot for Vaccination");
        System.out.println("5. Book Slot for Vaccination");
        System.out.println("6. List all slots for a hospital");
        System.out.println("7. Check Vaccination Status");
        System.out.println("8. Exit");
    }
}