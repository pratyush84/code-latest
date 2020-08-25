package com.learn.hackerrank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SherlockValidStrings {

    public static void main(String[] args) {
        System.out.println(isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd"));
//        System.out.println(findMedian(new long[]{1,2,3}));
    }
    static String isValid(String s){
        char[] chars = s.toCharArray();
        int len = chars.length;
        String answer = "NO";
        Map<Character, Long> freqMap = IntStream
                .range(0, len)
                .mapToObj(i -> chars[i])
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(freqMap.toString());
        long[] distinct = freqMap.values().stream().mapToLong(l -> l).distinct().sorted().toArray();
        long maxFreq = freqMap.values().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream().min(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .get()
                .getKey();

        if(distinct.length <= 3){

//            long med = findMedian(distinct);
            long sum = freqMap.values().stream()
                    .mapToLong(val -> Math.abs(maxFreq - val))
                    .sum();
            if(maxFreq - sum > 1)
                answer = "NO";
            else
                answer = "YES";
        }

        return answer;

    }

    private static long findMedian(long[] arr){
        if (arr.length == 3){
            return arr[1];
        } else
            return Arrays.stream(arr).max().orElse(0);
    }
}
