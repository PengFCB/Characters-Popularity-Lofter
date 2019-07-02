import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CoupleList {
    private Couple[] cplist;
    private Passage[] hotList;
    private Passage[] totalList;
	private List<Couple> cplistn;
	private List<Couple> cplisth;
	private List<Couple> cplistt;
    public CoupleList() throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("cpdic.json"));
        BufferedReader br1=new BufferedReader(new FileReader("lfhot.json"));
        BufferedReader br2=new BufferedReader(new FileReader("lf20190625_1110_rmdup.json"));
        
        cplist = new Gson().fromJson(br,Couple[].class);
        hotList=new Gson().fromJson(br1, Passage[].class);
        totalList=new Gson().fromJson(br2, Passage[].class);
        
        br.close();
        br1.close();
        br2.close();
    }

    public Couple[] getCplist() {
        return cplist;
    }

    public void setCplist(Couple[] cplist) {
        this.cplist = cplist;
    }
    
    public void resetCpIndex(){
    	for(int i=0;i<cplist.length;i++){
    		cplist[i].resetHot();
    	}
    }
    public void sort(){
		for(int i=0;i<cplist.length;i++){
			for(int j=0;j<hotList.length;j++){
				if(hotList[j].getTag().contains(cplist[i].getTag())){
					cplist[i].addHot(hotList[j].getHotIndex()+hotList[j].getCommentNum()*10);
				}
			}
		}
		cplisth=Arrays.asList(cplist);
		Collections.sort(cplisth);
		for(int i=0;i<cplist.length;i++){
			for(int j=0;j<totalList.length;j++){
				if(totalList[j].getTag().contains(cplist[i].getTag())){
					cplist[i].addHot(totalList[j].getHotIndex()+totalList[j].getCommentNum()*10);
				}
			}
		}
		cplistt=Arrays.asList(cplist);
		Collections.sort(cplistt);
		resetCpIndex();

		for(int i=0;i<cplist.length;i++){
			for(int j=0;j<totalList.length;j++){
				if(totalList[j].getTag().contains(cplist[i].getTag())){
					cplist[i].addHot(totalList[j].getHotIndex()+totalList[j].getCommentNum()*10);
				}
			}
		}
		cplistn=Arrays.asList(cplist);
		Collections.sort(cplistn);
	}
	public void totxt()throws IOException{
		BufferedWriter bw=new BufferedWriter(new FileWriter("txt/cpHotListRank.txt"));
		BufferedWriter bw1=new BufferedWriter(new FileWriter("txt/cpTotListRank.txt"));
		BufferedWriter bw2=new BufferedWriter(new FileWriter("txt/cpRank.txt"));
		for(int i=0;i<cplisth.size();i++){
			bw.write(cplisth.get(i).getTag()+"\t"+cplisth.get(i).getHotIndex()+"\n");
			bw.flush();
		}
		bw.close();
		for(int i=0;i<cplistt.size();i++){
			bw2.write(cplistt.get(i).getTag()+"\t"+cplistt.get(i).getHotIndex()+"\n");
			bw2.flush();
		}
		bw2.close();
		for(int i=0;i<cplistn.size();i++){
			bw1.write(cplistn.get(i).getTag()+"\t"+cplistn.get(i).getHotIndex()+"\n");
			bw1.flush();
		}
		bw1.close();
	}
    public void countMain()throws IOException {
		sort();
		totxt();
    }
    
}
