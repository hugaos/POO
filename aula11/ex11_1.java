package aula11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class ex11_1 {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner input = new Scanner(new File("C:/Users/sousa/Desktop/POO/POO/src/aula11/major.txt"));
        input.useDelimiter("[\\p{Punct}\\s]+");
        ArrayList<String> palavras = new ArrayList<>();
        HashMap<String, HashMap<String, Integer>> words = new HashMap<>();
        while (input.hasNext()) {
            String word = input.next();
            if (word.length() > 2) {
                palavras.add(word);
            }
        }
        for (int i = 0; i < palavras.size() - 1; i++) {
            String palavra = palavras.get(i);
            String next = palavras.get(i + 1).toLowerCase();
            if (!words.containsKey(palavra)) {
                HashMap<String, Integer> map = new HashMap<>();
                map.put(next, 1);
                words.put(palavra, map);

            } else {
                HashMap<String, Integer> map = words.get(palavra);
                if (!map.containsKey(next)) {
                    map.put(next, 1);
                } else {
                    int count = map.get(next);
                    map.put(next, count + 1);
                }
            }

        }
        input.close();
        for (int j = 0; j < words.size(); j++) {
            System.out.println(words.entrySet().toArray()[j].toString());
        }
    }
}
