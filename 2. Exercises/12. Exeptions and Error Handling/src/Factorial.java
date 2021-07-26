import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        BigInteger factorial = new BigInteger(String.valueOf(fact(BigInteger.valueOf(Integer.parseInt(console.nextLine())))));
        System.out.println(factorial);
    }

    private static BigInteger fact(BigInteger n) {
        BigInteger result = new BigInteger(String.valueOf(1));
        BigInteger isNull = new BigInteger(String.valueOf(BigInteger.valueOf(0)));
        if (n.equals(isNull)) {
            return result;
        }
        return n.multiply(fact(n.subtract(BigInteger.valueOf(1))));
    }
}
