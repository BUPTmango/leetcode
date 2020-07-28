package middle_level.jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * ��ָ Offer 48. ������ظ��ַ������ַ���
 * ����ַ������ҳ�һ����Ĳ������ظ��ַ������ַ��������������ַ����ĳ��ȡ�
 *
 * ?
 *
 * ʾ��?1:
 *
 * ����: "abcabcbb"
 * ���: 3
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
 * ʾ�� 2:
 *
 * ����: "bbbbb"
 * ���: 1
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��
 * ʾ�� 3:
 *
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
     * ��ϣ�� dic ͳ�ƣ� ָ�� j �����ַ� s ����ϣ��ͳ���ַ� s[j] ���һ�γ��ֵ����� ��
     * ������ָ�� i �� ����������ָ�� i �� dic[s[j]] ��ÿ�ָ�����߽� i ����֤���� [i + 1, j] �����ظ��ַ������
     * i = max(dic[s[j]], i)
     *
     * ���½�� res �� ȡ���� res �ͱ���˫ָ������ [i + 1,j] �Ŀ�ȣ��� j - i ���е����ֵ��
     * res = max(res, j - i)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for(int j = 0; j < s.length(); j++) {
            if(dic.containsKey(s.charAt(j))) {
                i = Math.max(i, dic.get(s.charAt(j))); // ������ָ�� i
            }
            dic.put(s.charAt(j), j); // ��ϣ���¼
            res = Math.max(res, j - i); // ���½��
        }
        return res;
    }
}
