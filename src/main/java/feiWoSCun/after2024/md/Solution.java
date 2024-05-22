package feiWoSCun.after2024.md;

import feiWoSCun.other.遥遥领先.Main;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/4/17
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        Main m = new Main();
        Class<? extends Main> aClass = m.getClass();
        Field name;
        try {
            name = aClass.getDeclaredField("name");
            Constructor<? extends Main> constructor = aClass.<Main>getConstructor();
            name.setAccessible(true);
            Main main = constructor.<Main>newInstance();
            name.set(main, "张三");
            Method processor = aClass.getDeclaredMethod("processor");
            processor.setAccessible(true);
            Object invoke = processor.invoke(main);
            System.out.println(invoke.toString());
        } catch (NoSuchFieldException | NoSuchMethodException | IllegalAccessException | InvocationTargetException |
                 InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    private String name;

    private void setName(String name) {
        this.name = name;
    }

    private String processor() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("尊敬的[");
        stringBuilder.append(name);
        stringBuilder.append("]先生");
        name = stringBuilder.toString();
        return name;
    }
}