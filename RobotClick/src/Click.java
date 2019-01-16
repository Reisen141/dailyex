import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Click {
    static Robot r;
//静态代码块处理静态异常？
    static {
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    static Random ran=new Random();


//    方法所需参数为点击位置p，点击后等待时间time
    static void toClick(Point p,int time){
        //鼠标移动
        if (Proccess.stopFlag==false) {
            r.mouseMove(p.x, p.y);
            r.delay(500 + ran.nextInt(500));

            //点击按钮
            r.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            r.delay(50);
            r.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            //点击后等待time毫秒
            r.delay(time + ran.nextInt(500));
        }
    }
}
