package simple_level;

import data_structure.TreeNode;

/**
 * 538
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 *
 * 输入: 二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/10 11:45 下午
 */
public class ConvertBST {
    int sum=0;

    /**
     * 用"中序遍历"的方式访问每个节点的值，并将该节点的值累加到一个 int sum 变量上，并用该 sum 变量更新该节点的值。
     * 要注意的是，此处的中序遍历是先遍历右子树，再访问根节点，然后再遍历左子树
     * （因为 BST 根节点的值小于右子树所有节点的值，大于左子树所有节点的值）。
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        addSum(root);
        return root;
    }

    /**
     * 二叉搜索树
     * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
     * @param root
     */
    public void addSum(TreeNode root){
        if(root!=null){
            addSum(root.right);
            sum+=root.val;
            root.val = sum;
            addSum(root.left);
        }
    }
}
