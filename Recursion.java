public class Recursion {

    public static String reverseString(String value) {
        int length = value.length();
        if (length == 1) {
            return value;
        }
        String last = value.substring(length - 1);

        String subString = value.substring(0, length - 1);
        System.out.println(subString + "  " + length + "  " + value + "  " + last);
        return last + reverseString(subString);
    }

    public static boolean isPalindrome(String value) {
        int length = value.length();
        if (length <= 1) {
            return true;
        }
        if (value.charAt(0) == value.charAt(length-1)) {
            String sub = value.substring(1, length - 1);
            return isPalindrome(sub);
        } else {
            return false;
        }
    }


}
