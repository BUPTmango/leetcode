package simple_level.coder_gold;

import java.util.HashSet;
import java.util.Set;

/**
 * ������ 01.01. �ж��ַ��Ƿ�Ψһ
 * ʵ��һ���㷨��ȷ��һ���ַ��� s �������ַ��Ƿ�ȫ����ͬ��
 *
 * ʾ�� 1��
 *
 * ����: s = "leetcode"
 * ���: false
 * ʾ�� 2��
 *
 * ����: s = "abc"
 * ���: true
 * ���ƣ�
 *
 * 0 <= len(s) <= 100
 * ����㲻ʹ�ö�������ݽṹ����ܼӷ֡�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/18 10:32 ����
 */
public class IsUnique {
    public boolean isUnique(String astr) {
        if (astr == null || astr.length() == 0) {
            return true;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            if (set.contains(c)) {
                return false;
            } else {
                set.add(c);
            }
        }
        return true;
    }
}
