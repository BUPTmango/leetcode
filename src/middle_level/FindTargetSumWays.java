package middle_level;

/**
 * ����ת�㷨������Ƶ���⡷��̬�滮 ��������
 * 494. Ŀ���
 * ����һ���Ǹ��������飬a1, a2, ..., an, ��һ��Ŀ������S������������������?+?��?-�����������е�����һ���������㶼���Դ�?+?��?-��ѡ��һ�����������ǰ�档
 * <p>
 * ���ؿ���ʹ���������ΪĿ���� S ��������ӷ��ŵķ�������
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: nums: [1, 1, 1, 1, 1], S: 3
 * ���: 5
 * ����:
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * һ����5�ַ���������Ŀ���Ϊ3��
 * ע��:
 * <p>
 * ����ǿգ��ҳ��Ȳ��ᳬ��20��
 * ��ʼ������ĺͲ��ᳬ��1000��
 * ��֤���ص����ս���ܱ�32λ�������¡�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/8 2:50 ����
 */
public class FindTargetSumWays {
    /**
     * ö��  ���Ƽ� ̫��
     * ִ����ʱ��
     * 728 ms
     * , ������ Java �ύ�л�����
     * 8.02%
     * ���û�
     * ���Խ������ + �� -���ݹ���������������
     *
     * @param nums
     * @param S
     * @return
     */
    int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }

    public void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S) {
                count++;
            }
            return;
        }
        calculate(nums, i + 1, sum + nums[i], S);
        calculate(nums, i + 1, sum - nums[i], S);
    }


    /**
     * ��̬�滮
     * �����з���Ϊ�������ܺ���Ϊһ������������������Ϊx��
     * �����з���Ϊ�������ܺ���Ϊһ������������������Ϊy��
     * �ڸ����������У��ж�����ѡ�񷽷��ñ���װ����
     * ��sumΪ������ܺͣ���x+y = sum�������������Ĳ�ΪS,��x-y=S���Ӷ����x=(S+sum)/2��
     * ����������������Ŀת��Ϊ�������⣺����һ�������һ������Ϊx�ı��������ж����ַ�ʽ�ñ���װ����
     *
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays_dp(int[] nums, int S) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        // ��������Ϊ������sum+SΪ�����Ļ�������Ҫ��
        if ((sum + S) % 2 == 1) {
            return 0;
        }
        // Ŀ��Ͳ����ܴ����ܺ�
        if (S > sum) {
            return 0;
        }
        int len = (sum + S) / 2;
        int[] dp = new int[len + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = len; i >= num; --i) {
                dp[i] += dp[i - num];
            }
        }

        return dp[len];
    }
}
