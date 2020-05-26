package middle_level;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 287. Ѱ���ظ���
 * ����һ������?n + 1 ������������?nums�������ֶ��� 1 �� n?֮�䣨���� 1 �� n������֪���ٴ���һ���ظ�������������ֻ��һ���ظ����������ҳ�����ظ�������
 *
 * ʾ�� 1:
 *
 * ����: [1,3,4,2,2]
 * ���: 2
 * ʾ�� 2:
 *
 * ����: [3,1,3,4,2]
 * ���: 3
 * ˵����
 *
 * ���ܸ���ԭ���飨����������ֻ���ģ���
 * ֻ��ʹ�ö���� O(1) �Ŀռ䡣
 * ʱ�临�Ӷ�С�� O(n2) ��
 * ������ֻ��һ���ظ������֣��������ܲ�ֹ�ظ�����һ�Ρ�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/26 10:35 ����
 */
public class FindDuplicate {
    /**
     * �����Ƚ�����Ԫ��
     * @param nums
     * @return
     */
    public int findDuplicate_sort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * HashSet
     * @param nums
     * @return
     */
    public int findDuplicate_hashset(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }
}
