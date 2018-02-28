package com.gmail.blanutsa.dmitriy.task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Task1 {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class<MyTestClass> cls = MyTestClass.class;
        MyTestClass obj = new MyTestClass();
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Parameters.class)) {
                Parameters parameters = method.getAnnotation(Parameters.class);
                method.setAccessible(true);
                method.invoke(obj, parameters.param2(), parameters.param1());
            }
        }
    }

}

