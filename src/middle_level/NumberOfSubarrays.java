package middle_level;

/**
 * 1248. ͳ�ơ����������项
 * ����һ����������?nums ��һ������ k��
 *
 * ���ĳ�� ���� ��������ǡ���� k ���������֣����Ǿ���Ϊ����������ǡ����������项��
 *
 * �뷵����������С����������项����Ŀ��
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺nums = [1,1,2,1,1], k = 3
 * �����2
 * ���ͣ����� 3 ���������������� [1,1,2,1] �� [1,2,1,1] ��
 * ʾ�� 2��
 *
 * ���룺nums = [2,4,6], k = 1
 * �����0
 * ���ͣ������в������κ����������Բ��������������顣
 * ʾ�� 3��
 *
 * ���룺nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * �����16
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/21 2:37 ����
 */
public class NumberOfSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length, res = 0, feed = 0, arr[] = new int[len + 2];
        // ����arr����洢1������
        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 == 1) {
                arr[++feed] = i;
            }
        }
        // ��һλΪ-1
        arr[0] = -1;
        // ���һλΪ�ܳ���
        arr[feed + 1] = len;
        // �鿴������û������ӵ�ż�������������
        for (int i = 1; i + k < feed + 2; i++) {
            res += (arr[i] - arr[i - 1]) * (arr[i + k] - arr[i + k - 1]);
        }
        return res;
    }
}
