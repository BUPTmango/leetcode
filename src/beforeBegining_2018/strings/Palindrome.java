package beforeBegining_2018.strings;

import javax.xml.stream.events.Characters;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 输入: "race a car"
 * 输出: false
 * @author mango
 * @create 2019-03-01 10:06 AM
 */
public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.equals("")) {
            return true;
        }
        int headIndex = 0;
        int tailIndex = s.length() - 1;
        while ((tailIndex - headIndex) > 0) {
            //开头不是字母或者数字
            while (!Character.isLetterOrDigit(s.charAt(headIndex))) {
                if((headIndex + 1) <= tailIndex) {
                    headIndex++;
                } else {
                    return true;
                }
            }
            //head找到了字母或者数字
            while (!Character.isLetterOrDigit(s.charAt(tailIndex))) {
                if ((tailIndex - 1) >= headIndex) {
                    tailIndex--;
                } else {
                    return true;
                }
            }
            //tail找到了字母或者数字
            //进行比较 查看字符是否相等
            if (!String.valueOf(s.charAt(headIndex)).equalsIgnoreCase(String.valueOf(s.charAt(tailIndex)))) {
                return false;
            } else {
                headIndex++;
                tailIndex--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(".,"));
    }
}