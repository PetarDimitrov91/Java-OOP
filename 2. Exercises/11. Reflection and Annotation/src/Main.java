import java.lang.reflect.Field;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;


public class Main {
    @Author(name = "George")
    public static void main(String[] args) {
       Tracker.printMethodsByAuthor(Main.class);
       Tracker.printMethodsByAuthor(Tracker.class);






        //      Class<Reflection> reflectionClass = Reflection.class;
//
        //      Field[] declaredFields = reflectionClass.getDeclaredFields();
        //      Arrays.stream(declaredFields)
        //              .sorted(Comparator.comparing(Field::getName))
        //              .forEach(m ->{
        //                  if(!Modifier.isPrivate(m.getModifiers())){
        //                      System.out.println(m.getName() + " must be private!");
        //                  }
        //              });
//
        //      Method[] declaredMethods = reflectionClass.getDeclaredMethods();
//
        //      Arrays.stream(declaredMethods)
        //              .filter(m -> m.getName().contains("get") || m.getName().contains("set"))
        //              .sorted(Comparator.comparing(Method::getName))
        //              .forEach(Main::printMethod);
//
        //  }
//
        //  private static void printMethod(Method m) {
        //     if(m.getName().contains("get") && !Modifier.isPublic(m.getModifiers())){
        //         System.out.println(m.getName() + " have to be public!");
        //     }else if(m.getName().contains("set") && !Modifier.isPrivate(m.getModifiers())){
        //         System.out.println(m.getName() + " have to be private!");
        //     }
        //  }
//
        //  public static String formatType(Class<?> type) {
        //      return type == int.class
        //              ? "class " + type
        //              : type.toString();
    }
}