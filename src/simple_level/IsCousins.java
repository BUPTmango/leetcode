package simple_level;

import data_structure.TreeNode;

/**
 * 993. �����������ֵܽڵ�
 * �ڶ������У����ڵ�λ����� 0 ����ÿ�����Ϊ k �Ľڵ���ӽڵ�λ����� k+1 ����
 *
 * ����������������ڵ������ͬ���� ���ڵ㲻ͬ ����������һ�����ֵܽڵ㡣
 *
 * ���Ǹ����˾���Ψһֵ�Ķ������ĸ��ڵ� root ���Լ�����������ͬ�ڵ��ֵ x �� y ��
 *
 * ֻ����ֵ x �� y ��Ӧ�Ľڵ������ֵܽڵ�ʱ���ŷ��� true �����򣬷��� false��
 *
 *
 * ʾ�� 1��
 *
 * ���룺root = [1,2,3,4], x = 4, y = 3
 * �����false
 * ʾ�� 2��
 *
 * ���룺root = [1,2,3,null,4,null,5], x = 5, y = 4
 * �����true
 * ʾ�� 3��
 *
 *
 * ���룺root = [1,2,3,null,4], x = 2, y = 3
 * �����false
 *
 * 
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/17 18:22
 */
public class IsCousins {
    private int x;
    private int y;
    private TreeNode xParent;
    private TreeNode yParent;
    private int xDepth;
    private int yDepth;
    private boolean xFound;
    private boolean yFound;

    public boolean isCousins(TreeNode root, int x, int y) {
        // ��������������� ��Ⱥ͸���
        this.x = x;
        this.y = y;
        dfs(root, 0, null);
        return xParent != yParent && xDepth == yDepth;
    }

    private void dfs(TreeNode node, int depth, TreeNode parent) {
        if (node == null) {
            return;
        }
        // ǰ�����
        if (node.val == x) {
            xDepth = depth;
            xParent = parent;
            xFound = true;
        }
        if (node.val == y) {
            yDepth = depth;
            yParent = parent;
            yFound = true;
        }
        // ������ҵ��� ��ǰ����
        if (xFound && yFound) {
            return;
        }

        dfs(node.left, depth + 1, node);
        dfs(node.right, depth + 1, node);
    }
}
