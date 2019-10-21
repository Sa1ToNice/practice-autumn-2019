package test.java.lesson02.part01;

import main.java.lesson02.part01.Task10;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;
@RunWith(JUnit4.class)
public class Task10Test {
    @Test
    public void test10()
    {
        //TODO: method modifiers
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task10.writeToConsole("hello");
        Assert.assertEquals("printing: hello", out.toString().trim());

        out.reset();
        Task10.main(null);
        Assert.assertEquals("printing: Hello world!", out.toString().trim());
    }
}