package simple_level.coder_gold;

import data_structure.linked_list.ListNode;

/**
 * 面试题 02.03. 删除中间节点
 * 实现一种算法，删除单向链表中间的某个节点（除了第一个和最后一个节点，不一定是中间节点），假定你只能访问该节点。
 *
 * 示例：
 *
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/17 10:34 上午
 */
public class DeleteNode {
    /**
     * 要把删除节点c，即node即为给定要删除的节点。
     * 要删除节点node，以上面为例，要删除节点c，我们可以把节点c的val变为节点d(node.next)的val，
     * 此时可以看成节点c已经变成了节点d，改变c(node)的下一个节点为e(node.next.next)。
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
