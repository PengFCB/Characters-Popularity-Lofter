import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RmDup {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new FileReader("lf20190625_1110.txt"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("tagRmDup.txt"));
		//Scanner sc;
		List<String> l=new ArrayList<String>();
		String str,str1;
		
		while(true){
			str=br.readLine();
			if(str==null){
				break;
			}
			if(str.startsWith("热度(")){
				//sc=new Scanner(str.replace("热度(", ""));
				str1=str.replace("热度(", "");
				str1=str1.replace(")", "");
				if(Integer.parseInt(str1)>=2661){
					l.clear();
					for(int i=0;i<10;i++){
						br.readLine();
					}
					//sc.close();
				}
				else{
					for(int i=0;i<l.size();i++){
						bw.write(l.get(i)+"\n");
						bw.flush();
					}
					l.clear();
					bw.write(str+"\n");
					bw.flush();
					for(int i=0;i<10;i++){
						bw.write(br.readLine()+"\n");
						bw.flush();
					}
				}
			}
			else{
				l.add(str);
			}
			
		}
		
	}

}
