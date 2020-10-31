package middle_level;

import data_structure.TreeNode;

/**
 * ���������
 * 654. ��������
 * ����һ�������ظ�Ԫ�ص��������顣һ���Դ����鹹�������������������£�
 *
 * �������ĸ��������е����Ԫ�ء�
 * ��������ͨ�����������ֵ��߲��ֹ����������������
 * ��������ͨ�����������ֵ�ұ߲��ֹ����������������
 * ͨ�����������鹹�������������������������ĸ��ڵ㡣
 *
 *
 * ʾ�� ��
 *
 * ���룺[3,2,1,6,0,5]
 * �������������������ĸ��ڵ㣺
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *
 * ��ʾ��
 *
 * ����������Ĵ�С�� [1, 1000] ֮�䡣
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/7 9:07 ����
 */
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }
    public TreeNode construct(int[] nums, int l, int r) {
        // ���ұ߽�һ��ʱ �������
        if (l == r) {
            return null;
        }
        int max_i = max(nums, l, r);
        TreeNode root = new TreeNode(nums[max_i]);
        // �ݹ鹹����������
        root.left = construct(nums, l, max_i);
        root.right = construct(nums, max_i + 1, r);
        return root;
    }

    /**
     * ����nums����[l, r)��Χ�ڵ����ֵ������
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public int max(int[] nums, int l, int r) {
        int max_i = l;
        for (int i = l; i < r; i++) {
            if (nums[max_i] < nums[i]) {
                max_i = i;
            }
        }
        return max_i;
    }
}
