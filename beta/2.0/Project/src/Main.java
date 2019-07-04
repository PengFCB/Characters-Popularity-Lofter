import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
       public static void main(String[] args) throws IOException, InterruptedException {
           final CountDownLatch cdt=new CountDownLatch(2);
           ExecutorService exe= Executors.newFixedThreadPool(2);
           exe.execute(new multtd(cdt,true));
           exe.execute(new multtd(cdt,false));
           cdt.await();
           JFrame frame=new JFrame("总榜单");
           frame.setLayout(new GridLayout(2,2,10,10));
           frame.add(new BarChart("txt/cpRank.txt","CP总榜单").getChartPanel());           //添加柱形图
           frame.add(new BarChart("txt/rank.txt","英雄总榜单").getChartPanel());           //添加柱形图的另一种效果
           frame.add(new PieChart("txt/cpRank.txt","CP总榜单").getChartPanel());           //添加饼状图
           frame.add(new PieChart("txt/rank.txt","英雄总榜单").getChartPanel());     //添加折线图
           frame.setBounds(50, 50, 800, 600);
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setVisible(true);

           JFrame frame1=new JFrame("新帖榜单");
           frame1.setLayout(new GridLayout(2,2,10,10));
           frame1.add(new BarChart("txt/cpTotListRank.txt","CP新帖榜单").getChartPanel());           //添加柱形图
           frame1.add(new BarChart("txt/rank_new.txt","英雄新帖榜单").getChartPanel());           //添加柱形图的另一种效果
           frame1.add(new PieChart("txt/cpTotListRank.txt","CP新帖榜单").getChartPanel());           //添加饼状图
           frame1.add(new PieChart("txt/rank_new.txt","英雄新帖榜单").getChartPanel());     //添加折线图
           frame1.setBounds(50, 50, 800, 600);
           frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame1.setVisible(true);

           JFrame frame2=new JFrame("热度榜单");
           frame2.setLayout(new GridLayout(2,2,10,10));
           frame2.add(new BarChart("txt/cpHotListRank.txt","CP热度榜单").getChartPanel());           //添加柱形图
           frame2.add(new BarChart("txt/rank_hot.txt","英雄热度榜单").getChartPanel());           //添加柱形图的另一种效果
           frame2.add(new PieChart("txt/cpHotListRank.txt","CP热度榜单").getChartPanel());           //添加饼状图
           frame2.add(new PieChart("txt/rank_hot.txt","英雄热度榜单").getChartPanel());     //添加折线图
           frame2.setBounds(50, 50, 800, 600);
           frame2.setVisible(true);
           frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       }
}
