package com.example.warpackage.util;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Auther: liweizhi
 * @Date: 2019/4/26 11:09
 * @Description:
 */
@Slf4j
public class IOUtil {

    private static final String PATH_PREFIX = System.getProperty("user.dir") + File.separator + "config/";

    private static com.alibaba.fastjson.JSONObject commonConfig = IOUtil.readJsonFile(PATH_PREFIX + "config.json");


    /**
     * @author liweizhi
     * Date 2019/4/15 下午2:22
     * Description 读取配置文件- config/config.json
     */
    public static com.alibaba.fastjson.JSONObject getCommonConfig() {
        return commonConfig;
    }

    /**
     * @author liweizhi
     * Date 2019/4/19 下午5:11
     * Description 刷新config.json
     */
    public static boolean refreshCommonConfig() {
        try {
            commonConfig = IOUtil.readJsonFile(PATH_PREFIX + "config.json");
            return true;
        } catch (Exception e) {
            log.error("read config.json error :{}", e);
            return false;
        }
    }

    /**
     * @author liweizhi
     * Date 2019/4/17 下午11:23
     * Description 读取config目录下的配置文件
     */
    public static com.alibaba.fastjson.JSONObject getConfigByname(String fileName) {
        return IOUtil.readJsonFile(PATH_PREFIX + fileName);
    }

    /**
     * @return com.alibaba.fastjson.JSONObject
     * Date 2019/4/13 下午6:19
     * Description 读取json文件
     * @author liweizhi
     */
    public static com.alibaba.fastjson.JSONObject readJsonFile(String fileName) {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(fileName)) {
            //Read JSON file
            JSONObject obj = (JSONObject) jsonParser.parse(reader);
            return JSON.parseObject(obj.toJSONString());
        } catch (Exception e) {
            log.error("read json error", e);
            return null;
        }
    }

    public static boolean writeJsonFile(JSONObject jsonObj) {
        //Write JSON file
        try (FileWriter file = new FileWriter("employees.json")) {
            file.write(jsonObj.toJSONString());
            file.flush();
            return true;
        } catch (IOException e) {
            log.error("write json file error", e);
            return false;
        }
    }

    private void writeTest() {
        //First Employee
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("firstName", "Lokesh");
        employeeDetails.put("lastName", "Gupta");
        employeeDetails.put("website", "howtodoinjava.com");

        JSONObject employeeObject = new JSONObject();
        employeeObject.put("employee", employeeDetails);

        //Second Employee
        JSONObject employeeDetails2 = new JSONObject();
        employeeDetails2.put("firstName", "Brian");
        employeeDetails2.put("lastName", "Schultz");
        employeeDetails2.put("website", "example.com");

        JSONObject employeeObject2 = new JSONObject();
        employeeObject2.put("employee", employeeDetails2);

        //Add employees to list
        JSONArray employeeList = new JSONArray();
        employeeList.add(employeeObject);
        employeeList.add(employeeObject2);

        writeJsonFile(employeeDetails);
    }
}
