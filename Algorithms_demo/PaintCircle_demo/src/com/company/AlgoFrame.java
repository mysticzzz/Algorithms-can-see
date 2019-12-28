package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
//渲染类，也就是绘制代码
public class AlgoFrame extends JFrame {
    private int canvasWidth;
    private int canvasHeight;
    public AlgoFrame(String title,int canvasWidth,int canvasHeight){//构造函数

        super(title);//调用父类来写

        this.canvasWidth=canvasWidth;//使类里的canvaWidth等于传进来的canvasWidth
        this.canvasHeight=canvasHeight;

        AlgoCanvas canvas=new AlgoCanvas();//构建一个画布
        //设置画布大小，注释掉下一句
        // canvas.setPreferredSize(new Dimension(canvasWidth,canvasHeight));//Dimension就是将长和宽放在一起的一个类
        this.setContentPane(canvas);//利用类的方法setContentPane将内部类创建好的canvas作为内容面板
        pack();//根据加载进画板的这些内容进行一次布局整理，自动调整AlgoFrame窗口的大小

        //this.setSize(canvasWidth,canvasHeight);//this可以省略，以下都省略掉
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }
    public AlgoFrame(String title){//构造函数，使主函数初始化时候不需要传入高度宽度
        this(title,1000,800);
    }

    public int getCanvasWidth() {return canvasWidth; }//构造函数，使外部类可以访问到私有的canvasWidth，高度同理
    public int getCanvasHeight(){ return canvasHeight; }
    //TODO:设置自己的数据
    private Object data;
    public void render(Object data){
        this.data=data;
        repaint();//repaint会调用画布，也就是AlgoCanvas中的paintComponent方法，根据传进来的代码来修改绘制代码就可以了
    }
    private Circle[] circles;//创建数据对象
    public void render(Circle[] circles){//告诉AlgoFrame要绘制什么
        this.circles=circles;//把数据对象传进来
        this.repaint();//将JFrame中的控件重新刷新一遍

    }
    //写一个内部类,作为算法的画板，只供AlgoFrame使用
    private class AlgoCanvas extends JPanel{

        public AlgoCanvas(){
            super(true);//是否支持双缓存，设置true就是打开双缓存
        }
        //具体的绘制代码
        @Override
        //JPanel本身就有paintComponent()函数，此处是覆盖，故写上override，
        // 可以自动检查是否覆盖父类的函数，使不会记错函数签名
        public  void paintComponent(Graphics g) {//绘制组件
        //g是绘制的上下文环境，绘制函数都定义在g上
                super.paintComponent(g);//调用父类相应的 super.paintComponent()将g传入

                Graphics2D g2d=(Graphics2D)g;//强制转换，将它转为g2d，获得图形上下文环境
                //抗锯齿
                RenderingHints hints=new RenderingHints(
                                        RenderingHints.KEY_ANTIALIASING,
                                        RenderingHints.VALUE_ANTIALIAS_ON);//打开抗锯齿
                g2d.addRenderingHints(hints);//添加抗锯齿，使渲染更加平滑

                //具体绘制
                //TODO：绘制自己的数据data
                AlgoVisHelper.setStrokeWidth(g2d,1);
                AlgoVisHelper.setColor(g2d,Color.RED);
                for(Circle circle:circles){//遍历circles数组
                    if(!circle.isFilled)//如果isFilled是false，则绘制空心圆，否则绘制实心圆
                        AlgoVisHelper.strokeCircle(g2d,circle.x,circle.y,circle.getR());//绘制空心圆
                    else
                        AlgoVisHelper.fillCircle(g2d,circle.x,circle.y,circle.getR());//绘制实心圆

                }
                /*AlgoVisHelper.setStrokeWidth(g2d,5);//设置线条宽度
                AlgoVisHelper.setColor(g2d,Color.CYAN);//设置颜色
                AlgoVisHelper.fillCircle(g2d,canvasWidth/2,canvasHeight/2,200);//绘制实心圆
                AlgoVisHelper.setColor(g2d,Color.RED);
                AlgoVisHelper.strokeCircle(g2d,canvasWidth/2,canvasHeight/2,200);//绘制空心圆*/

               /* Ellipse2D circle=new Ellipse2D.Float(50,50,300,300);//需要选择float和double
                //g.drawOval(50,50,300,300);//四个,前两个是坐标（包围和）
                g2d.setColor(Color.RED);//利用setcolor来更换颜色
                g2d.draw(circle);//将circle作为参数传进来就可以了
                Ellipse2D circle2=new Ellipse2D.Double(50,50,300,300);
                g2d.setColor(Color.blue);
                g2d.fill(circle2);//绘制实心的圆型*/
        }
        @Override
        public Dimension getPreferredSize(){//返回画布的大小
            //覆盖了这个方法后，系统创建algocanvas时就会自动调用这个方法来决定画布的大小，
            // 就可以注释掉设置画布大小那一句,因为画布的大小在画的时候决定，而不在创建窗口的时候决定，这样创建窗口的时候就不用管理窗口大小了

            return new Dimension(canvasWidth,canvasHeight);

        }
    }
}
