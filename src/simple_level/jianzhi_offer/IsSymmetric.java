package simple_level.jianzhi_offer;

import data_structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ����ת�㷨������Ƶ���⡷������ �ݹ�
 * ������28. �ԳƵĶ�����
 * ��ʵ��һ�������������ж�һ�ö������ǲ��ǶԳƵġ����һ�ö����������ľ���һ������ô���ǶԳƵġ�
 *
 * ���磬������?[1,2,2,3,4,4,3] �ǶԳƵġ�
 *
 * ? ? 1
 * ? ?/ \
 * ? 2 ? 2
 * ?/ \ / \
 * 3 ?4 4 ?3
 * �����������?[1,2,2,null,3,null,3] ���Ǿ���ԳƵ�:
 *
 * ? ? 1
 * ? ?/ \
 * ? 2 ? 2
 * ? ?\ ? \
 * ? ?3 ? ?3
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺root = [1,2,2,3,4,4,3]
 * �����true
 * ʾ�� 2��
 *
 * ���룺root = [1,2,2,null,3,null,3]
 * �����false
 * ?
 *
 * ���ƣ�
 *
 * 0 <= �ڵ���� <= 1000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/8 9:06 ����
 */
public class IsSymmetric {
    /**
     * �ݹ鷽��
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    /**
     * ��������
     * ʹ�ö��У�ÿ�ηŽ�ȥ����Ԫ�ؽ��бȽ�
     * @param root
     * @return
     */
    public boolean isSymmetric_notRecommend(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }

}
