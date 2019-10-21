package test.java.lesson02.part02;

import main.java.lesson02.part02.Task25;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.java.util.SystemInGatewayUtil;
import test.java.util.SystemOutGatewayUtil;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Task25Test {

    @Test
    public void test25() throws Exception {
        //TODO: check no out on full diff
        SystemOutGatewayUtil.setCustomOut();
        ByteArrayOutputStream out = SystemOutGatewayUtil.getOutputArray();
        out.reset();

        SystemInGatewayUtil.setCustomIn("4\n4");
        Task25.main(null);
        String[] output = out.toString().trim().split("\n");
        Assert.assertEquals("1", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("-4\n4");
        Task25.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("2", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("-4\n-4");
        Task25.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("3", output[output.length - 1].trim());
        out.reset();

        SystemInGatewayUtil.setCustomIn("4\n-4");
        Task25.main(null);
        output = out.toString().trim().split("\n");
        Assert.assertEquals("4", output[output.length - 1].trim());
        out.reset();
    }
}