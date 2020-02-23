package ReverseInteger;

import java.util.Scanner;

public class ReverseInteger {
    public static void main(String[] args) {
        //获取输入数据
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        //判断正负
        boolean flag = false;
        if (input > 0) {
            flag = true;
        }
        if (!flag) {
            input = 0 - input;
        }
        //获取位数
        String str = "" + input;
        int length = str.length();
        int output = 0;
        int middle = 0;
        //123
        for (int i = length; i > 0; i--) {
            middle = input % 10;//3
            input = input / 10;//12
            output = (int) (output + middle * Math.pow(10, i - 1));
        }
        if (!flag) {
            output = 0 - output;
        }
        System.out.println(output);
    }
}
