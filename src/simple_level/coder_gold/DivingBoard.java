package simple_level.coder_gold;

import java.lang.reflect.Array;
import java.util.*;

/**
 * ������ 16.11. ��ˮ��
 * ������ʹ��һ��ľ�彨����ˮ�塣���������͵�ľ�壬���г��Ƚ϶̵�ľ�峤��Ϊshorter�����Ƚϳ���ľ�峤��Ϊlonger�����������ʹ��k��ľ�塣��дһ��������������ˮ�����п��ܵĳ��ȡ�
 *
 * ���صĳ�����Ҫ��С�������С�
 *
 * ʾ����
 *
 * ���룺
 * shorter = 1
 * longer = 2
 * k = 3
 * ����� {3,4,5,6}
 * ��ʾ��
 *
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/2 11:56 ����
 */
public class DivingBoard {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= k; i++) {
            set.add(i * shorter + (k - i) * longer);
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int length = list.size();
        int[] result = new int[length];
        int index = 0;
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int element = it.next();
            result[index] = element;
            index++;
        }
        return result;
    }
}
