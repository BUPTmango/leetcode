package simple_level.coder_gold;

/**
 * ������ 01.03. URL��
 * URL������дһ�ַ��������ַ����еĿո�ȫ���滻Ϊ%20���ٶ����ַ���β�����㹻�Ŀռ��������ַ�������֪���ַ����ġ���ʵ�����ȡ���ע����Javaʵ�ֵĻ�����ʹ���ַ�����ʵ�֣��Ա�ֱ���������ϲ�������
 *
 * ʾ��1:
 *
 *  ���룺"Mr John Smith    ", 13
 *  �����"Mr%20John%20Smith"
 * ʾ��2:
 *
 *  ���룺"               ", 5
 *  �����"%20%20%20%20%20"
 * ��ʾ��
 *
 * �ַ���������[0, 500000]��Χ�ڡ�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/26 12:36 ����
 */
public class ReplaceSpaces {
    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++){
            if(S.charAt(i) == ' '){
                sb.append("%20");
            }else{
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }
}
