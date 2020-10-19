package middle_level;

/**
 * ����ת�㷨������Ƶ���⡷��̬�滮 ��������
 * 416. �ָ�Ⱥ��Ӽ�
 * ����һ��ֻ�����������ķǿ����顣�Ƿ���Խ��������ָ�������Ӽ���ʹ�������Ӽ���Ԫ�غ���ȡ�
 *
 * ע��:
 *
 * ÿ�������е�Ԫ�ز��ᳬ�� 100
 * ����Ĵ�С���ᳬ�� 200
 * ʾ�� 1:
 *
 * ����: [1, 5, 11, 5]
 *
 * ���: true
 *
 * ����: ������Էָ�� [1, 5, 5] �� [11].
 *
 * ʾ��?2:
 *
 * ����: [1, 2, 3, 5]
 *
 * ���: false
 *
 * ����: ���鲻�ָܷ������Ԫ�غ���ȵ��Ӽ�.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/11 5:57 ����
 */
public class CanPartition {
    /**
     * ���͵ı������� ��n����Ʒ��ѡ��һ����Ʒ����sum/2�ı���
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // ���У�������������Ͳ�����Ҫ��
        if (sum % 2 != 0) {
            return false;
        }

        int capacity = sum / 2;
        boolean[] dp = new boolean[capacity + 1];

        for (int i = 0; i <= capacity; i++) {
            // ��ʼ��ֻ����nums[0]��һ��Ԫ�ص�ʱ��Ҫ��������һ��Ԫ�ؾ�װ���˱�������Ϊtrue������Ϊfalse
            dp[i] = (nums[0] == i);
        }

        // ����nums[i]Ԫ�� �ڱ���j�����µ����
        for (int i = 1; i < len; i++) {
            for (int j = capacity; j >= nums[i]; j--) {
                // ���ǲ�ʹ�ú�ʹ������ӵ�nums[i]Ԫ���������
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        return dp[capacity];
    }
}
