import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AlgoVisualizer {

    private static int DELAY = 5;
    private static int blockSide = 32;

    private MineSweeperData data;
    private AlgoFrame frame;

    public AlgoVisualizer(int N, int M, int mineNumber){

        data = new MineSweeperData(N, M, mineNumber);
        int sceneWidth = M * blockSide;
        int sceneHeight = N * blockSide;

        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Mine Sweeper", sceneWidth,sceneHeight);
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                run();
            }).start();
        });
    }

    private void run(){

        setData(false,-1,-1);
    }

    private void setData(boolean isLeftCliked,int x,int y){
        if(data.inArea(x,y)){
            if(isLeftCliked) {
                if(data.isMine(x,y)) {//点击到了雷
                   // TODO: Game Over
                    data.open[x][y]=true;
                }
                else
                    data.open(x,y);
            }

            else
                data.flags[x][y]=!data.flags[x][y];//如果有旗子就取消，没有的话就标记上旗子
        }

        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    private class AlgoMouseListener extends MouseAdapter{

        @Override
        public void mouseReleased(MouseEvent event){//覆盖方法，指鼠标点击后再响应这个事件
                //将鼠标点击的位置进行平移
            event.translatePoint(
                    -(int)(frame.getBounds().width-frame.getCanvasWidth()),
                    -(int)(frame.getBounds().height-frame.getCanvasHeight())
            );
            Point pos=event.getPoint();//拿到鼠标点击的坐标

            //通过这个坐标来判断当前点击的是第几行第几列
            int w=frame.getCanvasWidth()/data.M();
            int h=frame.getCanvasHeight()/data.N();

            int x=pos.y/h;//得到的是行数
            int y=pos.x/w;//得到的是列数

            if(SwingUtilities.isLeftMouseButton(event))
                setData(true,x,y);
            else
                setData(false,x,y);
        }
    }

    public static void main(String[] args) {

        int N = 20;
        int M = 20;
        int mineNumber = 50;

        AlgoVisualizer vis = new AlgoVisualizer(N, M, mineNumber);

    }
}
