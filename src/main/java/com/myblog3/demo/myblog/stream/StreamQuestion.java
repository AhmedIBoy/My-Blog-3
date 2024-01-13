package com.myblog3.demo.myblog.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamQuestion {
    public static void main(String[] args) {

        List<Integer> num = Arrays.asList(28,32,57,24,39,65,24,57,85);

//================Sort The List========================
//        List<Integer> sorted = num.stream().sorted().collect(Collectors.toList());
//        System.out.println(sorted);

//===============Sort The List in ReverseOrder======================
//        List<Integer> reverse = num.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
//        System.out.println(reverse);

//===============Get First Five Elements from the List====================
//        List<Integer> five = num.stream().limit(5).collect(Collectors.toList());
//        System.out.println(five);

//================Get First Five Elements from the List and get even numbers==============

//        List<Integer> result = num.stream().limit(5).filter(e -> e % 2 == 0).collect(Collectors.toList());
//        System.out.println(result);

//===============Skip the first five elements in the list and get All======================

//        List<Integer> skip = num.stream().skip(5).collect(Collectors.toList());
//        System.out.println(skip);

//===============print the Duplicate Number From the list================================

//        Set<Integer> duplicate = num.stream().filter(e -> Collections.frequency(num, e) > 1).collect(Collectors.toSet());
//        System.out.println(duplicate);

//===============find a mix and max element from the list=================================

//        Integer max = num.stream().max(Comparator.comparing(Integer::valueOf)).get();
//        System.out.println(max);

//        Integer min = num.stream().min(Comparator.comparing(Integer::valueOf)).get();
//        System.out.println(min);

//=============Find 2nd lowest and highest number from the list==========================

//        Integer high = num.stream().sorted(Collections.reverseOrder()).distinct().skip(1).findFirst().get();
//        System.out.println(high);

//        Integer lowest = num.stream().sorted().distinct().skip(1).findFirst().get();
//        System.out.println(lowest);
    }
}
