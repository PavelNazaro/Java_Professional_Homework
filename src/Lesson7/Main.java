package Lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class c = TestClass.class;
        Method[] methods = c.getDeclaredMethods();
        List<Method> list = new ArrayList<>();

        for (Method o : methods){
            if(o.isAnnotationPresent(Test.class)){
                int priority = o.getAnnotation(Test.class).priority();
                if (priority < 1 || priority > 10) {
                    priority = 5;
                }
                list.add(o);
            }
        }

        list.sort((o1, o2) -> o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority());

        for (Method o : methods){
            if (o.isAnnotationPresent(BeforeSuite.class)){
                if (list.get(0).isAnnotationPresent(BeforeSuite.class)){
                    throw new RuntimeException("BeforeSuite exception");
                }
                list.add(0, o);
            }
            if (o.isAnnotationPresent(AfterSuite.class)){
                if (list.get(0).isAnnotationPresent(AfterSuite.class)){
                    throw new RuntimeException("AfterSuite exception");
                }
                list.add(o);
            }
        }

        for (Method o : list){
            o.invoke(null);
        }
    }
}
