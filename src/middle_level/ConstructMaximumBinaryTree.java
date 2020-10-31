package middle_level;

import data_structure.TreeNode;

/**
 * 构造二叉树
 * 654. 最大二叉树
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 *
 * 示例 ：
 *
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *
 * 提示：
 *
 * 给定的数组的大小在 [1, 1000] 之间。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/7 9:07 上午
 */
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }
    public TreeNode construct(int[] nums, int l, int r) {
        // 左右边界一致时 构造结束
        if (l == r) {
            return null;
        }
        int max_i = max(nums, l, r);
        TreeNode root = new TreeNode(nums[max_i]);
        // 递归构造左右子树
        root.left = construct(nums, l, max_i);
        root.right = construct(nums, max_i + 1, r);
        return root;
    }

    /**
     * 返回nums中在[l, r)范围内的最大值的索引
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
