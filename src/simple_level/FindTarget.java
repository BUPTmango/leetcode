package simple_level;

import data_structure.TreeNode;

import java.util.*;

/**
 * 653. 两数之和 IV - 输入 BST
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * 输出: True
 * ?
 *
 * 案例 2:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * 输出: False
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/27 10:46 上午
 */
public class FindTarget {

    /**
     * 法一：使用HashSet
     * 最简单的方法就是遍历整棵树，找出所有可能的组合，判断是否存在和为 k 的一对节点。现在在此基础上做一些改进。如果存在两个元素之和为 k，即 x+y=k，并且已知 x 是树上一个节点的值，则只需判断树上是否存在一个值为 yy 的节点，使得 y=k?x。
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget_hashset(TreeNode root, int k) {
        Set< Integer > set = new HashSet();
        return find(root, k, set);
    }
    private boolean find(TreeNode root, int k, Set < Integer > set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }

    /**
     * 法二：利用BFS和HashSet
     * 使用广度优先搜索查找一对节点和为 k 的过程如下。首先维护一个与 方法一 用途相同的 set。将根节点加入 queue，然后执行以下步骤：
     * 从队列首部删除一个元素 p。
     * 检查 set 中是否存在 k-p。如果存在，返回 True。
     * 否则，将 p 加入 set。然后将当前节点的左孩子和右孩子加入 queue。
     * 重复步骤一至三，直到 queue 为空。
     * 如果 queue 为空，返回 False。
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget_BFS(TreeNode root, int k) {
        Set < Integer > set = new HashSet();
        Queue< TreeNode > queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                TreeNode node = queue.remove();
                if (set.contains(k - node.val))
                    return true;
                set.add(node.val);
                queue.add(node.right);
                queue.add(node.left);
            } else
                queue.remove();
        }
        return false;
    }

    /**
     * 法三：
     * 在本方法中利用 BST 的性质，BST 的中序遍历结果是按升序排列的。因此，中序遍历给定的 BST，并将遍历结果存储到 list 中。
     * 遍历完成后，使用两个指针 l 和 r 作为 list 的头部索引和尾部索引。然后执行以下操作：
     * 检查 l 和 r 索引处两元素之和是否等于 k。如果是，立即返回 True。
     * 如果当前两元素之和小于 k，则更新 l 指向下一个元素。这是因为当我们需要增大两数之和时，应该增大较小数。
     * 如果当前两元素之和大于 k，则更新 r 指向上一个元素。这是因为当我们需要减小两数之和时，应该减小较大数。
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget_BST(TreeNode root, int k) {
        List < Integer > list = new ArrayList();
        inorder(root, list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k)
                return true;
            if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }
    private void inorder(TreeNode root, List< Integer > list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
