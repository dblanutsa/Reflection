package com.gmail.blanutsa.dmitriy.task2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Task2 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        Class<TextContainer> cls =  TextContainer.class;

        if (!cls.isAnnotationPresent(SaveTo.class)){
            System.out.println("Class " + cls.getName() + " is dont annotation");
            return;
        }

        TextContainer obj = new TextContainer();
        SaveTo saveTo = cls.getAnnotation(SaveTo.class);
        String path = saveTo.path();
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods){
            if (method.isAnnotationPresent(Saver.class)){
                Field pathField = cls.getDeclaredField("path");
                pathField.setAccessible(true);
                pathField.set(obj, path);
                method.invoke(obj);
            }
        }

    }

}
