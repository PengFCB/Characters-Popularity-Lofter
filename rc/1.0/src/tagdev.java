import java.util.ArrayList;
import java.util.List;

public class tagdev {
    private hero[] hh;
    private tag[] tg;
    private lofter[]pg;
    private Passage[] pgh;
    tagdev(hero[] h, tag[] t, lofter[]p, Passage[]ph){
        hh=h;
        tg=t;
        pg=p;
        pgh=ph;
    }
    public void rename(){
        for(lofter pp : pg){
            List<String> tag=pp.getTag();
            for(hero ho:hh){
                List<String>onl=ho.getWord();
                for(String on:onl){
                    if(tag.contains(on)){
                        tag.remove(on);
                        tag.add(ho.getHero().get(0));
                        pp.setTag(tag);
                    }
                }
            }
        }
        for(Passage pp : pgh){
            List<String> tag=pp.getTag();
            for(hero ho:hh){
                List<String>onl=ho.getWord();
                for(String on:onl){
                    if(tag.contains(on)){
                        tag.remove(on);
                        tag.add(ho.getHero().get(0));
                        pp.setTag(tag);
                    }
                }
            }
        }
    }
    public void devcp(){
        for(lofter pp : pg){
            List<String> tag=pp.getTag();
            for (tag tt : tg) {
                if(tag.contains(tt.getTag())){
                    tag.remove(tt.getTag());
                    for(String hh:tt.getHero()){
                        if(tag.contains(hh))continue;
                        tag.add(hh);
                    }
                    pp.setTag(tag);
                }
            }
        }
        for(Passage pp : pgh){
            List<String> tag=pp.getTag();
            for (tag tt : tg) {
                if(tag.contains(tt.getTag())){
                    tag.remove(tt.getTag());
                    for(String hh:tt.getHero()){
                        if(tag.contains(hh))continue;
                        tag.add(hh);
                    }
                    pp.setTag(tag);
                }
            }
        }
    }
    public void removedup() {
        List<String> namelist = new ArrayList<String>();
        List<String>del=new ArrayList<String>();
        for (hero ho : hh) namelist.addAll(ho.getHero());
        for (lofter pp : pg) {
            List<String> tag = pp.getTag();
            for(String tags:tag){
                if(namelist.contains(tags))continue;
                else del.add(tags);
            }
            tag.removeAll(del);
            pp.setTag(tag);
            del.clear();
        }
        del.clear();
        for (Passage pp : pgh) {
            List<String> tag = pp.getTag();
            for(String tags:tag){
                if(namelist.contains(tags))continue;
                else del.add(tags);
            }
            tag.removeAll(del);
            pp.setTag(tag);
            del.clear();
        }
    }

    public lofter[] getPg() {
        return pg;
    }

    public Passage[] getPgh() {
        return pgh;
    }
}
