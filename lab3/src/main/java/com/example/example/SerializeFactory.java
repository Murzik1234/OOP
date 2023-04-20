package com.example.example;

import com.example.example.factories.MilkProductFactory;
import com.example.example.utils.ProductInterface;

import java.util.HashMap;
import java.util.Map;

public class SerializeFactory {
    private static Map<String, MySerializer> map = new HashMap<String, MySerializer>();

    public static void initSerializer(){
        map.put("bin", new MyBinarySerialize());
        map.put("json", new MyJsonSerialize());
        map.put("txt", new MyTxtSerialize());
    }

    public static  MySerializer getSerializer(String serType){
        return  map.get(serType);
    }
}
