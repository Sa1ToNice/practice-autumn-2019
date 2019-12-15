package lesson05.part02;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Task06Test {
    private static String fileName = "./src/main/java/lesson05/part02/Task06.java";
    String s[];
    String r;
    int l1=0,l2=0,l3=0;
    public static List<String> collect;
    ByteArrayOutputStream ouputArr;

    @Before
    public void before() throws Exception {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            collect = stream.collect(Collectors.toList());

            for (int i=0;i<collect.size();i++
            ) {

                if(collect.get(i).contains("static class Cow")) l1++;
                if(collect.get(i).contains("static class Dog")) l2++;
                if(collect.get(i).contains("static class Whale")) l3++;

            }

            SystemOutGatewayUtil.setCustomOut();
            Task06.main(null);
            SystemOutGatewayUtil.setOriginalOut();
            ouputArr=SystemOutGatewayUtil.getOutputArray() ;
            r=ouputArr.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() throws Exception {
        SystemOutGatewayUtil.clearOutput();
    }

    @Test
    public void t1(){/*впишите свои числа */
        Assert.assertTrue(   "Не пройдено 1 условие",r.length()==0);
    }

    @Test
    public void t2(){/*впишите свои числа */
        Method[] a=Task06.class.getMethods();
        int r=0;
        for (Method c:a
             ) {if(c.toString().contains("Task06")) r++;

        }
        Assert.assertTrue(   "Не пройдено 2 условие",r==3);
    }

    @Test
    public void t3() throws NoSuchMethodException {/*впишите свои числа */
        Method a=Task06.class.getMethod("print",int.class);

        Assert.assertTrue(   "Не пройдено 3 условие",a.toString().contains("static"));
    }
    @Test
    public void t4() throws NoSuchMethodException {/*впишите свои числа */
        Method a=Task06.class.getMethod("print",String.class);

        Assert.assertTrue(   "Не пройдено 4 условие",a.toString().contains("static"));
    }
    @Test
    public void t5() throws NoSuchMethodException {/*впишите свои числа */
        Method a=Task06.class.getMethod("main",String[].class);

        Assert.assertTrue(   "Не пройдено 5 условие",a.toString().contains("static"));
    }

}