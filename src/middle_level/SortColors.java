package middle_level;

/**
 * ����ת�㷨������Ƶ���⡷��·����
 * 75. ��ɫ����
 * ����һ��������ɫ����ɫ����ɫ��һ��?n ��Ԫ�ص����飬ԭ�ض����ǽ�������ʹ����ͬ��ɫ��Ԫ�����ڣ������պ�ɫ����ɫ����ɫ˳�����С�
 *
 * �����У�����ʹ������ 0��?1 �� 2 �ֱ��ʾ��ɫ����ɫ����ɫ��
 *
 * ע��:
 * ����ʹ�ô�����е����������������⡣
 *
 * ʾ��:
 *
 * ����: [2,0,2,1,1,0]
 * ���: [0,0,1,1,2,2]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/18 7:53 ����
 */
public class SortColors {

    /**
     * ��·���� <1 =1 >1
     * @param nums
     */
    public void sortColors(int[] nums) {
        // nums[0,zero] == 0
        int zero = -1;
        // nums[two,n-1] == 2
        int two = nums.length;
        for (int i = 0; i < two; ) {
            // ==1 ֱ��������� �м䲿��Ϊ1
            if (nums[i] == 1) {
                i++;
                // ==2 two-1֮���i����λ�� ��������ṹ ���沿��Ϊ2
            } else if (nums[i] == 2) {
                swap(nums, --two, i);
                // ==0 zero+1֮�󽻻�λ�� ��������ӿ� ǰ�沿��Ϊ0
            } else {
                assert nums[i] == 0;
                swap(nums, ++zero, i++);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int middle = nums[i];
        nums[i] = nums[j];
        nums[j] = middle;
    }
}
