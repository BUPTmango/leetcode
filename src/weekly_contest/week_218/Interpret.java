package weekly_contest.week_218;

/**
 * 5617. ��� Goal ������
 * �������һ�����Խ����ַ��� command �� Goal ������ ��command �� "G"��"()" ��/�� "(al)" ��ĳ��˳����ɡ�Goal �������Ὣ "G" ����Ϊ�ַ��� "G"��"()" ����Ϊ�ַ��� "o" ��"(al)" ����Ϊ�ַ��� "al" ��Ȼ�󣬰�ԭ˳�򽫾����͵õ����ַ������ӳ�һ���ַ�����
 *
 * �����ַ��� command ������ Goal ������ �� command �Ľ��ͽ����
 *
 * ʾ�� 1��
 *
 * ���룺command = "G()(al)"
 * �����"Goal"
 * ���ͣ�Goal ��������������Ĳ���������ʾ��
 * G -> G
 * () -> o
 * (al) -> al
 * ������ӵõ��Ľ���� "Goal"
 * ʾ�� 2��
 *
 * ���룺command = "G()()()()(al)"
 * �����"Gooooal"
 * ʾ�� 3��
 *
 * ���룺command = "(al)G(al)()()G"
 * �����"alGalooG"
 *
 *
 * ��ʾ��
 *
 * 1 <= command.length <= 100
 * command �� "G"��"()" ��/�� "(al)" ��ĳ��˳�����
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/6 10:31 ����
 */
public class Interpret {
    public String interpret(String command) {
        int length = command.length();
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < length) {
            char curr = command.charAt(index);
            if (curr == 'G') {
                sb.append("G");
                index++;
            }
            if (curr == '(') {
                // ���Ѱ�� ) ������ al)
                char next = command.charAt(index + 1);
                if (next == ')') {
                    sb.append("o");
                    index += 2;
                } else {
                    sb.append("al");
                    index += 4;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Interpret interpret = new Interpret();
        String str = "G()()()()(al)";
        System.out.println(interpret.interpret(str));
    }
}
