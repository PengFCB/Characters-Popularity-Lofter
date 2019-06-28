import java.util.List;

public class tagdev {
    private hero[] hh;
    private tag[] tg;
    private page[]pg;
    private pagehot[] pgh;
    tagdev(hero[] h, tag[] t, page[]p, pagehot[]ph){
        hh=h;
        tg=t;
        pg=p;
        pgh=ph;
    }
    public void rename(){
        for(page pp : pg){
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
        for(pagehot pp : pgh){
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
        for(page pp : pg){
            List<String> tag=pp.getTag();
            for (tag tt : tg) {
                if(tag.contains(tt.getTag())){
                    tag.remove(tt.getTag());
                    tag.addAll(tt.getHero());
                    pp.setTag(tag);
                }
            }
        }
        for(pagehot pp : pgh){
            List<String> tag=pp.getTag();
            for (tag tt : tg) {
                if(tag.contains(tt.getTag())){
                    tag.remove(tt.getTag());
                    tag.addAll(tt.getHero());
                    pp.setTag(tag);
                }
            }
        }
    }

    public page[] getPg() {
        return pg;
    }

    public pagehot[] getPgh() {
        return pgh;
    }
}
