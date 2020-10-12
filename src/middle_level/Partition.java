package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * ����ת�㷨������Ƶ���⡷ �������� �����㷨
 * 131. �ָ���Ĵ�
 * ����һ���ַ��� s���� s �ָ��һЩ�Ӵ���ʹÿ���Ӵ����ǻ��Ĵ���
 *
 * ���� s ���п��ܵķָ����
 *
 * ʾ��:
 *
 * ����:?"aab"
 * ���:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/29 1:47 ����
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
        // ����������� ��ӽ��
        if (index == s.length()) {
            ans.add(new ArrayList<>(list));
        }

        // ����
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
