package test.java.lesson02.part02;

import main.java.lesson02.part02.Task27;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemInGatewayUtil;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task27Test {

    @Test
    public void test27() throws Exception {
        //TODO: check no out on full diff
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        SystemInGatewayUtil.setCustomIn("2");
        Task27.main(null);
        String[] output = out.toString().trim().split("\n");
        Assert.assertEquals("четное однозначное число", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("3");
        Task27.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("нечетное однозначное число", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("32");
        Task27.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("четное двузначное число", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("33");
        Task27.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("нечетное двузначное число", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("324");
        Task27.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("четное трехзначное число", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("325");
        Task27.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("нечетное трехзначное число", output[output.length - 1].trim());
        out.reset();
    }
}