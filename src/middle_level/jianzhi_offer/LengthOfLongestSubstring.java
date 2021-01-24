package middle_level.jianzhi_offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ��ָ Offer 48. ������ظ��ַ������ַ���
 * ����ַ������ҳ�һ����Ĳ������ظ��ַ������ַ��������������ַ����ĳ��ȡ�
 * <p>
 * ?
 * <p>
 * ʾ��?1:
 * <p>
 * ����: "abcabcbb"
 * ���: 3
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
 * ʾ�� 2:
 * <p>
 * ����: "bbbbb"
 * ���: 1
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��
 * ʾ�� 3:
 * <p>
 * ����: "pwwkew"
 * ���: 3
 * ����: ��Ϊ���ظ��ַ�����Ӵ���?"wke"�������䳤��Ϊ 3��
 * ?    ��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke"?��һ�������У������Ӵ���
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/28 9:36 ����
 */
public class LengthOfLongestSubstring {
    /**
     * �������ڣ�˫ָ��
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, res = 0;
        while (right < s.length()) {
            char c = s.charAt(right++);
            // �����ظ����ַ������ƶ���ָ�룬ֱ�����������в����и��ַ�
            while (set.contains(c)) {
                set.remove(s.charAt(left++));
            }
            set.add(c);
            res = Math.max(res, right - left);
        }
        return res;
    }
}
