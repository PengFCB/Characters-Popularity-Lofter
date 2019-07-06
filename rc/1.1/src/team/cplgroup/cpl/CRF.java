package team.cplgroup.cpl;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.model.crf.CRFNERecognizer;

import java.io.IOException;

public class CRF {
    CRF(String pp) throws IOException {
        new CRFNERecognizer(HanLP.Config.CRFNERModelPath);
    }
}
