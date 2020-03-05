package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class fileStreamTest {
    public static void main(String[] args) throws IOException {
       // File f = new File("C:/Users/17251/Desktop/picture/圆圆.jpg");
       /* FileOutputStream fop = new FileOutputStream(f);
        // 构建FileOutputStream对象,文件不存在会自动新建

        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        // 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk

        writer.append("中文输入");
        // 写入到缓冲区

        writer.append("\r\n");
        // 换行

        writer.append("English");
        // 刷新缓存冲,写入到文件,如果下面已经没有写入的内容了,直接close也会写入

        writer.close();
        // 关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉

        fop.close();
        // 关闭输出流,释放系统资源*/
       /* FileInputStream fip=new FileInputStream(f);
        // 构建FileInputStream对象
        InputStreamReader reader = new InputStreamReader(fip);
        // 构建InputStreamReader对象,编码与写入相同
        StringBuffer sb=new StringBuffer();
        while(reader.ready()){
            sb.append((char)reader.read());
            // 转成char加到StringBdduffer对象中
        }
        System.out.println(sb.toString());
        reader.close();
        // 关闭读取流

        fip.close();
        // 关闭输入流,释放系统资源
  */
        File out = new File("C:/Users/17251/Desktop/picture/圆圆.jpg");
        //将图片写入ImageIO流
        try {
            BufferedImage img = ImageIO.read(out);
            //将图片写出到指定位置（复制图片）
            OutputStream ops = new FileOutputStream(new File("C:/Users/17251/Desktop/picture"));
            //如果该路径已有文件存在，则会覆盖原有文件
            ImageIO.write(img, "jpg", ops);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
