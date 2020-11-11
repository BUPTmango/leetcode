package middle_level;


import java.util.LinkedList;
import java.util.Stack;

/**
 * 394. �ַ�������
 * ����һ������������ַ������������������ַ�����
 *
 * �������Ϊ: k[encoded_string]����ʾ���з������ڲ��� encoded_string �����ظ� k �Ρ�ע�� k ��֤Ϊ��������
 *
 * �������Ϊ�����ַ���������Ч�ģ������ַ�����û�ж���Ŀո�������ķ��������Ƿ��ϸ�ʽҪ��ġ�
 *
 * ���⣬�������Ϊԭʼ���ݲ��������֣����е�����ֻ��ʾ�ظ��Ĵ��� k �����粻�������3a��2[4]�����롣
 *
 * ʾ�� 1��
 *
 * ���룺s = "3[a]2[bc]"
 * �����"aaabcbc"
 * ʾ�� 2��
 *
 * ���룺s = "3[a2[c]]"
 * �����"accaccacc"
 * ʾ�� 3��
 *
 * ���룺s = "2[abc]3[cd]ef"
 * �����"abcabccdcdcdef"
 * ʾ�� 4��
 *
 * ���룺s = "abc3[cd]xyz"
 * �����"abccdcdcdxyz"
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/11 9:34 ����
 */
public class DecodeString {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for(Character c : s.toCharArray()) {
            // �� c Ϊ [ ʱ������ǰ multi �� res ��ջ�����ֱ��ÿ��� 0��
            if(c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                // ��ջ������
                multi = 0;
                res = new StringBuilder();
            }
            // �� c Ϊ ] ʱ��stack ��ջ��ƴ���ַ��� res = last_res + cur_multi * res
            else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for(int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + tmp);
            }
            // �� c Ϊ����ʱ���������ַ�ת��Ϊ���� multi�����ں����������㣻
            else if(c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            // �� c Ϊ��ĸʱ���� res β����� c��
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString("3[a]2[bc]"));
    }
}
