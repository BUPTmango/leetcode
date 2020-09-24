package simple_level;

import data_structure.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 501. �����������е�����
 * ����һ������ֵͬ�Ķ�����������BST�����ҳ� BST �е���������������Ƶ����ߵ�Ԫ�أ���
 * <p>
 * �ٶ� BST �����¶��壺
 * <p>
 * �������������������ֵС�ڵ��ڵ�ǰ����ֵ
 * �������������������ֵ���ڵ��ڵ�ǰ����ֵ
 * �����������������Ƕ���������
 * ���磺
 * ���� BST [1,null,2,2],
 * <p>
 * 1
 * \
 * 2
 * /
 * 2
 * ����[2].
 * <p>
 * ��ʾ�������������1�������迼�����˳��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/28 10:05 ����
 */

/**
 * ����һ�飨����ģ����е��������޷Ǿ��Ǳ������飬ͳ��ÿ�����ֵĳ���Ƶ�ʡ�
 * �����������������ӽ��͸����֮���д�С��ϵ�����ƣ��Ҷ��������������������ġ��ɴˣ��������ת�����һ���������е����в���������
 *
 * ��Ȼ����������ģ��Ϳ��Ա���һ�����ͳ�ơ���Ϊ������������ǰһ����������С�ڵ��ں�һ�����֡�
 * ��������������һ����¼��ǰ���֣�һ����¼��ǰ���ֵ�Ƶ�ʣ�һ����¼��һ����ӵ�List�����ֵ�Ƶ�ʡ�
 *
 * ÿ����һ�����֣��ͽ�������ֵĳ��ִ�����һ�������ǰ���ִ���������һ����ӵ�List�����ֵĳ��ִ��������ڽ��List�����������֣�
 * �����ǰ���ִ���������һ����ӵ�List�����ֵĳ��ִ���������ս��List�����������֣�������һ����ӵ�List���ֵĳ��ִ�������Ϊ��ǰ���ִ�����
 *
 * [note]
 * �����״η��ʣ���Ҫ����һ����ӵ�List�����ֵ�Ƶ����Ϊ1��
 * ÿ����һ�������֣��򽫵�ǰ���ֵĳ��ִ������㡣
 *
 */
public class FindMode {
    private List<Integer> modes;
    private int cur;
    private int curTimes;
    private int lastTimes;

    public int[] findMode(TreeNode root) {
        modes = new LinkedList<>();
        inOrder(root);
        int[] res = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            res[i] = modes.get(i);
        }
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        // �״η��ʣ�����һ����������Ϊ1����Ϊ����Ҫ���бȽ�
        if (lastTimes == 0) {
            lastTimes = 1;
        }
        // ���������ֽ���ǰ��������Ϊ0����������++
        if (root.val != cur) {
            curTimes = 0;
        }
        cur = root.val;
        curTimes++;
        // ��ǰ��������һ��������ͬ�����Ԫ��
        if (curTimes == lastTimes) {
            modes.add(cur);
        }
        // ��ǰ�������࣬���list����ӵ�ǰԪ��
        if (curTimes > lastTimes) {
            lastTimes = curTimes;
            modes.clear();
            modes.add(cur);
        }
        inOrder(root.right);
    }
}
