package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:\\Users\\Ilay\\Desktop\\Random_Book.txt"));
        List<String> text = new ArrayList<>();
        while (scanner.hasNext()) {
            String x = scanner.next();
            text.add(x);
        }
        List<String> filteredWords = new ArrayList<>();
        for (String words : text) {
            String separatedWords = words.replaceAll("[^\\w\\s]", "").toLowerCase();
            filteredWords.add(separatedWords);
        }
        HashMap<String, Integer> uniqueWordMap = new HashMap<>();
        String[] uniqueWords = filteredWords.stream().distinct().toArray(String[]::new);
        for (String uniqueWord : uniqueWords) {
            int frequency = Collections.frequency(filteredWords, uniqueWord);
            uniqueWordMap.put(uniqueWord, frequency);
        }
        Stream<Map.Entry<String, Integer>> topWordsFirst = uniqueWordMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed());
        topWordsFirst.forEach(System.out::println);
    }
}
