package simple_level;

/**
 * 303. ����ͼ��� - ���鲻�ɱ�
 * ����һ���������� ?nums��������������?i?��?j??(i?��?j) ��Χ��Ԫ�ص��ܺͣ�����?i,? j?���㡣
 *
 * ʾ����
 *
 * ���� nums = [-2, 0, 3, -5, 2, -1]����ͺ���Ϊ sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * ˵��:
 *
 * ����Լ������鲻�ɱ䡣
 * ���ε���?sumRange?������
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/8/25 11:06 ����
 */
class NumArray {

    private int[] sum;

    /**
     * ��ʼ����ʱ������ÿ�����������sum
     * @param nums
     */
    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    /**
     * ����������λ�õ�sum������ǽ��
     * @param i
     * @param j
     * @return
     */
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
