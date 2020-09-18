package beforeBegining_2018;

import java.util.Arrays;

/**
 * 《玩转算法面试视频例题》
 * 88. 合并两个有序数组
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
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 创建一个nums1的拷贝
        int [] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // 创建两个指针 分别是指向nums1的copy和nums2的
        int p1 = 0;
        int p2 = 0;

        // 设置nums1的指针
        int p = 0;

        // 比较nums1的copy和nums2中的较小者放入nums1中
        while ((p1 < m) && (p2 < n)) {
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
        }

        // 两个数组中有一个已经遍历完 另一个还剩下元素
        if (p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }
}