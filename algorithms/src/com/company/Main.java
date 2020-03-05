package com.company;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        List<String> list=new ArrayList<String>();
        list.add("Hello");
        list.add("World");
        list.add("HAHAHAHA");
        //TODO:
        //ArrayList的遍历
        //1.for-each方式
        for(String str:list){
            System.out.println(str);
        }
        System.out.println("================");
        //2.把链表变为数组相关的内容进行遍历
        String[] strArray=new String[list.size()];//String数组
        list.toArray(strArray);//toArray方法
        for(int i=0;i<strArray.length;i++) //这里也可以改写为  for(String str:strArray) 这种形式
        {
            System.out.println(strArray[i]);
        }
        System.out.println("================");
        //第三种遍历 使用迭代器进行相关遍历
        Iterator<String> ite=list.iterator();
        while(ite.hasNext())//判断下一个元素后有值
        {
            System.out.println(ite.next());
        }
        System.out.println("================");
        //TODO:
        //Map的遍历
        Map<String,String> map=new HashMap<String,String>();
        map.put("1","value1");
        map.put("2","value2");
        map.put("3","value3");
        //第一种：普遍使用，二次取值
        System.out.println("通过Map.keySet遍历key和value：");
        for(String key:map.keySet()){
            System.out.println("Key="+key+" and value="+map.get(key));
        }
        //第二种
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String,String>> it=map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,String> entry=it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        //第三种：推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key和value");
        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第四种
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }
    }
        /* BubbleSort bubbleSort=new BubbleSort();
        //SelectionSort selectionSort=new SelectionSort();
        //InsertSort insertSort=new InsertSort();
        int []arr=new int[]{2,1,4,3,54,32,14};
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        System.out.println("-------------");
        arr=bubbleSort.sort(arr);
        //arr=insertSort.sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }*/


    }
