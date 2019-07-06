package team.cplgroup.cpl;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;

public class CoupleList {
    public Couple[] cplist;
    private Passage[] hotList;
    private Passage[] totalList;
    
    public CoupleList() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("json/cpdic.json"),"UTF-8"));
        BufferedReader br1=new BufferedReader(new InputStreamReader(new FileInputStream("json/lfhot.json"),"UTF-8"));
        BufferedReader br2=new BufferedReader(new InputStreamReader(new FileInputStream("json/lf.json"),"UTF-8"));
        
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
    public void countMain() throws IOException{
    	BufferedWriter bw=new BufferedWriter(new FileWriter("txt/cpHotListRank.txt"));
    	BufferedWriter bw1=new BufferedWriter(new FileWriter("txt/cpTotListRank.txt"));
    	BufferedWriter bw2=new BufferedWriter(new FileWriter("txt/cpRank.txt"));
    	for(int i=0;i<cplist.length;i++){
    		for(int j=0;j<hotList.length;j++){
    			if(hotList[j].getTag().contains(cplist[i].getTag())){
    				cplist[i].addHot(hotList[j].getHotIndex()+hotList[j].getCommentNum()*10);
    			}
    		}
    	}
    	List<Couple> l=Arrays.asList(cplist);
    	Collections.sort(l);
    	for(int i=0;i<l.size();i++){
    		bw.write(l.get(i).getTag()+"\t"+l.get(i).getHotIndex()+"\n");
    		bw.flush();
    	}
    	bw.close();
    	
    	for(int i=0;i<cplist.length;i++){
    		for(int j=0;j<totalList.length;j++){
    			if(totalList[j].getTag().contains(cplist[i].getTag())){
    				cplist[i].addHot(totalList[j].getHotIndex()+totalList[j].getCommentNum()*10);
    			}
    		}
    	}
    	l=Arrays.asList(cplist);
    	Collections.sort(l);
    	for(int i=0;i<l.size();i++){
    		bw2.write(l.get(i).getTag()+"\t"+l.get(i).getHotIndex()+"\n");
    		bw2.flush();
    	}
    	bw2.close();
    	
    	resetCpIndex();
    	
    	for(int i=0;i<cplist.length;i++){
    		for(int j=0;j<totalList.length;j++){
    			if(totalList[j].getTag().contains(cplist[i].getTag())){
    				cplist[i].addHot(totalList[j].getHotIndex()+totalList[j].getCommentNum()*10);
    			}
    		}
    	}
    	l=Arrays.asList(cplist);
    	Collections.sort(l);
    	for(int i=0;i<l.size();i++){
    		bw1.write(l.get(i).getTag()+"\t"+l.get(i).getHotIndex()+"\n");
    		bw1.flush();
    	}
    	bw1.close();
    	
    }
    
    
}
