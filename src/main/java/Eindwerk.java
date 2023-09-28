/**
 * IEindwerkCollectie.java:Eindwerk
 *
 * @author thibe
 * @version 28/09/2023
 */
public class Eindwerk implements Comparable<Eindwerk>{
    private String titel;
    private int jaartal;
    private String opleiding;
    private Student student;

    public Eindwerk(String titel, int jaartal, String opleiding, Student student) {
        this.titel = titel;
        this.jaartal = jaartal;
        this.opleiding = opleiding;
        this.student = student;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getJaartal() {
        return jaartal;
    }

    public void setJaartal(int jaartal) {
        this.jaartal = jaartal;
    }

    public String getOpleiding() {
        return opleiding;
    }

    public void setOpleiding(String opleiding) {
        this.opleiding = opleiding;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return  student + " " + titel;
    }

        @Override
    public int compareTo(Eindwerk o) {
        if (this.student.compareTo(o.getStudent()) < 0) return -1;
        else if (this.student.compareTo(o.getStudent()) > 0) return 1;
        else if (this.student.getStudentennummer() < o.getStudent().getStudentennummer()) return -1;
        else if (this.student.getStudentennummer() > o.getStudent().getStudentennummer()) return 1;
        return 0;
    }
}
