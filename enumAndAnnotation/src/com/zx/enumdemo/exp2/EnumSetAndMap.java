package com.zx.enumdemo.exp2;

import com.zx.enumdemo.exp.Buttiro;
import com.zx.enumdemo.exp.OzWitch;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.function.Consumer;

public class EnumSetAndMap {
    public static void main(String[] args) {
        EnumSet<OzWitch> enumSet = EnumSet.noneOf(OzWitch.class);
        EnumMap<OzWitch,Consumer<String>> enumMap = new EnumMap(OzWitch.class);
        enumMap.put(OzWitch.EAST,(e)-> System.out.println(e));
        enumMap.put(OzWitch.WEST,(e)-> System.out.println(e));
        for (Map.Entry<OzWitch,Consumer<String>> e:
                enumMap.entrySet()) {
            System.out.println(e.getKey());
            e.getValue().accept("aa");
        }
    }



}
