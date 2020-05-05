package middle_level;

import data_structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. �������½ǵ�ֵ
 * ����һ�������������������һ���ҵ�����ߵ�ֵ��
 *
 * ʾ�� 1:
 *
 * ����:
 *
 *     2
 *    / \
 *   1   3
 *
 * ���:
 * 1
 * ?
 *
 * ʾ�� 2:
 *
 * ����:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * ���:
 * 7
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/5 11:57 ����
 */
public class FindBottomLeftValue {
    /**
     * �������������������ÿ����ߵ�һ��Ԫ��Ϊ�����������ɺ�ֱ�ӷ��ؽ��
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        //�������
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            //��ÿ����ߵ�һ����Ϊ���
            res = queue.peek().val;
            while (count-- > 0) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return res;
    }
}
