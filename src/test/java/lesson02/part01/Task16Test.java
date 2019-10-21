package test.java.lesson02.part01;

import main.java.lesson02.part01.Task16;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task16Test {
    @Test
    public void test16()
    {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        Task16.main(null);
        Assert.assertEquals("日本語", out.toString().trim());
    }
}