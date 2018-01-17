package com.zx.annotationdemo.test;

import com.zx.annotationdemo.annotation.Test;

public class Testable {
    public void execute(){
        System.out.println("Execute...");
    }
    @Test
    public void testExecute(){
        execute();
    }
}
