package middle_level.jianzhi_offer;


/**
 * ��ָ Offer 35. ��������ĸ���
 * ��ʵ�� copyRandomList ����������һ�����������ڸ��������У�ÿ���ڵ������һ�� next ָ��ָ����һ���ڵ㣬����һ�� random ָ��ָ�������е�����ڵ���� null��
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * �����[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * ʾ�� 2��
 *
 *
 * ���룺head = [[1,1],[2,1]]
 * �����[[1,1],[2,1]]
 * ʾ�� 3��
 *
 *
 * ���룺head = [[3,null],[3,0],[3,null]]
 * �����[[3,null],[3,0],[3,null]]
 * ʾ�� 4��
 *
 * ���룺head = []
 * �����[]
 * ���ͣ�����������Ϊ�գ���ָ�룩����˷��� null��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/3 5:57 ����
 */
public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        copy(head);
        randomDirect(head);
        return reList(head);
    }
    // ��������
    // ����ÿһ���ڵ㣬ʹ�ø��ƺ�Ľڵ㶼�ڵ�ǰ�ڵ����һ���ڵ�
    private void copy(Node head){
        while(head!=null){
            Node cloneNode = new Node(head.val);
            Node nextNode = head.next;
            head.next = cloneNode;
            cloneNode.next = nextNode;
            head = cloneNode.next;
        }
    }
    // ָ�����ָ��
    // ԭ������Ľڵ��ָ������ڵ㣬ʹ���ƵĽڵ�Ҳ��ָ��ĳһ����ڵ�
    private void randomDirect(Node head){
        while(head!=null){
            Node cloneNode = head.next;
            if(head.random!=null){
                Node direct = head.random;
                cloneNode.random = direct.next;
            }
            head = cloneNode.next;
        }
    }
    // �������� ����
    // �������ӽڵ㣬��ԭ���ڵ����������������ѿ�¡��Ľڵ���������
    private Node reList(Node head){
        Node cloneNode = head.next;
        Node cloneHead = cloneNode;
        head.next = cloneNode.next;
        head = head.next;
        while(head!=null){
            cloneNode.next = head.next;
            head.next = head.next.next;
            head = head.next;
            cloneNode = cloneNode.next;
        }
        return cloneHead;
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
