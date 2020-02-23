package simple_level;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 217
 * �����ظ�Ԫ��
 * ����һ���������飬�ж��Ƿ�����ظ�Ԫ�ء�
 *
 * ����κ�ֵ�������г����������Σ��������� true�����������ÿ��Ԫ�ض�����ͬ���򷵻� false��
 *
 * ʾ�� 1:
 *
 * ����: [1,2,3,1]
 * ���: true
 * ʾ�� 2:
 *
 * ����: [1,2,3,4]
 * ���: false
 * ʾ��?3:
 *
 * ����: [1,1,1,3,3,4,3,2,4,2]
 * ���: true
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/21 10:19 ����
 */
public class ContainsDuplicate {
    public boolean containsDuplicate_map(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            } else {
                map.put(num, 1);
            }
        }
        return false;
    }

    public boolean containsDuplicate_set(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}
