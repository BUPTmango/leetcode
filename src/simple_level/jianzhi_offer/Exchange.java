package simple_level.jianzhi_offer;

/**
 * ������21. ��������˳��ʹ����λ��ż��ǰ��
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ����������λ�������ǰ�벿�֣�����ż��λ������ĺ�벿�֡�
 *
 * ʾ����
 *
 * ���룺nums =?[1,2,3,4]
 * �����[1,3,2,4]
 * ע��[3,1,2,4] Ҳ����ȷ�Ĵ�֮һ��
 *
 * ��ʾ��
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/4 10:26 ����
 */
public class Exchange {
    /**
     * ����˫ָ��
     *
     * �������˫ָ�� fastfast �� lowlow ��fastfast ��ǰ�� lowlow �ں� .
     * fastfast ����������ǰ��������λ�ã�lowlow ��������ָ����һ������Ӧ����ŵ�λ��
     * fastfast ��ǰ�ƶ�����������������ʱ�������� nums[low]nums[low] ��������ʱ lowlow ��ǰ�ƶ�һ��λ�� .
     * �ظ�����������ֱ�� fastfast ָ������ĩβ .
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] % 2 != 0) {
                nums = swap(nums, fast, slow);
                slow++;
            }
            fast++;
        }
        return nums;
    }

    private int[] swap(int[] nums, int i, int j) {
        int middle = nums[i];
        nums[i] = nums[j];
        nums[j] = middle;
        return nums;
    }
}
