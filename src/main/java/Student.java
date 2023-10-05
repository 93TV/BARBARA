import java.util.Random;

/**
 * IEindwerkCollectie.java:Student
 * @author thibe
 * @version 28/09/2023
 */public class Student implements Comparable<Student>{
     private String voornaam;
     private String familienaam;
     private int studentennummer;

    public Student(String familienaam,String voornaam, int studentennummer) {
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.studentennummer = studentennummer;
    }

    private String generateUniekNummer(String familienaam, String voornaam) {

            String initials = familienaam.substring(0, 1) + voornaam.substring(0, 1);
            int randomNumber = (int) (111111 + (Math.random() * 999999));
            return initials + randomNumber;
        }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    public int getStudentennummer() {
        return studentennummer;
    }


    @Override
    public String toString() {
        return familienaam + " " + familienaam;
    }

    @Override
    public int compareTo(Student o) {
        if ((this.familienaam.compareTo(o.getFamilienaam())) < 0) return -1;
        else if ((this.familienaam.compareTo(o.getFamilienaam())) > 0) return 1;
        else if ((this.voornaam.compareTo(o.getVoornaam())) < 0) return -1;
        else if ((this.voornaam.compareTo(o.getVoornaam())) > 0) return 1;
        return 0;
    }
}
