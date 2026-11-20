package Week11.Bai5_3;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {

        int min = Collections.min(brr);

        int[] crr = new int[101];

        for (int x : brr) {
            crr[x - min]++;
        }

        for (int x : arr) {
            crr[x - min]--;
        }

        List<Integer> missing = new ArrayList<>();
        for (int i = 0; i < crr.length; i++) {
            if (crr[i] > 0) {
                missing.add(i + min);
            }
        }

        return missing;
    }

}



