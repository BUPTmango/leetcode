package hard_level;

/**
 * 327. ����͵ĸ���
 * ����һ����������nums�������������[lower, upper]֮��ĸ���������lower��upper��
 * �����S(i, j)��ʾ��nums�У�λ�ô�i��j��Ԫ��֮�ͣ�����i��j(i �� j)��
 *
 * ˵��:
 * ��ֱ�۵��㷨���Ӷ���O(n2) �����ڴ˻������Ż�����㷨��
 *
 * ʾ��:
 *
 * ����: nums = [-2,5,-1], lower = -2, upper = 2,
 * ���: 3
 * ����: 3������ֱ���: [0,0], [2,2], [0,2]�����Ǳ�ʾ�ĺͷֱ�Ϊ: -2, -1, 2��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/7 12:17 ����
 */
public class CountRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int res = 0;
        long low = lower;
        long up = upper;
        for (int i = 0; i < nums.length; i++) {
            long sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= low && sum <= up) {
                    res++;
                }
            }
        }
        return res;
    }
}
