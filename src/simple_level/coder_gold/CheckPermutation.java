package simple_level.coder_gold;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 01.02. 判定是否互为字符重排
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 *
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/19 10:20 上午
 */
public class CheckPermutation {
    /**
     * 先决条件：两个数组必须大小一样；
     * 哈希表存储每个字母出现的次数，只要任何一个字符出现的次数都相等，则可以进行重排列得到。
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkPermutation(String s1, String s2) {
        if(s1.length()!=s2.length()) {
            return false;
        }

        int hash1[] = new int[128];
        int hash2[] = new int[128];
        for(int j=0;j<s1.length(); j++){
            hash1[s1.charAt(j)]++;
            hash2[s2.charAt(j)]++;
        }

        for(int a=0; a<128; a++){
            if(hash1[a]!=hash2[a]) {
                return false;
            }
        }
        return true;
    }

}
