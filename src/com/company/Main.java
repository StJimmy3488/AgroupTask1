package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\karin\\Desktop\\Random Book.txt");
        Scanner scanner = new Scanner(file);
        System.out.println(file.getName());
        List<String> text = new ArrayList<>();
        while (scanner.hasNext()) {
            String x = scanner.next().toLowerCase();
            text.add(x);
        }
        List<String> filteredWords = new ArrayList<>();
        for (String words : text) {
            String separatedWords = words.replaceAll("[^\\w\\s]", "");
            filteredWords.add(separatedWords);
        }
        HashMap<String, Integer> uniqueWordMap = new HashMap<>();
        String[] uniqueWords = filteredWords.stream().distinct().toArray(String[]::new);
        int frequency;
        for (String uniqueWord : uniqueWords) {
            frequency = Collections.frequency(filteredWords, uniqueWord);
            uniqueWordMap.put(uniqueWord, frequency);
        }
        Stream<Map.Entry<String, Integer>> topWordsFirst = uniqueWordMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed());
        topWordsFirst.forEach(System.out::println);
    }
}
