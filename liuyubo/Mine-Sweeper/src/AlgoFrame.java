import java.awt.*;
import javax.swing.*;

public class AlgoFrame extends JFrame {

    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight) {

        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setVisible(true);
    }

    public AlgoFrame(String title) {

        this(title, 1024, 768);
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    // data
    private MineSweeperData data;

    public void render(MineSweeperData data) {
        this.data = data;
        repaint();//repaint会调用paintComponent()函数进行具体的绘制
    }

    private class AlgoCanvas extends JPanel {

        public AlgoCanvas() {
            // 双缓存
            super(true);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;

            // 抗锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);

            // 具体绘制
            int w = canvasWidth / data.M();
            int h = canvasHeight / data.N();
            //显示逻辑
            for (int i = 0; i < data.N(); i++)
                for (int j = 0; j < data.M(); j++) {

                    if (data.open[i][j]) {//如果点击打开了
                        if (data.isMine(i, j))//是雷显示雷
                            AlgoVisHelper.putImage(g2d, j * w, i * h, MineSweeperData.mineImageURL);
                        else//是数字显示数字
                            AlgoVisHelper.putImage(g2d, j * w, i * h, MineSweeperData.numberImageURL(data.getNumbers(i, j)));
                    } else {//没打开的情况
                        if (data.flags[i][j])//是旗子显示旗子
                            AlgoVisHelper.putImage(g2d, j * w, i * h, MineSweeperData.flagImageURL);
                        else//是格子显示格子
                            AlgoVisHelper.putImage(g2d, j * w, i * h, MineSweeperData.blockImageURL);

                    }
                }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}