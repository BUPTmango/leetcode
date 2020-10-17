package simple_level;

import data_structure.TreeNode;


/**
 * 938. �����������ķ�Χ��
 * ���������������ĸ����root������ L �� R������֮������н���ֵ�ĺ͡�
 *
 * ������������֤����Ψһ��ֵ��
 *
 *
 * ʾ�� 1��
 *
 * ���룺root = [10,5,15,3,7,null,18], L = 7, R = 15
 * �����32
 * ʾ��2��
 *
 * ���룺root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * �����23
 *
 * ��ʾ��
 *
 * ���еĽ���������Ϊ10000����
 * ���յĴ𰸱�֤С��2^31��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/17 10:34 ����
 */
public class RangeSumBST {
    int ans;

    /**
     * �ݹ�ʵ�������������
     * @param root
     * @param L
     * @param R
     * @return
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        dfs(root, L, R);
        return ans;
    }

    public void dfs(TreeNode node, int L, int R) {
        if (node != null) {
            // �����ǰ��node��val�ڷ�Χ����ۼ�
            if (L <= node.val && node.val <= R) {
                ans += node.val;
            }
            // ��� node.val С�ڵ��� L����ôֻ��Ҫ��������������������
            // ��� node.val ���ڵ��� R����ôֻ��Ҫ��������������������
            // ��� node.val ������ (L, R) �У�����Ҫ����������������
            if (L < node.val) {
                dfs(node.left, L, R);
            }
            if (node.val < R) {
                dfs(node.right, L, R);
            }
        }
    }
}
