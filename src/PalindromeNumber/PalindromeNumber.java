package PalindromeNumber;

/**
 * 回文(思路：将后一半的数据进行反转，和前一半的进行对比)
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        //判断反转的位数
        int bits = new String("" + x).length() / 2;//2
        //34243
        int after = 0;
        int middle = 0;
        for (int i = 0; i < bits; i++) {
            middle = x % 10;
            x = x /10;
            after = (int) (after + middle * Math.pow(10, bits - i));
        }
        int before = Integer.parseInt(new String("" + x).substring(0, bits));
        if (before == after) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();
        System.out.println(p.isPalindrome(121));
    }
}
