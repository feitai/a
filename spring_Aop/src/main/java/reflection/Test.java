package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Description: Test
 * Author: heyv
 * Time: 2023 2023/7/31 10:59
 */
public class Test {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<?> personClass =Person.class;
        Person person1 = (Person) personClass.newInstance();


        System.out.println("Creating a Class: " + person1);

        System.out.println(person1);

        person1.setAge(100);
        person1.setName("Jihn");

        System.out.println(person1.toString());

//        Field nameField = personClass.getDeclaredField("name");
//        nameField.setAccessible(true);
//        nameField.set(person1,"James");
//
//        Field ageField = personClass.getDeclaredField("age");
//        ageField.setAccessible(true);
//        ageField.set(person1,12);
//
//        Method sayHelloMethod = personClass.getDeclaredMethod("sayHello");
//        sayHelloMethod.invoke(person1);





    }


}
