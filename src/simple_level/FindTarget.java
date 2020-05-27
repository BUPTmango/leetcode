package simple_level;

import data_structure.TreeNode;

import java.util.*;

/**
 * 653. ����֮�� IV - ���� BST
 * ����һ��������������һ��Ŀ��������� BST �д�������Ԫ�������ǵĺ͵��ڸ�����Ŀ�������򷵻� true��
 *
 * ���� 1:
 *
 * ����:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * ���: True
 * ?
 *
 * ���� 2:
 *
 * ����:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * ���: False
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/27 10:46 ����
 */
public class FindTarget {

    /**
     * ��һ��ʹ��HashSet
     * ��򵥵ķ������Ǳ������������ҳ����п��ܵ���ϣ��ж��Ƿ���ں�Ϊ k ��һ�Խڵ㡣�����ڴ˻�������һЩ�Ľ��������������Ԫ��֮��Ϊ k���� x+y=k��������֪ x ������һ���ڵ��ֵ����ֻ���ж������Ƿ����һ��ֵΪ yy �Ľڵ㣬ʹ�� y=k?x��
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget_hashset(TreeNode root, int k) {
        Set< Integer > set = new HashSet();
        return find(root, k, set);
    }
    private boolean find(TreeNode root, int k, Set < Integer > set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }

    /**
     * ����������BFS��HashSet
     * ʹ�ù��������������һ�Խڵ��Ϊ k �Ĺ������¡�����ά��һ���� ����һ ��;��ͬ�� set�������ڵ���� queue��Ȼ��ִ�����²��裺
     * �Ӷ����ײ�ɾ��һ��Ԫ�� p��
     * ��� set ���Ƿ���� k-p��������ڣ����� True��
     * ���򣬽� p ���� set��Ȼ�󽫵�ǰ�ڵ�����Ӻ��Һ��Ӽ��� queue��
     * �ظ�����һ������ֱ�� queue Ϊ�ա�
     * ��� queue Ϊ�գ����� False��
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget_BFS(TreeNode root, int k) {
        Set < Integer > set = new HashSet();
        Queue< TreeNode > queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                TreeNode node = queue.remove();
                if (set.contains(k - node.val))
                    return true;
                set.add(node.val);
                queue.add(node.right);
                queue.add(node.left);
            } else
                queue.remove();
        }
        return false;
    }

    /**
     * ������
     * �ڱ����������� BST �����ʣ�BST �������������ǰ��������еġ���ˣ�������������� BST��������������洢�� list �С�
     * ������ɺ�ʹ������ָ�� l �� r ��Ϊ list ��ͷ��������β��������Ȼ��ִ�����²�����
     * ��� l �� r ��������Ԫ��֮���Ƿ���� k������ǣ��������� True��
     * �����ǰ��Ԫ��֮��С�� k������� l ָ����һ��Ԫ�ء�������Ϊ��������Ҫ��������֮��ʱ��Ӧ�������С����
     * �����ǰ��Ԫ��֮�ʹ��� k������� r ָ����һ��Ԫ�ء�������Ϊ��������Ҫ��С����֮��ʱ��Ӧ�ü�С�ϴ�����
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget_BST(TreeNode root, int k) {
        List < Integer > list = new ArrayList();
        inorder(root, list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k)
                return true;
            if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }
    private void inorder(TreeNode root, List< Integer > list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
