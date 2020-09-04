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
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            if (!charMap.containsKey(ch)) {
                return ch;
            } else if (charMap.get(ch) == 0) {
                return ch;
            } else {
                charMap.put(ch, charMap.get(ch) - 1);
            }
        }
        return 'a';
    }
}
