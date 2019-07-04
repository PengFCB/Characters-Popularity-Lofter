import java.util.List;

public class herohot {
    private String name;
    private List<String> tags;
    private int[]taghot={0};
    private int hotnum=0;
    private List<String>comm;
    herohot(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public List<String> getTags() {
        return tags;
    }

    public int getTaghot(String name) {
        if(tags.contains(name))return taghot[tags.lastIndexOf(name)];
        else throw new NullPointerException();
    }

    public int getHotnum() {
        return hotnum;
    }

    public List<String> getComm() {
        return comm;
    }

    public void addtag(String tag){
        if(!tags.contains(tag))tags.add(tag);
    }
    public void tagcon(String tag){
        if(tags.contains(tag)){
            taghot[tags.lastIndexOf(tag)]=taghot[tags.lastIndexOf(tag)]+1;
            hotnum=hotnum+1;
        }
        else throw new ArrayIndexOutOfBoundsException();
    }
    public void addcomm(String comm){
        if(!this.comm.contains(comm))this.comm.add(comm);
    }
}
