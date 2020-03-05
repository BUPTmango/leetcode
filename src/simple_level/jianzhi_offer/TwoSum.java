package simple_level.jianzhi_offer;

/**
 * ������57. ��Ϊs����������
 * ����һ����������������һ������s���������в�����������ʹ�����ǵĺ�������s������ж�����ֵĺ͵���s�����������һ�Լ��ɡ�
 *
 * ʾ�� 1��
 *
 * ���룺nums = [2,7,11,15], target = 9
 * �����[2,7] ���� [7,2]
 * ʾ�� 2��
 *
 * ���룺nums = [10,26,30,31,47,60], target = 40
 * �����[10,30] ���� [30,10]
 * ?
 * ���ƣ�
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i]?<= 10^6
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/5 9:52 ����
 */
public class TwoSum {
    /**
     * �ύ���ɹ�
     * ����ʱ������
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            int num = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == num) {
                    return new int[] {nums[i], nums[j]};
                }
            }
        }
        return null;
    }

    /**
     * �ӵ�һ�������һ��Ԫ�ؿ�ʼ�㡣
     * ���������Ľ����Ŀ����Ǿ����һ����ǰ�ƣ�����͵�һ��Ŀ�������ơ�
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_better(int[] nums, int target) {
        int head = 0;
        int tail = nums.length - 1;
        while (head < tail) {
            int sum = nums[head] + nums[tail];
            if (sum == target) {
                return new int[] {nums[head], nums[tail]};
            } else if (sum > target) {
                tail--;
            } else {
                head++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum sum = new TwoSum();
        int[] result = sum.twoSum(new int[]{2,7,11,15}, 9);
        for (int i : result) {
            System.out.println(i + "    ");
        }
    }
}
