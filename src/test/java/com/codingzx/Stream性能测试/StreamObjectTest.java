//package com.codingzx.Stream性能测试;
//
///**
// * @author created by zhangxin27695
// * @Classname StreamObjectTest
// * @Description
// * 测试用例：10个用户，每人200个订单。按用户统计订单的总价。
// * 测试结论（测试代码见后文）：
// *
// * Stream并行流的执行效率远高于普通for循环
// * Stream串行流的执行效率大于等于普通for循环
// * Stream并行流计算 > Stream串行流计算 >= 普通for循环
// * @Date 2020-04-08 9:29
// */
//import com.github.houbb.junitperf.core.annotation.JunitPerfConfig;
//import com.github.houbb.junitperf.core.report.impl.HtmlReporter;
//import org.junit.jupiter.api.BeforeAll;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class StreamObjectTest {
//
//    public static List<com.codingzx.JAVA8高级语法.Stream性能测试.Order> orders;
//
//    @BeforeAll
//    public static void init() {
//        orders = com.codingzx.JAVA8高级语法.Stream性能测试.Order.genOrders(10);
//    }
//
//    @JunitPerfConfig(duration = 10000, warmUp = 1000, reporter = {HtmlReporter.class})
//    public void testSumOrderForLoop(){
//        Map<String, Double> map = new HashMap<>();
//        for(com.codingzx.JAVA8高级语法.Stream性能测试.Order od : orders){
//            String userName = od.getUserName();
//            Double v;
//            if((v=map.get(userName)) != null){
//                map.put(userName, v+od.getPrice());
//            }else{
//                map.put(userName, od.getPrice());
//            }
//        }
//
//    }
//
//    @JunitPerfConfig(duration = 10000, warmUp = 1000, reporter = {HtmlReporter.class})
//    public void testSumOrderStream(){
//        orders.stream().collect(
//                Collectors.groupingBy(com.codingzx.JAVA8高级语法.Stream性能测试.Order::getUserName,
//                        Collectors.summingDouble(com.codingzx.JAVA8高级语法.Stream性能测试.Order::getPrice)));
//    }
//
//    @JunitPerfConfig(duration = 10000, warmUp = 1000, reporter = {HtmlReporter.class})
//    public void testSumOrderParallelStream(){
//        orders.parallelStream().collect(
//                Collectors.groupingBy(com.codingzx.JAVA8高级语法.Stream性能测试.Order::getUserName,
//                        Collectors.summingDouble(com.codingzx.JAVA8高级语法.Stream性能测试.Order::getPrice)));
//    }
//}
//
//
//class Order{
//    private String userName;
//    private double price;
//    private long timestamp;
//    public Order(String userName, double price, long timestamp) {
//        this.userName = userName;
//        this.price = price;
//        this.timestamp = timestamp;
//    }
//    public String getUserName() {
//        return userName;
//    }
//    public double getPrice() {
//        return price;
//    }
//    public long getTimestamp() {
//        return timestamp;
//    }
//
//    public static List<com.codingzx.JAVA8高级语法.Stream性能测试.Order> genOrders(int listLength){
//        ArrayList<com.codingzx.JAVA8高级语法.Stream性能测试.Order> list = new ArrayList<>(listLength);
//        Random rand = new Random();
//        int users = listLength/200;// 200 orders per user
//        users = users==0 ? listLength : users;
//        ArrayList<String> userNames = new ArrayList<>(users);
//        for(int i=0; i<users; i++){
//            userNames.add(UUID.randomUUID().toString());
//        }
//        for(int i=0; i<listLength; i++){
//            double price = rand.nextInt(1000);
//            String userName = userNames.get(rand.nextInt(users));
//            list.add(new com.codingzx.JAVA8高级语法.Stream性能测试.Order(userName, price, System.nanoTime()));
//        }
//        return list;
//    }
//    @Override
//    public String toString(){
//        return userName + "::" + price;
//    }
//}
