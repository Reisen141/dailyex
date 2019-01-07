import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Proccess {

    static void start(Point p1,Point p2,Point p3,int loop,boolean flag,int time) throws AWTException {
        Robot r = new Robot();
        Random ran=new Random();

        for (int i=0;i<=loop;i++) {
            System.out.println("循环次数     "+i);


            //鼠标移动战场按钮
            r.mouseMove(p1.x, p1.y);
            r.delay(500+ran.nextInt(500));

            //点击战场按钮
            System.out.println("点击战场");
            r.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            r.delay(50);
            r.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            //点击战场按钮后等待2s
            r.delay(2000+ran.nextInt(500));
            //鼠标移动开始按钮
            r.mouseMove(p3.x, p3.y);
            r.delay(500+ran.nextInt(500));
            //点击开始按钮
            System.out.println("点击开始");
            r.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            r.delay(50);
            r.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            //开始后等待战场时间
            if (time<=60){
            r.delay(time*1000+ran.nextInt(2000));}
            else {
                r.delay(60000);
            r.delay((time-60)*1000+ran.nextInt(2000));}

            //以后也许有掉线处理

            //mission complete点击
            System.out.println("点击mission complete");

            r.mouseMove(p3.x, p3.y);
            r.delay(500+ran.nextInt(500));
            r.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            r.delay(50);
            r.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            r.delay(5000+ran.nextInt(500));
            //结算点击
            System.out.println("点击结算");
            r.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            r.delay(50);
            r.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            r.delay(2000+ran.nextInt(500));
            r.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            r.delay(50);
            r.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            r.delay(4000+ran.nextInt(500));
            //休息判定
            if (flag){
                //鼠标移动休息按钮
                r.mouseMove(p2.x, p2.y);
                r.delay(500+ran.nextInt(500));
                //点击休息按钮
                System.out.println("点击休息");
                r.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
                r.delay(50);
                r.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
                //点击休息按钮后等待4s
                r.delay(4000+ran.nextInt(500));
            }



        }
    }

}
