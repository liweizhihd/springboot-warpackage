package com.example.warpackage;

import com.example.warpackage.util.IOUtil;
import org.junit.Test;

/**
 * @Auther: liweizhi
 * @Date: 2019/4/26 11:20
 * @Description:
 */
public class SimpleTest {
    @Test
    public void readConfig(){

        System.out.println(IOUtil.getCommonConfig().getString("age"));
    }
}
