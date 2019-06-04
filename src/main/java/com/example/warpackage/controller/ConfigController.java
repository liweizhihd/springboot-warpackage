package com.example.warpackage.controller;

import com.example.warpackage.util.IOUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: liweizhi
 * @Date: 2019/4/26 11:09
 * @Description:
 */
@RestController
@RequestMapping("config")
public class ConfigController {
    @GetMapping("read")
    public Object readConfig() {
        try {
            return IOUtil.getCommonConfig();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getStackTrace();
        }
    }

    @GetMapping("refresh")
    public Object refresh() {
        try {
            IOUtil.refreshCommonConfig();
        } catch (Throwable e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Value("${custom-name}")
    private String cName;

    @GetMapping("prop")
    public String getProp() {
        return cName;
    }
}
