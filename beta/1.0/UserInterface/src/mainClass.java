import java.awt.GridLayout;
import java.io.IOException;


import javax.swing.JFrame;



public class mainClass {
	public static void main(String args[]) throws IOException{
		JFrame frame=new JFrame("总榜单");
		frame.setLayout(new GridLayout(2,2,10,10));
		frame.add(new BarChart("cpRank.txt","CP总榜单").getChartPanel());           //添加柱形图
		frame.add(new BarChart("rank.txt","英雄总榜单").getChartPanel());           //添加柱形图的另一种效果
		frame.add(new PieChart("cpRank.txt","CP总榜单").getChartPanel());           //添加饼状图
		frame.add(new PieChart("rank.txt","英雄总榜单").getChartPanel());     //添加折线图
		frame.setBounds(50, 50, 800, 600); 
		frame.setVisible(true);
		
		JFrame frame1=new JFrame("新帖榜单");
		frame1.setLayout(new GridLayout(2,2,10,10));
		frame1.add(new BarChart("cpTotListRank.txt","CP新帖榜单").getChartPanel());           //添加柱形图
		frame1.add(new BarChart("rank_new.txt","英雄新帖榜单").getChartPanel());           //添加柱形图的另一种效果
		frame1.add(new PieChart("cpTotListRank.txt","CP新帖榜单").getChartPanel());           //添加饼状图
		frame1.add(new PieChart("rank_new.txt","英雄新帖榜单").getChartPanel());     //添加折线图
		frame1.setBounds(50, 50, 800, 600); 
		frame1.setVisible(true);
		
		JFrame frame2=new JFrame("热度榜单");
		frame2.setLayout(new GridLayout(2,2,10,10));
		frame2.add(new BarChart("cpHotListRank.txt","CP热度榜单").getChartPanel());           //添加柱形图
		frame2.add(new BarChart("rank_hot.txt","英雄热度榜单").getChartPanel());           //添加柱形图的另一种效果
		frame2.add(new PieChart("cpHotListRank.txt","CP热度榜单").getChartPanel());           //添加饼状图
		frame2.add(new PieChart("rank_hot.txt","英雄热度榜单").getChartPanel());     //添加折线图
		frame2.setBounds(50, 50, 800, 600); 
		frame2.setVisible(true);
	}
	
}		
