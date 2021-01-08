package hard_level.sword_offer;

import data_structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ��ָ Offer 37. ���л�������
 * ��ʵ�������������ֱ��������л��ͷ����л���������
 * <p>
 * ʾ��:
 * <p>
 * ����Խ����¶�������
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * ���л�Ϊ "[1,2,3,null,null,4,5]"
 * ע�⣺��������վ 297 ����ͬ��https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/8 11:21 ����
 */
public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                res.append("null,");
            }
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if (!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}
