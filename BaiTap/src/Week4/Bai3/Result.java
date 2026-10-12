package Week4.Bai3;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        int temp = arr.get(n - 1);
        int i = n-2;
        while (i>=0 && arr.get(i)>temp) {
            arr.set(i+1, arr.get(i));
            printArray(arr);
            i--;
        }
        arr.set(i+1, temp);
        printArray(arr);
    }

    private static void printArray(List<Integer> arr) {
        String output = arr.stream()
                .map(String::valueOf)
                .collect(joining(" "));
        System.out.println(output);
    }
}