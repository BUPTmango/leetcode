package middle_level;

import data_structure.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 652. 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/1 8:34 下午
 */
public class FindDuplicateSubtrees {
    /**
     * 记录所有子树以及出现的次数
     */
    private Map<String, Integer> memo = new HashMap<>();
    /**
     * 记录重复的子树的根节点
     */
    private List<TreeNode> res = new LinkedList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }


    private String traverse(TreeNode root) {
        // 对于空节点，可以用一个特殊符号表示
        if (root == null) {
            return "#";
        }
        // 使用后序遍历框架
        // 将左右子树序列化成字符串
        String left = traverse(root.left);
        String right = traverse(root.right);
        // 左右子树加上自己，就是以自己为根的二叉树序列化结果
        String subTree = left + "," + right + "," + root.val;

        int freq = memo.getOrDefault(subTree, 0);
        // 多次重复也只会加入结果集一次
        if (freq == 1) {
            res.add(root);
        }
        // 给子树对应的出现次数加一
        memo.put(subTree, freq + 1);
        return subTree;
    }
}
