package simple_level;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * @author mango
 * @create 2019-03-14 10:44 AM
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int head = 0;
        String result = "";
        while (indexA >= 0 && indexB >= 0) {
            int numA = Integer.parseInt(String.valueOf(a.charAt(indexA)));
            int numB = Integer.parseInt(String.valueOf(b.charAt(indexB)));
            //要考虑三者的相加关系
            if (numA + numB + head> 1) {
                if (numA + numB + head > 2) {
                    result = "1" + result;
                } else {
                    result = "0" + result;
                }
                //进位
                head = 1;
            } else {
                //先加head 之后再重置head
                result = (numA + numB +head) + result;
                head = 0;
            }
            indexA--;
            indexB--;
        }
        while (indexA >= 0) {
            int numA = Integer.parseInt(String.valueOf(a.charAt(indexA)));
            if (numA + head > 1) {
                //当前位变为0
                result = "0" + result;
                //进位
                head = 1;
            } else {
                result = (numA + head) + result;
                head = 0;
            }
            indexA--;
        }
        while (indexB >= 0) {
            int numB = Integer.parseInt(String.valueOf(b.charAt(indexB)));
            if (numB + head > 1) {
                //当前位变为0
                result = "0" + result;
                //进位
                head = 1;
            } else {
                result = (numB + head) + result;
                head = 0;
            }
            indexB--;
        }
        if (head == 1) {
            result = "1" + result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(addBinary("110010","10111"));
    }
}