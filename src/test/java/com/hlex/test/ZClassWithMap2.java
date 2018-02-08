package com.hlex.test;

import java.util.HashMap;

public class ZClassWithMap2 {
        private   String name;
        private HashMap<String,String> map=new HashMap<String,String>();

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public HashMap<String, String> getMap() {
            return map;
        }

        public void setMap(HashMap<String, String> map) {
            this.map = map;
        }
    }