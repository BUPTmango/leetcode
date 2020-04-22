package middle_level;

import data_structure.TreeNode;

import java.util.*;

/**
 * 199. ������������ͼ
 * ����һ�ö������������Լ�վ�������Ҳ࣬���մӶ������ײ���˳�򣬷��ش��Ҳ����ܿ����Ľڵ�ֵ��
 *
 * ʾ��:
 *
 * ����:?[1,2,3,null,5,null,4]
 * ���:?[1, 3, 4]
 * ����:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/22 11:53 ����
 */
public class RightSideView {
    /**
     * ˼·
     *
     * ���ǿ��ԶԶ��������в�α�������ô����ÿ����˵�����ұߵĽ��һ������󱻱������ġ�
     * �������Ĳ�α��������ù����������ʵ�֡�
     *
     * �㷨
     *
     * ִ�й���������������������ҽ��֮ǰ�����������Ƕ�ÿһ�㶼�����ҷ��ʡ�
     * ��ˣ�ֻ����ÿ����������ʵĽ�㣬���ǾͿ����ڱ�������������õ�ÿ��������ҵĽ�㡣
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode node, int level) {
        if(node != null) {
            // �����һ��ĵ�һ��Ԫ��
            if(res.size() == level) {
                res.add(node.val);
            }
            // ����������һ�� ���ҽڵ� ֮����ڵ�
            dfs(res, node.right, level + 1);
            dfs(res, node.left, level + 1);
        }
    }
}
