package com.spring.java8;

import com.spring.java8.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LambdaTest {

    private  static final Logger logger = LoggerFactory.getLogger(LambdaTest.class);

    static interface MyPredicate<T>{
        public boolean test(T t);
    }

    public List<User> filterUser(List<User> users,MyPredicate<User> myPredicate) {
        List<User> userList = new ArrayList<>();
        for (User user :
                users) {
            if (myPredicate.test(user)) {
                userList.add(user);
            }

        }
        return userList;
    }
    private final static List<User> users = Arrays.asList(
            new User("1","zx1",18),
            new User("2","zx2",19),
            new User("3","zx3",17),
            new User("4","zx4",15),
            new User("5","zx5",14),
            new User("6","zx6",12));
    @Test
    public void contextLoads() {
        List<User> userList = filterUser(users, (e) -> e.getAge() <= 16);
        userList.forEach(System.out::println);

    }

    @Test
    public void test1(){
        users.stream()
                .filter((q) -> q.getAge() >= 16)
                .limit(2)
                .forEach(System.out::println);

        users.stream().filter((e) -> e.getAge() < 16)
                .map(User::getUsername)
                .forEach(logger::info);
    }

    /**
     * Consumer<T>:消费型接口
     * void accept(T t);
     *
     * Supplier<T>:供给型接口
     * T get();
     *
     * Function<T,R>:函数型接口
     * R apply(T t);
     *
     * Predicate<T>:断言型接口
     * boolean test(T t);
     */
    @Test
    public void test2(){
    }
}
