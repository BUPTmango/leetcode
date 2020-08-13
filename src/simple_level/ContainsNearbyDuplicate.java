package simple_level;

import java.util.HashSet;
import java.util.Set;

/**
 * 219. �����ظ�Ԫ�� II
 * ����һ�����������һ������?k���ж��������Ƿ����������ͬ������?i?��?j��ʹ��?nums [i] = nums [j]������ i �� j?�Ĳ�� ����ֵ ����Ϊ k��
 *
 * ?
 *
 * ʾ��?1:
 *
 * ����: nums = [1,2,3,1], k = 3
 * ���: true
 * ʾ�� 2:
 *
 * ����: nums = [1,0,1,1], k = 1
 * ���: true
 * ʾ�� 3:
 *
 * ����: nums = [1,2,3,1,2,3], k = 2
 * ���: false
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/8/12 6:09 ����
 */
public class ContainsNearbyDuplicate {
    /**
     * ��ɢ�б�ά��һ�� k ��С�Ļ�������
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            // ��ɢ�б���������ǰԪ�أ�����ҵ��˾ͷ���true
            if (set.contains(nums[i])) {
                return true;
            }
            // ��ɢ�б��в��뵱ǰԪ��
            set.add(nums[i]);
            // �����ǰɢ�б�Ĵ�С������k�� ɾ��ɢ�б�����ɵ�Ԫ��
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
