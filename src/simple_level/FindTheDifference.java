package simple_level;

import java.util.HashMap;
import java.util.Map;

/**
 * 389. �Ҳ�ͬ
 * ���������ַ��� s �� t������ֻ����Сд��ĸ��
 *
 * �ַ���?t?���ַ���?s?������ţ�Ȼ�������λ�����һ����ĸ��
 *
 * ���ҳ��� t �б���ӵ���ĸ��
 *
 * ?
 *
 * ʾ��:
 *
 * ���룺
 * s = "abcd"
 * t = "abcde"
 *
 * �����
 * e
 *
 * ���ͣ�
 * 'e' ���Ǹ�����ӵ���ĸ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/4 9:09 ����
 */
public class FindTheDifference {
    /**
     * ������
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            cnt[ch - 'a']--;
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }
        return ' ';
    }

    /**
     * ��ͷ� ���������ַ�����asc��Ĳ�ֵ
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference_sum(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }

    /**
     * λ����
     * ����������ַ���ƴ�ӳ�һ���ַ�����������ת�������ַ����г��������ε��ַ���
     * �����ڡ�136. ֻ����һ�ε����֡�������ʹ��λ����ļ��ɽ�����⡣
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference_bit(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            ret ^= t.charAt(i);
        }
        return (char) ret;
    }
}
