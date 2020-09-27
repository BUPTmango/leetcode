package middle_level.jianzhi_offer;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ��ָ Offer 34. �������к�Ϊĳһֵ��·��
 * ����һ�ö�������һ����������ӡ���������нڵ�ֵ�ĺ�Ϊ��������������·���������ĸ��ڵ㿪ʼ����һֱ��Ҷ�ڵ��������Ľڵ��γ�һ��·����
 *
 * ʾ��:
 * �������¶��������Լ�Ŀ���?sum = 22��
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * ����:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/21 9:21 ����
 */
public class PathSum {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    /**
     * ·�����£� ����ǰ�ڵ�ֵ root.val ����·�� path ��
     * Ŀ��ֵ���£� tar = tar - root.val����Ŀ��ֵ tar �� sum ���� 00 ����
     * ·����¼�� �� �� root ΪҶ�ڵ� �� �� ·���͵���Ŀ��ֵ ���򽫴�·�� path ���� res ��
     * ��������� �ݹ��� / ���ӽڵ㡣
     * ·���ָ��� ���ϻ���ǰ����Ҫ����ǰ�ڵ��·�� path ��ɾ������ִ�� path.pop() ��
     * @param root
     * @param tar
     */
    void recur(TreeNode root, int tar) {
        if(root == null) {
            return;
        }
        path.add(root.val);
        tar -= root.val;
        // �ҵ���·���Ͳ�����Ҷ�ӽڵ� �Ͳ���Ҫ��������
        if(tar == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        // ����������
        recur(root.left, tar);
        // ����������
        recur(root.right, tar);
        path.remove(path.size() - 1);
    }
}
