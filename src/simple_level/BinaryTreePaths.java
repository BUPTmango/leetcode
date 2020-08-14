package simple_level;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. ������������·��
 * ����һ�����������������дӸ��ڵ㵽Ҷ�ӽڵ��·����
 *
 * ˵��:?Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 *
 * ʾ��:
 *
 * ����:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * ���: ["1->2->5", "1->3"]
 *
 * ����: ���и��ڵ㵽Ҷ�ӽڵ��·��Ϊ: 1->2->5, 1->3
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/8/14 12:20 ����
 */
public class BinaryTreePaths {
    /**
     * �����ǰ�Ľڵ㲻��Ҷ�ӽڵ㣬���ڵ�ǰ��·��ĩβ��Ӹýڵ㣬���ݹ�����ýڵ��ÿһ�����ӽڵ㡣
     * �����ǰ�Ľڵ���Ҷ�ӽڵ㣬���ڵ�ǰ��·��ĩβ��Ӹýڵ�󣬾͵õ���һ���Ӹ��ڵ㵽Ҷ�ӽڵ��·�������԰Ѹ�·�����뵽���С�
     *
     * @param root
     * @param path
     * @param paths
     */
    public void construct_paths(TreeNode root, String path, ArrayList<String> paths) {
        if (root != null) {
            path += Integer.toString(root.val);
            // ��ǰ�ڵ���Ҷ�ӽڵ�
            if ((root.left == null) && (root.right == null)) {
                // ��·�����뵽����
                paths.add(path);
            } else {
                // ��ǰ�ڵ㲻��Ҷ�ӽڵ㣬�����ݹ����
                path += "->";
                construct_paths(root.left, path, paths);
                construct_paths(root.right, path, paths);
            }
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> paths = new ArrayList();
        construct_paths(root, "", paths);
        return paths;
    }
}
