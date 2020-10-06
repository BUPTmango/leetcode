package simple_level;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * ����ת�㷨������Ƶ���⡷������ �ݹ���ֹ����
 * 257. ������������·��
 * ����һ�����������������дӸ��ڵ㵽Ҷ�ӽڵ��·����
 * <p>
 * ˵��:?Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 * <p>
 * ʾ��:
 * <p>
 * ����:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * ���: ["1->2->5", "1->3"]
 * <p>
 * ����: ���и��ڵ㵽Ҷ�ӽڵ��·��Ϊ: 1->2->5, 1->3
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/8/14 12:20 ����
 */
public class BinaryTreePaths {
    private List<String> paths = new ArrayList();
    /**
     * �����ǰ�Ľڵ㲻��Ҷ�ӽڵ㣬���ڵ�ǰ��·��ĩβ��Ӹýڵ㣬���ݹ�����ýڵ��ÿһ�����ӽڵ㡣
     * �����ǰ�Ľڵ���Ҷ�ӽڵ㣬���ڵ�ǰ��·��ĩβ��Ӹýڵ�󣬾͵õ���һ���Ӹ��ڵ㵽Ҷ�ӽڵ��·�������԰Ѹ�·�����뵽���С�
     *
     * @param root
     * @param path
     */
    private void construct_paths(TreeNode root, String path) {
        if (root != null) {
            path += Integer.toString(root.val);
            // ��ǰ�ڵ���Ҷ�ӽڵ� ����ǵݹ���ֹ����
            if (root.left == null && root.right == null) {
                // ��·�����뵽����
                paths.add(path);
            } else {
                // ��ǰ�ڵ㲻��Ҷ�ӽڵ㣬�����ݹ����
                path += "->";
                construct_paths(root.left, path);
                construct_paths(root.right, path);
            }
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        construct_paths(root, "");
        return paths;
    }
}
