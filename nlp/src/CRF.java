import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.model.crf.CRFNERecognizer;

import java.io.IOException;

public class CRF {
    private CRFNERecognizer crfr;
    private String page;
    CRF(String pp) throws IOException {
        page=pp;
        crfr=new CRFNERecognizer(HanLP.Config.CRFNERModelPath);
    }
}
