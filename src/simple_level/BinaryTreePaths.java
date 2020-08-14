package simple_level;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明:?叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/8/14 12:20 下午
 */
public class BinaryTreePaths {
    /**
     * 如果当前的节点不是叶子节点，则在当前的路径末尾添加该节点，并递归遍历该节点的每一个孩子节点。
     * 如果当前的节点是叶子节点，则在当前的路径末尾添加该节点后，就得到了一条从根节点到叶子节点的路径，可以把该路径加入到答案中。
     *
     * @param root
     * @param path
     * @param paths
     */
    public void construct_paths(TreeNode root, String path, ArrayList<String> paths) {
        if (root != null) {
            path += Integer.toString(root.val);
            // 当前节点是叶子节点
            if ((root.left == null) && (root.right == null)) {
                // 把路径加入到答案中
                paths.add(path);
            } else {
                // 当前节点不是叶子节点，继续递归遍历
                path += "->";
                construct_paths(root.left, path, paths);
                construct_paths(root.right, path, paths);
            }
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> paths = new ArrayList();
        construct_paths(root, "", paths);
        return paths;
    }
}
