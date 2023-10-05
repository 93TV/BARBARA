import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * BARBARA:StudentTest
 *
 * @author thibe
 * @version 5/10/2023
 */
class StudentTest {
    Student student1;
    Student student2;
    Student student3;

    @BeforeEach
    void init() {
        student1 = new Student("Peter", "Demeester");

        student2 = new Student("Katja", "Verbeeck");

        student3 = new Student("Kristien", "Van Assche");

        Eindwerk eindwerk1 = new Eindwerk("Scheiding der veranderlijken in de geodetische Hamilton-Jacobi vergelijking", 2011, "ICT", student1);

        Eindwerk eindwerk2 = new Eindwerk("Automatische verificatie van eindige state machines", 2012, "ICT", student2);

        Eindwerk eindwerk3 = new Eindwerk("Coordinated Exploration in Multi-agent Reinforcement Learning", 2012, "ICT", student3);

        Eindwerk eindwerk4 = new Eindwerk("Performantie van ATM schakelelementen met gemeenschappelijke buffer", 2010, "OPT", student1);
    }

    @Test
    void uniqueStudentID() {
        assertAll("unique id",
                () -> assertNotEquals(student1.getStudentennummer(), student2.getStudentennummer()),
                () -> assertNotEquals(student1.getStudentennummer(), student3.getStudentennummer()),
                () -> assertNotEquals(student2.getStudentennummer(), student3.getStudentennummer())
        );
    }
}