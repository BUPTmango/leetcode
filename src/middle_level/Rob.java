package middle_level;

import data_structure.TreeNode;

/**
 * 337. ��ҽ��� III
 * ���ϴδ����һ���ֵ�֮���һȦ���ݺ�С͵�ַ�����һ���µĿ����Եĵ������������ֻ��һ����ڣ����ǳ�֮Ϊ�������� ���ˡ�����֮�⣬ÿ����������ֻ��һ��������������֮������һ�����֮�󣬴�����С͵��ʶ��������ط������з��ݵ�����������һ�ö��������� �������ֱ�������ķ�����ͬһ�����ϱ���٣����ݽ��Զ�������
 *
 * �����ڲ���������������£�С͵һ���ܹ���ȡ����߽�
 *
 * ʾ�� 1:
 *
 * ����: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * ���: 7
 * ����:?С͵һ���ܹ���ȡ����߽�� = 3 + 3 + 1 = 7.
 * ʾ�� 2:
 *
 * ����: [3,4,5,1,3,null,1]
 *
 * ?    3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * ���: 9
 * ����:?С͵һ���ܹ���ȡ����߽��?= 4 + 5 = 9.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/3 5:38 ����
 */
public class Rob {
    /**
     * ������� �ֱ��ǵ�ǰ�ڵ��ٺͲ����
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = postRoot(root);
        return Math.max(res[0], res[1]);
    }
    private int[] postRoot(TreeNode cur) {
        if (cur == null) {
            return new int[]{0, 0};
        }
        // �ֱ��ȡ���ҵĽ��
        int[] l = postRoot(cur.left);
        int[] r = postRoot(cur.right);
        int[] res = new int[2];
        // 0������ٵ���� 1�����ٵ����
        res[0] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        res[1] = l[0] + r[0] + cur.val;
        return res;
    }
}
