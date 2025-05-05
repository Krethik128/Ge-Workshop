package gevernova.workShopStreams.practiceProblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import gevernova.workShopStreams.employees.*;

public class WordsProblems {
    public static void main(String[] args) {
        String lorem="hello world";
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
                 .entrySet()
                 .stream()
                 .filter((x)->x.getValue()==1 )
                 .findFirst()
                 .ifPresent(x-> System.out.println(x.getKey()));

         // //Given the string[] group the strings based on the middle character
        String[] arr={"eat","tea","tan","ate","nat","bat"};
        System.out.println(Arrays.stream(arr)
                .collect(Collectors.groupingBy(x->String.valueOf(x.charAt(x.length()/2))))); //map the string with Middle char


        //Sort a list of strings in alphabetical order
        System.out.println("\nSort a list of strings in alphabetical order");
        Arrays.stream(arr)
                .sorted((a,b)->a.compareTo(b))
                .forEach(string->System.out.print(string+" "));


        ///Convert a list of strings to uppercase
        System.out.println("\nConvert a list of strings to uppercase");
        Arrays.stream(arr)
                .map(String::toUpperCase)
                .forEach(string-> System.out.print(string+" "));

        /// Find the occurrence of domains using Java streams
        System.out.println();
        Employee el = new Employee ("Sam" ,"sam@gmail.com");
        Employee e2 = new Employee ("Adam", "adam@yahoo.com");
        Employee e3 = new Employee ("Peter", "peter@gmail.com");
       List<Employee> empList=new ArrayList<>();
        empList.add (el) ;
        empList.add (e2) ;
        empList.add (e3) ;

        empList.stream()
                .map(emp->emp.getEmail().substring(emp.getEmail().indexOf("@")))
                .distinct() //Using  map to map the object to string and then finding the "@" in string to get the substring
                .forEach(str-> System.out.println(str+" "));






    }
}
