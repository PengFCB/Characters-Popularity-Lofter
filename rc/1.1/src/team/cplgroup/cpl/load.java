package team.cplgroup.cpl;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class load extends JFrame {
    public JProgressBar progressBar;
    load(){
        progressBar = new JProgressBar();
        progressBar.setOrientation(JProgressBar.HORIZONTAL);
        progressBar.setSize(200, 10);
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setStringPainted(true);
        JLabel jl=new JLabel("loading");
        this.setLayout(new FlowLayout());
        this.setSize(400, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    progressBar.setValue(i);
                    try {
                        TimeUnit.MILLISECONDS.sleep(800);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }).start();
        this.add(progressBar);
        this.add(jl);
        this.setVisible(true);
    }

}
