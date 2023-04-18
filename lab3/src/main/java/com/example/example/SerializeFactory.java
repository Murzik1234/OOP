package com.example.example;

import com.example.example.factories.MilkProductFactory;
import com.example.example.utils.ProductInterface;

public class SerializeFactory {
    public static MySerializer getSerializer(String serType){
        MySerializer mySerializer = null;
        switch (serType){
            case "json" : return mySerializer = new MyJsonSerialize();
            case "txt"  : return mySerializer = new MyTxtSerialize();
            case "bin" : return mySerializer = new MyBinarySerialize();
        }
        return  mySerializer;
    }
}
