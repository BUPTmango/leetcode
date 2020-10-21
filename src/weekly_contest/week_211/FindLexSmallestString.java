package weekly_contest.week_211;

import java.util.ArrayList;
import java.util.List;

/**
 * 5544. 执行操作后字典序最小的字符串
 * 给你一个字符串 s 以及两个整数 a 和 b 。其中，字符串 s 的长度为偶数，且仅由数字 0 到 9 组成。
 * <p>
 * 你可以在 s 上按任意顺序多次执行下面两个操作之一：
 * <p>
 * 累加：将  a 加到 s 中所有下标为奇数的元素上（下标从 0 开始）。数字一旦超过 9 就会变成 0，如此循环往复。例如，如果 s = "3456" 且 a = 5，则执行此操作后 s 变成 "3951"。
 * 轮转：将 s 向右轮转 b 位。例如，如果 s = "3456" 且 b = 1，则执行此操作后 s 变成 "6345"。
 * 请你返回在 s 上执行上述操作任意次后可以得到的 字典序最小 的字符串。
 * <p>
 * 如果两个字符串长度相同，那么字符串 a 字典序比字符串 b 小可以这样定义：在 a 和 b 出现不同的第一个位置上，字符串 a 中的字符出现在字母表中的时间早于 b 中的对应字符。例如，"0158” 字典序比 "0190" 小，因为不同的第一个位置是在第三个字符，显然 '5' 出现在 '9' 之前。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "5525", a = 9, b = 2
 * 输出："2050"
 * 解释：执行操作如下：
 * 初态："5525"
 * 轮转："2555"
 * 累加："2454"
 * 累加："2353"
 * 轮转："5323"
 * 累加："5222"
 * 累加："5121"
 * 轮转："2151"
 * 累加："2050"????????????
 * 无法获得字典序小于 "2050" 的字符串。
 * 示例 2：
 * <p>
 * 输入：s = "74", a = 5, b = 1
 * 输出："24"
 * 解释：执行操作如下：
 * 初态："74"
 * 轮转："47"
 * 累加："42"
 * 轮转："24"
 * 无法获得字典序小于 "24" 的字符串。
 * 示例 3：
 * <p>
 * 输入：s = "0011", a = 4, b = 2
 * 输出："0011"
 * 解释：无法获得字典序小于 "0011" 的字符串。
 * 示例 4：
 * <p>
 * 输入：s = "43987654", a = 7, b = 3
 * 输出："00553311"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= s.length <= 100
 * s.length 是偶数
 * s 仅由数字 0 到 9 组成
 * 1 <= a <= 9
 * 1 <= b <= s.length - 1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/18 10:45 上午
 */
public class FindLexSmallestString {
    String rotate(String s1, String s2, int b) {
        String s = "";
        for (int i = 0; i < s1.length(); i++) {
            s += s2.charAt(i);
            s += s1.charAt(i);
        }
        if (b == 0) {
            return s;
        }
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            str += s.charAt((i + b) % s.length());
        }
        return str;
    }

    String helper(String s, List<Integer> lst, int b) {
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 1) {
                s3 += s.charAt(i);
            } else {
                s4 += s.charAt(i);
            }
        }
        List<String> lst1 = new ArrayList<>();
        List<String> lst2 = new ArrayList<>();
        lst1.add(s3);
        lst2.add(s4);
        for (int i = 0; i < lst.size(); i++) {
            int n = lst.get(i);
            s1 = "";
            s2 = "";
            for (int j = 1; j < s.length(); j += 2) {
                int k = s.charAt(j) - '0' - n;
                if (k < 0) k += 10;
                s1 += k;
            }
            lst1.add(s1);
            if (b % 2 == 1) {
                for (int j = 0; j < s.length(); j += 2) {
                    int k = s.charAt(j) - '0' - n;
                    if (k < 0) k += 10;
                    s2 += k;
                }
                lst2.add(s2);
            }
        }
        String str = s;
        for (int i = 0; i < lst2.size(); i++) {
            for (int j = 0; j < lst1.size(); j++) {
                int l = 1;
                String temp = rotate(lst1.get(j), lst2.get(i), 0);
                if (str.compareTo(temp) > 0) str = temp;
                while (l * b % s.length() != 0) {

                    temp = rotate(lst1.get(j), lst2.get(i), l * b);
                    if (str.compareTo(temp) > 0) str = temp;
                    l++;
                }
            }
        }
        return str;

    }

    public String findLexSmallestString(String s, int a, int b) {
        List<Integer> lst = new ArrayList<>();
        int n = 10 - a;
        int k = n;
        do {
            if (k != 0) {
                lst.add(k);
            }
            k = (n + k) % 10;
        } while (n != k);
        return helper(s, lst, b);
    }
}
