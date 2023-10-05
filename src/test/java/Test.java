/**
 * BARBARA:EindwerkCollectieThibeThibaultTest
 *
 * @author thibe
 * @version 5/10/2023
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.sql.Time;
import java.time.Duration;
import java.util.Arrays;
import java.util.SortedSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * BARBARA:StudentTest
 *
 * @author thibe
 * @version 5/10/2023
 */
class test {
    Student student1;
    Student student2;
    Student student3;
    static Eindwerk eindwerk1;
    static Eindwerk eindwerk2;
    static Eindwerk eindwerk3;
    static Eindwerk eindwerk4;
    EindwerkCollectieThibeThibault eindwerkCol;

    test() {
        student1 = new Student("Peter", "Demeester");

        student2 = new Student("Katja", "Verbeeck");

        student3 = new Student("Kristien", "Van Assche");

        eindwerk1 = new Eindwerk("Scheiding der veranderlijken in de geodetische Hamilton-Jacobi vergelijking", 2011, "ICT", student1);

        eindwerk2 = new Eindwerk("Automatische verificatie van eindige state machines", 2012, "ICT", student2);

        eindwerk3 = new Eindwerk("Coordinated Exploration in Multi-agent Reinforcement Learning", 2012, "ICT", student3);

        eindwerk4 = new Eindwerk("Performantie van ATM schakelelementen met gemeenschappelijke buffer", 2010, "OPT", student1);

        eindwerkCol = new EindwerkCollectieThibeThibault();
        eindwerkCol.voegToe(eindwerk1);
        eindwerkCol.voegToe(eindwerk2);
        eindwerkCol.voegToe(eindwerk3);
        eindwerkCol.voegToe(eindwerk4);

    }

    @Test
    void UniqueStudentID() {
        assertAll("unique id",
                () -> assertNotEquals(student1.getStudentennummer(), student2.getStudentennummer()),
                () -> assertNotEquals(student1.getStudentennummer(), student3.getStudentennummer()),
                () -> assertNotEquals(student2.getStudentennummer(), student3.getStudentennummer())
        );
    }

    @ParameterizedTest
    @MethodSource("provideEindwerken")
    void EindwerkenToegevoegdInDeDataSet(Eindwerk eindwerk) {
        for (int i = 0; i < eindwerkCol.getEindwerken().size(); i++) {
            Eindwerk[] eindwerkenVanOpleiding = eindwerkCol.getEindwerkenVanOpleiding(eindwerkCol.getEindwerken().keySet().toArray()[i].toString());
            if (Arrays.stream(eindwerkenVanOpleiding).toList().contains(eindwerk))
                assertTrue(true);
        }
    }

    private static Stream<Arguments> provideEindwerken() {
        return Stream.of(
                Arguments.of(eindwerk1),
                Arguments.of(eindwerk2),
                Arguments.of(eindwerk3),
                Arguments.of(eindwerk4)
        );
    }

    @Test
    void EindWerkenInDeJuisteOpleidingMoetenZitten() {
        assertAll("toevoegen van eindwerken",
                () -> assertTrue(Arrays.stream(eindwerkCol.getEindwerkenVanOpleiding(eindwerk1.getOpleiding())).toList().contains(eindwerk1)),
                () -> assertTrue(Arrays.stream(eindwerkCol.getEindwerkenVanOpleiding(eindwerk2.getOpleiding())).toList().contains(eindwerk2)),
                () -> assertTrue(Arrays.stream(eindwerkCol.getEindwerkenVanOpleiding(eindwerk3.getOpleiding())).toList().contains(eindwerk3)),
                () -> assertTrue(Arrays.stream(eindwerkCol.getEindwerkenVanOpleiding(eindwerk4.getOpleiding())).toList().contains(eindwerk4))
        );
    }

    @Test
    void ZoekAlleEindwerkenVanICT() {
        assertTrue(eindwerkCol.getEindwerkenVanOpleiding("ICT").length > 0);
    }

    @Test
    void VerwijderAlleICTEindwerken() {
        int lengt = eindwerkCol.getEindwerkenVanOpleiding("ICT").length;
        for (int i = 0; i < lengt; i++) {
            eindwerkCol.verwijder((Eindwerk) Arrays.stream(eindwerkCol.getEindwerkenVanOpleiding("ICT")).toArray()[0]);
        }
        assertTrue(eindwerkCol.getEindwerkenVanOpleiding("ICT").length == 0);
    }

    @Timeout(1000)
    @Test
    void DuurtTeLangOmTeLezen() {
        assertTimeout(Duration.ofMillis(20000), () -> eindwerkCol.leesBestand());
    }

}