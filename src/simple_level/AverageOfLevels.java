package simple_level;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. �������Ĳ�ƽ��ֵ
 * ����һ���ǿն�����, ����һ����ÿ��ڵ�ƽ��ֵ��ɵ�����.
 *
 * ʾ�� 1:
 *
 * ����:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * ���: [3, 14.5, 11]
 * ����:
 * ��0���ƽ��ֵ�� 3,  ��1���� 14.5, ��2���� 11. ��˷��� [3, 14.5, 11].
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/5 1:52 ����
 */
public class AverageOfLevels {
    /**
     * �������
     * ʹ���������� sum �������ÿһ��Ľڵ���ֵ֮�ͣ��Լ� count �������ÿһ��Ľڵ�����֮�͡�
     * �ڱ���ʱ����Ҫ�����¼��ǰ�ڵ����ڵĸ߶ȣ������ݸ߶� h ��������Ԫ�� sum[h] �� count[h]��
     * �ڱ�������֮��res = sum / cnt ��Ϊ�𰸡�
     *
     * @param root
     * @return
     */
    public List < Double > averageOfLevel_DFS(TreeNode root) {
        List < Integer > count = new ArrayList<>();
        List < Double > res = new ArrayList<>();
        // ���б���
        average(root, 0, res, count);
        // sum / cnt
        for (int i = 0; i < res.size(); i++) {
            res.set(i, res.get(i) / count.get(i));
        }
        return res;
    }
    private void average(TreeNode t, int i, List<Double> sum, List<Integer> count) {
        if (t == null) {
            return;
        }
        // �����
        if (i < sum.size()) { // ����С��sum�Ĵ�С����ʾ��ǰ���Ѿ���Ԫ���ˣ��Ǿ�Ҫ�������������������Ԫ��
            sum.set(i, sum.get(i) + t.val);
            count.set(i, count.get(i) + 1);
        } else {
            sum.add(1.0 * t.val);
            count.add(1);
        }
        // ��ڵ���� ������һ��
        average(t.left, i + 1, sum, count);
        // �ҽڵ���� ������һ��
        average(t.right, i + 1, sum, count);
    }

    /**
     * �������
     * ���Ƚ����ڵ������� queue �У������� queue �е�ÿһ���ڵ㣬�������ӽڵ������ʱ���� temp �С�
     * �� queue �е����нڵ㶼������Ϻ�temp �м������������ queue ��Ӧ�Ĳ�������һ���еĽڵ㡣
     * �ڽ��ӽڵ���� temp �Ĺ����У�����Ҳ����˳������ queue �нڵ����ֵ֮�ͣ��Դ˵õ�ƽ��ֵ��
     * ������ǽ� temp ��ֵ�� queue������������һ�ֵĹ������������ֱ��ĳһ�� temp Ϊ�ա�
     *
     * @param root
     * @return
     */
    public List <Double> averageOfLevels_BFS(TreeNode root) {
        List <Double> res = new ArrayList<> ();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            long sum = 0, count = 0;
            Queue <TreeNode> temp = new LinkedList<> ();
            while (!queue.isEmpty()) {
                TreeNode n = queue.remove();
                // ���㵱ǰ��ĺ�
                sum += n.val;
                // ���㵱ǰ��ĸ���
                count++;
                if (n.left != null) {
                    // ����һ��(��ڵ�)��ӵ�temp
                    temp.add(n.left);
                }
                if (n.right != null) {
                    // ����һ��(�ҽڵ�)��ӵ�temp
                    temp.add(n.right);
                }
            }
            // ��temp��Ԫ�ط���queue�У�������һ��ѭ��
            queue = temp;
            res.add(sum * 1.0 / count);
        }
        return res;
    }
}
