package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入:?"aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/29 1:47 下午
 */
public class Partition {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, s,  new ArrayList<String>());
        return res;
    }
    private void backtrack(List<List<String>> res, String s, ArrayList<String> tmp) {
        // s表示待分割的字符串 长度为0代表已经分割完一种情况
        if (s == null || s.length() == 0) res.add(new ArrayList<>(tmp));
        // 从头寻找第一个分割点
        for (int i = 1; i <= s.length(); i++) {
            if (isPalidrome(s.substring(0, i))) {
                tmp.add(s.substring(0, i));
                // 继续回溯剩下的字符串
                backtrack(res, s.substring(i, s.length()), tmp);
                // 回溯后删除最后一种情况
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    /**
     * 双指针验证是不是回文串
     * @param sb
     * @return
     */
    private  boolean isPalidrome(String sb) {
        int left = 0;
        int right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) return false;
            left++;
            right--;
        }
        return true;

    }
}
