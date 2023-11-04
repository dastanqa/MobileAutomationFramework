package com.dastancompany.testcases;

import com.aventstack.extentreports.ExtentTest;
import com.dastancompany.driver.Driver;
import com.dastancompany.facade.DragDropFacade;
import com.dastancompany.facade.FakerFacade;
import com.dastancompany.reports.ExtentReport;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.MAP;

public class TapTests extends BaseTest {


    @Test(dataProvider = "getData")
    public void tapTests(Map<String,Object>map) throws MalformedURLException {



        String actualResult = new DragDropFacade()
                .navigateToDragAndDropPage()
                .getDragAndDropPage()
                .perforDragDrop()
                .getSuccessMessage();

        FakerFacade.getBuildingNumber();
        assertThat(actualResult)
                .isEqualTo("Dropped!");
    }

    @DataProvider(parallel = true)
    public Object[]getData() throws IOException {
        Map<String,Object>map=new HashMap<>();
        map.put("systemPort",8200);
        map.put("udid","U2JUT21728005376");

        Map<String,Object>map2=new HashMap<>();
        map2.put("systemPort",8201);
        map2.put("udid","emulator-5554");

        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map);
        list.add(map2);

        HashMap<String,Object> hashMap = new ObjectMapper().readValue(new File(System.getProperty("user.dir") +
                "/src/test/resources/jsontestdata/iteration1.json"), HashMap.class);

        HashMap<String,Object> hashMap2 = new ObjectMapper().readValue(new File(System.getProperty("user.dir") +
                "/src/test/resources/jsontestdata/iteration2.json"), HashMap.class);
        //return list.toArray();
        return new Object[]{hashMap,hashMap2};


    }
    //@Test

}
