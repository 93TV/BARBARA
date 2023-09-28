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
    private SortedSet<Eindwerk> studentenTree = new TreeSet<Eindwerk>();
    private SortedMap<String, SortedSet<Eindwerk>> eindwerken = new TreeMap<>();

    public void leesBestand() throws IOException {
        File file = new File("src/main/java/eindwerken.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        int i = 0;
        while (br.readLine() != null && i < 10) {
            String line = br.readLine();
            String[] sliced = line.split("\\$");
            Student student = new Student(sliced[0], sliced[1], Integer.parseInt(sliced[2]));
            Eindwerk eindwerk = new Eindwerk(sliced[3], Integer.parseInt(sliced[4]), sliced[5], student);
            i++;
            studentenTree.add(eindwerk);
            System.out.println(eindwerk.getOpleiding());
            if (eindwerken.containsKey(eindwerk.getOpleiding())) {
                SortedSet<Eindwerk> temp = eindwerken.get(eindwerk.getOpleiding());
                temp.addAll(studentenTree);
                eindwerken.replace(eindwerk.getOpleiding(), temp);
            } else {
                eindwerken.put(eindwerk.getOpleiding(), studentenTree);
            }
        }
    }


    @Override
    public Eindwerk[] getEindwerkenVanOpleiding(String opleiding) {
        SortedSet<Eindwerk> temp = eindwerken.get(opleiding);
        return new Eindwerk[0];
    }

    @Override
    public void verwijder(Eindwerk eindwerk) {

    }

    @Override
    public void voegToe(Eindwerk eindwerk) {

    }

    public static void main(String[] args) {

    }
}
