package middle_level;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ����ת�㷨������Ƶ���⡷ջ
 * 71. ��·��
 * �� Unix ������һ���ļ��ľ���·��������Ҫ���������߻��仰˵������ת��Ϊ�淶·����
 *
 * �� Unix �����ļ�ϵͳ�У�һ���㣨.����ʾ��ǰĿ¼�������⣬������ ��..����ʾ��Ŀ¼�л�����һ����ָ��Ŀ¼�������߶������Ǹ������·������ɲ��֡�������Ϣ����ģ�Linux / Unix�еľ���·�� vs ���·��
 *
 * ��ע�⣬���صĹ淶·������ʼ����б�� / ��ͷ����������Ŀ¼��֮�����ֻ��һ��б�� /�����һ��Ŀ¼����������ڣ������� / ��β�����⣬�淶·�������Ǳ�ʾ����·��������ַ�����
 *
 *
 * ʾ�� 1��
 *
 * ���룺"/home/"
 * �����"/home"
 * ���ͣ�ע�⣬���һ��Ŀ¼������û��б�ܡ�
 * ʾ�� 2��
 *
 * ���룺"/../"
 * �����"/"
 * ���ͣ��Ӹ�Ŀ¼����һ���ǲ����еģ���Ϊ��������Ե������߼���
 * ʾ�� 3��
 *
 * ���룺"/home//foo/"
 * �����"/home/foo"
 * ���ͣ��ڹ淶·���У��������б����Ҫ��һ��б���滻��
 * ʾ�� 4��
 *
 * ���룺"/a/./b/../../c/"
 * �����"/c"
 * ʾ�� 5��
 *
 * ���룺"/a/../../b/../c//.//"
 * �����"/c"
 * ʾ�� 6��
 *
 * ���룺"/a//b////c/d//././/.."
 * �����"/a/b/c"
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/28 8:07 ����
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }
        String[] dirs = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String dir : dirs) {
            if (dir.equals("") || dir.equals(".")) {
                continue;
            } else if (dir.equals("..")) {
                if (stack.isEmpty()) {
                    continue;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(dir);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        List<String> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0;i--) {
            sb.append("/");
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] split = "/a//b////c/d//././/..".split("/");
        for (String s : split) {
            System.out.println(s);
        }
    }
}
