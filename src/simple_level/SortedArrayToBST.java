package simple_level;

import data_structure.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * @author mango
 * @create 2019-03-18 5:01 PM
 */
public class SortedArrayToBST {
    /**
     * 这个问题用递归很容易解出来。考虑下面一棵二叉搜索树：
     * 这是一棵平衡的二叉搜索树，所谓平衡的定义，就是指二叉树的子树高度之差不能超过1。
     * 如果要从一个有序数组中选择一个元素作为根结点，应该选择哪个元素呢？
     * 我们应该选择有序数组的中间元素作为根结点。
     * 选择了中间元素作为根结点并创建后，剩下的元素分为两部分，可以看作是两个数组。
     * 这样剩下的元素在根结点左边的作为左子树，右边的作为右子树。
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    private TreeNode sortedArrayToBST(int arr[], int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = sortedArrayToBST(arr, start, mid - 1);
        root.right = sortedArrayToBST(arr, mid + 1, end);
        return root;
    }
}