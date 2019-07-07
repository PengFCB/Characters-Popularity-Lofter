package team.cplgroup.cpl;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CPL {
	private static JFrame frame;
    private static JMenuBar jMenuBar;
    private JMenu jMenu;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JMenuItem jMenuItem4;
    private JMenuItem cpyright;
	
    CPL(){
    	jMenuBar = new JMenuBar();
    	jMenu = new JMenu("切换视图");
    	
    	jMenuItem1 = new JMenuItem("总榜单");
    	jMenuItem2 = new JMenuItem("新帖榜单");
    	jMenuItem3 = new JMenuItem("热度榜单");
    	jMenuItem4 = new JMenuItem("开源软件许可");
    	cpyright = new JMenuItem("版权声明");
    	
    	jMenu.add(jMenuItem1);
    	jMenu.add(jMenuItem2);
    	jMenu.add(jMenuItem3);
    	jMenu.add(jMenuItem4);
    	jMenu.add(cpyright);
    	jMenuBar.add(jMenu);
    	jMenuItem1.addActionListener(new ActionListener(){
    		@Override
    		public void actionPerformed(ActionEvent a) {
    			try{
    				frame.getContentPane().removeAll();
    				frame.setTitle("总榜单");
    				frame.setLayout(new GridLayout(2,2,10,10));
    				frame.add(new BarChart("txt/cpRank.txt","CP总榜单").getChartPanel());           //添加柱形图
    				frame.add(new BarChart("txt/rank.txt","英雄总榜单").getChartPanel());           //添加柱形图的另一种效果
    				frame.add(new PieChart("txt/cpRank.txt","CP总榜单").getChartPanel());           //添加饼状图
    				frame.add(new PieChart("txt/rank.txt","英雄总榜单").getChartPanel());     //添加折线图
    				frame.setBounds(50, 50, 1024, 768);
    				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    				frame.setVisible(true);
    	           
    				frame.pack();
    	        
    				frame.setJMenuBar(jMenuBar);
    			}
    			catch(IOException e){
    				e.printStackTrace();
    			}
    		}
    	});
    	jMenuItem2.addActionListener(new ActionListener(){
    		@Override
    		public void actionPerformed(ActionEvent a) {
    			try{
    				frame.getContentPane().removeAll();
    				frame.setTitle("新帖榜单");
    				frame.setLayout(new GridLayout(2,2,10,10));
    		        frame.add(new BarChart("txt/cpTotListRank.txt","CP新帖榜单").getChartPanel());           //添加柱形图
    		        frame.add(new BarChart("txt/rank_new.txt","英雄新帖榜单").getChartPanel());           //添加柱形图的另一种效果
    		        frame.add(new PieChart("txt/cpTotListRank.txt","CP新帖榜单").getChartPanel());           //添加饼状图
    		        frame.add(new PieChart("txt/rank_new.txt","英雄新帖榜单").getChartPanel());     //添加折线图
    				frame.setBounds(50, 50, 1024, 768);
    				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    				frame.setVisible(true);
    	           
    				frame.pack();
    	        
    				frame.setJMenuBar(jMenuBar);
    			}
    			catch(IOException e){
    				e.printStackTrace();
    			}
    		}
    	});
    	jMenuItem3.addActionListener(new ActionListener(){
    		@Override
    		public void actionPerformed(ActionEvent a) {
    			try{
    				frame.getContentPane().removeAll();
    				frame.setTitle("热度榜单");
    				frame.setLayout(new GridLayout(2,2,10,10));
    		        frame.add(new BarChart("txt/cpHotListRank.txt","CP热度榜单").getChartPanel());           //添加柱形图
    		        frame.add(new BarChart("txt/rank_hot.txt","英雄热度榜单").getChartPanel());           //添加柱形图的另一种效果
    		        frame.add(new PieChart("txt/cpHotListRank.txt","CP热度榜单").getChartPanel());           //添加饼状图
    		        frame.add(new PieChart("txt/rank_hot.txt","英雄热度榜单").getChartPanel());     //添加折线图
    				frame.setBounds(50, 50, 1024, 768);
    				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    				frame.setVisible(true);
    	           
    				frame.pack();
    	        
    				frame.setJMenuBar(jMenuBar);
    			}
    			catch(IOException e){
    				e.printStackTrace();
    			}
    		}
    	});
    	jMenuItem4.addActionListener(new ActionListener(){
    		@Override
    		public void actionPerformed(ActionEvent a){
    			JFrame f=new JFrame();
    			f.getContentPane().removeAll();
    			f.setTitle("开源软件许可");
    			Object[][] softwareInfo = {
    		            // 创建表格中的数据
    		            { "HanLp", "1.7.3", "否", "Apache-2.0", "https://github.com/hankcs/HanLP" },
    		            { "gson", "2.8.5", "否", "Apache-2.0", "https://github.com/google/gson" },
    		            { "jcommon", "1.0.16", "否", "LGPL-2.1", "https://github.com/jfree/jcommon" },
    		            { "jfreechart", "1.0.13", "否", "LGPL-2.1", "https://github.com/jfree/jfreechart" }};
    		    // 创建表格中的横标题
    		    String[] Names = { "软件名称", "版本", "是否修改", "许可证类别", "项目主页" };
    		    // 以Names和playerInfo为参数，创建一个表格
    		    @SuppressWarnings("serial")
				JTable table = new JTable(softwareInfo, Names){
    		    	@Override
    		    	 public boolean isCellEditable(int row, int column) {                // 表格不可编辑
    		            return false;
    		        }
    		    };
    		    f.setBounds(50, 50, 1024, 768);
    		    // 设置此表视图的首选大小
    		    table.setPreferredScrollableViewportSize(new Dimension(800, 600));
    		    // 将表格加入到滚动条组件中
    		    JScrollPane scrollPane = new JScrollPane(table);
    		    f.getContentPane().add(scrollPane, BorderLayout.CENTER);
    		    // 再将滚动条组件添加到中间容器中
    		    f.pack();
    		    f.setVisible(true);
    		    
    		
    		}
    	});
    	cpyright.addActionListener(new ActionListener(){
    		@Override
    		public void actionPerformed(ActionEvent a){
    			new Copyright().pack();
    		}
    	});
    }
	
       public static void main(String[] args) throws IOException, InterruptedException {
    	   boolean showWarning=false;
    	   File f1=new File("data/dictionary/custom/CustomDictionary.txt");
    	   File f2=new File("data/dictionary/CoreNatureDictionary.txt.bin");
    	   File f3=new File("data/dictionary/CoreNatureDictionary.txt");
    	   if(!f1.exists() || !f2.exists() || !f3.exists()){
    		   System.err.println("Missing Data!!");
    		   showWarning=true;
    	   }
    	   
    	   
           final CountDownLatch cdt=new CountDownLatch(2);
           ExecutorService exe= Executors.newFixedThreadPool(2);
           exe.execute(new multtd(cdt,true));
           exe.execute(new multtd(cdt,false));
           cdt.await();
           
           new CPL();
           
           
           frame=new JFrame("总榜单");
           frame.setLayout(new GridLayout(2,2,10,10));
           frame.add(new BarChart("txt/cpRank.txt","CP总榜单").getChartPanel());           //添加柱形图
           frame.add(new BarChart("txt/rank.txt","英雄总榜单").getChartPanel());           //添加柱形图的另一种效果
           frame.add(new PieChart("txt/cpRank.txt","CP总榜单").getChartPanel());           //添加饼状图
           frame.add(new PieChart("txt/rank.txt","英雄总榜单").getChartPanel());     //添加折线图
           frame.setBounds(50, 50, 1024, 768);
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setVisible(true);
           
           frame.setJMenuBar(jMenuBar);
           frame.pack();
           
           if(showWarning){
        	   new DataMissingWarning();
           }
       
           
           
           
           /*JFrame frame=new JFrame("总榜单");
           frame.setLayout(new GridLayout(2,2,10,10));
           frame.add(new BarChart("txt/cpRank.txt","CP总榜单").getChartPanel());           //添加柱形图
           frame.add(new BarChart("txt/rank.txt","英雄总榜单").getChartPanel());           //添加柱形图的另一种效果
           frame.add(new PieChart("txt/cpRank.txt","CP总榜单").getChartPanel());           //添加饼状图
           frame.add(new PieChart("txt/rank.txt","英雄总榜单").getChartPanel());     //添加折线图
           frame.setBounds(50, 50, 800, 600);
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setVisible(true);
           
           frame.pack();
           //frame.setVisible(true);
           JMenuBar jMenuBar = new JMenuBar();
           JMenu jMenu = new JMenu("操作");
           JMenuItem item1 = new JMenuItem("item1");
           JMenuItem item2 = new JMenuItem("item2");
           JMenuItem item3 = new JMenuItem("item3");
           JMenuItem item4 = new JMenuItem("退出");
           jMenu.add(item1);
           jMenu.add(item2);
           jMenu.add(item3);
           jMenu.add(item4);
           jMenuBar.add(jMenu);
           frame.setJMenuBar(jMenuBar);
           item4.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   System.exit(0);
               }
           } );
           item2.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   //System.exit(0);
            	   try{
            		   frame.removeAll();
            		   frame.setLayout(new GridLayout(2,2,10,10));
            		   frame.add(new BarChart("txt/cpTotListRank.txt","CP新帖榜单").getChartPanel());           //添加柱形图
            		   frame.add(new BarChart("txt/rank_new.txt","英雄新帖榜单").getChartPanel());           //添加柱形图的另一种效果
            		   frame.add(new PieChart("txt/cpTotListRank.txt","CP新帖榜单").getChartPanel());           //添加饼状图
            		   frame.add(new PieChart("txt/rank_new.txt","英雄新帖榜单").getChartPanel());     //添加折线图
            		   frame.pack();
            		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            		   frame.setVisible(true);
            	   }
            	   catch(IOException ex){
            		   ex.printStackTrace();
            	   }
               }
           } );
    
      
           /*
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
           */
       }
       
       
}
