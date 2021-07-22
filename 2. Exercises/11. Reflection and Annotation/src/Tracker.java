import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker {

    @Author(name = "Peter")
    public static void printMethodsByAuthor(Class<?> clazz) {
        Map<String, List<String>> methodsByAuthor = new HashMap<>();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            Author annotation = method.getAnnotation(Author.class);

            if (annotation != null) {
                methodsByAuthor.putIfAbsent(annotation.name(), new ArrayList<>());
                methodsByAuthor.get(annotation.name()).add(method.getName() + "()");
            }
        }

        for (Map.Entry<String, List<String>> stringListEntry : methodsByAuthor.entrySet()) {
            System.out.print(stringListEntry.getKey() + ": ");
            stringListEntry.getValue()
                    .forEach(System.out::print);
            System.out.println();
        }
    }
}
