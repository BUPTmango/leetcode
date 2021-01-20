package simple_level;

import java.util.Arrays;

/**
 * 628. �����������˻�
 * ����һ���������飬���������ҳ�����������ɵ����˻������������˻���
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: [1,2,3]
 * ���: 6
 * ʾ�� 2:
 * <p>
 * ����: [1,2,3,4]
 * ���: 24
 * ע��:
 * <p>
 * �������������鳤�ȷ�Χ��[3,104]�����������е�Ԫ�ط�Χ��[-1000, 1000]��
 * ����������������������ĳ˻����ᳬ��32λ�з��������ķ�Χ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/20 9:12 ����
 */
public class MaximumProduct {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // �ֱ����������������ĳ˻����Լ�������С��������������ĳ˻�������֮������ֵ��Ϊ�����
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }
}
