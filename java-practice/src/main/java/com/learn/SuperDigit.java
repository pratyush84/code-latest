package com.learn;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuperDigit {
    public static void main(String[] args) throws IOException {
        List<String> input =  Files.readAllLines(Paths.get("C:\\Pratyush\\sam\\sam-test\\leetcodecontest\\src\\main\\resources\\input.txt"));

        long startTime = System.nanoTime();
        System.out.println(superDigit(input.get(0),10000));
        long endTime = System.nanoTime();

        System.out.println("Time Diff in NanoSeconds- " + (endTime-startTime));
    }

    static int superDigit(String n, int k) {
        Map<String,String> resultMap = new HashMap<>();
      int result =  Integer.parseInt(sum(n,n.length(),resultMap)) * k;
      String finalResult = String.valueOf(result);
        Map<String,String> resultMap1 = new HashMap<>();
      if(result > 9){
           finalResult = sum(String.valueOf(result), String.valueOf(result).length(), resultMap1);
      }
      return Integer.parseInt(finalResult);

    }

    static String sum(String num, int len, Map<String, String> resultMap){
        if(resultMap.containsKey(num)){
            return resultMap.get(num);
        }

        String result = null;

        if(len == 0){
            result =  "0";
        } else if(len == 1){
            result =  num;
        } else {
            result = sum(sumDigit(num), num.length(), resultMap);
        }
        resultMap.put(num, result);

        return result;
    }

    static String sumDigit(String s){
        if(s.length() == 0){
            return "0";
        } else if(s.length() == 1){
            return s;
        }
      char[] chars = s.toCharArray();
        int sum = 0;
      for (char chr: chars){
          sum+=Integer.parseInt(String.valueOf(chr));
      }

      return String.valueOf(sum);
    }

}
