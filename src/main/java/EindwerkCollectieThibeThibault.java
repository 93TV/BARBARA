import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * AlgoDataLabo1 : EindwerkCollectieThibault
 *
 * @author viaen
 * @version 28/09/2023
 */
public class EindwerkCollectieThibeThibault implements IEindwerkCollectie {
    public SortedMap<String, SortedSet<Eindwerk>> getEindwerken() {
        return eindwerken;
    }

    private SortedMap<String, SortedSet<Eindwerk>> eindwerken = new TreeMap<>();
    private SortedSet<Eindwerk> studentenTree;

    public void leesBestand() throws IOException {

        File file = new File("src/main/java/eindwerken.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
 // test
        while (br.readLine() != null) {
            String line = br.readLine();
            String[] sliced = line.split("\\$");
            Eindwerk eindwerk = maakEindwerk(sliced);
            if (bestaatOpleidingAl(eindwerk)) {
                voegEindewerkToeAanBestaandeOpleiding(eindwerk);
            } else {
                voegEindwerkToeMetNieuweOpleiding(eindwerk);
            }
        }
    }

    private String[] stringSlicer(String line) {
        return line.split("\\$");
    }

    private Student maakStudent(String[] slicedString) {
        return new Student(slicedString[0], slicedString[1], Integer.parseInt(slicedString[2]));
    }

    private Eindwerk maakEindwerk(String[] slicedString) {
        return new Eindwerk(slicedString[3], Integer.parseInt(slicedString[4]), slicedString[5],
                maakStudent(slicedString));
    }

    private boolean bestaatOpleidingAl(Eindwerk eindwerk) {
        return (eindwerken.containsKey(eindwerk.getOpleiding()));
    }

    private void voegEindewerkToeAanBestaandeOpleiding(Eindwerk eindwerk) {
        SortedSet<Eindwerk> temp = eindwerken.get(eindwerk.getOpleiding());
        temp.add(eindwerk);
        eindwerken.replace(eindwerk.getOpleiding(), temp);
    }

    private void voegEindwerkToeMetNieuweOpleiding(Eindwerk eindwerk) {
        studentenTree = new TreeSet<>();
        studentenTree.add(eindwerk);
        eindwerken.put(eindwerk.getOpleiding(), studentenTree);
    }

    @Override
    public Eindwerk[] getEindwerkenVanOpleiding(String opleiding) {
        SortedSet<Eindwerk> temp = eindwerken.get(opleiding);
        return temp.toArray(new Eindwerk[0]);
    }

    @Override
    public void verwijder(Eindwerk eindwerk) {
        eindwerken.get(eindwerk.getOpleiding()).remove(eindwerk);
    }

    @Override
    public void voegToe(Eindwerk eindwerk) {
        studentenTree = new TreeSet<Eindwerk>();
        studentenTree.add(eindwerk);
        if (eindwerken.containsKey(eindwerk.getOpleiding())) {
            SortedSet<Eindwerk> temp = eindwerken.get(eindwerk.getOpleiding());
            temp.add(eindwerk);
            eindwerken.replace(eindwerk.getOpleiding(), temp);
        } else {
            eindwerken.put(eindwerk.getOpleiding(), studentenTree);
        }
    }

    public static void main(String[] args) throws IOException {
        EindwerkCollectieThibeThibault et = new EindwerkCollectieThibeThibault();
        et.leesBestand();
    }
}
