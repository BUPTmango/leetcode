package simple_level.jianzhi_offer;

import data_structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 《玩转算法面试视频例题》二叉树 递归
 * 面试题28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树?[1,2,2,3,4,4,3] 是对称的。
 *
 * ? ? 1
 * ? ?/ \
 * ? 2 ? 2
 * ?/ \ / \
 * 3 ?4 4 ?3
 * 但是下面这个?[1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 * ? ? 1
 * ? ?/ \
 * ? 2 ? 2
 * ? ?\ ? \
 * ? ?3 ? ?3
 *
 * ?
 *
 * 示例 1：
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * ?
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/8 9:06 上午
 */
public class IsSymmetric {
    /**
     * 递归方法
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    /**
     * 迭代方法
     * 使用队列，每次放进去两个元素进行比较
     * @param root
     * @return
     */
    public boolean isSymmetric_notRecommend(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }

}
