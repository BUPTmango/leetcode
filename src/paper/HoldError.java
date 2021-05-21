package paper;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 小论文容错框架流程
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/13 20:55
 */
public class HoldError {

    /**
     * 语法树根节点
     */
    private ASTtranslation_unit astRoot;
    /**
     * 符号表
     */
    private SymboltableInfo symbolTable;
    private String chooseInterFileName;
    private int errorLine;

    List<String> interFileList = new ArrayList<>();  //保存完整的中间文件
    TreeSet<Integer> rows = new TreeSet<>();  //保存化简后的中间文件的行号

    public void progress() {
        try {
            // 先将完整的中间文件存入list
            // 之后得到去头后的中间文件

            // 根据去头中间文件生成语法树
            boolean firstFlag = true;
            try {
                astRoot = createAST("");
            } catch (Exception e) {
                // 第一次生成语法树失败
                firstFlag = false;
                // 记录错误行数
                errorLine = 0;
            }
            // 如果源文件生成语法树失败，需要进行函数划分
            if (!firstFlag) {
                // 函数划分
            }
            while (!firstFlag) {
                // 根据错误行数对中间文件进行注释操作
                // 先对当前行进行注释操作 如果连续失败三次 注释当前函数
                int totalTimes = 3;
                int errorTimes = 0;
                doComment(errorLine, errorLine);
                try {
                    // 根据去头中间文件生成语法树
                    astRoot = createAST("");
                    firstFlag = true;
                } catch (Exception e) {
                    // 通过错误信息拿到报错行数
                    errorLine = 0;
                }
            }

            int cnt = 5;//需要补全的次数
            int count = 1;//当前补全的次数
            TreeSet<Integer> theLastRows = new TreeSet<>();
            try {
                while (cnt > count) {
                    theLastRows = (TreeSet<Integer>) rows.clone();
                    // 进行中间文件补全
                    chooseInterFileName = addInterFile(chooseInterFileName, interFileList, astRoot, rows);
                    // 对化简后的中间文件  生成抽象语法树AST
                    astRoot = createAST(chooseInterFileName);
                    // 对化简后的中间文件    生成符号表
                    symbolTable = createSymboltable(astRoot);
                    if (symbolTable.getUnknownNum() <= 0) {
                        break;
                    }
                    count++;
                    // new Thread 看门狗计时器 进行倒计时
                    // 每次成功迭代一次，喂狗
                    // 迭代次数 和 超时时间需要根据模型给出
                    // 需要想一下 源代码行数 头文件行数 unknownSet大小何时如何统计
                }
            } catch (Exception e) {
                // 生成语法树失败，恢复上次补齐的中间文件
                chooseInterFileName = getInterFile(chooseInterFileName, interFileList, theLastRows);
            }

        } catch (Exception e) {
            // 恢复块技术  如果出现意外异常，通过去头中间文件再次生成语法树
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
     * 根据中间文件生成语法树
     *
     * @return
     */
    private ASTtranslation_unit createAST(String i) {
        return null;
    }

    /**
     * 对中间文件相应函数区间进行注释操作
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
