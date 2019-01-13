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

            waitForTimeOut();

            //开始后等待战场时间



            while (!missionCompleteJudgeOneTime())
            {
                r.delay(1000);
                }



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

                waitForTimeOut();

                //点击休息按钮后等待4s
                r.delay(4000+ran.nextInt(500));
            }



        }
    }

    static public void waitForTimeOut() throws AWTException {

        boolean flag= false;
        Robot r = new Robot();
        r.delay(100);
        Random ran=new Random();
        while (flag==false) {
            r.delay(500);
            if (retryJudgeOneTime())
            {
                r.mouseMove(1151, 762);
                r.delay(1000);
                r.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
                r.delay(50);
                r.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
                r.delay(5000 + ran.nextInt(500));

                }
            if (!connectingJudgeOneTime()){
                flag=true;
            }
            }
        }

    static  public boolean missionCompleteJudgeOneTime() throws AWTException {
        boolean flag=false;
        Robot r = new Robot();

        waitForTimeOut();

            Color c1=r.getPixelColor(284,503);
            Color c2=r.getPixelColor(907,502);
            Color c3=r.getPixelColor(1635,506);

            if (c1.getRed()<=255&&c1.getRed()>240&&c1.getGreen()<=180&&c1.getGreen()>170&&c1.getBlue()>=40&&c1.getBlue()<60&&
                    c2.getRed()<=255&&c2.getRed()>240&&c2.getGreen()<=180&&c2.getGreen()>170&&c2.getBlue()>=40&&c2.getBlue()<60&&
                    c3.getRed()<=255&&c3.getRed()>240&&c3.getGreen()<=180&&c3.getGreen()>170&&c3.getBlue()>=40&&c3.getBlue()<60)
            {
                flag=true;
//                System.out.println("检测一次operation，f="+flag);
            }
        return flag;
    }
    static public boolean connectingJudgeOneTime() throws AWTException {
        boolean flag=false;
        Robot r = new Robot();

        Color c4 = r.getPixelColor(1438, 182);
        Color c5 = r.getPixelColor(1498, 183);
        Color c6 = r.getPixelColor(1709, 180);

        if (c4.getRed() == 255 && c4.getGreen() == 255 && c4.getBlue() == 255 && c5.getRed() == 255 && c5.getGreen() == 255 && c5.getBlue() == 255 && c6.getRed() == 255 && c6.getGreen() == 255 && c6.getBlue() == 255) {
            flag = true;
        }
//        System.out.println("connectJudgeOneTime="+flag);
        return flag;
        }


    static public boolean retryJudgeOneTime() throws AWTException {
        boolean flag=false;
        Robot r = new Robot();

        Color c1 = r.getPixelColor(693, 745);
        Color c2 = r.getPixelColor(853, 744);
        Color c3 = r.getPixelColor(775, 777);
        if (c1.getRed() > 240 &&c1.getRed()<250&& c1.getGreen() > 140&&c1.getGreen()<150 && c1.getBlue() >20&&c1.getBlue()<40 &&
                c2.getRed() > 240 &&c2.getRed()<250&& c2.getGreen() > 140&&c2.getGreen()<150 && c2.getBlue() >20&&c2.getBlue()<40 &&
                c3.getRed() > 240 &&c3.getRed()<250&& c3.getGreen() > 140&&c3.getGreen()<150 && c3.getBlue() >20&&c3.getBlue()<40 ) {
            flag= true;
        }
//        System.out.println("retryJudgeOneTime="+flag);
        return flag;


    }



}
