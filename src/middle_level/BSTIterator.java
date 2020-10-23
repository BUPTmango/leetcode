package middle_level;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 173. 二叉搜索树迭代器
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 *
 * 示例：
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 *
 * 提示：
 *
 * next()和hasNext()操作的时间复杂度是O(1)，并使用O(h) 内存，其中h是树的高度。
 * 你可以假设next()调用总是有效的，也就是说，当调用 next()时，BST 中至少存在一个下一个最小的数。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/23 9:29 上午
 */
public class BSTIterator {

    private List<Integer> list = new ArrayList<>();
    private int index = 0;
    public BSTIterator(TreeNode root) {
        // 中序遍历
        inOrder(root);
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }

    /** @return the next smallest number */
    public int next() {
        int res = 0;
        if (hasNext()) {
            res = list.get(index);
            index++;
        }
        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (index < list.size()) {
            return true;
        } else {
            return false;
        }
    }

}
