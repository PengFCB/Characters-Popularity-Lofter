import java.io.IOException;

public class Main {
       public static void main(String[] args) throws IOException {
        keyword txt=new keyword();
        word_dev dev=new word_dev();
        txtload op=new txtload();
        jsonherotag jht=new jsonherotag();
        String xx="";
        String str="";
       while(true) {
           xx=op.Readln();
           if (xx==null) break;
           if(xx.equals("main:")){
               str=null;
               while(true){
                   xx=op.Readln();
                   if(xx.equals("other:"))break;
                   str = str+xx;
               }
           }

           else continue;
           if(str.length()<200)continue;
           txt.Reset(str);
            op.Write(txt.GetKeyWord(10));
       }
    }
}
