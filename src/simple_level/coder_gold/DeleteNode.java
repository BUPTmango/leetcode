package simple_level.coder_gold;

import data_structure.linked_list.ListNode;

/**
 * ������ 02.03. ɾ���м�ڵ�
 * ʵ��һ���㷨��ɾ�����������м��ĳ���ڵ㣨���˵�һ�������һ���ڵ㣬��һ�����м�ڵ㣩���ٶ���ֻ�ܷ��ʸýڵ㡣
 *
 * ʾ����
 *
 * ���룺��������a->b->c->d->e->f�еĽڵ�c
 * ������������κ����ݣ����������Ϊa->b->d->e->f
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/17 10:34 ����
 */
public class DeleteNode {
    /**
     * Ҫ��ɾ���ڵ�c����node��Ϊ����Ҫɾ���Ľڵ㡣
     * Ҫɾ���ڵ�node��������Ϊ����Ҫɾ���ڵ�c�����ǿ��԰ѽڵ�c��val��Ϊ�ڵ�d(node.next)��val��
     * ��ʱ���Կ��ɽڵ�c�Ѿ�����˽ڵ�d���ı�c(node)����һ���ڵ�Ϊe(node.next.next)��
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
