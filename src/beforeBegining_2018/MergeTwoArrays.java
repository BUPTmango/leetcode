package beforeBegining_2018;

import java.util.Arrays;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 * @author mango
 * @create 2019-02-27 2:24 PM
 */
public class MergeTwoArrays {
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0, index2 = 0, index = 0;
        int[] nums3 = new int[m + n];
        //遍历完二者小的 就停止了
        while (index1 < m && index2 < n) {
            if (nums1[index1] <= nums2[index2]) {
                nums3[index] = nums1[index1];
                index1++;
                index++;
            } else {
                nums3[index] = nums2[index2];
                index2++;
                index++;
            }
        }
        //继续遍历剩下的那一个数组的内容
        if (index1 < m) {
            while (index1 < m) {
                nums3[index] = nums1[index1];
                index1++;
                index++;
            }
        }
        if (index2 < n) {
            while (index2 < n) {
                nums3[index] = nums2[index2];
                index2++;
                index++;
            }
        }
        return nums3;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,5,6};
        int[] num3 = merge(nums1, nums1.length, nums2, nums2.length);
        System.out.println(Arrays.toString(num3));
    }
}