package com.spring.java8.permissions;

public class PermissionTest {


    public static void main(String[] args) throws Exception{
        System.setProperty("java.security.policy", "E:/idea-project/j2se/java8/src/main/java/com/spring/java8/permissions/PermissionTest.policy");
        System.setSecurityManager(new SecurityManager());
        WordCheckPermission p = new WordCheckPermission("C+", "insert");
        SecurityManager manager = System.getSecurityManager();
        try{
            if(manager != null){
                manager.checkPermission(p);
                System.out.println("权限通过"+p);
            }
        }catch (SecurityException ex){
            System.out.println("I am sorry, but I cannot do that.");
            ex.printStackTrace();
        }
    }
}

