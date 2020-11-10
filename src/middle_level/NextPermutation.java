package middle_level;

/**
 * 31. ��һ������
 * ʵ�ֻ�ȡ��һ�����еĺ������㷨��Ҫ���������������������г��ֵ�������һ����������С�
 *
 * �����������һ����������У��������������г���С�����У����������У���
 *
 * ����ԭ���޸ģ�ֻ����ʹ�ö��ⳣ���ռ䡣
 *
 * ������һЩ���ӣ�����λ������У�����Ӧ���λ���Ҳ��С�
 * 1,2,3 �� 1,3,2
 * 3,2,1 �� 1,2,3
 * 1,1,5 �� 1,5,1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/8 12:38 ����
 */
public class NextPermutation {
    /**
     * https://www.bilibili.com/video/BV1N4411V7Yw?from=search&seid=988948089204799977
     * �㷨������
     * ���������ҵ�һ��ǰ��Ⱥ���С����
     * �ٴ��������ҵ�һ���ȸ��ҵ��Ǹ��������
     * ����������
     * ֮��Ѻ��������������˳��
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        // �Ӻ���ǰ�ҵ�������������
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = n - 1;
            // ���������ҵ��ȵ�ǰ������ִ����
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        // ���������ȫ������˳��
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private void reverse(int[] nums, int low, int high) {
        while (low < high) {
            swap(nums, low++, high--);
        }
    }
}
