import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dictionary.stopword.CoreStopWordDictionary;
import com.hankcs.hanlp.model.crf.CRFLexicalAnalyzer;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;

import java.io.IOException;
import java.util.List;

public class word_dev {
    private CRFLexicalAnalyzer analyzer ;
    private List<String> con=null;
    private String str="";
    private Segment segment;
    public word_dev() throws IOException {
        analyzer = new CRFLexicalAnalyzer();
        segment= HanLP.newSegment().enableNameRecognize(true);
    }
    public word_dev(String str) throws IOException {
        this.str=str;
        analyzer = new CRFLexicalAnalyzer();
        segment= HanLP.newSegment().enableNameRecognize(true);
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
    public List<String>GetNameList(){
        List<Term> termList = segment.seg(str);
        CoreStopWordDictionary.apply(termList);
        List<String>stt=null;
        for(Term tt:termList)stt.add(tt.word);
        return stt;
    }
    public void Reset(String str){
        this.str=str;
    }
}
