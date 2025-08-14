package QUEUE;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingLetters {
    public static void printFirstNonRepeating(String str) {
        int frequency[] = new int[26]; 
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));

            q.add(ch);
            frequency[ch - 'a']++;

            while (!q.isEmpty() && frequency[q.peek() - 'a'] > 1) {
                q.remove();
            }

            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String str1 = "aabcccxbac";  // lowercase example
        String str2 = "AaBccC";      // mixed case example

        System.out.println("Lowercase example:");
        printFirstNonRepeating(str1);

        System.out.println("Mixed case example:");
        printFirstNonRepeating(str2);
    }
}
