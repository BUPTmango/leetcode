package middle_level;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. ��ͬ�Ķ��������� II
 * ����һ����ͬ���� ���Ƿ������ĸ��� ������Ҫ���ؾ����������
 *
 * ����һ������ n������������ 1 ...n Ϊ�ڵ�����ɵ� ���������� ��
 *
 * ʾ����
 *
 * ���룺3
 * �����
 * [
 *  [1,null,3,2],
 *  [3,2,null,1],
 *  [3,1,null,null,2],
 *  [2,1,3],
 *  [1,null,2,null,3]
 * ]
 * ���ͣ�
 * ���ϵ������Ӧ���� 5 �ֲ�ͬ�ṹ�Ķ�����������
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * 
 *
 * ��ʾ��
 *
 * 0 <= n <= 8
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/9 11:34 ����
 */
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        // ע�⣡���� ע������������������Ĵ���
        // ��ʱû�����֣��� null ��������
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        // ֻ��һ�����֣���ǰ������Ϊһ������������
        if (start == end) {
            TreeNode tree = new TreeNode(start);
            allTrees.add(tree);
            return allTrees;
        }
        // ������Ϊ���ڵ������
        for (int i = start; i <= end; i++) {
            // ������п��е�����������
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            // ������п��е�����������
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            // ��������������ѡ��һ������������������������ѡ��һ����������ƴ�ӵ����ڵ���
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }
}
