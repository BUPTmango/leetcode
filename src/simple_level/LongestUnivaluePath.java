package simple_level;

import data_structure.TreeNode;

/**
 * 687. �ֵͬ·��
 * ����һ�����������ҵ����·�������·���е�ÿ���ڵ������ֵͬ�� ����·�����Ծ���Ҳ���Բ��������ڵ㡣
 *
 * ע�⣺�����ڵ�֮���·������������֮��ı�����ʾ��
 *
 * ʾ�� 1:
 *
 * ����:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * ���:
 *
 * 2
 * ʾ�� 2:
 *
 * ����:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * ���:
 *
 * 2
 * ע��: �����Ķ�����������10000����㡣 ���ĸ߶Ȳ�����1000��
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/21 4:01 ����
 */
public class LongestUnivaluePath {
    private int ans;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        this.ans = 0;
        univaluePath(root);
        return this.ans;
    }

    private int univaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = univaluePath(root.left);
        int r = univaluePath(root.right);
        int pl = 0, pr = 0;
        // �������������ڵ� pl+1
        if (root.left != null && root.val == root.left.val) {
            pl = l + 1;
        }
        // ������������ҽڵ� pr+1
        if (root.right != null && root.val == root.right.val) {
            pr = r + 1;
        }
        // ��pl+pr����ans��ֵ
        this.ans = Math.max(this.ans, pl + pr);
        return Math.max(pl, pr);
    }
}
