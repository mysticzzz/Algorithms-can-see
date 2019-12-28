package com.company;

import java.awt.*;

import static java.lang.System.out;

public class Circle {

    public int x,y;//这样外部不仅可以读取到圆圈的位置，在移动的过程中还能改变圆圈的位置
    private int r;//指定圆圈的半径大小，用的私有，指定好以后就不改变了
    public int vx,vy;//圆圈的速度
    public boolean isFilled=false;//判断绘制的圆是否是一个实心的圆

    public Circle(int x, int y, int r, int vx, int vy) {//构造函数
        this.x = x;
        this.y = y;
        this.r = r;
        this.vx = vx;
        this.vy = vy;
    }
    public int getR(){return r;}//获取私有变量r的函数
    public void move(int minx, int miny, int maxx, int maxy,Circle[] circles){
        x+=vx;
        y+=vy;
        checkCollision(minx,miny,maxx,maxy);//由于碰撞检测需要传入参数，所以相应的move函数添加参数
        circleAndCircleCollision(circles);
    }

    private void checkCollision(int minx, int miny, int maxx, int maxy) {//碰撞检测函数
        if (x - r < minx) {
            x = r;
            vx = -vx;
        }
        if (x + r >= maxx) {
            x = maxx - r;
            vx = -vx;
        }
        if (y - r < miny) {
            y = r;
            vy = -vy;
        }
        if (y + r >= maxy) {
            y = maxy - r;
            vy = -vy;
        }
    }
    /*public static double distance(Circle[] circles){
        for(int i=0;i<circles.length;i++) {
            for(int j=0;j<circles.length&&j!=i;j++)
            {
                return Math.sqrt(Math.pow(circles[i].x - circles[j].x, 2)
                        + Math.pow(circles[i].y - circles[j].y, 2));
            }
        }
        return 0;
    }*/
    //碰撞检测函数（有点丑陋）
    //当两个圆半径之和*r1+r2小于两个圆的圆心距c时，即发生碰撞
    public static void circleAndCircleCollision(Circle[] circles){
        for(int i=0;i<circles.length;i++) {
            for (int j = 0; j < circles.length && j != i; j++) {
               if( Math.sqrt(Math.pow(circles[i].x - circles[j].x, 2)
                       + Math.pow(circles[i].y - circles[j].y, 2))
                       <circles[i].getR()+circles[j].getR()){
                   //System.out.println("发生碰撞");
                   circles[i].vx=-circles[i].vx;
                   circles[i].vy=-circles[i].vy;
                   circles[j].vx=-circles[j].vx;
                   circles[j].vy=-circles[j].vy;

               }
            }
        }

        /*
        if(distance(circles) < circles[0].getR()+circles[1].getR()){
            System.out.println("发生碰撞");
            circles[0].vx=-circles[0].vx;
            circles[0].vy=-circles[0].vy;

        }
        else {

        }*/
    }

    public boolean contain(Point p){//判断点在不在圆内
        return (x-p.x)*(x-p.x)+(y-p.y)*(y-p.y)<=r*r;
    }
}
