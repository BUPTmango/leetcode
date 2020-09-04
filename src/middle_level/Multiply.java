package middle_level;

import java.util.Arrays;

/**
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数?num1?和?num2，返回?num1?和?num2?的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例?2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1?和?num2?的长度小于110。
 * num1 和?num2 只包含数字?0-9。
 * num1 和?num2?均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/4 6:30 下午
 */
public class Multiply {
    public String multiply(String num1, String num2) {
        // 把num1和num2都转化成charArray
        char[] chrs1 = num1.toCharArray();
        char[] chrs2 = num2.toCharArray();
        // 存储结果的char数组
        char[] res = new char[chrs1.length + chrs2.length];
        Arrays.fill(res, '0');
        // 竖式乘法
        for (int j = chrs2.length - 1; j >= 0; j--) {
            for (int i = chrs1.length - 1; i >= 0; i--) {
                // 乘法
                int product = (chrs1[i] - '0') * (chrs2[j] - '0');
                // 当前位加上product为tmp
                int tmp = (res[i + j + 1] - '0') + product;
                // tmp除以10的余数留在当前位，结果进位
                res[i + j + 1] = (char) (tmp % 10 + '0');
                res[i + j] = (char) ((res[i + j] - '0') + tmp / 10 + '0');
            }
        }
        StringBuilder sb = new StringBuilder();
        // 去掉头部0
        boolean seen = false;
        for (char c : res) {
            if (c == '0' && !seen) {
                continue;
            } else {
                seen = true;
                sb.append(c);
            }
        }
        // 长度为0，说明当作头部空格去掉了
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
