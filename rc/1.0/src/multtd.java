import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class multtd  extends Thread
   {
        private CountDownLatch cdt=null;
        private boolean flag;
        public multtd(CountDownLatch cdt, boolean flag){
            this.cdt=cdt;
            this.flag=flag;
        }
       public void run() {
            try {
                 if(flag){
                 jsonherotag jht=new jsonherotag();
                 tagdev tgd=new tagdev(jht.getHh(),jht.getTg(),jht.getPg(),jht.getPgh());
                 tgd.rename();
                 tgd.devcp();
                 tgd.removedup();
                 rank rr=new rank(tgd.getPg(),tgd.getPgh());
                 rr.ranktotxt();
                 rr.rankhottotxt();
                 rr.ranknewtotxt();
                 }
                 else{
                    new CoupleList().countMain();
                 }
            }catch (IOException e) {
               System.out.println("Thread interrupted.");
           }
           finally {
                if(null!=cdt)cdt.countDown();
            }
       }
}
