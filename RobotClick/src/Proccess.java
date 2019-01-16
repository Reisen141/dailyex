import java.awt.*;
import java.util.Random;

public class Proccess implements Runnable{
    static Robot r;

    {
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    static Random ran=new Random();
    Point p1,p2,p3;
    int loop;
    boolean restFlag;
    static boolean stopFlag=false;
    static int iOut;
    static StringBuffer labelOut=new StringBuffer("大家好我又开始了");

//  重写后的run方法为执行点击的总流程
    @Override
    public void run() {
        for (int i=0;i<loop&&!stopFlag;i++) {
            iOut=i+1;


            System.out.println("循环次数     "+i);
            labelOut.delete(0,labelOut.length());
            labelOut.append("循环次数     "+i);


            System.out.println("点击战场");
            labelOut.delete(0,labelOut.length());
            labelOut.append("点击战场");

            Click.toClick(p1,2000);


            System.out.println("点击开始");
            labelOut.delete(0,labelOut.length());
            labelOut.append("点击开始");

            Click.toClick(p3,1);
            LogicJudgement.waitForTimeOut();

//            开始后等待战场时间
            if (stopFlag==false){
                r.delay(5000);
                labelOut.delete(0,labelOut.length());
                labelOut.append("少女出征中...");

            }
//            判定mission是否complete，如果没complete，等1s再判断
            while (!LogicJudgement.missionCompleteJudge()&&!stopFlag)
            {
                r.delay(1000);
            }

            //mission complete点击
            System.out.println("点击");
            labelOut.delete(0,labelOut.length());
            labelOut.append("mission complete");

            Click.toClick(p3,5000);

            //结算点击
            System.out.println("点击结算");
            labelOut.delete(0,labelOut.length());
            labelOut.append("点击结算");

            Click.toClick(p3,2000);
            Click.toClick(p3,4000);

            //休息判定
            if (restFlag){
                System.out.println("点击休息");
                labelOut.delete(0,labelOut.length());
                labelOut.append("点击休息");

                Click.toClick(p2,500);

                LogicJudgement.waitForTimeOut();

                //点击休息按钮后等待4s
                r.delay(4000+ran.nextInt(500));
            }



        }
//          System.out.println("结束了");
            labelOut.delete(0,labelOut.length());
            labelOut.append("我好了");

    }

//    构造函数传入面板得来的各项参数
    Proccess(Point p1,Point p2,Point p3,int loop,boolean restFlag) {
        this.p1=p1;
        this.p2=p2;
        this.p3=p3;
        this.loop=loop;
        this.restFlag=restFlag;

    }



}




