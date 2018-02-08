package com.hlex.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsoniter.output.JsonStream;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class JsoniterSpeedTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    enum Using{JACKSON,JSONITER};
    Using mode=Using.JSONITER;

    @Test
    public void testSpeed(){

        ZClassWithMap2 generate = generate();
        for (int i = 0; i < 10000; i++) {
            test(generate).length();
            test(new int[]{1,2,3}).length();
            test(new HashMap<String,String>()).length();
        }

    }



    String test(Object o){
        switch (mode){
            case JACKSON: return viaJackSon(o);
            case JSONITER: return viaJsoniter(o);

        }
        return null;
    }

    String viaJsoniter(Object o){
        return JsonStream.serialize(o);

    }
    String viaJackSon(Object o){
        try {
            return new ObjectMapper().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }



    private ZClassWithMap2 generate() {
        ZClassWithMap2 ret=new ZClassWithMap2();
        ret.setName("h");
        for (int i = 0; i < 100; i++) {
            ret.getMap().put("i"+i,i+"");
        }
        return ret;
    }

//    public class ClassWithMap{
//        private   String name;
//        private HashMap<String,String> map=new HashMap<String,String>();
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public HashMap<String, String> getMap() {
//            return map;
//        }
//
//        public void setMap(HashMap<String, String> map) {
//            this.map = map;
//        }
//    }
}
