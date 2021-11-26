package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    String m;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter file name: ");
        String name = sc.nextLine();
        System.out.println("Select disk to search in (ex. c, d, j): ");
        String disc = sc.nextLine();
        disc += ":\\\\";
        System.out.println(disc);
        Main m = new Main();
        String path = m.fileFinder(name, new File(disc));


        Scanner scanner = new Scanner(new File(path));
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

    public String fileFinder(String name, File file) {
        File[] list = file.listFiles();
        if (list != null) {
            for (File fil : list) {
                if (fil.isDirectory()) {
                    fileFinder(name, fil);
                } else if (name.equalsIgnoreCase(fil.getName())) {
                    m = fil.getAbsolutePath();
                }


            }
        }
        return m;

    }
}

