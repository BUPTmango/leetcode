package middle_level;

import data_structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * 示例 1:
 *
 * 输入:
 *
 *     2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 * ?
 *
 * 示例 2:
 *
 * 输入:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * 输出:
 * 7
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/5 11:57 下午
 */
public class FindBottomLeftValue {
    /**
     * 迭代，层序遍历，保存每层左边第一个元素为结果，遍历完成后直接返回结果
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        //层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            //将每层左边第一个作为结果
            res = queue.peek().val;
            while (count-- > 0) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return res;
    }
}
