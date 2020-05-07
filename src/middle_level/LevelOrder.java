package middle_level;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. �������Ĳ������
 * ����һ�������������㷵���䰴 ������� �õ��Ľڵ�ֵ�� �������أ������ҷ������нڵ㣩��
 *
 * ʾ����
 * ��������[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * �������α��������
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/7 10:46 ����
 */
public class LevelOrder {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level)
            // ÿһ�����һ���µ�list
            levels.add(new ArrayList<>());

        // fulfil the current level ��Ӹ��ڵ�
        levels.get(level).add(node.val);

        // process child nodes for the next level ���������������һ��
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    /**
     * �ݹ鷽��
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }


    /**
     * ����ʵ��
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_another(TreeNode root) {
        if(root==null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        //�����ڵ��������У�Ȼ�󲻶ϱ�������
        queue.add(root);
        while(queue.size()>0) {
            //��ȡ��ǰ���еĳ��ȣ���������൱�� ��ǰ��һ��Ľڵ����
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            //�������е�Ԫ�ض��ó���(Ҳ���ǻ�ȡ��һ��Ľڵ�)���ŵ���ʱlist��
            //����ڵ����/��������Ϊ�գ�Ҳ���������
            for(int i=0;i<size;++i) {
                TreeNode t = queue.remove();
                tmp.add(t.val);
                if(t.left!=null) {
                    queue.add(t.left);
                }
                if(t.right!=null) {
                    queue.add(t.right);
                }
            }
            //����ʱlist�������շ��ؽ����
            res.add(tmp);
        }
        return res;
    }
}
