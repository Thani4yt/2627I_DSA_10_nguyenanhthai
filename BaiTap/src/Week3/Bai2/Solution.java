package Week3.Bai2;

import java.util.Scanner;
import java.util.Stack;

class Result {

    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return "NO";
                }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống sau khi nhập số t

            for (int i = 0; i < t; i++) {
                String s = scanner.nextLine();
                String result = Result.isBalanced(s);
                System.out.println(result);
            }
        }

        scanner.close();
    }
}