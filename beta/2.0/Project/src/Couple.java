import java.util.List;


public class Couple implements Comparable<Couple>{
    private String tag;
    private int hotIndex;
    private List<String> hero;
    
    public Couple(){
    	this.setHotIndex(0);
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getHotIndex() {
        return hotIndex;
    }

    public void setHotIndex(int hotIndex) {
        this.hotIndex = hotIndex;
    }

    public List<String> getHero() {
        return hero;
    }

    public void setHero(List<String> hero) {
        this.hero = hero;
    }
    
    public void addHot(int add){
    	hotIndex=hotIndex+add;
    }
    public void resetHot(){
    	this.setHotIndex(0);
    }
    
    @Override
    public int compareTo(Couple cp){
    	return cp.hotIndex-this.hotIndex;
    }
    
}
