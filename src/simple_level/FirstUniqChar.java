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
        if (s == null || s.length() == 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        // ��һ�����map����
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        // �ڶ�����в���
        for (int j = 0; j < s.length(); j++) {
            char r = s.charAt(j);
            if (map.containsKey(r)) {
                if (map.get(r) == 1) {
                    return j;
                }
            }
        }
        return -1;
    }
}
