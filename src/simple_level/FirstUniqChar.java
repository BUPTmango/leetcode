package simple_level;

import java.util.HashMap;
import java.util.Map;

/**
 * 387
 * �ַ����еĵ�һ��Ψһ�ַ�
 * ����һ���ַ������ҵ����ĵ�һ�����ظ����ַ���������������������������ڣ��򷵻� -1��
 *
 * ����:
 *
 * s = "leetcode"
 * ���� 0.
 *
 * s = "loveleetcode",
 * ���� 2.
 * ?
 *
 * ע����������Լٶ����ַ���ֻ����Сд��ĸ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/23 10:25 ����
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        // ��һ���¼����
        int[] times = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            times[s.charAt(i) - 'a']++;
        }
        // Ѱ�Ҵ���Ϊ1�ĵ�һ��
        for (int i = 0; i < len; i++) {
            if (times[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
