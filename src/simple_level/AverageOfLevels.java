package simple_level;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. 二叉树的层平均值
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 *
 * 示例 1:
 *
 * 输入:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/5 1:52 下午
 */
public class AverageOfLevels {
    /**
     * 深度优先
     * 使用两个数组 sum 存放树中每一层的节点数值之和，以及 count 存放树中每一层的节点数量之和。
     * 在遍历时，需要额外记录当前节点所在的高度，并根据高度 h 更新数组元素 sum[h] 和 count[h]。
     * 在遍历结束之后，res = sum / cnt 即为答案。
     *
     * @param root
     * @return
     */
    public List < Double > averageOfLevel_DFS(TreeNode root) {
        List < Integer > count = new ArrayList<>();
        List < Double > res = new ArrayList<>();
        // 进行遍历
        average(root, 0, res, count);
        // sum / cnt
        for (int i = 0; i < res.size(); i++) {
            res.set(i, res.get(i) / count.get(i));
        }
        return res;
    }
    private void average(TreeNode t, int i, List<Double> sum, List<Integer> count) {
        if (t == null) {
            return;
        }
        // 处理根
        if (i < sum.size()) { // 层数小于sum的大小，表示当前层已经有元素了，那就要更新数组而不是增加新元素
            sum.set(i, sum.get(i) + t.val);
            count.set(i, count.get(i) + 1);
        } else {
            sum.add(1.0 * t.val);
            count.add(1);
        }
        // 左节点继续 进入下一层
        average(t.left, i + 1, sum, count);
        // 右节点继续 进入下一层
        average(t.right, i + 1, sum, count);
    }

    /**
     * 广度优先
     * 首先将根节点放入队列 queue 中，随后对于 queue 中的每一个节点，将它的子节点放入临时队列 temp 中。
     * 在 queue 中的所有节点都处理完毕后，temp 中即存放了所有在 queue 对应的层数的下一层中的节点。
     * 在将子节点放入 temp 的过程中，我们也可以顺便计算出 queue 中节点的数值之和，以此得到平均值。
     * 最后我们将 temp 赋值给 queue，继续进行下一轮的广度优先搜索，直到某一轮 temp 为空。
     *
     * @param root
     * @return
     */
    public List <Double> averageOfLevels_BFS(TreeNode root) {
        List <Double> res = new ArrayList<> ();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            long sum = 0, count = 0;
            Queue <TreeNode> temp = new LinkedList<> ();
            while (!queue.isEmpty()) {
                TreeNode n = queue.remove();
                // 计算当前层的和
                sum += n.val;
                // 计算当前层的个数
                count++;
                if (n.left != null) {
                    // 将下一层(左节点)添加到temp
                    temp.add(n.left);
                }
                if (n.right != null) {
                    // 将下一层(右节点)添加到temp
                    temp.add(n.right);
                }
            }
            // 把temp中元素放入queue中，进行下一轮循环
            queue = temp;
            res.add(sum * 1.0 / count);
        }
        return res;
    }
}
