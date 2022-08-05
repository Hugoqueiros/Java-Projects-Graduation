package logtest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogTest {

    public static void main(String[] args) throws IOException {

        Map<String, Integer> map = new TreeMap<String, Integer>();
        File file = new File("frase.txt");

        Scanner scanner = new Scanner(new File(frase));
        while (scanner.hasNext()) {
            String word = scanner.next();
            Integer count = map.get(word);
            count = (count == null ? 1 : count + 1);
            map.put(word, count);
        }
        System.out.println(map.values());
    }

}
