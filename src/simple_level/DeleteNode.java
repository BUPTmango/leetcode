package simple_level;

import data_structure.linked_list.ListNode;

/**
 * ����ת�㷨������Ƶ���⡷����
 * 237
 * ɾ�������еĽڵ�
 * ���дһ��������ʹ�����ɾ��ĳ�������и����ģ���ĩβ���ڵ㣬�㽫ֻ������Ҫ��ɾ���Ľڵ㡣
 *
 * ����һ������ --?head =?[4,5,1,9]�������Ա�ʾΪ:
 * ʾ�� 1:
 *
 * ����: head = [4,5,1,9], node = 5
 * ���: [4,1,9]
 * ����: ������������ֵΪ?5?�ĵڶ����ڵ㣬��ô�ڵ�������ĺ���֮�󣬸�����Ӧ��Ϊ 4 -> 1 -> 9.
 * ʾ�� 2:
 *
 * ����: head = [4,5,1,9], node = 1
 * ���: [4,5,9]
 * ����: ������������ֵΪ?1?�ĵ������ڵ㣬��ô�ڵ�������ĺ���֮�󣬸�����Ӧ��Ϊ 4 -> 5 -> 9.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/17 11:45 ����
 */
public class DeleteNode {
    /**
     * ��Ϊ������һ��ListNode ����û�а취�õ�ǰһ���ڵ�
     * ֱ�ӽ���һ���ڵ��val���Ƶ���ǰ�ڵ�֮��ɾ����һ���ڵ������
     *
     * ���������е��������ⶼ�Ǵ������� �е���������¿��Ըı�ڵ��ֵ���ﵽҪ��
     * @param node
     */
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        if (node.next == null) {
            node = null;
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
