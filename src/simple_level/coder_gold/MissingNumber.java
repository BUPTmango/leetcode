package simple_level.coder_gold;

import java.util.HashSet;
import java.util.Set;

/**
 * ������ 17.04. ��ʧ������
 * ����nums������0��n������������������ȱ��һ�������д�����ҳ��Ǹ�ȱʧ�����������а취��O(n)ʱ���������
 *
 * ע�⣺�����������ԭ�������Ķ�
 *
 * ʾ�� 1��
 *
 * ���룺[3,0,1]
 * �����2
 *
 * ʾ�� 2��
 *
 * ���룺[9,6,4,2,3,5,7,0,1]
 * �����8
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/21 8:58 ����
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int length = nums.length;
        for (int j = 0; j <= length; j++) {
            if (!set.contains(j)) {
                return j;
            }
        }
        return -1;
    }
}
