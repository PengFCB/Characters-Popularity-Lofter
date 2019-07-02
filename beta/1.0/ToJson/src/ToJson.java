import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ToJson {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new FileReader("lfhot.txt"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("lfhot.json"));
		Gson g=new Gson();
		Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
		List<Passage> l=new ArrayList<Passage>();
		String str;
		Passage p=new Passage();
		
		
		while(true){
			str=br.readLine();
			if(str==null){
				break;
			}
			if(str.equals("user:")){
				p=new Passage();
				p.setUser(br.readLine());
				System.out.println(p.getUser());
				br.readLine(); //pass "main:"
			}
			
			str=br.readLine();
			
			while(!str.equals("other:")){
				if(str.equals("")){  //ignore empty line
					str=br.readLine();
					continue;
				}
				p.getMain().add(str);
				str=br.readLine();
			}
			str=br.readLine(); 
			while(!str.startsWith("热度(")){
				if(!str.equals("转载")){
					p.getTag().add(str);
				}
				else{
					break;
				}
				br.readLine();  //pass "other:"
				str=br.readLine();
			}
			if(str.equals("转载")){
				p.setHotIndex(0);
				p.setCommentNum(0);
				for(int i=0;i<6;i++){
					br.readLine(); //pass 8 lines
				}
				l.add(p);
				continue;
			}
			
			str=str.replace("热度(", "");
			str=str.replace(")", "");
			p.setHotIndex(Integer.parseInt(str));
			
			br.readLine(); //pass "other:"
			str=br.readLine();
			if(str.startsWith("评论(")){
				str=str.replace("评论(", "");
				str=str.replace(")", "");
				p.setCommentNum(Integer.parseInt(str));
			}
			else{
				p.setCommentNum(0);
				for(int i=0;i<6;i++){
					br.readLine(); //pass 8 lines
				}
				l.add(p);
				continue;
			}
			l.add(p);
			
			for(int i=0;i<8;i++){
				br.readLine(); //pass 8 lines
			}
			
		}
		br.close();
		bw.write("[\n");
		bw.flush();
		for(int i=0;i<l.size()-1;i++){
			str=gson.toJson(l.get(i));
			
			//str=gson.toJson(str);
			bw.write(str+",\n");
			bw.flush();
		}
		str=gson.toJson(l.get(l.size()-1));
		
		bw.write(str+"\n]");
		bw.flush();
		bw.close();
	}

}
