package test.java.lesson02.part01;

import main.java.lesson02.part01.Task01;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task01Test {
    @Test
    public void test01()
    {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();

        out.reset();
        Task01.div(5, 6);
        String output = out.toString().trim();

        Assert.assertEquals("0", output);
        out.reset();
        Task01.main(null);

        String[] s = out.toString().trim().split("\n");

        Assert.assertEquals(3, s.length);
        Assert.assertEquals("2", s[0].trim());
        Assert.assertEquals("1", s[1].trim());
        Assert.assertEquals("0", s[2].trim());
    }
}