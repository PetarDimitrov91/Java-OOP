package harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    static Field[] fields;

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String input = console.readLine();

        Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;

        fields = richSoilLandClass.getDeclaredFields();

        while (!input.equals("HARVEST")) {

            Predicate<? super Field> predicate;
            switch (input) {
                case "private":
                    predicate = e -> Modifier.isPrivate(e.getModifiers());
                    printFields(predicate);
                    break;
                case "protected":
                    predicate = e -> Modifier.isProtected(e.getModifiers());
                    printFields(predicate);
                    break;
                case "public":
                    predicate = e -> Modifier.isPublic(e.getModifiers());
                    printFields(predicate);
                    break;
                case "all":
                    printFields();
                    break;
            }
            input = console.readLine();
        }
    }

    private static void printFields(Predicate<? super Field> predicate) {
        Arrays.stream(fields)
                .filter(predicate)
                .forEach(e -> System.out.println(Modifier.toString(e.getModifiers()) + " "
                        + e.getType().getSimpleName()
                        + " " + e.getName()));
    }

    private static void printFields() {
        Arrays.stream(fields)
                .forEach(e -> System.out.println(Modifier.toString(e.getModifiers()) + " "
                        + e.getType().getSimpleName()
                        + " " + e.getName()));
    }
}
