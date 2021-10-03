import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * AllSentences
 */
public class AllSentences {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String[]> lines = new ArrayList<>();

        String inp = null;

        while ((inp = br.readLine()) != null) {
            if (inp.isBlank())
                break;
            lines.add(inp.split(" "));
        }

        printAll(lines, 0, new StringBuilder());

    }

    static void printAll(List<String[]> lines, int index, StringBuilder line) throws InterruptedException {
        if (index == lines.size()) {
            System.out.println(line);
            return;
        }

        String[] wordsInLine = lines.get(index);
        for (String word : wordsInLine) {
            // line.addLast(word);
            int length = line.length();
            line.append(word).append(" ");
            printAll(lines, index + 1, line);
            line.replace(length, length + word.length() + 1, "");
        }

    }
}
// you we
// have are
// sleep eat drink
