package com.dastancompany.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProviderDemo {

    @Test(dataProvider = "getData")
    public void dataProviderTest(Map<String,String>map){
        System.out.println(map.get("username")+" : "+map.get("password")+" : "+map.get("address"));
    }

    @DataProvider
    public Object[] getData(){

        Map<String,String> map = new HashMap<>();
        map.put("username","Das");
        map.put("password","123");
        map.put("address","bishkek");

        Map<String,String> map2 = new HashMap<>();
        map2.put("username","Ayg");
        map2.put("password","456");
        map2.put("address","tokmok");

        List<Map<String,String>> list = new ArrayList<>();
        list.add(map);
        list.add(map2);

        return  list.toArray();
    }
    @DataProvider
    public Object[][] getData1(){
       return new Object[][] {
               {"Das","123"},
               {"Ayg","456"},
               {"rgy","789"}
        };
    }
}
