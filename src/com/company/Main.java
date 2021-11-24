package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\karin\\Desktop\\Random Book.txt");
        Scanner scanner = new Scanner(file);
        System.out.println(file.getName());
        List<String> text = new ArrayList<>();

        while (scanner.hasNext()) {
            String x = scanner.next();
            text.add(x);
        }
        for (String words : text) {
            String[] sepWords = words.split("\\P{Alpha}+");
//            System.out.println(Arrays.toString(sepWords));

        }
        String[] uniqueWords = text.stream().distinct().
                toArray(String[]::new);
        Map<String, Integer> wordsMap = new HashMap<>();
        int frequency = 0;
//        //Load the words to Map with each uniqueword as Key and frequency as Value
        for (String uniqueWord : uniqueWords) {
            frequency = Collections.frequency(text, uniqueWord);
            System.out.println(uniqueWord + " occured " + frequency + " times");
            wordsMap.put(uniqueWord, frequency);
        }
//
//        //Now, Sort the words with the reverse order of frequency(value of HashMap)
//        Stream<Map.Entry<String, Integer>> topWords = wordsMap.entrySet().stream().
//                sorted(Map.Entry.<String, Integer>comparingByValue().reversed());
//
//        //Now print the Top 5 words to console
//        System.out.println("Top 5 Words:::");
//        topWords.forEach(System.out::println);


    }
}
