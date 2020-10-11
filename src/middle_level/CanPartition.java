package middle_level;

/**
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
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        // ������ά״̬���飬�У���Ʒ�������У����������� 0��
        boolean[][] dp = new boolean[len][target + 1];

        // ������� 0 �У��� 1 ����ֻ�����ݻ�Ϊ���Լ��ı���ǡ��װ��
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        // ��������漸��
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                // ֱ�Ӵ���һ���Ȱѽ����������Ȼ��������
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][target];
    }
}
