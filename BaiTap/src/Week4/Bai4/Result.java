package Week4.Bai4;

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
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int n, List<Integer> arr) {

        for (int i = 1; i < n; i++) {
            int temp = arr.get(i);
            int j = i - 1;

            while (j >= 0 && arr.get(j) > temp) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, temp);

            for (int k = 0; k < n; k++) {
                System.out.print(arr.get(k) + (k == n - 1 ? "" : " "));
            }
            System.out.println();
        }
    }

}