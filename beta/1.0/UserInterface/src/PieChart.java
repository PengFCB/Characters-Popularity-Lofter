

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class PieChart {
	ChartPanel frame1;
	public PieChart(String addr,String title) throws IOException{
		  DefaultPieDataset data = getDataSet(addr);
	      JFreeChart chart = ChartFactory.createPieChart3D(title,data,true,false,false);
	    //设置百分比
	      PiePlot pieplot = (PiePlot) chart.getPlot();
	      DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题
	      NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象
	      StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象
	      pieplot.setLabelGenerator(sp1);//设置饼图显示百分比
	  
	  //没有数据的时候显示的内容
	      pieplot.setNoDataMessage("无数据显示");
	      pieplot.setCircular(false);
	      pieplot.setLabelGap(0.02D);
	  
	      pieplot.setIgnoreNullValues(true);//设置不显示空值
	      pieplot.setIgnoreZeroValues(true);//设置不显示负值
	      frame1=new ChartPanel (chart,true);
	      chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
	      PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象
	      piePlot.setLabelFont(new Font("宋体",Font.BOLD,10));//解决乱码
	      chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10));
	}
    private static DefaultPieDataset getDataSet(String addr) throws IOException{
    	BufferedReader br=new BufferedReader(new FileReader(addr));
    	Scanner sc;
    	String str;
    	int other=0,index;
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        for(int i=0;i<5;i++){
        	sc=new Scanner(br.readLine());
        	str=sc.next();
        	index=sc.nextInt();
        	dataset.setValue(str,index);
        	sc.close();
        }        
        while((str=br.readLine())!=null){
        	sc=new Scanner(str);
        	sc.next();
        	other=other+sc.nextInt();
        	sc.close();
        }
        dataset.setValue("其他",other);
        br.close();
        
        return dataset;
}
    public ChartPanel getChartPanel(){
    	return frame1;
    	
    }
}
