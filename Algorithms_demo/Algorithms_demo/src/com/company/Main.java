package com.company;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        int sceneWidth=800;
        int sceneHeight=800;

        int N=5;
        Circle[] circles=new Circle[N];
        int R=50;
        for(int i=0;i<N;i++){//随机化这四个参数
            int x=(int)(Math.random()*(sceneWidth-2*R)+R);//随机生成圆心坐标
            //Math.random()生成的是0-1之间的一个随机数
            int y=(int)(Math.random()*(sceneHeight-2*R)+R);
            int vx=(int)(Math.random()*11)-5;//取-5到+5之间
            int vy=(int)(Math.random()*11)-5;
            circles[i]=new Circle(x,y,R,vx,vy);
        }

        EventQueue.invokeLater(()->{
                //AlgoFrame frame=new AlgoFrame("Welcome",1000,800);
                 // AlgoFrame frame=new AlgoFrame("Welcome");
            AlgoFrame frame=new AlgoFrame("Welcome",sceneWidth,sceneHeight);
            //创建一个线程，用这个线程执行任务（java8中的规定）
            new Thread(()->{
                while(true){
                    //绘制数据
                    frame.render(circles);
                    AlgoVisHelper.pause(20);//封装好的带异常捕获的睡眠函数

                    //更新数据
                    for(Circle circle:circles)
                        circle.move(0,0,sceneWidth,sceneHeight,circles);

                }
            }).start();
            //动画的效果，这样会执行不起来，因为事件队列的问题
        /*    while(true){
                //绘制数据
                    frame.render(circles);
                    AlgoVisHelper.pause(20);//封装好的带异常捕获的睡眠函数

                //更新数据
                    for(Circle circle:circles)
                        circle.move();

            }*/

                });
          /*      //将程序块放入了一个lambda表达式里，这样当GUI越来越大，避免线程之间发生的错误
        EventQueue.invokeLater(()->{
            JFrame frame=new JFrame("Welcome");//创建一个JFrame对象frame
            frame.setSize(1000,800);//java没有外部参数名，所以加入了提示width，height，不是程序的一部分
            frame.setResizable(false);//禁止用户设置窗口大小
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口,保证×了程序以后程序正常结束
            frame.setVisible(true);//设为true，显示窗口，Visible：可显示的，可看的到的
        });//官方推荐使用事件队列
*/
	    /*JFrame frame=new JFrame("Welcome");//创建一个JFrame对象frame
        frame.setSize(1000,800);//java没有外部参数名，所以加入了提示width，height，不是程序的一部分
        frame.setResizable(false);//禁止用户设置窗口大小
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口,保证×了程序以后程序正常结束
	    frame.setVisible(true);//设为true，显示窗口，Visible：可显示的，可看的到的*/

    }
}