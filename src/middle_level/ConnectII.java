package middle_level;

import data_structure.Node;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有?next 指针都被设置为 NULL。
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 * 示例：
 *
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/28 9:03 上午
 */
public class ConnectII {
    /**
     * 左子右子都有，则左子next指向右子，右子next指向getNextNoNullChild
     * 只有左子，左子指向getNextNoNullChild，
     * 只有右子，右子指向getNextNoNullChild，
     *
     * 注意：递归时要先递归右子树，否则上级节点next关系没建好，下级无法成功getNextNoNullChild
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null || (root.right == null && root.left == null)) {
            return root;
        }
        // 左子右子都有，则左子next指向右子，右子next指向getNextNoNullChild
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            root.right.next = getNextNoNullChild(root);
        }
        // 只有右子，右子指向getNextNoNullChild
        if (root.left == null) {
            root.right.next = getNextNoNullChild(root);
        }
        // 只有左子，左子指向getNextNoNullChild
        if (root.right == null) {
            root.left.next = getNextNoNullChild(root);
        }

        // 这里要注意：先递归右子树，否则右子树根节点next关系没建立好，左子树到右子树子节点无法正确挂载
        root.right = connect(root.right);
        root.left = connect(root.left);

        return root;
    }

    /**
     * 一路向右找到有子节点的根节点
     */
    private static Node getNextNoNullChild(Node root) {
        while (root.next != null) {
            if (root.next.left != null) {
                return root.next.left;
            }
            if (root.next.right != null) {
                return root.next.right;
            }
            root = root.next;
        }
        return null;
    }
}
