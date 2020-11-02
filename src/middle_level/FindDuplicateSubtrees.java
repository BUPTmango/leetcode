package middle_level;

import data_structure.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 652. Ѱ���ظ�������
 * ����һ�ö����������������ظ�������������ͬһ����ظ���������ֻ��Ҫ������������һ�õĸ���㼴�ɡ�
 *
 * �������ظ���ָ���Ǿ�����ͬ�Ľṹ�Լ���ͬ�Ľ��ֵ��
 *
 * ʾ�� 1��
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * �����������ظ���������
 *
 *       2
 *      /
 *     4
 * ��
 *
 *     4
 * ��ˣ�����Ҫ���б����ʽ���������ظ������ĸ���㡣
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/1 8:34 ����
 */
public class FindDuplicateSubtrees {
    /**
     * ��¼���������Լ����ֵĴ���
     */
    private Map<String, Integer> memo = new HashMap<>();
    /**
     * ��¼�ظ��������ĸ��ڵ�
     */
    private List<TreeNode> res = new LinkedList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }


    private String traverse(TreeNode root) {
        // ���ڿսڵ㣬������һ��������ű�ʾ
        if (root == null) {
            return "#";
        }
        // ʹ�ú���������
        // �������������л����ַ���
        String left = traverse(root.left);
        String right = traverse(root.right);
        // �������������Լ����������Լ�Ϊ���Ķ��������л����
        String subTree = left + "," + right + "," + root.val;

        int freq = memo.getOrDefault(subTree, 0);
        // ����ظ�Ҳֻ���������һ��
        if (freq == 1) {
            res.add(root);
        }
        // ��������Ӧ�ĳ��ִ�����һ
        memo.put(subTree, freq + 1);
        return subTree;
    }
}
