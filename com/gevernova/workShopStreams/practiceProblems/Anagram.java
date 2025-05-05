package gevernova.workShopStreams.practiceProblems;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Anagram {
    public static void main(String[] args) {
        String[] arr={"eat","tea","tan","ate","nat","bat"};
        List<String> newArr= Arrays.asList(arr);
        Collection<List<String>> ars = newArr.stream()
                .collect(Collectors.groupingBy(
                        word -> Arrays.stream(word.toLowerCase().split(""))
                                .sorted()
                                .collect(Collectors.joining()),// optional, to preserve order
                        Collectors.toList()
                ))
                .values();
        System.out.println(ars);
    }
}
