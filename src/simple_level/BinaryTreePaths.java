package simple_level;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 《玩转算法面试视频例题》二叉树 递归终止条件
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明:?叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/8/14 12:20 下午
 */
public class BinaryTreePaths {
    private List<String> paths = new ArrayList();
    /**
     * 如果当前的节点不是叶子节点，则在当前的路径末尾添加该节点，并递归遍历该节点的每一个孩子节点。
     * 如果当前的节点是叶子节点，则在当前的路径末尾添加该节点后，就得到了一条从根节点到叶子节点的路径，可以把该路径加入到答案中。
     *
     * @param root
     * @param path
     */
    private void construct_paths(TreeNode root, String path) {
        if (root != null) {
            path += Integer.toString(root.val);
            // 当前节点是叶子节点 这才是递归终止条件
            if (root.left == null && root.right == null) {
                // 把路径加入到答案中
                paths.add(path);
            } else {
                // 当前节点不是叶子节点，继续递归遍历
                path += "->";
                construct_paths(root.left, path);
                construct_paths(root.right, path);
            }
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        construct_paths(root, "");
        return paths;
    }
}
