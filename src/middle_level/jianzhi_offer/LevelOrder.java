package middle_level.jianzhi_offer;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * 例如:
 * 给定二叉树:?[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/7 10:56 上午
 */
public class LevelOrder {
    public int[] levelOrder(TreeNode root) {
        // 根节点为空 返回空数组
        if(root == null) return new int[0];
        // 创建queue并把root放在队列里
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{ add(root); }};
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()) {
            // 取出元素放到队列中
            TreeNode node = queue.poll();
            ans.add(node.val);
            // 如果取出的节点有左节点 放入队列
            if(node.left != null) queue.add(node.left);
            // 如果取出的节点有左节点 放入队列
            if(node.right != null) queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }
}
