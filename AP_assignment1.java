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
    static int noOfVaccines = 0;
    String nameOfVaccine;
    int noOfDoses;
    int gap;
    int vid;

    Vaccine(String nameOfVaccine, int noOfDoses, int gap) {
        this.nameOfVaccine = nameOfVaccine;
        this.noOfDoses = noOfDoses;
        this.gap = gap;
        this.vid = noOfVaccines++;
    }

    public void printVaccineInfo(Vaccine v) {
        System.out.println("Vaccine name: " + v.nameOfVaccine + ", Number of Doses: " + v.noOfDoses
                + ", Gap between doses: " + v.gap);
    }

    public static int getVaccineByName(String name, ArrayList<Vaccine> vaccines) {
        for (int i = 0; i < vaccines.size(); i++) {
            if (vaccines.get(i).nameOfVaccine.equals(name)) {
                return i;
            }
        }
        return -1;
    }
}

class Hospital {
    static int noOfHospitals = 100000;
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
        System.out.println(
                "Hospital Name: " + h.nameOfHosptital + " ,Pincode: " + h.pincode + " ,Unique ID: " + h.uniqueID_H);
    }

    public void printSlotDetails(Slot s, Hospital h) {
        System.out.println("Slot added by Hospital " + h.uniqueID_H + " for day " + s.dayOfSlot
                + ",available quantity: " + s.availableQuantity + " of vaccine " + s.VaccineGiven.nameOfVaccine);
    }

    public static int getHospitalByUniqueID(int uid, ArrayList<Hospital> hospitals) {
        for (int i = 0; i < hospitals.size(); i++) {
            if (hospitals.get(i).uniqueID_H == uid) {
                return i;
            }
        }
        return -1;
    }

    public static void decSlot(ArrayList<Hospital> hospitals, int hosIndex, int slotIndex) {
        hospitals.get(hosIndex).slots.get(slotIndex).availableQuantity--;
        if (hospitals.get(hosIndex).slots.get(slotIndex).availableQuantity == 0) {
            hospitals.get(hosIndex).slots.remove(slotIndex);
        }
    }

    public static boolean verifyHospital(int pc, ArrayList<Hospital> hospitals) {
        for (Hospital c : hospitals) {
            if (c.pincode == pc) {
                return true;
            }
        }
        return false;
    }

}

class Citizen {
    static int noOfCitizens = 0;
    String nameOfCitizen;
    int age;
    String uniqueID_C;
    String vaccinationStatus;
    Vaccine vaccineGiven;
    int noOfDosesGiven;
    int nextDueDate;

    Citizen(String nameOfCitizen, int age, String uniqueID_C) {
        this.nameOfCitizen = nameOfCitizen;
        this.age = age;
        this.uniqueID_C = uniqueID_C;
        Citizen.noOfCitizens++;
        this.vaccinationStatus = "REGISTERED";
        this.noOfDosesGiven = 0;
        this.nextDueDate = 0;
    }

    public void printCitizenInfo(Citizen c) {
        System.out.println("Citizen Name: " + c.nameOfCitizen + " ,Age: " + c.age + " ,Unique ID: " + c.uniqueID_C);
    }

    public static int getCitizenByUniqueID(String uid, ArrayList<Citizen> citizens) {
        for (int i = 0; i < citizens.size(); i++) {
            if (citizens.get(i).uniqueID_C.equals(uid)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean verifyCitizen(String uid, ArrayList<Citizen> citizens) {
        for (Citizen c : citizens) {
            if (c.uniqueID_C.equals(uid)) {
                return true;
            }
        }
        return false;
    }

}

public class AP_assignment1 {
    public static void main(String[] args) {

        ArrayList<Vaccine> vaccines = new ArrayList<>();
        ArrayList<Citizen> citizens = new ArrayList<>();
        ArrayList<Hospital> hospitals = new ArrayList<>();
        ArrayList<ArrayList<Hospital>> Vhospitals = new ArrayList<>();

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
                    int gap;
                    if (doses > 1) {
                        System.out.println("Gap between Doses:");
                        gap = s.nextInt();

                    } else {
                        gap = 0;
                    }
                    Vaccine v = new Vaccine(nameOfVaccine, doses, gap);
                    v.printVaccineInfo(v);
                    vaccines.add(v);
                    ArrayList<Hospital> Vh = new ArrayList<>();
                    Vhospitals.add(Vh);
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
                    if (age >= 18) {
                        System.out.println("Unique ID: ");
                        String uniqueID_C = s.next();
                        Citizen c = new Citizen(nameOfCitizen, age, uniqueID_C);
                        c.printCitizenInfo(c);
                        citizens.add(c);
                        break;
                    } else {
                        System.out.println("Not eligible for vaccination.");
                        break;
                    }

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
                        int i = Hospital.getHospitalByUniqueID(hospitalID, hospitals);
                        hospitals.get(i).slots.add(S);
                        Vhospitals.get(vaccines.get(vaccine).vid).add(hospitals.get(i));
                        hospitals.get(i).printSlotDetails(S, hospitals.get(i));
                    }
                    break;
                case 5:// Book slot for vaccination
                    System.out.println("Enter patient Unique ID: ");
                    String uniqueIDC = s.next();
                    if (!Citizen.verifyCitizen(uniqueIDC, citizens)) {
                        break;
                    }
                    int cindex = Citizen.getCitizenByUniqueID(uniqueIDC, citizens);
                    System.out.println("1. Search by Area");
                    System.out.println("2. Search by Vaccine");
                    System.out.println("3. Exit");
                    System.out.println("Enter Option:");
                    int C = s.nextInt();
                    switch (C) {
                        case 1:
                            System.out.println("Enter Pincode:");
                            int pc = s.nextInt();
                            boolean pcvh = Hospital.verifyHospital(pc, hospitals);
                            if (pcvh == false) {
                                System.out.println("No hospitals in this pincode");
                                break;
                            }
                            for (Hospital H : hospitals) {
                                if (H.pincode == pc) {
                                    System.out.println(H.uniqueID_H + ". " + H.nameOfHosptital);
                                }
                            }
                            System.out.println("Enter Hospital ID: ");
                            int o = s.nextInt();
                            int i = Hospital.getHospitalByUniqueID(o, hospitals);
                            Hospital hospital = hospitals.get(i);
                            boolean slotE = false;
                            for (Slot S : hospital.slots) {
                                if (S.dayOfSlot >= citizens.get(cindex).nextDueDate) {
                                    slotE = true;
                                }
                            }
                            if (slotE == false) {
                                System.out.println("No slots available.");
                                break;
                            }
                            int a = 0;

                            for (Slot S : hospital.slots) {
                                if (S.dayOfSlot >= citizens.get(cindex).nextDueDate) {
                                    System.out.println((a++) + " --> " + "Day: " + S.dayOfSlot + " Avalaible Qty: "
                                            + S.availableQuantity + " Vaccine: " + S.VaccineGiven.nameOfVaccine);
                                }

                            }
                            System.out.println("Choose Slot: ");
                            int slot = s.nextInt();
                            Vaccine V = hospitals.get(i).slots.get(slot).VaccineGiven;

                            // after this step its meant that the citizen has taken the vaccine
                            Hospital.decSlot(hospitals, i, slot);
                            int noOfdose = hospitals.get(i).slots.get(slot).VaccineGiven.noOfDoses;
                            int gp = hospitals.get(i).slots.get(slot).VaccineGiven.gap;
                            int d = hospitals.get(i).slots.get(slot).dayOfSlot;

                            if (noOfdose == 1) {
                                citizens.get(cindex).vaccinationStatus = "Fully Vaccinated";
                                citizens.get(cindex).noOfDosesGiven++;
                                citizens.get(cindex).vaccineGiven = V;
                            } else if (noOfdose > 1
                                    && (citizens.get(cindex).vaccinationStatus.equals("Partially Vaccinated")
                                            || citizens.get(cindex).vaccinationStatus.equals("REGISTERED"))) {
                                citizens.get(cindex).noOfDosesGiven++;
                                citizens.get(cindex).vaccineGiven = V;
                                if (citizens.get(cindex).noOfDosesGiven == noOfdose) {
                                    citizens.get(cindex).vaccinationStatus = "Fully Vaccinated";
                                } else {
                                    citizens.get(cindex).nextDueDate = d + gp;
                                    citizens.get(cindex).vaccinationStatus = "Partially Vaccinated";
                                }
                            }
                            System.out.println(citizens.get(cindex).nameOfCitizen + "  was vaccinated with "
                                    + citizens.get(cindex).vaccineGiven.nameOfVaccine);
                            break;
                        case 2:
                            System.out.println("Enter Vaccine Name:");
                            String vn = s.next();
                            int Vid = Vaccine.getVaccineByName(vn, vaccines);
                            if (Vid == -1) {
                                System.out.println("No vaccines Found by this name.");
                                break;
                            }
                            for (Hospital H : Vhospitals.get(Vid)) {
                                System.out.println(H.uniqueID_H + " " + H.nameOfHosptital);
                            }
                            System.out.println("Enter hospital ID: ");
                            int ud = s.nextInt();
                            int i_ = Hospital.getHospitalByUniqueID(ud, hospitals);
                            Hospital hospital_ = hospitals.get(i_);
                            boolean slotE_ = false;
                            for (Slot S : hospital_.slots) {
                                if (S.dayOfSlot >= citizens.get(cindex).nextDueDate) {
                                    slotE_ = true;
                                }
                            }
                            if (slotE_ == false) {
                                System.out.println("No slots available.");
                                break;
                            }

                            int a_ = 0;

                            for (Slot S : hospital_.slots) {
                                if (S.dayOfSlot >= citizens.get(cindex).nextDueDate
                                        && S.VaccineGiven.nameOfVaccine.equals(vn)) {
                                    System.out.println((a_++) + " --> " + "Day: " + S.dayOfSlot + " Avalaible Qty: "
                                            + S.availableQuantity + " Vaccine: " + S.VaccineGiven.nameOfVaccine);
                                }

                            }
                            System.out.println("Choose Slot: ");
                            int slot_ = s.nextInt();
                            Vaccine V_ = hospitals.get(i_).slots.get(slot_).VaccineGiven;
                            Hospital.decSlot(hospitals, i_, slot_);
                            int noOfdose_ = hospitals.get(i_).slots.get(slot_).VaccineGiven.noOfDoses;
                            int gp_ = hospitals.get(i_).slots.get(slot_).VaccineGiven.gap;
                            int d_ = hospitals.get(i_).slots.get(slot_).dayOfSlot;

                            if (noOfdose_ == 1) {
                                citizens.get(cindex).vaccinationStatus = "Fully Vaccinated";
                                citizens.get(cindex).noOfDosesGiven++;
                                citizens.get(cindex).vaccineGiven = V_;
                            } else if (noOfdose_ > 1
                                    && (citizens.get(cindex).vaccinationStatus.equals("Partially Vaccinated")
                                            || citizens.get(cindex).vaccinationStatus.equals("REGISTERED"))) {
                                citizens.get(cindex).noOfDosesGiven++;
                                citizens.get(cindex).vaccineGiven = V_;
                                if (citizens.get(cindex).noOfDosesGiven == noOfdose_) {
                                    citizens.get(cindex).vaccinationStatus = "Fully Vaccinated";
                                } else {
                                    citizens.get(cindex).nextDueDate = d_ + gp_;
                                    citizens.get(cindex).vaccinationStatus = "Partially Vaccinated";
                                }
                            }
                            System.out.println(citizens.get(cindex).nameOfCitizen + "  was vaccinated with "
                                    + citizens.get(cindex).vaccineGiven.nameOfVaccine);

                            break;
                        case 3:
                            break;
                    }
                    break;
                case 6:// List all slots for a hospital
                    System.out.println("Enter Hospital ID: ");
                    int hospitalid = s.nextInt();
                    int i = Hospital.getHospitalByUniqueID(hospitalid, hospitals);
                    Hospital H = hospitals.get(i);
                    for (Slot S : H.slots) {
                        System.out.println("Day: " + S.dayOfSlot + " Vaccine: " + S.VaccineGiven.nameOfVaccine
                                + " Available Qty: " + S.availableQuantity);
                    }
                    break;
                case 7:// Check Vaccination Status
                    System.out.println("Enter patientID: ");
                    String pID = s.next();
                    for (Citizen citizen : citizens) {
                        if (citizen.uniqueID_C.equals(pID)) {
                            if (citizen.vaccinationStatus == "Fully Vaccinated") {
                                System.out.println("Current Vaccination Status: " + citizen.vaccinationStatus);
                                System.out.println("Vaccine Given: " + citizen.vaccineGiven.nameOfVaccine);
                                System.out.println("No of Doses Given: " + citizen.noOfDosesGiven);
                            } else if (citizen.vaccinationStatus == "Partially Vaccinated") {
                                System.out.println("Current Vaccination Status: " + citizen.vaccinationStatus);
                                System.out.println("Vaccine Given: " + citizen.vaccineGiven.nameOfVaccine);
                                System.out.println("No of Doses Given: " + citizen.noOfDosesGiven);
                                System.out.println("Next dose due date: " + citizen.nextDueDate);
                            } else if (citizen.vaccinationStatus == "REGISTERED") {
                                System.out.println("Current Vaccination Status: " + citizen.vaccinationStatus);
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