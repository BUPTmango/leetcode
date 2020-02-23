package simple_level;

import data_structure.linked_list.ListNode;

/**
 * 234
 * ��������
 * ���ж�һ�������Ƿ�Ϊ��������
 *
 * ʾ�� 1:
 *
 * ����: 1->2
 * ���: false
 * ʾ�� 2:
 *
 * ����: 1->2->2->1
 * ���: true
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/16 10:59 ����
 */
public class IsPalindrome {
    /**
     * https://blog.csdn.net/ds19980228/article/details/84191952
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        //ע���,����fast�ĸ�ֵ
        ListNode fast=head.next,slow=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode tmp=slow.next;
        ListNode newhead=null;
        slow.next = null;
        //���ú�������
        while(tmp!=null){
            ListNode cur=tmp.next;
            tmp.next = newhead;
            newhead=tmp;
            tmp=cur;
        }
        //������������бȽ�
        while(newhead!=null){
            if(newhead.val!=head.val){
                return false;
            }
            newhead=newhead.next;
            head=head.next;
        }
        return true;
    }

}
