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
public class Session {
    private String name;
    private int enrollment;

    public Session(String name, int enrollment) {
        this.name = name;
        this.enrollment = enrollment;
    }
    public Session() {
        this.name = "";
        this.enrollment = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }

    @Override
    public String toString() {
        return "Session{" +
                "Name - " + name + ", Enrollment - " + enrollment +
                '}';
    }
}
