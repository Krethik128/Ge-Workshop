package gevernova.workShopStreams.practiceProblems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PlayWithNumbers {
    public static void main(String[] args) {
        int []arr={4,5,5,3,3,7,1,2,9};
        //Group nunbers into category
        List<Integer>ans=Arrays.stream(arr)
                .boxed()
                .toList();

        Map<Integer,List<Integer>> newans=ans.stream()
                .sorted()
                .collect(Collectors.groupingBy(x->x/10*10, LinkedHashMap::new,Collectors.toList()));
        System.out.println(newans);

        //Multiply even index numbers
        System.out.println(IntStream.range(0,arr.length)
                .filter(x->x%2==0)
                .map(x->arr[x])
                .reduce(1,(x,y)->x*y));

        //Find the product of first 2 elements
        System.out.println(IntStream.range(0, arr.length)
                .limit(2)
                .map(x->arr[x])
                .reduce(1,(a,b)->a*b));;

        System.out.println("\nWrite a program to multiply 1st and last element, 2nd and 2nd last element etc. ");
        //Write a program to multiply 1st and last element, 2nd and 2nd last element etc.
        IntStream.range(0,arr.length/2)
                .map(x->arr[x]* arr[arr.length-x-1])
                .forEach(System.out::println);


        //In a given array of integers, return true if it contains distinct values
        System.out.println("\nIn a given array of integers, return true if it contains distinct values");
        System.out.println(ans.stream()
                .collect(Collectors.groupingBy(x->x,Collectors.counting()))
                .values()
                .stream()
                .noneMatch(x->x>1));;


        //Find the sum of all the elements in a list.
        System.out.println(Arrays.stream(arr)
                .boxed()
                .reduce(Integer::sum)
                .get());


        ///Find the k smallest integer in the list of integers
        int n=3;
        Arrays.stream(arr)
                .boxed()
                .sorted()
                .distinct()
                .skip(n-1)
                .findFirst()
                .ifPresent(System.out::println);

        ///Find the intersection of two lists using Java streams
        List<Integer> list1 = Arrays.asList(1, 2, 3,4,5);
        List<Integer> list2 = Arrays.asList(3, 5, 6, 4, 5,7); //Use contains method
        list1.stream()
                .filter(list2::contains)
                .forEach(x->System.out.print(x+" "));


    }
}
