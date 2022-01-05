package com.ssq.demo.jdkdemo;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * JDK1.8 -- Stream流应用
 */
public class Jdk8Stream {
    /**
     * 创建实体数据
     * @return
     */
    private List<TestStreamModel> getList(){
        // 创建集合
        List<TestStreamModel> modelList = new ArrayList();

        // 写入数据
        TestStreamModel testStreamModel = new TestStreamModel();
        testStreamModel.setId(2);
        testStreamModel.setName("张三");
        testStreamModel.setClasses(1);
        testStreamModel.setGrade(1);
        testStreamModel.setScore(80);
        testStreamModel.setNum(Lists.newArrayList(1,2,3,5,7));
        modelList.add(testStreamModel);

        TestStreamModel testStreamModel1 = new TestStreamModel();
        testStreamModel1.setId(1);
        testStreamModel1.setName("李四");
        testStreamModel1.setClasses(1);
        testStreamModel1.setGrade(1);
        testStreamModel1.setScore(60);
        testStreamModel1.setNum(Lists.newArrayList(4,5,6,1));
        modelList.add(testStreamModel1);

        TestStreamModel testStreamModel2 = new TestStreamModel();
        testStreamModel2.setId(3);
        testStreamModel2.setName("王二麻子");
        testStreamModel2.setClasses(2);
        testStreamModel2.setGrade(1);
        testStreamModel2.setScore(90);
        modelList.add(testStreamModel2);

        TestStreamModel testStreamModel3 = new TestStreamModel();
        testStreamModel3.setId(4);
        testStreamModel3.setName("王五");
        testStreamModel3.setClasses(2);
        testStreamModel3.setGrade(1);
        testStreamModel3.setScore(59.5);
        modelList.add(testStreamModel3);

        TestStreamModel testStreamModel4 = new TestStreamModel();
        testStreamModel4.setId(8);
        testStreamModel4.setName("小明");
        testStreamModel4.setClasses(1);
        testStreamModel4.setGrade(2);
        testStreamModel4.setScore(79.5);
        modelList.add(testStreamModel4);

        TestStreamModel testStreamModel5 = new TestStreamModel();
        testStreamModel5.setId(5);
        testStreamModel5.setName("小红");
        testStreamModel5.setClasses(2);
        testStreamModel5.setGrade(2);
        testStreamModel5.setScore(99);
        modelList.add(testStreamModel5);

        TestStreamModel testStreamModel6 = new TestStreamModel();
        testStreamModel6.setId(7);
        testStreamModel6.setName("小黑");
        testStreamModel6.setClasses(2);
        testStreamModel6.setGrade(2);
        testStreamModel6.setScore(45);
        modelList.add(testStreamModel6);

        TestStreamModel testStreamModel7 = new TestStreamModel();
        testStreamModel7.setId(6);
        testStreamModel7.setName("小白");
        testStreamModel7.setClasses(1);
        testStreamModel7.setGrade(2);
        testStreamModel7.setScore(88.8);
        modelList.add(testStreamModel7);

        TestStreamModel testStreamModel8 = new TestStreamModel();
        testStreamModel8.setId(6);
        testStreamModel8.setName("小白");
        testStreamModel8.setClasses(1);
        testStreamModel8.setGrade(2);
        testStreamModel8.setScore(88.8);
        modelList.add(testStreamModel8);

        return modelList;
    }

    /**
     * Demo
     * @param args
     */
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Jdk8Stream stream = new Jdk8Stream();
        /**
         * 1. stream
         */
        List<TestStreamModel> modelList = stream.getList();
        // 去重
        System.out.println("去重前: " + modelList);
        List<TestStreamModel> distinctList = modelList.stream().distinct().collect(Collectors.toList());
        System.out.println("去重后: " +distinctList);

        // 排序 按id升序排列
        System.out.println("排序前: " + modelList);
        List<TestStreamModel> sortedList = modelList.stream().sorted((a, b) -> a.getId() - b.getId()).collect(Collectors.toList());
        System.out.println("排序后:" + sortedList);

        // 过滤 按照自己的需求来筛选list数据
        System.out.println("过滤前: " + modelList);
        List<TestStreamModel> filterList = modelList.stream().filter(t -> t.getScore() < 60).collect(Collectors.toList());
        System.out.println("过滤后: " + filterList);

        // MAP 提取对象中的某一元素
        System.out.println("提取前: " + modelList);
        List<String> mapList = modelList.stream().map(m -> m.getName()).collect(Collectors.toList());
        System.out.println("提取后: " + mapList);

        // 统计 所有人分数总和
        double sum = modelList.stream().mapToDouble(t -> t.getScore()).sum();
        int count = modelList.stream().mapToInt(t -> t.getId()).sum();
        System.out.println(count + "-----" + sum);

        // 分组 按字段中某属性将list分组
        Map<Integer, List<TestStreamModel>> groupByList = modelList.stream().collect(Collectors.groupingBy(t -> t.getGrade()));
        System.out.println("按年级分组; " + groupByList);
        System.out.println("取Map内所有Key: " + groupByList.keySet());
        // 对map进行处理,方便取出数据
        for (Map.Entry<Integer, List<TestStreamModel>> entry : groupByList.entrySet()){
            System.out.println("Key: " + entry.getKey());
            System.out.println("Value: " + entry.getValue());
        }

        // 多重分组
        Map<Integer, Map<Integer, Double>> groupsList =
                modelList.stream().collect(Collectors.groupingBy(t -> t.getGrade(), Collectors.groupingBy(m -> m.getClasses(), Collectors.summingDouble(n -> n.getScore()))));
        System.out.println(groupsList);
        System.out.println("取出一年级一班的总分: " + groupsList.get(1).get(1));

        // stream是链式的,所有功能可以一起使用 --> 如计算每个年级每个班级的及格人数
        Map<Integer, Map<Integer, Long>> collect =
                modelList.stream().filter(t -> t.getScore() >= 60).collect(Collectors.groupingBy(t -> t.getGrade(), Collectors.groupingBy(t -> t.getClasses(), Collectors.counting())));
        System.out.println("二班级一班的及格人数为: " + collect.get(2).get(1));

        // 输出数据且去重
        List<String> distinct = modelList.stream().map(m -> m.getName()).distinct().collect(Collectors.toList());
        System.out.println(distinct);

        // 升序排序, 只取第一条
        modelList.stream().map(x -> x.getScore()).sorted(Comparator.comparing(Double::doubleValue)).findFirst().orElse(null);
        // 降序排序
        modelList.stream().map(x -> x.getScore()).sorted(Comparator.reverseOrder()).findFirst().orElse(null);
        // 降序写法二
        modelList.stream().map(x -> x.getScore()).sorted(Comparator.comparing(Double::doubleValue).reversed()).collect(Collectors.toList());

        // 统计List中嵌套List元素的总数
        int insideListSize = modelList.stream().filter(x -> !CollectionUtils.isEmpty(x.getNum())).mapToInt(x -> x.getNum().size()).sum();
        System.out.println("统计该stream中List元素的总数: " + insideListSize);
        /**
         * 2. 反射
         */
//        reflex(modelList);
    }

    public static void reflex(List<TestStreamModel> modelList) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<TestStreamModel> test = new ArrayList<>();
        for(TestStreamModel s : modelList) {
            Class clazz = s.getClass();
            System.out.println("反射信息为: " + clazz + " --- 类名: " + clazz.getName());
            Method getName = clazz.getDeclaredMethod("getName");
            Method getScore = clazz.getDeclaredMethod("getScore");
            getName.setAccessible(true);
            Object obj = getName.invoke(s);
            String s1 = (String) obj;
            System.out.println(s1);
            TestStreamModel build = TestStreamModel.builder()
                    .name(s1)
                    .build();
            System.out.println(build);
            test.add(build);
        }
    }
}
