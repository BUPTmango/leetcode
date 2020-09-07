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
     * �������˫ָ�� fast �� low ��fast ��ǰ�� low �ں� .
     * fast ����������ǰ��������λ�ã�low ��������ָ����һ������Ӧ����ŵ�λ��
     * fast ��ǰ�ƶ�����������������ʱ�������� nums[low] ��������ʱ low ��ǰ�ƶ�һ��λ�� .
     * �ظ�����������ֱ�� fast ָ������ĩβ .
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int fast = 0, slow = 0;
        // fast��ǰ��������λ��
        while (fast < nums.length) {
            // ����������
            if (nums[fast] % 2 != 0) {
                // fastλ�ú�slowλ�ý���
                nums = swap(nums, fast, slow);
                // slow��ǰ�ƶ�һ��λ�� slow����һ������Ӧ�ô�ŵ�λ��
                slow++;
            }
            // fast��ǰ�ƶ�
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
