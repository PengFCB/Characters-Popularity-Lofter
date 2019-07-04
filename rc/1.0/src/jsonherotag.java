import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.List;
import java.util.Random;

public class jsonherotag {
    private Gson js;
    private Reader brr;
    private hero[] hh;
    private tag[] tg;
    private lofter[]pg;
    private Passage[] pgh;
    loadpress ls;
    Random rand;
    int i=0;
    jsonherotag() throws FileNotFoundException {
        ls=new loadpress();
        keyword kk=new keyword();
        js=new GsonBuilder().create();
        try{
            rand= new Random();
            //File writeName = new File("txt\\keyword.txt");;
            //writeName.createNewFile();
            //FileWriter writer  = new FileWriter(writeName);
            //BufferedWriter out= new BufferedWriter(writer);
            brr= new InputStreamReader(new FileInputStream("json/dic.json"),"UTF-8");
            hh=js.fromJson(brr,hero[].class);

            brr= new InputStreamReader(new FileInputStream("json/dictionary.json"),"UTF-8");
            tg=js.fromJson(brr,tag[].class);

            brr= new InputStreamReader(new FileInputStream("json/lofter.json"),"UTF-8");
            pg=js.fromJson(brr,lofter[].class);

            brr= new InputStreamReader(new FileInputStream("json/lfhot.json"),"UTF-8");
            pgh=js.fromJson(brr,Passage[].class);
            for(Passage ph:pgh){
                int i=ph.getCommentNum();
                int a=ph.getHotIndex();
                a=i*10+a;
                ph.setHotIndex(a);
                kk.Reset(ph.getMain().toString());
                List<String> kw=kk.GetKeyWord(5);
                i=rand.nextInt(300);
                if(i<2)
                ls.showkw(ph.getMain().toString(),kw.toString());
               // out.write(ph.getMain().toString()+"\t"+kw.toString());
                for(String st:kw){
                    List<String>tgs=ph.getTag();
                    if(tgs.contains(st))continue;
                    else tgs.add(st);
                }
            }
            for(lofter ll:pg){
                kk.Reset(ll.getText());
                List<String> kw=kk.GetKeyWord(5);
                //out.write(ll.getText().toString()+"\t"+kw.toString());
                i=rand.nextInt(300);
                if(i<2)
                ls.showkw(ll.getText().toString(),kw.toString());
                for(String st:kw){
                    List<String>tgs=ll.getTag();
                    if(tgs.contains(st))continue;
                    else tgs.add(st);
                }
            }
            ls.setVisible(false);
            //out.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    public hero[] getHh() {
        return hh;
    }

    public tag[] getTg() {
        return tg;
    }

    public lofter[] getPg() {
        return pg;
    }

    public Passage[] getPgh() {
        return pgh;
    }
}
