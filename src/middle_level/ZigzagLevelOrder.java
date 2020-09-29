package middle_level;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ����ת�㷨������Ƶ���⡷���� �������
 * 102 103 107 199�õ�����ͬ�Ĵ���
 * 103. �������ľ���β�α���
 * ����һ����������������ڵ�ֵ�ľ���β�α����������ȴ������ң��ٴ������������һ��������Դ����ƣ������֮�佻����У���
 *
 * ���磺
 * ����������?[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * ���ؾ���β�α������£�
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/5 8:35 ����
 */
public class ZigzagLevelOrder {
    /**
     * BFS ������ȱ���
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder_BFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        // trueΪ������ falseΪ���ҵ���
        boolean order = true;
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // �����ڵ��������У�Ȼ�󲻶ϱ�������
        queue.add(root);
        while (queue.size() > 0) {
            // ��ȡ��ǰ���еĳ��ȣ���������൱�� ��ǰ��һ��Ľڵ����
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            // �������е�Ԫ�ض��ó���(Ҳ���ǻ�ȡ��һ��Ľڵ�)���ŵ���ʱlist��
            // ����ڵ����/��������Ϊ�գ�Ҳ���������
            for (int i = 0; i < size; ++i) {
                TreeNode t = queue.remove();
                if (order) {
                    tmp.add(t.val);
                } else {
                    tmp.add(0, t.val);
                }
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            // ����ʱlist�������շ��ؽ����
            res.add(tmp);
            // ��ת˳��
            order = !order;
        }
        return res;
    }



    List<List<Integer>> levels = new ArrayList<>();

    public void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        // ����ǵ�ǰ��ĵ�һ��Ԫ�� ���һ���յ�list
        if (level == levels.size()) {
            levels.add(new ArrayList<>());
        }
        if (level % 2 == 0) {
            levels.get(level).add(node.val);
        } else {
            levels.get(level).add(0, node.val);
        }

        // �ֱ�������ҽڵ�
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }

    /**
     * �ݹ鷽�� DFS
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder_DFS(TreeNode root) {
        if (root == null) {
            return levels;
        }
        dfs(root, 0);
        return levels;
    }
}
