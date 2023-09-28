/**
 * IEindwerkCollectie.java:Student
 * @author thibe
 * @version 28/09/2023
 */public class Student implements Comparable<Student>{
     private String voornaam;
     private String familienaam;
     private String studentennummer;

    public Student(String voornaam, String familienaam, String studentennummer) {
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

    public String getStudentennummer() {
        return studentennummer;
    }

    public void setStudentennummer(String studentennummer) {
        this.studentennummer = studentennummer;
    }

    @Override
    public int compareTo(Student o) {
        if ((this.familienaam.compareTo(o.familienaam)) < 0) return -1;
        if ((this.familienaam.compareTo(o.familienaam)) > 0) return 1;
        else if ((this.voornaam.compareTo(o.getVoornaam())) < 0) return -1;
        else if ((this.voornaam.compareTo(o.getVoornaam())) > 0) return 1;
        else return 0;
    }
}
