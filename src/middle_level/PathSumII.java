package middle_level;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * ����ת�㷨������Ƶ���⡷������ �ݹ���ֹ����
 * 113. ·���ܺ� II
 * ����һ����������һ��Ŀ��ͣ��ҵ����дӸ��ڵ㵽Ҷ�ӽڵ�·���ܺ͵��ڸ���Ŀ��͵�·����
 * <p>
 * ˵��:Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 * <p>
 * ʾ��:
 * �������¶��������Լ�Ŀ���sum = 22��
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * ����:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/6 8:04 ����
 */
public class PathSumII {
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
     *
     * @param root
     * @param tar
     */
    private void recur(TreeNode root, int tar) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        tar -= root.val;
        // �ҵ���·���Ͳ�����Ҷ�ӽڵ� �Ͳ���Ҫ��������
        if (tar == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        // ����������
        recur(root.left, tar);
        // ����������
        recur(root.right, tar);
        path.remove(path.size() - 1);
    }
}
