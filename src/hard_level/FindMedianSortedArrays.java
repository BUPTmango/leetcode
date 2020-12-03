package hard_level;

import java.util.Arrays;

/**
 * 4. Ѱ�����������������λ��
 * ����������СΪ m �� n �����򣨴�С��������nums1 ��nums2�������ҳ������������������������λ����
 * <p>
 * ���ף��������һ��ʱ�临�Ӷ�Ϊ O(log (m+n)) ���㷨�����������
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums1 = [1,3], nums2 = [2]
 * �����2.00000
 * ���ͣ��ϲ����� = [1,2,3] ����λ�� 2
 * ʾ�� 2��
 * <p>
 * ���룺nums1 = [1,2], nums2 = [3,4]
 * �����2.50000
 * ���ͣ��ϲ����� = [1,2,3,4] ����λ�� (2 + 3) / 2 = 2.5
 * ʾ�� 3��
 * <p>
 * ���룺nums1 = [0,0], nums2 = [0,0]
 * �����0.00000
 * ʾ�� 4��
 * <p>
 * ���룺nums1 = [], nums2 = [1]
 * �����1.00000
 * ʾ�� 5��
 * <p>
 * ���룺nums1 = [2], nums2 = []
 * �����2.00000
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/3 9:53 ����
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // �ϲ�������������
        int[] merge = merge(nums1, nums2);
        // ��ȡ��λ��
        int n = merge.length;
        if (n % 2 == 0) {
            return (merge[n / 2 - 1] + merge[n / 2]) / 2;
        } else {
            return merge[n / 2];
        }
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int i = 0, j = 0, index = 0;
        int[] res = new int[length1 + length2];
        while (i < length1 && j < length2) {
            if (nums1[i] <= nums2[j]) {
                res[index++] = nums1[i++];
            } else {
                res[index++] = nums2[j++];
            }
        }
        while (i < length1) {
            res[index++] = nums1[i++];
        }
        while (j < length2) {
            res[index++] = nums2[j++];
        }
        return res;
    }

    public static void main(String[] args) {
        FindMedianSortedArrays find = new FindMedianSortedArrays();
        System.out.println(Arrays.toString(find.merge(new int[]{3, 5}, new int[]{2,4,6})));
    }
}
