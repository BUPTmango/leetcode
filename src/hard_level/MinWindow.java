package hard_level;

import java.util.HashMap;
import java.util.Map;

/**  ��������ģ��
 * 76. ��С�����Ӵ�
 * ����һ���ַ��� S��һ���ַ��� T ���������һ���㷨�������� O(n) ��ʱ�临�Ӷ��ڣ����ַ��� S �����ҳ������� T �����ַ�����С�Ӵ���
 *
 * ʾ����
 *
 * ���룺S = "ADOBECODEBANC", T = "ABC"
 * �����"BANC"
 *
 * ��ʾ��
 *
 * ��� S �в����������Ӵ����򷵻ؿ��ַ��� ""��
 * ��� S �д����������Ӵ������Ǳ�֤����Ψһ�Ĵ𰸡�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/26 10:11 ����
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        // need��¼Ѱ���ִ���Ҫ�����������ַ� window��¼�����е������ַ�
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char tChar : tArray) {
            need.put(tChar, need.getOrDefault(tChar, 0) + 1);
        }

        int left = 0, right = 0, valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // c�ǽ����봰���е��ַ�
            char c = sArray[right];
            // ���ƴ���
            right++;
            // ���д��������ݵ�һϵ�и���
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // ����һֱ����rightָ�룬ֱ�������а�����need�е������ַ�
            // ��������Ҫ����leftָ��Ѱ�����Ž�
            while (valid == need.size()) {
                // �����������С�����Ӵ�
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d�ǽ��Ƴ����ڵ��ַ�
                char d = sArray[left];
                // ���ƴ���
                left++;
                // ���д��������ݵ�һϵ�и���
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
