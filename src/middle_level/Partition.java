package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
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
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, s,  new ArrayList<String>());
        return res;
    }
    private void backtrack(List<List<String>> res, String s, ArrayList<String> tmp) {
        // s��ʾ���ָ���ַ��� ����Ϊ0�����Ѿ��ָ���һ�����
        if (s == null || s.length() == 0) res.add(new ArrayList<>(tmp));
        // ��ͷѰ�ҵ�һ���ָ��
        for (int i = 1; i <= s.length(); i++) {
            if (isPalidrome(s.substring(0, i))) {
                tmp.add(s.substring(0, i));
                // ��������ʣ�µ��ַ���
                backtrack(res, s.substring(i, s.length()), tmp);
                // ���ݺ�ɾ�����һ�����
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    /**
     * ˫ָ����֤�ǲ��ǻ��Ĵ�
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
