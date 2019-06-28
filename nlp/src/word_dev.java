import com.hankcs.hanlp.model.crf.CRFLexicalAnalyzer;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;

import java.io.IOException;
import java.util.List;

public class word_dev {
    private CRFLexicalAnalyzer analyzer ;
    private List<String> con=null;
    private String str="";
    public word_dev() throws IOException {
        analyzer = new CRFLexicalAnalyzer();
    }
    public word_dev(String str) throws IOException {
        this.str=str;
        analyzer = new CRFLexicalAnalyzer();
    }
    public String GetCRFdev(){
        str=analyzer.analyze(str).toStringWithoutLabels();
        final String str1=str;
        return str1;
    }
    public String GetNLPdev(){
        str= NLPTokenizer.analyze(str).toStringWithoutLabels();
        final String str1=str;
        return str1;
    }
    public void Reset(String str){
        this.str=str;
    }
}
