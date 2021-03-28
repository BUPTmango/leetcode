package middle_level.jianzhi_offer;

import java.util.HashSet;
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
        int n = s.length();
        int l = 0, r = 0;
        int res = 0;
        // ��������
        while (l < n) {
            while (r < n && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }
            // ����
            res = Math.max(res, r - l);
            set.remove(s.charAt(l++));
        }
        return res;
    }
}
