package team.cplgroup.cpl;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class loadpress extends JFrame {
    JTextArea jt;
    JScrollPane js;
    public loadpress(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(420, 440);
        this.setTitle("loading");
        jt=new JTextArea();
        js=new JScrollPane(jt);
        js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        js.setSize(400,400);
        jt.setSize(400,400);
        jt.setFont(new Font("标楷体", Font.BOLD, 16));
        jt.setLineWrap(true);// 激活自动换行功能
        jt.setWrapStyleWord(true);// 激活断行不断字功能
        jt.setBackground(Color.CYAN);
        this.add(js);
        this.setVisible(true);
    }
    public void showkw(String txt,String key){
        jt.append("文章："+txt+"\n关键词："+key+"\n");
        jt.setCaretPosition(jt.getDocument().getLength());
        jt.invalidate();
        jt.repaint();
    }
}
