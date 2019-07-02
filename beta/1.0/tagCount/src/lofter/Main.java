package lofter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<Count> l=new ArrayList<Count>();
		l.add(new Count("王者荣耀"));
		String str;
		
		BufferedReader br=new BufferedReader(new FileReader("lf20190625_1110.txt"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("tagCountTotal.txt"));
		
		while(true){
			str=br.readLine();
			if(str==null){
				break;
			}
			if(str.equals("other:")){
				str=br.readLine();
				if(str.startsWith("热度")||str.startsWith("评论")||str.equals("转载")||str.equals("分享")
						||str.equals("推荐")||str.equals("喜欢")){
					continue;
				}
				if(!haveTag(str,l)){
					l.add(new Count(str,1));
				}
			}
			
		}
		
		//List<Count> list = new ArrayList<Count>();
		Collections.sort(l);
		for(int i=0;i<l.size();i++){
			System.out.println(l.get(i).getTag()+":"+l.get(i).getCount());
			bw.write(l.get(i).getTag()+":"+l.get(i).getCount()+"\n");
			bw.flush();
		}
		
	}
	
	static boolean haveTag(String str,List<Count> l){
		for(int i=0;i<l.size();i++){
			if(l.get(i).getTag().equals(str)){
				l.get(i).add();
				return true;
			}
		}
		return false;
	}

}
