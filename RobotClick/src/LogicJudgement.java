import java.awt.*;

public class LogicJudgement {
    static public boolean flag = false;
    static public Robot r;

    static {
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    static public void waitForTimeOut(){
        r.delay(100);
        while (!flag) {
            r.delay(500);
            if (LogicJudgement.retryJudge())
            {
//              定义、点击retry点
                System.out.println("点击retry");
                Proccess.labelOut.delete(0,Proccess.labelOut.length());
                Proccess.labelOut.append("点击retry");

                Point pRetry=new Point(1151,762);
                Click.toClick(pRetry,5000);
            }
            if (!LogicJudgement.connectingJudge()){
                flag=true;
            }
            if (Proccess.stopFlag==true){
                flag=true;
            }
        }
    }

    static public boolean missionCompleteJudge()  {
        waitForTimeOut();

        Color c1 = r.getPixelColor(284, 503);
        Color c2 = r.getPixelColor(907, 502);
        Color c3 = r.getPixelColor(1635, 506);

        return  (c1.getRed() <= 255 && c1.getRed() > 240 && c1.getGreen() <= 180 && c1.getGreen() > 170 && c1.getBlue() >= 40 && c1.getBlue() < 60 &&
                c2.getRed() <= 255 && c2.getRed() > 240 && c2.getGreen() <= 180 && c2.getGreen() > 170 && c2.getBlue() >= 40 && c2.getBlue() < 60 &&
                c3.getRed() <= 255 && c3.getRed() > 240 && c3.getGreen() <= 180 && c3.getGreen() > 170 && c3.getBlue() >= 40 && c3.getBlue() < 60) ;

    }

    static public boolean connectingJudge()  {
        Color c4 = r.getPixelColor(1438, 182);
        Color c5 = r.getPixelColor(1498, 183);
        Color c6 = r.getPixelColor(1709, 180);

        return (c4.getRed() == 255 && c4.getGreen() == 255 && c4.getBlue() == 255 && c5.getRed() == 255 && c5.getGreen() == 255 && c5.getBlue() == 255 && c6.getRed() == 255 && c6.getGreen() == 255 && c6.getBlue() == 255) ;

    }


    static public boolean retryJudge() {
        Color c1 = r.getPixelColor(693, 745);
        Color c2 = r.getPixelColor(853, 744);
        Color c3 = r.getPixelColor(775, 777);
        return  (c1.getRed() > 240 && c1.getRed() < 250 && c1.getGreen() > 140 && c1.getGreen() < 150 && c1.getBlue() > 20 && c1.getBlue() < 40 &&
                c2.getRed() > 240 && c2.getRed() < 250 && c2.getGreen() > 140 && c2.getGreen() < 150 && c2.getBlue() > 20 && c2.getBlue() < 40 &&
                c3.getRed() > 240 && c3.getRed() < 250 && c3.getGreen() > 140 && c3.getGreen() < 150 && c3.getBlue() > 20 && c3.getBlue() < 40) ;

    }
}
