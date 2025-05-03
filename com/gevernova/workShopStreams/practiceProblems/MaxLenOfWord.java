package gevernova.workShopStreams.practiceProblems;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLenOfWord {
    public static void main(String[] args) {
        String lorem="hello this is Anna from Sydney but not Australia";
        Arrays.stream(lorem.split(" "))
                .max(Comparator.comparing(String::length))
                .ifPresentOrElse(
                        System.out::println,
                        ()-> System.out.println("Not possible")
                );

        Arrays.stream(lorem.split(" "))
                .sorted(Comparator.comparing(String::length).reversed())
                .skip(1)
                .limit(1)
                .forEach(System.out::println);
    }
}
