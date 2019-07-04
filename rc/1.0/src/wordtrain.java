import com.hankcs.hanlp.mining.word2vec.Word2VecTrainer;
import com.hankcs.hanlp.mining.word2vec.WordVectorModel;

public class wordtrain {
   public  wordtrain(){
       Word2VecTrainer trainerBuilder = new Word2VecTrainer();
       WordVectorModel wordVectorModel = trainerBuilder.train("F:\\hanlp-wiki-vec-zh\\hanlp-wiki-vec-zh.txt", "data/msr_vectors.txt");
       wordVectorModel.nearest("中国");
    }

}
