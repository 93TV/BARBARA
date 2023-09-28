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
