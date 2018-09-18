package com.spring.java8.steam;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class OptionalTest {
    public static Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    public static Optional<Double> squareRoot(Double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("E:/idea-project/j2se/java8/src/main/resources/application.yml");
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));

        Optional<String> optionalValue = wordList.stream().filter(s -> s.contains("fred")).findFirst();
        System.out.println(optionalValue.orElse("No word")+ " contains fred");

        Optional<String> optionalString = Optional.empty();
        String result = optionalString.orElse("N/A");
        System.out.println("result: "+result);
        result = optionalString.orElseGet(()-> Locale.getDefault().getDisplayName());
        System.out.println("result: "+result);

        try {
            result = optionalString.orElseThrow(IllegalAccessError::new);
        }catch (Throwable e){
            System.out.println(e.getLocalizedMessage());
        }

        optionalValue = wordList.stream().filter(s->s.contains("server")).findFirst();
        optionalValue.ifPresent(s-> System.out.println(s + " contains server"));

        Set<String> results = new HashSet<>();
        optionalValue.ifPresent(results::add);
        //添加失败，因为上面已经添加，set不能重复
        Optional<Boolean> added = optionalValue.map(results::add);
        System.out.println(added);

        System.out.println(inverse(4.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(-1.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(0.0).flatMap(OptionalTest::squareRoot));
        Optional<Double> result2 = Optional.of(-4.0).flatMap(OptionalTest::inverse).flatMap(OptionalTest::squareRoot);
        System.out.println(result2);
    }
}
