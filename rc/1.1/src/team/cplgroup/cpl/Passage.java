package team.cplgroup.cpl;
import java.util.ArrayList;
import java.util.List;

public class Passage {
	private String user;
	private List<String> main;
	private List<String> tag;
	private int hotIndex;
	private int commentNum;
	
	public Passage(){
		main=new ArrayList<String>();
		tag=new ArrayList<String>();
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public List<String> getMain() {
		return main;
	}
	public void setMain(List<String> main) {
		this.main = main;
	}
	public List<String> getTag() {
		return tag;
	}
	public void setTag(List<String> tag) {
		this.tag = tag;
	}
	public int getHotIndex() {
		return hotIndex;
	}
	public void setHotIndex(int hotIndex) {
		this.hotIndex = hotIndex;
	}
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	
	
}
