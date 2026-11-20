package Week11.Bai5_2;

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

        Collections.sort(arr);
        Collections.sort(brr);

        List<Integer> missing = new ArrayList<>();
        int i = 0;
        int j = 0;


        while (i < arr.size() && j < brr.size()) {

            int valA = arr.get(i);
            int valB = brr.get(j);

            if (valA == valB) {

                i++;
                j++;
            } else {

                if (missing.isEmpty() || missing.get(missing.size() - 1) != valB) {
                    missing.add(valB);
                }
                j++;
            }
        }

        while (j < brr.size()) {
            int valB = brr.get(j);
            if (missing.isEmpty() || missing.get(missing.size() - 1) != valB) {
                missing.add(valB);
            }
            j++;
        }

        return missing;
    }
}
