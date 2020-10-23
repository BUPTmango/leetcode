package middle_level;

/**
 * 138. 复制带随机指针的链表
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的深拷贝。
 *
 * 我们用一个由n个节点组成的链表来表示输入/输出中的链表。每个节点用一个[val, random_index]表示：
 *
 * val：一个表示Node.val的整数。
 * random_index：随机指针指向的节点索引（范围从0到n-1）；如果不指向任何节点，则为null。
 * 
 * 示例 1：
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 *
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 *
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 *
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 * 提示：
 *
 * -10000 <= Node.val <= 10000
 * Node.random为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/23 8:24 上午
 */
public class CopyRandomList {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        // 遍历原来的链表并拷贝每一个节点，将拷贝节点放在原来节点的旁边，创造出一个旧节点和新节点交错的链表
        Node ptr = head;
        while (ptr != null) {
            // 复制节点
            Node newNode = new Node(ptr.val);

            // A->B->C  =》 A->A'->B->B'->C->C'
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }

        ptr = head;

        // 迭代这个新旧节点交错的链表，并用旧节点的 random 指针去更新对应新节点的 random 指针。
        // 比方说， B 的 random 指针指向 A ，意味着 B' 的 random 指针指向 A' 。
        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        // next指针也需要正确赋值
        // A->A'->B->B'->C->C' 应该拆分成 A->B->C 和 A'->B'->C'
        // A->B->C
        Node ptr_old_list = head;
        // A'->B'->C'
        Node ptr_new_list = head.next;
        Node head_old = head.next;
        while (ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }
        return head_old;
    }


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
