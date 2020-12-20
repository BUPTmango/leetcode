package simple_level;

/**
 * 415. �ַ������
 * ���������ַ�����ʽ�ķǸ�����num1 ��num2���������ǵĺ͡�
 *
 * ��ʾ��
 *
 * num1 ��num2�ĳ��ȶ�С�� 5100
 * num1 ��num2 ��ֻ��������0-9
 * num1 ��num2 ���������κ�ǰ����
 * �㲻��ʹ���κ΃Ƚ� BigInteger �⣬Ҳ����ֱ�ӽ�������ַ���ת��Ϊ������ʽ
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/20 3:28 ����
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            // �����ڵĽ��в���
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + carry;
            ans.append(result % 10);
            carry = result / 10;
            i--;
            j--;
        }
        // �������Ժ�Ĵ���Ҫ��ת����
        ans.reverse();
        return ans.toString();
    }
}
