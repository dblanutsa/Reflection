package com.gmail.blanutsa.dmitriy.task3;

import com.gmail.blanutsa.dmitriy.task3.Save;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class SerializeUtil {

    public static void serialize(Object obj, String path) throws IllegalAccessException {
        Class<?> cls = obj.getClass();

        StringBuilder sb = new StringBuilder();

        sb.append(cls.getName()).append("#");

        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Save.class)) {
                field.setAccessible(true);
                sb.append(field.getName()).append(":");
                sb.append(field.get(obj)).append("#");
            }
        }

        try(PrintWriter pw = new PrintWriter(path)){
            pw.print(sb);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static <T> T deserialize(Class<T> clsDe, String path) throws FileNotFoundException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Scanner scanner = new Scanner(new FileInputStream(path));
        String[] array = scanner.nextLine().split("#");

        if(!clsDe.getName().equals(array[0])){
            System.out.println("Serialize error!!!\n\r class is " + array[0]);
            return null;
        }

        Object obj = clsDe.getConstructor().newInstance();
        for (int i = 1; i < array.length; i++){
            String[] arrayField = array[i].split(":");
            Field field = clsDe.getDeclaredField(arrayField[0]);
            if (Modifier.isPrivate(field.getModifiers())) {
                field.setAccessible(true);
            }
            field.set(obj, pull(field.getType(), arrayField[1]));
        }
        return (T) obj;
    }

    private static  <T> T pull(Class<T> cls, String value){
        if (cls == String.class){
            return (T) value;
        }
        if (cls == Long.class || cls == long.class){
            Long lon = Long.parseLong(value);
            return (T) lon;
        }
        if (cls == Integer.class || cls == int.class){
            Integer in = Integer.parseInt(value);
            return (T) in;
        }
        if (cls == Short.class || cls == short.class){
            Short sh = Short.parseShort(value);
            return (T) sh;
        }
        if (cls == Byte.class || cls == byte.class){
            Byte b = Byte.parseByte(value);
            return (T) b;
        }
        if (cls == Double.class || cls == double.class){
            Double d = Double.parseDouble(value);
            return (T) d;
        }
        if (cls == Float.class || cls == float.class){
            Float f = Float.parseFloat(value);
            return (T) f;
        }
        if (cls == Character.class || cls == char.class){
            Character ch = value.charAt(0);
            return (T) ch;
        }
        if (cls == Boolean.class || cls == boolean.class){
            Boolean b = Boolean.parseBoolean(value);
            return (T) b;
        }
        return null;
    }


}
