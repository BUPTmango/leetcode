package middle_level.jianzhi_offer;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 * 示例:
 * 给定如下二叉树，以及目标和?sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/21 9:21 上午
 */
public class PathSum {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    /**
     * 路径更新： 将当前节点值 root.val 加入路径 path ；
     * 目标值更新： tar = tar - root.val（即目标值 tar 从 sum 减至 00 ）；
     * 路径记录： 当 ① root 为叶节点 且 ② 路径和等于目标值 ，则将此路径 path 加入 res 。
     * 先序遍历： 递归左 / 右子节点。
     * 路径恢复： 向上回溯前，需要将当前节点从路径 path 中删除，即执行 path.pop() 。
     * @param root
     * @param tar
     */
    void recur(TreeNode root, int tar) {
        if(root == null) {
            return;
        }
        path.add(root.val);
        tar -= root.val;
        // 找到了路径和并且是叶子节点 就不需要继续遍历
        if(tar == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        // 遍历左子树
        recur(root.left, tar);
        // 遍历右子树
        recur(root.right, tar);
        path.remove(path.size() - 1);
    }
}
