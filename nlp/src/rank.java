import java.util.*;

public class rank {
    private page[] pg;
    private pagehot[]pgh;
    private TreeMap ranks;
    private TreeMap ranksh;
    private TreeMap ranktt;
    private List<Map.Entry<String, Integer>> list = new ArrayList<>();
    public rank(page[]pg,pagehot[]pgh){
        this.pg=pg;
        this.pgh=pgh;
        int i=0;
        ranks=new TreeMap<String,Integer>();
        ranksh=new TreeMap<String,Integer>();
        ranktt=new TreeMap<String,Integer>();
        for(page pp:this.pg)for(String tags :pp.getTag()){
            assert ranks != null;
            assert ranktt != null;
            if(ranks.containsKey(tags)){
                i=(int)ranks.get(tags);
                i=i+1;
                i=i+pp.getHotIndex();
                i=i+pp.getCommentNum()*10;
                ranks.put(tags,i);
            }
            else{
                ranks.put(tags,1);
            }
            if(ranktt.containsKey(tags)){
                i=(int)ranktt.get(tags);
                i=i+1;
                i=i+pp.getHotIndex();
                i=i+pp.getCommentNum()*10;
                ranktt.put(tags,i);
            }
            else{
                ranktt.put(tags,1);
            }
        }
        for(pagehot pp:this.pgh){
            for(String tags :pp.getTag()){
                assert ranksh != null;
                if(ranksh.containsKey(tags)){
                    i=(int)ranksh.get(tags);
                    i=i+1;
                    i=i+pp.getHotIndex();
                    i=i+pp.getCommentNum()*10;
                    ranksh.put(tags,i);
                }
                else{
                    ranksh.put(tags,1);
                }
                if(ranktt.containsKey(tags)){
                    i=(int)ranktt.get(tags);
                    i=i+1;
                    i=i+pp.getHotIndex();
                    i=i+pp.getCommentNum()*10;
                    ranktt.put(tags,i);
                }
                else{
                    ranktt.put(tags,1);
                }
            }
        }

    }
    public rank(page[]pg){
        this.pg=pg;
        this.pgh=pgh;
        ranks=new TreeMap();
        ranksh=new TreeMap();
        int i=0;
        for(page pp:this.pg)for(String tags :pp.getTag()){
            if(ranks.containsKey(tags)){
                i=(int)ranks.get(tags);
                i=i+1;
                ranks.put(tags,i);
            }
            else{
                ranks.put(tags,i);
            }
        }
    }
    public rank(pagehot[]pgh){
        this.pg=pg;
        this.pgh=pgh;
        ranks=new TreeMap<String,Integer>();
        ranksh=new TreeMap<String,Integer>();
        int i=0;
        for(pagehot pp:this.pgh)for(String tags :pp.getTag()){
            if(ranksh.containsKey(tags)){
                i=(int)ranks.get(tags);
                i=i+1;
                ranksh.put(tags,i);
            }
            else{
                ranksh.put(tags,i);
            }
        }
    }
    public Map getRanksh() {
        return ranksh;
    }

    public Map getRanks() {
        return ranks;
    }

    public void showranks(){
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(ranks.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>() {
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() < o2.getValue() ? 1:-1;
            }
        });
        for( Map.Entry<String, Integer> ee:list){
            System.out.println("话题："+ee.getKey()+"\t 热度："+ee.getValue());
        }
        /*
        String key;
        Integer integ = null;
        Iterator iter = ranks.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next();
            // 获取key
            key = (String)entry.getKey();
            // 获取value
            integ = (Integer)entry.getValue();
            System.out.println("话题："+key+"\t 热度："+integ);
        }
         */
    }
    public void showranksh(){
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(ranksh.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>() {
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() < o2.getValue() ? 1:-1;
            }
        });
        for( Map.Entry<String, Integer> ee:list){
            System.out.println("话题："+ee.getKey()+"\t 热度："+ee.getValue());
        }
        /*String key;
        Integer integ = null;
        Iterator iter = ranksh.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next();
            // 获取key
            key = (String)entry.getKey();
            // 获取value
            integ = (Integer)entry.getValue();
            System.out.println("话题："+key+"\t 热度："+integ);
        }
        */

    }
    public void showranktt(){
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(ranktt.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>() {
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() < o2.getValue() ? 1:-1;
            }
        });
        for( Map.Entry<String, Integer> ee:list){
            System.out.println("话题："+ee.getKey()+"\t 热度："+ee.getValue());
        }
    }
}
