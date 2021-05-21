package paper;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * С�����ݴ�������
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/13 20:55
 */
public class HoldError {

    /**
     * �﷨�����ڵ�
     */
    private ASTtranslation_unit astRoot;
    /**
     * ���ű�
     */
    private SymboltableInfo symbolTable;
    private String chooseInterFileName;
    private int errorLine;

    List<String> interFileList = new ArrayList<>();  //�����������м��ļ�
    TreeSet<Integer> rows = new TreeSet<>();  //���滯�����м��ļ����к�

    public void progress() {
        try {
            // �Ƚ��������м��ļ�����list
            // ֮��õ�ȥͷ����м��ļ�

            // ����ȥͷ�м��ļ������﷨��
            boolean firstFlag = true;
            try {
                astRoot = createAST("");
            } catch (Exception e) {
                // ��һ�������﷨��ʧ��
                firstFlag = false;
                // ��¼��������
                errorLine = 0;
            }
            // ���Դ�ļ������﷨��ʧ�ܣ���Ҫ���к�������
            if (!firstFlag) {
                // ��������
            }
            while (!firstFlag) {
                // ���ݴ����������м��ļ�����ע�Ͳ���
                // �ȶԵ�ǰ�н���ע�Ͳ��� �������ʧ������ ע�͵�ǰ����
                int totalTimes = 3;
                int errorTimes = 0;
                doComment(errorLine, errorLine);
                try {
                    // ����ȥͷ�м��ļ������﷨��
                    astRoot = createAST("");
                    firstFlag = true;
                } catch (Exception e) {
                    // ͨ��������Ϣ�õ���������
                    errorLine = 0;
                }
            }

            int cnt = 5;//��Ҫ��ȫ�Ĵ���
            int count = 1;//��ǰ��ȫ�Ĵ���
            TreeSet<Integer> theLastRows = new TreeSet<>();
            try {
                while (cnt > count) {
                    theLastRows = (TreeSet<Integer>) rows.clone();
                    // �����м��ļ���ȫ
                    chooseInterFileName = addInterFile(chooseInterFileName, interFileList, astRoot, rows);
                    // �Ի������м��ļ�  ���ɳ����﷨��AST
                    astRoot = createAST(chooseInterFileName);
                    // �Ի������м��ļ�    ���ɷ��ű�
                    symbolTable = createSymboltable(astRoot);
                    if (symbolTable.getUnknownNum() <= 0) {
                        break;
                    }
                    count++;
                    // new Thread ���Ź���ʱ�� ���е���ʱ
                    // ÿ�γɹ�����һ�Σ�ι��
                    // �������� �� ��ʱʱ����Ҫ����ģ�͸���
                    // ��Ҫ��һ�� Դ�������� ͷ�ļ����� unknownSet��С��ʱ���ͳ��
                }
            } catch (Exception e) {
                // �����﷨��ʧ�ܣ��ָ��ϴβ�����м��ļ�
                chooseInterFileName = getInterFile(chooseInterFileName, interFileList, theLastRows);
            }

        } catch (Exception e) {
            // �ָ��鼼��  ������������쳣��ͨ��ȥͷ�м��ļ��ٴ������﷨��
            astRoot = createAST("");
        }
    }

    private String getInterFile(String chooseInterFileName, List<String> interFileList, TreeSet<Integer> theLastRows) {
        return null;
    }

    private SymboltableInfo createSymboltable(ASTtranslation_unit astRoot) {
        return null;
    }

    private String addInterFile(String chooseInterFileName, List<String> interFileList, ASTtranslation_unit astRoot, TreeSet<Integer> rows) {
        return "";
    }

    /**
     * �����м��ļ������﷨��
     *
     * @return
     */
    private ASTtranslation_unit createAST(String i) {
        return null;
    }

    /**
     * ���м��ļ���Ӧ�����������ע�Ͳ���
     */
    private void doComment(int beginLine, int endLine) {
    }


    private class SymboltableInfo {
        public int getUnknownNum() {
            return 0;
        }
    }

    private class ASTtranslation_unit {
    }
}
