package com.linkwanggo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 345. Reverse Vowels of a String (Easy)
 * <a href="https://leetcode-cn.com/problems/reverse-vowels-of-a-string/description/">力扣</a>
 * ---
 * Given s = "leetcode", return "leotcede".
 * ---
 * 使用双指针，一个指针从头向尾遍历，一个指针从尾到头遍历，当两个指针都遍历到元音字符时，交换这两个元音字符。
 *
 * 为了快速判断一个字符是不是元音字符，我们将全部元音字符添加到集合 HashSet 中，从而以 O(1) 的时间复杂度进行该操作。
 *
 * 时间复杂度为 O(N)：只需要遍历所有元素一次
 * 空间复杂度 O(1)：只需要使用两个额外变量
 */

public class ReverseVowelsOfString {

    private final static HashSet<Character> vowelSet = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public static String reverseVowels(String str)  {
        if (str == null) {
            return null;
        }
        int i = 0, j = str.length() - 1;
        char[] result = new char[str.length()];
        while (i <= j) {
            char ci = str.charAt(i);
            char cj = str.charAt(j);
            if (!vowelSet.contains(ci)) {
                result[i++] = ci;
            } else if (!vowelSet.contains(cj)) {
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        String str = "leetcode";
        String result = ReverseVowelsOfString.reverseVowels(str);
        System.out.println("result = " + result);
    }
}
