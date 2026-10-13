package Week3.Bai3;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Long> stackEnqueue = new Stack<>();
        Stack<Long> stackDequeue = new Stack<>();

        try {

            int q = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < q; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int type = Integer.parseInt(st.nextToken());

                if (type == 1) {
                    long x = Long.parseLong(st.nextToken());
                    stackEnqueue.push(x);
                } else {

                    if (stackDequeue.isEmpty()) {
                        while (!stackEnqueue.isEmpty()) {
                            stackDequeue.push(stackEnqueue.pop());
                        }
                    }

                    if (type == 2) {
                        if (!stackDequeue.isEmpty()) {
                            stackDequeue.pop();
                        }
                    } else if (type == 3) {
                        if (!stackDequeue.isEmpty()) {
                            sb.append(stackDequeue.peek()).append("\n");
                        }
                    }
                }
            }
            System.out.print(sb);

        } catch (Exception e) {
        }
    }
}