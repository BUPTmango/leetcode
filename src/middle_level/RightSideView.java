package middle_level;

import data_structure.TreeNode;

import java.util.*;

/**
 * ����ת�㷨������Ƶ���⡷���� �������
 * 199. ������������ͼ
 * ����һ�ö������������Լ�վ�������Ҳ࣬���մӶ������ײ���˳�򣬷��ش��Ҳ����ܿ����Ľڵ�ֵ��
 *
 * ʾ��:
 *
 * ����:?[1,2,3,null,5,null,4]
 * ���:?[1, 3, 4]
 * ����:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/22 11:53 ����
 */
public class RightSideView {
    /**
     * ˼·
     *
     * ���ǿ��ԶԶ��������в�α�������ô����ÿ����˵�����ұߵĽ��һ������󱻱������ġ�
     * �������Ĳ�α��������ù����������ʵ�֡�
     *
     * �㷨
     *
     * ִ�й���������������������ҽ��֮ǰ�����������Ƕ�ÿһ�㶼�����ҷ��ʡ�
     * ��ˣ�ֻ����ÿ����������ʵĽ�㣬���ǾͿ����ڱ�������������õ�ÿ��������ҵĽ�㡣
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView_DFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode node, int level) {
        if(node != null) {
            // �����һ��ĵ�һ��Ԫ��
            if(res.size() == level) {
                res.add(node.val);
            }
            // ����������һ�� ���ҽڵ� ֮����ڵ�
            dfs(res, node.right, level + 1);
            dfs(res, node.left, level + 1);
        }
    }


    /**
     * ��������
     * @param root
     * @return
     */
    public List<Integer> rightSideView_BFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // �����ڵ��������У�Ȼ�󲻶ϱ�������
        queue.add(root);
        while (queue.size() > 0) {
            // ��ȡ��ǰ���еĳ��ȣ���������൱�� ��ǰ��һ��Ľڵ����
            int size = queue.size();
            int ele = 0;
            // �������е�Ԫ�ض��ó���(Ҳ���ǻ�ȡ��һ��Ľڵ�)���ŵ���ʱlist��
            // ����ڵ����/��������Ϊ�գ�Ҳ���������
            for (int i = 0; i < size; ++i) {
                TreeNode t = queue.remove();
                ele = t.val;
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            // ��ÿһ������һ��Ԫ�طŵ�res��
            res.add(ele);
        }
        return res;
    }
}
