package middle_level.jianzhi_offer;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * <p>
 * <p>
 * 为了让您更好地理解问题，以下面的二叉搜索树为例：
 * <p>
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 * <p>
 * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
 * <p>
 * <p>
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/14 5:59 下午
 */
public class TreeToDoublyList {
    Node pre, head;

    /**
     * 将 二叉搜索树 转换成一个 “排序的循环双向链表” ，其中包含三个要素：
     * <p>
     * 排序链表： 节点应从小到大排序，因此应使用 中序遍历 “从小到大”访问树的节点；
     * 双向链表： 在构建相邻节点（设前驱节点 prepre ，当前节点 curcur ）关系时，不仅应 pre.right = curpre.right=cur ，也应 cur.left = precur.left=pre 。
     * 循环链表： 设链表头节点 headhead 和尾节点 tailtail ，则应构建 head.left = tailhead.left=tail 和 tail.right = headtail.right=head 。
     *
     * @param root
     * @return
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        // 第一步 排序链表
        dfs(root);
        // 第三步 循环链表 头尾相连
        head.left = pre;
        pre.right = head;
        return head;
    }

    void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        // 第二步 双向链表 左连右 left->right right->left
        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }


    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;
}
