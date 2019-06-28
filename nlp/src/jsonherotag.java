import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class jsonherotag {
    private Gson js;
    private Reader brr;
    private hero[] hh;
    private tag[] tg;
    private page[]pg;
    private pagehot[] pgh;
    jsonherotag() throws FileNotFoundException {
        js=new GsonBuilder().create();
        try{
            brr= new InputStreamReader(new FileInputStream("dic.json"),"UTF-8");
            hh=js.fromJson(brr,hero[].class);

            brr= new InputStreamReader(new FileInputStream("dictionary.json"),"UTF-8");
            tg=js.fromJson(brr,tag[].class);

            brr= new InputStreamReader(new FileInputStream("lf20190625_1110.json"),"UTF-8");
            pg=js.fromJson(brr,page[].class);

            brr= new InputStreamReader(new FileInputStream("lfhot.json"),"UTF-8");
            pgh=js.fromJson(brr,pagehot[].class);
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

    public page[] getPg() {
        return pg;
    }

    public pagehot[] getPgh() {
        return pgh;
    }
}
