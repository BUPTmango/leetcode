package simple_level.coder_gold;

import java.util.HashMap;
import java.util.Map;

/**
 * ������ 01.04. ��������
 * ����һ���ַ�������дһ�������ж����Ƿ�Ϊĳ�����Ĵ�������֮һ��
 *
 * ���Ĵ���ָ������������һ���ĵ��ʻ���������ָ��ĸ���������С�
 *
 * ���Ĵ���һ�����ֵ䵱�еĵ��ʡ�
 *
 * ?
 *
 * ʾ��1��
 *
 * ���룺"tactcoa"
 * �����true��������"tacocat"��"atcocta"���ȵȣ�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/29 12:21 ����
 */
public class CanPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int count = 0;
        for (char c : map.keySet()) {
            if (map.get(c) % 2 != 0) {
                count++;
            }
        }
        return count <= 1;
    }
}
