import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChart {
	ChartPanel frame1;
	public  BarChart(String addr,String title) throws IOException{
		CategoryDataset dataset = getDataSet(addr);
        JFreeChart chart = ChartFactory.createBarChart3D(
       		                 title, // 图表标题
                            "", // 目录轴的显示标签
                            "数量", // 数值轴的显示标签
                            dataset, // 数据集
                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                            true,           // 是否显示图例(对于简单的柱状图必须是false)
                            false,          // 是否生成工具
                            false           // 是否生成URL链接
                            );
        
        //从这里开始
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象
        CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表
         domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
         domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
         ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
         rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
          chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
          chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
          
          //到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题
          
         frame1=new ChartPanel(chart,true);        //这里也可以用chartFrame,可以直接生成一个独立的Frame
         
	}
	private static CategoryDataset getDataSet(String addr) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(addr));
    	Scanner sc;
    	String str;
    	int index;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(int i=0;i<5;i++){
        	sc=new Scanner(br.readLine());
        	str=sc.next();
        	index=sc.nextInt();
        	dataset.setValue(index,str,str);
        	sc.close();
        }
        
        br.close();
        return dataset;
}

public ChartPanel getChartPanel(){
	return frame1;
	
}
}
