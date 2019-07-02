package lofter;

public class Count implements Comparable<Count>{
	private String tag;
	private int count;
	
	Count(){
		count=0;
	}
	Count(String tag){
		this.tag=tag;
		count=0;
	}
	Count(String tag,int count){
		this.tag=tag;
		this.count=count;
	}
	
	void add(){
		count++;
	}
	
	String getTag(){
		return tag;
	}
	int getCount(){
		return count;
	}
	
	@Override
	public int compareTo(Count c){
		return c.getCount()-this.count;
	}
}
