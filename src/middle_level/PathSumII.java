package middle_level;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 《玩转算法面试视频例题》二叉树 递归终止条件
 * 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明:叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/6 8:04 下午
 */
public class PathSumII {
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
     *
     * @param root
     * @param tar
     */
    private void recur(TreeNode root, int tar) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        tar -= root.val;
        // 找到了路径和并且是叶子节点 就不需要继续遍历
        if (tar == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        // 遍历左子树
        recur(root.left, tar);
        // 遍历右子树
        recur(root.right, tar);
        path.remove(path.size() - 1);
    }
}
