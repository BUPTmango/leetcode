package simple_level;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 590. N�����ĺ������
 * ����һ�� N ������������ڵ�ֵ�ĺ��������
 *
 * ���磬����һ�� 3���� :
 *
 * ������������: [5,6,3,2,4,1].
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/23 9:10 ����
 */
public class PostorderN {
    private List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        post(root);
        return res;
    }

    private void post(Node node) {
        if (node == null) {
            return;
        }
        List<Node> children = node.children;
        children.forEach(child -> {
            post(child);
        });
        res.add(node.val);
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
    };
}
