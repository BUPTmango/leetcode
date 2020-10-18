package middle_level;

import data_structure.TreeNode;

import java.util.*;

/**
 * 894. ���п��ܵ���������
 * ����������һ�������������ÿ�����ǡ���� 0 �� 2 ���ӽ�㡣
 *
 * ���ذ��� N ���������п��������������б� �𰸵�ÿ��Ԫ�ض���һ���������ĸ���㡣
 *
 * ����ÿ������ÿ����㶼������ node.val=0��
 *
 * ����԰��κ�˳�򷵻����������б�
 *
 * ʾ����
 *
 * ���룺7
 * �����[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * ���ͣ�
 *
 * ��ʾ��
 *
 * 1 <= N <= 20
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/18 10:04 ����
 */
public class AllPossibleFBT {
    Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        if (!memo.containsKey(N)) {
            List<TreeNode> ans = new LinkedList();
            if (N == 1) {
                ans.add(new TreeNode(0));
                // ͨ���򵥵ļ���������û����������������ż�������
            } else if (N % 2 == 1) {
                // ���� N��3�����ǿ����趨���µĵݹ���ԣ�
                // FBT(N)= [�������е� xx�����е��������ӽ������FBT(x) �����ӽ������FBT(N-1-x)]��
                for (int x = 0; x < N; ++x) {
                    int y = N - 1 - x;
                    for (TreeNode left: allPossibleFBT(x)) {
                        for (TreeNode right: allPossibleFBT(y)) {
                            TreeNode bns = new TreeNode(0);
                            bns.left = left;
                            bns.right = right;
                            ans.add(bns);
                        }
                    }
                }
            }
            // ����Ӧ�û��溯�� FBT ֮ǰ�Ľ�����������ǾͲ����ڵݹ������¼�������
            memo.put(N, ans);
        }

        return memo.get(N);
    }
}
