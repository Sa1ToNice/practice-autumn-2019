package test.java.lesson02.part02;

import main.java.lesson02.part02.Task42;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemInGatewayUtil;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task42Test {

    @Test
    public void test42() throws Exception {
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        SystemInGatewayUtil.setCustomIn("3\n4\n2\n2\n-1");
        Task42.main(null);
        String[] output = out.toString().trim().split("\n");
        Assert.assertEquals("10", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("-1");
        Task42.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("-1", output[output.length - 1].trim());
        out.reset();
    }
}