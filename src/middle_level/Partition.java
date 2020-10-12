package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 《玩转算法面试视频例题》 树形问题 回溯算法
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
    private List<List<String>> ans = new ArrayList<>();
    private List<String> list = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return ans;
        }
        findPartition(s, 0);
        return ans;
    }

    private void findPartition(String s, int index) {
        // 遍历到最后了 添加结果
        if (index == s.length()) {
            ans.add(new ArrayList<>(list));
        }

        // 遍历
        for (int endIndex = index; endIndex < s.length(); endIndex++) {
            String subString = s.substring(index, endIndex + 1);
            if (isPalindrome(subString)) {
                list.add(subString);
                findPartition(s, endIndex + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
