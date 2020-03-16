package simple_level.coder_gold;

import data_structure.TreeNode;

import java.util.Arrays;

/**
 * 面试题 04.02. 最小高度树
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 *
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *           0
 *          / \
 *        -3   9
 *        /   /
 *      -10  5
 *
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/16 9:46 上午
 */
public class SortedArrayToBST {
    /**
     * sortedArrayToBST方法是传入一个数组，
     * 然后取数组中间的数建立根节点root，然后以中间为分界，
     * 将左边的子数组和右边的子数组分别传入sortedArrayToBST进行递归，
     * 返回的是左子树和右子树的根节点，令其等于root.left和root.right即可：
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) {
            return null;
        }
        TreeNode n = new TreeNode(nums[nums.length/2]);
        n.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,nums.length/2));
        n.right = sortedArrayToBST(Arrays.copyOfRange(nums,nums.length/2+1,nums.length));
        return n;
    }
}
