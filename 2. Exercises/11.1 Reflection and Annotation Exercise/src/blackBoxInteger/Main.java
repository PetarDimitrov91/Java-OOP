package blackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;

        Constructor<BlackBoxInt> declaredConstructor = blackBoxIntClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);

        BlackBoxInt blackBoxInt = declaredConstructor.newInstance();

        List<Method> methods = Arrays.asList(blackBoxIntClass.getDeclaredMethods());

        Field innerValue = blackBoxIntClass.getDeclaredField("innerValue");

        String command = bufferedReader.readLine();

        while (!command.equals("END")) {
            String operation = command.split("_")[0];
            int n = Integer.parseInt(command.split("_")[1]);

            Method method = methods.stream()
                    .filter(m -> m.getName().equals(operation))
                    .findFirst()
                    .orElse(null);

            assert method != null;
            method.setAccessible(true);
            method.invoke(blackBoxInt, n);
            innerValue.setAccessible(true);
            System.out.println(innerValue.get(blackBoxInt));

            command = bufferedReader.readLine();
        }

    }
}
