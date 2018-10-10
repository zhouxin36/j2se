package com.spring.java8.classLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ClassLoaderTest {

    public static void main(String[] args) {
    }
}



class CryptoClassLoader extends ClassLoader{
    private int key;

    public CryptoClassLoader(int k){
        this.key = k;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException{
        try {
            byte[] classBytes = null;
            classBytes = loadClassBytes(name);
            Class<?> cl = defineClass(name, classBytes, 0, classBytes.length);
            if (cl == null) {
                throw new ClassNotFoundException(name);
            }
            return cl;
        }catch (Exception e) {
            throw new ClassNotFoundException(name);
        }
    }

    private byte[] loadClassBytes(String name) throws IOException{
        String cname = name.replace('.', '/') + ".caesar";
        byte[] bytes = Files.readAllBytes(Paths.get(cname));
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] - key);
        }
        return bytes;
    }
}