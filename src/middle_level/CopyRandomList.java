package middle_level;

/**
 * 138. ���ƴ����ָ�������
 * ����һ������ÿ���ڵ����һ���������ӵ����ָ�룬��ָ�����ָ�������е��κνڵ��սڵ㡣
 *
 * Ҫ�󷵻��������������
 *
 * ������һ����n���ڵ���ɵ���������ʾ����/����е�����ÿ���ڵ���һ��[val, random_index]��ʾ��
 *
 * val��һ����ʾNode.val��������
 * random_index�����ָ��ָ��Ľڵ���������Χ��0��n-1���������ָ���κνڵ㣬��Ϊnull��
 * 
 * ʾ�� 1��
 *
 * ���룺head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * �����[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * ʾ�� 2��
 *
 * ���룺head = [[1,1],[2,1]]
 * �����[[1,1],[2,1]]
 * ʾ�� 3��
 *
 * ���룺head = [[3,null],[3,0],[3,null]]
 * �����[[3,null],[3,0],[3,null]]
 * ʾ�� 4��
 *
 * ���룺head = []
 * �����[]
 * ���ͣ�����������Ϊ�գ���ָ�룩����˷��� null��
 * ��ʾ��
 *
 * -10000 <= Node.val <= 10000
 * Node.randomΪ�գ�null����ָ�������еĽڵ㡣
 * �ڵ���Ŀ������ 1000 ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/23 8:24 ����
 */
public class CopyRandomList {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        // ����ԭ������������ÿһ���ڵ㣬�������ڵ����ԭ���ڵ���Աߣ������һ���ɽڵ���½ڵ㽻�������
        Node ptr = head;
        while (ptr != null) {
            // ���ƽڵ�
            Node newNode = new Node(ptr.val);

            // A->B->C  =�� A->A'->B->B'->C->C'
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }

        ptr = head;

        // ��������¾ɽڵ㽻����������þɽڵ�� random ָ��ȥ���¶�Ӧ�½ڵ�� random ָ�롣
        // �ȷ�˵�� B �� random ָ��ָ�� A ����ζ�� B' �� random ָ��ָ�� A' ��
        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        // nextָ��Ҳ��Ҫ��ȷ��ֵ
        // A->A'->B->B'->C->C' Ӧ�ò�ֳ� A->B->C �� A'->B'->C'
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
