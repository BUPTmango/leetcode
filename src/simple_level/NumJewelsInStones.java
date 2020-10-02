package simple_level;

import java.util.HashSet;
import java.util.Set;

/**
 * 771. ��ʯ��ʯͷ
 * �����ַ���J����ʯͷ�б�ʯ�����ͣ����ַ���S������ӵ�е�ʯͷ��S��ÿ���ַ�������һ����ӵ�е�ʯͷ�����ͣ�����֪����ӵ�е�ʯͷ���ж����Ǳ�ʯ��
 *
 * J�е���ĸ���ظ���J��S�е������ַ�������ĸ����ĸ���ִ�Сд�����"a"��"A"�ǲ�ͬ���͵�ʯͷ��
 *
 * ʾ�� 1:
 *
 * ����: J = "aA", S = "aAAbbbb"
 * ���: 3
 * ʾ�� 2:
 *
 * ����: J = "z", S = "ZZ"
 * ���: 0
 * ע��:
 *
 * S��J��ຬ��50����ĸ��
 * J�е��ַ����ظ���
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/2 8:25 ����
 */
public class NumJewelsInStones {

    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (char j : J.toCharArray()) {
            set.add(j);
        }

        int count = 0;
        for (char s : S.toCharArray()) {
            if (set.contains(s)) {
                count++;
            }
        }

        return count;
    }
}
