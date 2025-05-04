package gevernova.workShopStreams.practiceProblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.*;
import java.util.stream.Collectors;

public class WordsPtoblems {
    public static void main(String[] args) {
        String lorem="hello this is Anna from Sydney but not Australia Australia Sydney Ana";
        Arrays.stream(lorem.split(" "))
                .max(Comparator.comparing(String::length))
                .ifPresentOrElse(
                        System.out::println,
                        ()-> System.out.println("Not possible")
                );

        Arrays.stream(lorem.split(" "))
                .sorted(Comparator.comparing(String::length).reversed())
                .skip(1)
                .findFirst()
                .ifPresentOrElse(
                        System.out::println,
                        ()-> System.out.println("Not possible")
                );

        //count freq of words
        System.out.println(Arrays.stream(lorem.split(" "))
                .collect(Collectors.groupingBy(word->word,Collectors.counting())));

        //find words with specific number of vowels
        Arrays.stream(lorem.split(" "))
                .filter(x->x.replaceAll("[^aeiouAEIOU]","").length()==2)
                .forEach(System.out::println);

        //Given a word, find the occurrence of each character
        System.out.println(Arrays.stream(lorem.split(""))
                        .filter(x-> !x.equals(" "))
                        .collect(Collectors.groupingBy(x->x,Collectors.counting())));


        //First Non-repeating character
      Arrays.stream(lorem.split(""))
                .filter(c->lorem.indexOf(c)==lorem.lastIndexOf(c))
                .findFirst()
                .ifPresent(System.out::println);

         lorem.chars()
                .mapToObj(x -> (char)x)
                .collect(Collectors.groupingBy(x -> x, LinkedHashMap::new,Collectors.counting()))
                .forEach((key,val)->{
                    if(val==(2)){
                        System.out.println(key);
                    }
                });





    }
}
