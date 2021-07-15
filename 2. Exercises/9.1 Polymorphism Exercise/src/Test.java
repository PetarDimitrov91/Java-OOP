import java.text.DecimalFormat;

public class Test {
    public static void main(String[] args) {

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        double d = 15.001;

        System.out.println(decimalFormat.format(d));
    }
}
