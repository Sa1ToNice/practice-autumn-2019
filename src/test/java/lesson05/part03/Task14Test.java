package lesson05.part03;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ReadFuncBodyUtil;
import util.SystemInGatewayUtil;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task14Test {
    public static String fileName = "./src/main/java/lesson05/part03/Task14.java";
    public static List<String> collect;
    public static List<String> mainFunc;

    static {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            collect = stream.collect(Collectors.toList());
            int numberMainFunc = -1;

            for (int i = 0; i < collect.size(); i++) {
                if (collect.get(i).contains("public static void main(String[] args)")) {
                    numberMainFunc = i;
                }
            }

            mainFunc = ReadFuncBodyUtil.getFuncBody(collect, numberMainFunc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void before() {
        SystemOutGatewayUtil.setCustomOut();
    }

    @After
    public void after() {
        SystemInGatewayUtil.setOriginalIn();
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void test14ClassFoxImplements() {
        int numberFox = -1;

        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).contains("class Fox implements Animal")) {
                numberFox = i;
            }
        }

        Assert.assertTrue(
                "Интерфейс Animal должен быть реализован в классе Fox.",
                numberFox > -1
        );
    }

    @Test
    public void test14FoxOneMethod() {
        Method[] methods = Task13.Fox.class.getMethods();
        int foxClassMethodsCount = 0;
        for (Method list: methods) {
            if (list.toString().contains("Fox.")) {
                foxClassMethodsCount++;
            }
        }


        Assert.assertTrue(
                "В классе Fox должен быть реализован только один метод(getName).",
                foxClassMethodsCount == 1
        );
    }

    @Test
    public void test14AnimalInterfaceDeclareMethodGetColor() {
        Method[] methods = Task13.Animal.class.getMethods();
        boolean isGetColorMethod = false;
        for (Method list: methods) {
            if (list.toString().contains("Animal.getColor")) {
                isGetColorMethod = true;
            }
        }
        Assert.assertTrue(
                "В интерфейсе Animal должен быть объявлен метод getColor.",
                isGetColorMethod
        );
    }

    @Test
    public void test14BigFoxExtendFox() {
        Assert.assertTrue(
                "Класс BigFox должен быть потомком класса Fox.",
                Task14.BigFox.class.getSuperclass().toString().contains("Fox")
        );
    }
}