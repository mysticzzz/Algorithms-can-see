package com.company;

import java.awt.*;
import java.awt.event.*;

public class AlgoVisualizer {//作为MVC层的控制器层

    private Circle[] circles;
    private AlgoFrame frame;
    private boolean isAnimated = true;//判断当前动画是否在执行，初始值设为true


    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N) {


        //初始化cricle
        circles = new Circle[N];//创建一个圆数组
        int R = 50;
        for (int i = 0; i < N; i++) {//随机化这四个参数
            int x = (int) (Math.random() * (sceneWidth - 2 * R) + R);//随机生成圆心坐标
            //Math.random()生成的是0-1之间的一个随机数
            int y = (int) (Math.random() * (sceneHeight - 2 * R) + R);
            int vx = (int) (Math.random() * 11) - 5;//取-5到+5之间
            int vy = (int) (Math.random() * 11) - 5;
            circles[i] = new Circle(x, y, R, vx, vy);
        }
        //初始化frame
        EventQueue.invokeLater(() -> {
            //AlgoFrame frame=new AlgoFrame("Welcome",1000,800);
            // AlgoFrame frame=new AlgoFrame("Welcome");
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            frame.addKeyListener(new AlgoKeyListener());//监听键盘事件
            frame.addMouseListener(new AlgoMouseListener());//监听鼠标事件
            //创建一个线程，用这个线程执行任务（java8中的规定）
            new Thread(() -> {
                run();
            }).start();
        });
    }

    //动画逻辑
    private void run() {
        while (true) {
            //绘制数据
            frame.render(circles);
            AlgoVisHelper.pause(20);//封装好的带异常捕获的睡眠函数

            //更新数据
            if (isAnimated)
                for (Circle circle : circles)
                    circle.move(0, 0, frame.getCanvasWidth(), frame.getCanvasHeight(), circles);

        }
    }

    private class AlgoKeyListener extends KeyAdapter {//KeyAdapter实现了KeyListener接口的空实现

        @Override
        public void keyReleased(KeyEvent event) {

            if (event.getKeyChar() == ' ') {//
                isAnimated = !isAnimated;
            }

        }

    }
    private class AlgoMouseListener extends MouseAdapter{

        @Override
        public void mousePressed(MouseEvent event) {
            //进行鼠标的坐标转换
            event.translatePoint(0,
                    -(frame.getBounds().height - frame.getCanvasHeight()));//对鼠标传入的点，进行位移(x,y),在这里将frame上边框的坐标影响去除
            //System.out.println(event.getPoint());
            for(Circle circle:circles){
                //判断鼠标点击的位置是否在circle中
                if(circle.contain(event.getPoint())){
                    circle.isFilled=!circle.isFilled;
                }
            }
        }

    }

    public static void main(String[] args) {
        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 5;

        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N);

    }
}
