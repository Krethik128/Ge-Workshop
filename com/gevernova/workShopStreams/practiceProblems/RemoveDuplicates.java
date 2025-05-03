package gevernova.workShopStreams.practiceProblems;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String lorem="KrethikKrethik";
//        lorem.chars()
//                .distinct()
//                .mapToObj(x->(char)x)
//                .forEach(System.out::print);

        Arrays.stream(lorem.split(""))
                .distinct()
                .forEach(System.out::print);
    }
}
