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
public class LabManager {
    private Lab labOne;
    private Lab labTwo;
    private Lab labThree;

    public LabManager(Lab labOne, Lab labTwo, Lab labThree) {
        this.labOne = labOne;
        this.labTwo = labTwo;
        this.labThree = labThree;
    }

    public Lab getLabOne() {
        return labOne;
    }

    public void setLabOne(Lab labOne) {
        this.labOne = labOne;
    }

    public Lab getLabTwo() {
        return labTwo;
    }

    public void setLabTwo(Lab labTwo) {
        this.labTwo = labTwo;
    }

    public Lab getLabThree() {
        return labThree;
    }

    public void setLabThree(Lab labThree) {
        this.labThree = labThree;
    }

    public int calculateTotalCapacity() {
        return 2 * labOne.getCapacity() + 2 * labTwo.getCapacity() + 2 * labThree.getCapacity();
    }

    public double calculateTotalUtilization() {
        return (labOne.getMorning().getEnrollment()
                + labTwo.getMorning().getEnrollment()
                + labThree.getMorning().getEnrollment()
                + labOne.getAfternoon().getEnrollment()
                + labTwo.getAfternoon().getEnrollment()
                + labThree.getAfternoon().getEnrollment())
                / (double)this.calculateTotalCapacity();
    }

    public int calculateAvailableSeats() {
        return (int) (this.calculateTotalCapacity()
                - this.calculateTotalCapacity() * this.calculateTotalUtilization());
    }

    public String listReservedLabs() {
        return String.format("Lab One\n"
                + labOne.listReservations()
                + "Lab Two\n" + labTwo.listReservations()
                + "Lab Three\n" + labThree.listReservations() + "\n");
    }

    public String listAvailableLabs() {
        return String.format("Lab One\n" + labOne.listAvailabilities()
                + "Lab Two\n" + labTwo.listAvailabilities()
                + "Lab Three\n" + labThree.listAvailabilities() + "\n");
    }

    public String addReservation(String location, String time, String name, int enrollment) {
        if (time.equals("morning") && location.equals(labOne.getLocation())) {
            if (enrollment > labOne.getCapacity())
                return "Error. Capacity exceeded";
            if (labOne.getMorning().getEnrollment() == 0) {
                labOne.getMorning().setName(name);
                labOne.getMorning().setEnrollment(enrollment);
                return "Reservation added!";
            } else {
                return "Error. Invalid time.";
            }
        } else if (time.equals("morning") && location.equals(labTwo.getLocation())) {
            if (enrollment > labTwo.getCapacity())
                return "Error. Capacity exceeded";
            if (labTwo.getMorning().getEnrollment() == 0) {
                labTwo.getMorning().setName(name);
                labTwo.getMorning().setEnrollment(enrollment);
                return "Reservation added!";
            } else {
                return "Error. Invalid time.";
            }
        } else if (time.equals("morning") && location.equals(labThree.getLocation())) {
            if (enrollment > labThree.getCapacity())
                return "Error. Capacity exceeded";
            if (labThree.getMorning().getEnrollment() == 0) {
                labThree.getMorning().setName(name);
                labThree.getMorning().setEnrollment(enrollment);
                return "Reservation added!";
            } else {
                return "Error. Invalid time.";
            }
        } else if (time.equals("afternoon") && location.equals(labOne.getLocation())) {
            if (enrollment > labOne.getCapacity())
                return "Error. Capacity exceeded";
            if (labOne.getAfternoon().getEnrollment() == 0) {
                labOne.getAfternoon().setName(name);
                labOne.getAfternoon().setEnrollment(enrollment);
                return "Reservation added!";
            } else {
                return "Error. Invalid time.";
            }
        } else if (time.equals("afternoon") && location.equals(labTwo.getLocation())) {
            if (enrollment > labTwo.getCapacity())
                return "Error. Capacity exceeded";
            if (labTwo.getAfternoon().getEnrollment() == 0) {
                labTwo.getAfternoon().setName(name);
                labTwo.getAfternoon().setEnrollment(enrollment);
                return "Reservation added!";
            } else {
                return "Error. Invalid time.";
            }
        } else if (time.equals("afternoon") && location.equals(labThree.getLocation())) {
            if (enrollment > labThree.getCapacity())
                return "Error. Capacity exceeded";
            if (labThree.getAfternoon().getEnrollment() == 0) {
                labThree.getAfternoon().setName(name);
                labThree.getAfternoon().setEnrollment(enrollment);
                return "Reservation added!";
            } else {
                return "Error. Invalid time.";
            }
        } else if (!(time.equals("morning")) && !(time.equals("afternoon"))) {
            return "Error. Invalid time.";
        } else if (!(location.equals(labOne.getLocation()))
                && !(location.equals(labTwo.getLocation()))
                && !(location.equals(labThree.getLocation())) )
            return "Error. Invalid location";
        else
            return null;
    }
    public String removeReservation(String location, String time) {
        if (time.equals("morning") && location.equals(labOne.getLocation())) {
            if (labOne.getMorning().getEnrollment() == 0) {
                System.out.println(labOne.getMorning().getEnrollment());
                return "Error. Invalid time.";
            }
            labOne.getMorning().setName("");
            labOne.getMorning().setEnrollment(0);
            return "Reservation removed!";
        } else if (time.equals("morning") && location.equals(labTwo.getLocation())) {
            if (labTwo.getMorning().getEnrollment() == 0)
                return "Error. Invalid time.";
            labTwo.getMorning().setName("");
            labTwo.getMorning().setEnrollment(0);
            return "Reservation removed!";
        } else if (time.equals("morning") && location.equals(labThree.getLocation())) {
            if (labThree.getMorning().getEnrollment() == 0)
                return "Error. Invalid time.";
            labThree.getMorning().setName("");
            labThree.getMorning().setEnrollment(0);
            return "Reservation removed!";
        } else if (time.equals("afternoon") && location.equals(labOne.getLocation())) {
            if (labOne.getAfternoon().getEnrollment() == 0)
                return "Error. Invalid time.";
            labOne.getAfternoon().setName("");
            labOne.getAfternoon().setEnrollment(0);
            return "Reservation removed!";
        } else if (time.equals("afternoon") && location.equals(labTwo.getLocation())) {
            if (labTwo.getAfternoon().getEnrollment() == 0)
                return "Error. Invalid time.";
            labTwo.getAfternoon().setName("");
            labTwo.getAfternoon().setEnrollment(0);
            return "Reservation removed!";
        } else if (time.equals("afternoon") && location.equals(labThree.getLocation())) {
            if (labThree.getAfternoon().getEnrollment() == 0)
                return "Error. Invalid time.";
            labThree.getAfternoon().setName("");
            labThree.getAfternoon().setEnrollment(0);
            return "Reservation removed!";
        } else if (!(time.equals("morning")) && !(time.equals("afternoon"))) {
            return "Error. Invalid time.";
        } else if (!(location.equals(labOne.getLocation()))
                && !(location.equals(labTwo.getLocation()))
                && !(location.equals(labThree.getLocation())) )
            return "Error. Invalid location";
        else
            return null;
    }
    public String modifyReservation(String location, String time, String name, int enrollment) {
        if (time.equals("morning") && location.equals(labOne.getLocation())) {
            if (enrollment > labOne.getCapacity())
                return "Error. Capacity exceeded";
            if (labOne.getMorning().getEnrollment() == 0)
                return "Error. Invalid time.";
            labOne.getMorning().setName(name);
            labOne.getMorning().setEnrollment(enrollment);
            return "Reservation modified!";
        } else if (time.equals("morning") && location.equals(labTwo.getLocation())) {
            if (enrollment > labTwo.getCapacity())
                return "Error. Capacity exceeded";
            if (labTwo.getMorning().getEnrollment() == 0)
                return "Error. Invalid time.";
            labTwo.getMorning().setName(name);
            labTwo.getMorning().setEnrollment(enrollment);
            return "Reservation modified!";
        } else if (time.equals("morning") && location.equals(labThree.getLocation())) {
            if (enrollment > labThree.getCapacity())
                return "Error. Capacity exceeded";
            if (labThree.getMorning().getEnrollment() == 0)
                return "Error. Invalid time.";
            labThree.getMorning().setName(name);
            labThree.getMorning().setEnrollment(enrollment);
            return "Reservation modified!";
        } else if (time.equals("afternoon") && location.equals(labOne.getLocation())) {
            if (enrollment > labOne.getCapacity())
                return "Error. Capacity exceeded";
            if (labOne.getAfternoon().getEnrollment() == 0)
                return "Error. Invalid time.";
            labOne.getAfternoon().setName(name);
            labOne.getAfternoon().setEnrollment(enrollment);
            return "Reservation modified!";
        } else if (time.equals("afternoon") && location.equals(labTwo.getLocation())) {
            if (enrollment > labTwo.getCapacity())
                return "Error. Capacity exceeded";
            if (labTwo.getAfternoon().getEnrollment() == 0)
                return "Error. Invalid time.";
            labTwo.getAfternoon().setName(name);
            labTwo.getAfternoon().setEnrollment(enrollment);
            return "Reservation modified!";
        } else if (time.equals("afternoon") && location.equals(labThree.getLocation())) {
            if (enrollment > labThree.getCapacity())
                return "Error. Capacity exceeded";
            if (labThree.getAfternoon().getEnrollment() == 0)
                return "Error. Invalid time.";
            labThree.getAfternoon().setName(name);
            labThree.getAfternoon().setEnrollment(enrollment);
            return "Reservation modified!";
        } else if (!(time.equals("morning")) && !(time.equals("afternoon"))) {
            return "Error. Invalid time.";
        } else if (!(location.equals(labOne.getLocation()))
                && !(location.equals(labTwo.getLocation()))
                && !(location.equals(labThree.getLocation())) )
            return "Error. Invalid location";
        else
            return null;
    }

    @Override
    public String toString() {
        return "LabManager{" +
                labOne + "," + labTwo +
                "," + labThree + "}" ;
    }
}
