package com.spring.java8.inAndOut;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.CRC32;

public class MemoryMapTest {
    private static long checksumInputStream(Path fileName) throws IOException {
        try (InputStream in = Files.newInputStream(fileName)) {
            CRC32 crc32 = new CRC32();

            int c;
            while ((c = in.read()) != -1) {
                crc32.update(c);
            }
            return crc32.getValue();
        }
    }

    private static long checksumBufferedInpuStream(Path fileName) throws IOException {
        try (InputStream in = new BufferedInputStream(Files.newInputStream(fileName))) {
            CRC32 crc32 = new CRC32();

            int c;
            while ((c = in.read()) != -1) {
                crc32.update(c);
            }
            return crc32.getValue();
        }
    }

    private static long checksumRandomAccessFile(Path fileName) throws IOException {
        try (RandomAccessFile file = new RandomAccessFile(fileName.toFile(), "r")) {
            long length = file.length();
            CRC32 crc32 = new CRC32();

            for (long p = 0; p < length; p++) {
                file.seek(p);
                int c = file.readByte();
                crc32.update(c);
            }
            return crc32.getValue();
        }
    }

    private static long checksumMappedFile(Path fileName) throws IOException {
        try (FileChannel channel = FileChannel.open(fileName)) {
            CRC32 crc32 = new CRC32();
            int length = (int) channel.size();
            MappedByteBuffer byteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, length);
            for (int p = 0; p < length; p++) {
                int c = byteBuffer.get(p);
                crc32.update(c);
            }
            return crc32.getValue();
        }
    }

    public static void main(String[] args) throws IOException {
        String path = "E:/idea-project/j2se/java8/src/main/java/com/spring/java8/inAndOut/employee.dat";

        System.out.println("Input Stream:");
        long start = System.nanoTime();
        Path fileName = Paths.get(path);
        long crcValue = checksumInputStream(fileName);
        long end = System.nanoTime();
        System.out.println(Long.toHexString(crcValue));
        System.out.println((end - start) + " milliseconds");
        System.out.println();

        System.out.println("Buffered Input Stream:");
        start = System.nanoTime();
        crcValue = checksumBufferedInpuStream(fileName);
        end = System.nanoTime();
        System.out.println(Long.toHexString(crcValue));
        System.out.println((end - start) + " milliseconds");
        System.out.println();

        System.out.println("Random Access File:");
        start = System.nanoTime();
        crcValue = checksumRandomAccessFile(fileName);
        end = System.nanoTime();
        System.out.println(Long.toHexString(crcValue));
        System.out.println((end - start) + " milliseconds");
        System.out.println();

        System.out.println("Mapped File:");
        start = System.nanoTime();
        crcValue = checksumMappedFile(fileName);
        end = System.nanoTime();
        System.out.println(Long.toHexString(crcValue));
        System.out.println((end - start) + " milliseconds");
        System.out.println();
    }
}
