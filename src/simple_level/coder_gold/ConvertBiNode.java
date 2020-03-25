package simple_level.coder_gold;

import data_structure.TreeNode;

/**
 * 面试题 17.12. BiNode
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求值的顺序保持不变，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 *
 * 返回转换后的单向链表的头节点。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 * 提示：
 *
 * 节点数量不会超过 100000。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/25 9:34 上午
 */
public class ConvertBiNode {
    /**
     * 递归
     * BST中序遍历是有序的，我们只要对树进行中序遍历即可，
     * 利用一个前驱节点prev，记录上一个被处理的节点，当前节点被遍历到的时候，
     * 将prev.right指向当前节点node，然后node.left置空，prev指针后移到node,最后node进入右子树即可。
     *
     * node.left = null;// 当前节点左指针置空
     * prev.right = node;// 前置指针右指针指向当前节点，作为链表的next指针，链表新增元素
     * prev = node;// 指针后移
     *
     * @param root
     * @return
     */
    public TreeNode convertBiNode(TreeNode root) {
        TreeNode head = new TreeNode(0);// 单链表的头指针哨兵
        // 开始中序遍历
        inorder(root,head);
        return head.right;
    }

    private TreeNode inorder(TreeNode root,TreeNode prev){
        if (root != null){
            prev = inorder(root.left,prev);
            root.left = null;
            prev.right = root;
            prev = root;
            prev = inorder(root.right,prev);
        }
        return prev;
    }
}
