package apimanagement;

public class AccessMask {
	private int mask;
	private String name;
	
	public AccessMask(int mask,String name){
		this.mask=mask;
		this.name=name;
	}
	
	public int getMask(){
		return mask;
	}
	public String getName(){
		return name;
	}
}
