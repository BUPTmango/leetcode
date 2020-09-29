package middle_level;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ����ת�㷨������Ƶ���⡷���� �������
 * 102 103 107 199�õ�����ͬ�Ĵ���
 * 102. �������Ĳ������
 * ����һ�������������㷵���䰴 ������� �õ��Ľڵ�ֵ�� �������أ������ҷ������нڵ㣩��
 * <p>
 * ʾ����
 * ��������[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * �������α��������
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/7 10:46 ����
 */
public class LevelOrder {
    List<List<Integer>> levels = new ArrayList<>();

    public void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        // ����ǵ�ǰ��ĵ�һ��Ԫ�� ���һ���յ�list
        if (level == levels.size()) {
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(node.val);

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
    public List<List<Integer>> levelOrder_DFS(TreeNode root) {
        if (root == null) {
            return levels;
        }
        dfs(root, 0);
        return levels;
    }


    /**
     * ����ʵ�� BFS
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_BFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
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
                tmp.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            // ����ʱlist�������շ��ؽ����
            res.add(tmp);
        }
        return res;
    }
}
