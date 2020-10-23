package middle_level;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 173. ����������������
 * ʵ��һ���������������������㽫ʹ�ö����������ĸ��ڵ��ʼ����������
 *
 * ���� next() �����ض����������е���һ����С������
 *
 *
 * ʾ����
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // ���� 3
 * iterator.next();    // ���� 7
 * iterator.hasNext(); // ���� true
 * iterator.next();    // ���� 9
 * iterator.hasNext(); // ���� true
 * iterator.next();    // ���� 15
 * iterator.hasNext(); // ���� true
 * iterator.next();    // ���� 20
 * iterator.hasNext(); // ���� false
 *
 * ��ʾ��
 *
 * next()��hasNext()������ʱ�临�Ӷ���O(1)����ʹ��O(h) �ڴ棬����h�����ĸ߶ȡ�
 * ����Լ���next()����������Ч�ģ�Ҳ����˵�������� next()ʱ��BST �����ٴ���һ����һ����С������
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/23 9:29 ����
 */
public class BSTIterator {

    private List<Integer> list = new ArrayList<>();
    private int index = 0;
    public BSTIterator(TreeNode root) {
        // �������
        inOrder(root);
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }

    /** @return the next smallest number */
    public int next() {
        int res = 0;
        if (hasNext()) {
            res = list.get(index);
            index++;
        }
        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (index < list.size()) {
            return true;
        } else {
            return false;
        }
    }

}
