package com.gmail.blanutsa.dmitriy.task3;

import java.io.*;
import java.lang.reflect.InvocationTargetException;


public class Task3 {

    public static void main(String[] args) throws FileNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, NoSuchFieldException, InvocationTargetException, ClassNotFoundException {
        TestSerialize obj = new TestSerialize("str", 5, 7L, (short) 3, (byte) 1, (float) 7.8, 9.1, 'd', true);

        String path = System.getProperty("user.dir") + "/serialize.txt";
        System.out.println(obj);
        SerializeUtil.serialize(obj, path);

        TestSerialize obj2 = SerializeUtil.deserialize(obj.getClass(),path);
        System.out.println(obj2);
        System.out.println(obj.equals(obj2));

    }

}
