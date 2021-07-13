

public class Test {
    public static void main(String[] args) {

        String name = "Petar";

        String reversed = reverse(name);

        System.out.println(reversed);
    }

    private static String reverse(String name) {
        if(name.isEmpty()){
            return name;
        }
        return reverse(name.substring(1)) + name.charAt(0);
    }
}
