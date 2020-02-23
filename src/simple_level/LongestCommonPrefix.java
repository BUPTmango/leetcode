package simple_level;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * @author mango
 * @create 2019-03-06 2:17 PM
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        //如果传入空值或长度为0的话直接返回""
        if (strs == null || strs.length == 0) {
            return "";
        }
        //如果长度位1 直接返回那个字符串 因为只有两个以上的字符串才能进行比较
        if (strs.length == 1) {
            return strs[0];
        }
        //计算最短字符串长度
        int minLength = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
            }
        }
        if (minLength == 0) {
            return "";
        }
        int round = 0;
        int flag =1;
        String result = "";
        while (round < minLength && flag == 1) {
            //第一个字符串的第round位
            char target = strs[0].charAt(round);
            flag = 1;//都一致的话 为1 初始化为1
            //后面的字符串和第一个字符串的第round位比较
            for (int j = 1; j < strs.length; j++) {
                char compare = strs[j].charAt(round);
                if (target != compare) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {
                result = result + target;
            }
            round++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"aa", "aa"}));
    }
}