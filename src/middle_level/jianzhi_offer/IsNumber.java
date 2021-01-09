package middle_level.jianzhi_offer;


/**
 * 剑指 Offer 20. 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/11 10:01 上午
 */
public class IsNumber {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        // 面向测试用例编程，末尾有空格算数字？不解
        s = s.trim();
        try {
            double a = Double.parseDouble(s);
        } catch (Exception e) {
            return false;
        }

        char c = s.charAt(s.length() - 1);
        // 特，末尾有f，d,D这些不算，但是3.算数字（面向测试用例编程）
        return (c >= '0' && c <= '9') || c == '.';
    }
}
