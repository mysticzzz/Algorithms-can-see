package com.company;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class AlgoVisHelper {

    private AlgoVisHelper(){}//写成了私有，故不能实例化它

    public static void setStrokeWidth(Graphics2D g2d,int w){//设置画笔样式，
        // 包括粗细，线段端点为圆形，线段拐点为圆形，显得更加平滑一点
        int strokeWidth=w;//笔画宽度是10
        g2d.setStroke(new BasicStroke(strokeWidth,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));//调整笔画粗细
    }

    public static void setColor(Graphics2D g2d,Color color){//设置颜色
        g2d.setColor(color);
    }

    public static void strokeCircle(Graphics2D g2d,int x,int y,int r){//绘制圆形
        Ellipse2D circle=new Ellipse2D.Double(x-r,y-r,2*r,2*r);
        g2d.draw(circle);

    }
    public static void fillCircle(Graphics2D g2d,int x,int y,int r){//绘制实心圆
        Ellipse2D circle=new Ellipse2D.Double(x-r,y-r,2*r,2*r);
        g2d.fill(circle);

    }

    public static void pause(int t){//暂停函数
        try{
            Thread.sleep(t);
        }
        catch (InterruptedException e){
            System.out.println("Error in sleeping.");
        }
    }

}
