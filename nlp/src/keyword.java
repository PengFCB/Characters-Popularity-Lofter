import com.hankcs.hanlp.HanLP;

import java.util.List;

public class keyword {
    private String str;
    private List<String>con;
    keyword(){}
    keyword(String str){
        this.str=str;
    }
    public List<String> GetKeyWord(int num){
        con= HanLP.extractKeyword(str,num);
        final List<String>con1=con;
        return con1;
    }
    public void Reset(String str){
        this.str=str;
    }
}
