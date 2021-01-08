package com.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class testGetAPI {

    public static final Logger log =Logger.getLogger(testGetAPI.class);

    public static void main(String[] args){

        TestNG testng = new TestNG();

        List suites = Lists.newArrayList();

        suites.add("src/main/resources/testng.xml");//path to xml..

        testng.setTestSuites(suites);

        testng.run();



    }

}
