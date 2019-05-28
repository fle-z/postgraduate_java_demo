package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 十种翻转字符串的方法
 */
public class ReverseString {
    public String reverseWithStringConcat(String input) {
        String output = new String();
        for (int i = (input.length() - 1); i >= 0; i--) {
            output += (input.charAt(i));
        }
        display(input, output);
        return output;
    }

    public String reverseWithStringBuilder(String input) {
        final StringBuilder builder = new StringBuilder(input);
        display(input, builder.reverse().toString());
        return builder.reverse().toString();
    }

    public String reverseWithCharAt(String input) {
        final StringBuilder builder = new StringBuilder();
        for (int i = (input.length() - 1); i >= 0; i--) {
            builder.append(input.charAt(i));
        }
        display(input, builder.toString());
        return builder.toString();
    }

    public String reverseWithSwqps(String input) {
        final char[] array = input.toCharArray();
        final int length = array.length - 1;
        final int half = (int) Math.floor(array.length / 2);
        char c;
        for (int i = length; i >= half; i--) {
            c = array[length - i];
            array[length - i] = array[i];
            array[i] = c;
        }
        display(input, String.valueOf(array));
        return String.valueOf(array);
    }

    public String reverseWithXOR(String input) {
        final char[] arary = input.toCharArray();
        final int length = arary.length;
        final int half = (int) Math.floor(arary.length / 2);
        for (int i = 0; i < half; i++) {
            arary[i] ^= arary[length-i-1];
            arary[length-i-1] ^= arary[i];
            arary[i] ^= arary[length-i-1];
        }
        display(input, String.valueOf(arary));
        return String.valueOf(arary);
    }

    public String reverseWithStack(String input) {
        if (input == null || input.equals(""))
            return input;
        Stack<Character> stack = new Stack<>();
        char[] array = input.toCharArray();
        for (int i =0; i < input.length(); i++)
            stack.push(array[i]);
        int k = 0;
        while (!stack.empty())
            array[k++] = stack.pop();
        return String.copyValueOf(array);
    }

    public String reverseWithCollection(String str) {
        if (str == null || str.equals(""))
            return str;
        List<Character> list = new ArrayList<>();
        for (char c : str.toCharArray())
            list.add(c);
        Collections.reverse(list);
        StringBuilder builder = new StringBuilder(list.size());
        for (Character c : list)
            builder.append(c);

        return builder.toString();
    }

    public String reverseWithByte(String str) {
        if (str == null || str.equals(""))
            return str;
        byte[] bytes = str.getBytes();
        for (int l = 0, h = str.length() - 1; l < h; l++, h--) {
            byte temp = bytes[l];
            bytes[l] = bytes[h];
            bytes[h] = temp;
        }

        return new String(bytes);
    }

    public String reverseWithSubstring(String str) {
        if (str == null || str.equals(""))
            return str;
        return str.charAt(str.length() - 1) + reverseWithSubstring(str.substring(0, str.length() - 1));
    }

    static int p = 0;
    public void reverseWithRecursive(char[] str, int k) {
        if (k == str.length)
            return;
        reverseWithRecursive(str, k + 1);
        if (p < k) {
            char temp = str[k];
            str[k] = str[p];
            str[p++] = temp;
        }
    }
    public String reverseWithRecursive(String str) {
        if (str == null || str.equals(""))
            return str;
        char[] ch = str.toCharArray();
        reverseWithRecursive(ch, 0);
        return String.copyValueOf(ch);
    }

    private void display(String input, String output) {
        System.out.println("input string : " + input);
        System.out.println("output string : " + output);
    }

    public static void main(String[] args) {
        String input = "javaguides";
        ReverseString reverseString = new ReverseString();
        reverseString.reverseWithStringConcat(input);
    }
}
