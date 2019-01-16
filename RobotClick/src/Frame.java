import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame implements Runnable{
    JFrame f = new JFrame("按键Java灵");
    //button
    JButton bBatlle = new JButton("清空战斗点");
    JButton bRest = new JButton("清空休息点");
    JButton bLoop = new JButton("清空循环次数");
    JButton bStart = new JButton("开始");
    JButton bEnd = new JButton("结束");

    JLabel l5 = new JLabel("循环次数" + Proccess.iOut);
    JLabel l6 = new JLabel();


    Checkbox c1=new Checkbox("rest");

    TextField tBattle = new TextField("1293.603");
    TextField tRest = new TextField("1152.719");
    TextField tStartX = new TextField("1757");
    TextField tStartY = new TextField("486");
    TextField tLoop = new TextField("20");




    @Override
    public void run() {
        while (true) {
            l5.setText("循环次数        " + Proccess.iOut);
            l6.setText(Proccess.labelOut.toString());
//            System.out.println("我画了");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

     Frame() {
        //frame的相关构造

        f.setSize(100, 400);
        f.setLocation(1780, 70);
        f.setLayout(new FlowLayout(1));
        f.setAlwaysOnTop(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);



        //点击按钮清空的监听事件
        empty(bRest,tRest);
        empty(bLoop,tLoop);
        empty(bBatlle,tBattle);



        bStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//              点击开始时进程t1开始
                Proccess p=new Proccess(new Point(Integer.parseInt(tBattle.getText().split("\\.")[0]),Integer.parseInt(tBattle.getText().split("\\.")[1])),
                        new Point(Integer.parseInt(tRest.getText().split("\\.")[0]),Integer.parseInt(tRest.getText().split("\\.")[1])),
                        new Point(Integer.parseInt(tStartX.getText()),
                        Integer.parseInt(tStartY.getText())),Integer.parseInt(tLoop.getText()),
                        c1.getState());
                Proccess.stopFlag=false;
                new Thread(p).start();



            }
        });


        bEnd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//              点击终止时结束进程
                Proccess.stopFlag=true;
//                System.out.println(Thread.currentThread().getState());
                System.out.println("即将停止");
                Proccess.labelOut.delete(0,Proccess.labelOut.length());
                Proccess.labelOut.append("即将停止");



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
        f.add(l6);

        f.setVisible(true);
    }

//    静态方法清空TextField
    static void empty(JButton b,TextField t){
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                t.getText();
                t.setText("");
            }
        });
    }



}
