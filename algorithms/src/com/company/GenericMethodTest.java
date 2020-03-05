package com.company;
/*
如何使用泛型方法打印不同字符串的元素
*
* */
public class GenericMethodTest {

    // 泛型方法 printArray
    public static <E> void printArray(E[] inputArry){
        //输出数组元素
        for(E element:inputArry){
            System.out.printf( "%s ", element );//%s的意思就是什么dataType都可以接受
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 创建不同类型数组： Integer, Double 和 Character
        Integer []intArray={1,2,3,4,5};
        Double []doubleArrya={ 1.1, 2.2, 3.3, 4.4 };
        Character []charArray = { 'H', 'E', 'L', 'L', 'O' };
        System.out.println( "元素为:" );
        printArray(intArray);
        printArray(doubleArrya);
        printArray(charArray);
    }
}
