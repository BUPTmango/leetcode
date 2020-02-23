package simple_level;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 *
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * @author mango
 * @create 2019-03-06 1:54 PM
 */
public class RomanToInt {
    public static final int I = 1;
    public static final int V = 5;
    public static final int X = 10;
    public static final int L = 50;
    public static final int C = 100;
    public static final int D = 500;
    public static final int M = 1000;
    public static int romanToInt(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            if (target == 'I') {
                //索引不能溢出 并且I在V或者X左边
                if (i + 1 < s.length() && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                    count = count - I;
                } else {
                    count = count + I;
                }
            }
            if (target == 'X') {
                //索引不能溢出 并且I在V或者X左边
                if (i + 1 < s.length() && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                    count = count - X;
                } else {
                    count = count + X;
                }
            }
            if (target == 'C') {
                //索引不能溢出 并且I在V或者X左边
                if (i + 1 < s.length() && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                    count = count - C;
                } else {
                    count = count + C;
                }
            }
            if (target == 'V') {
                count = count + V;
            }
            if (target == 'L') {
                count = count + L;
            }
            if (target == 'D') {
                count = count + D;
            }
            if (target == 'M') {
                count = count + M;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}