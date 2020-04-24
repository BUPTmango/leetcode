package simple_level;

import java.util.Arrays;

/**
 * 561. ������ I
 * ��������Ϊ?2n?������, ��������ǽ���Щ���ֳ�?n ��, ���� (a1, b1), (a2, b2), ..., (an, bn) ��ʹ�ô�1 ��?n �� min(ai, bi) �ܺ����
 *
 * ʾ�� 1:
 *
 * ����: [1,4,3,2]
 *
 * ���: 4
 * ����: n ���� 2, ����ܺ�Ϊ 4 = min(1, 2) + min(3, 4).
 * ��ʾ:
 *
 * n?��������,��Χ�� [1, 10000].
 * �����е�Ԫ�ط�Χ�� [-10000, 10000].
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/24 10:09 ����
 */
public class ArrayPairSum {
    /**
     * ���ǿ��ԶԸ��������Ԫ�ؽ������򣬲�ֱ�Ӱ�����˳���γ�Ԫ�ص���ԡ�
     * �⽫����Ԫ�ص���ԣ�����֮��Ĳ�����С���Ӷ����������ܺ͵���󻯡�
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        // ����
        Arrays.sort(nums);
        int sum = 0;
        // ����һ�� ѡÿ���һ��
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
