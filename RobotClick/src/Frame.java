import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame {

    int loop = 0;
    int time = 0;

    Frame() {
        //frame的相关构造参数
        JFrame f = new JFrame("按键Java灵");
        f.setSize(100, 400);
        f.setLocation(1780, 35);
        f.setLayout(new FlowLayout(1));
        f.setAlwaysOnTop(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //button
        JButton bBatlle = new JButton("清空战斗点");
        JButton bRest = new JButton("清空休息点");
        JButton bStartPoint = new JButton("清空开始点");
        JButton bLoop = new JButton("清空循环次数");
        JButton bTime = new JButton("清空战场用时/秒");
        JButton bStart = new JButton("开始");
        JButton bEnd = new JButton("结束");





        JLabel l5 = new JLabel("循环次数统计\r\n" + loop);

        Checkbox c1=new Checkbox("rest");


        TextField tBattleX = new TextField(4);
        TextField tBattleY = new TextField(4);
        TextField tRestX = new TextField(4);
        TextField tRestY = new TextField(4);
        TextField tStartX = new TextField("1757");
        TextField tStartY = new TextField("486");
        TextField tLoop = new TextField(4);
        TextField tTime = new TextField(4);

        //点击按钮清空的监听事件
        bBatlle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tBattleX.getText();
                tBattleX.setText("");
                tBattleY.getText();
                tBattleY.setText("");

            }
        });
        //点击按钮清空的监听事件
        bRest.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tRestX.getText();
                tRestX.setText("");
                tRestY.getText();
                tRestY.setText("");

            }
        });
        //点击按钮清空的监听事件
        bStartPoint.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tStartX.getText();
                tStartX.setText("");
                tStartY.getText();
                tStartY.setText("");
            }
        });
        //点击按钮清空的监听事件
        bLoop.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                tLoop.getText();
                tLoop.setText("");
            }
        });
        //开始
        bStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    //给点赋值
                    Point p1=new Point(Integer.parseInt(tBattleX.getText()),Integer.parseInt(tBattleY.getText()));
                    Point p2=new Point(Integer.parseInt(tRestX.getText()),Integer.parseInt(tRestY.getText()));
                    Point p3=new Point(Integer.parseInt(tStartX.getText()),Integer.parseInt(tStartY.getText()));
                    loop=Integer.parseInt(tLoop.getText());
                    time=Integer.parseInt(tTime.getText());



                    Proccess.start(p1,p2,p3,loop,c1.getState(),time+20);
                } catch (AWTException e1) {
                    e1.printStackTrace();
                }


            }
        });





        f.add(bBatlle);
        f.add(tBattleX);
        f.add(tBattleY);
        f.add(bRest);
        f.add(tRestX);
        f.add(tRestY);
        f.add(bStartPoint);
        f.add(tStartX);
        f.add(tStartY);
        f.add(bTime);
        f.add(tTime);
        f.add(bLoop);
        f.add(tLoop);
        f.add(c1);
        f.add(bStart);
        f.add(bEnd);
        f.add(l5);

        f.setVisible(true);


    }
}
