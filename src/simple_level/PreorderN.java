package simple_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N������ǰ�����
 * ����һ�� N ������������ڵ�ֵ��ǰ�������
 *
 * ���磬����һ�� 3���� :
 *
 * ������ǰ�����: [1,3,5,6,2,4]��
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/6 9:48 ����
 */
public class PreorderN {
    private List<Integer> result = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        order(root);
        return result;
    }
    private void order(Node node) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        for (Node child : node.children) {
            order(child);
        }
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
