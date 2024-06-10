package recursion;

public class SumOfDigits {


    public static void main(String args[]) {

        System.out.println("Sum of digits: "+sumOfDigits(425));

    }

    private static int sumOfDigits(int n) {
        if(n<10){
            return n;
        }
        return sumOfDigits(n/10)+n % 10;

    }

}
