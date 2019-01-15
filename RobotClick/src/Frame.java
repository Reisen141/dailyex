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
        f.setLocation(1780, 70);
        f.setLayout(new FlowLayout(1));
        f.setAlwaysOnTop(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setUndecorated(true);
        f.setOpacity(0.7f);

        //button
        JButton bBatlle = new JButton("清空战斗点");
        JButton bRest = new JButton("清空休息点");

        JButton bLoop = new JButton("清空循环次数");

        JButton bStart = new JButton("开始");
        JButton bEnd = new JButton("结束");





        JLabel l5 = new JLabel("循环次数统计\r\n" + loop);

        Checkbox c1=new Checkbox("rest");


        TextField tBattle = new TextField("1293.603");
        TextField tRest = new TextField("1152.719");
        TextField tStartX = new TextField("1757");
        TextField tStartY = new TextField("486");
        TextField tLoop = new TextField("20");


        //点击按钮清空的监听事件
        bBatlle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tBattle.getText();
                tBattle.setText("");

            }
        });
        //点击按钮清空的监听事件
        bRest.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tRest.getText();
                tRest.setText("");

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
                    Point p1=new Point(Integer.parseInt(tBattle.getText().split("\\.")[0]),Integer.parseInt(tBattle.getText().split("\\.")[1]));
                    Point p2=new Point(Integer.parseInt(tRest.getText().split("\\.")[0]),Integer.parseInt(tRest.getText().split("\\.")[1]));
                    Point p3=new Point(Integer.parseInt(tStartX.getText()),Integer.parseInt(tStartY.getText()));
                    loop=Integer.parseInt(tLoop.getText());




                    Proccess.start(p1,p2,p3,loop,c1.getState());
                } catch (AWTException e1) {
                    e1.printStackTrace();
                }


            }
        });





        f.add(bBatlle);
        f.add(tBattle);
        f.add(bRest);
        f.add(tRest);
        f.add(bLoop);
        f.add(tLoop);
        f.add(c1);
        f.add(bStart);
        f.add(bEnd);
        f.add(l5);

        f.setVisible(true);


    }
}
