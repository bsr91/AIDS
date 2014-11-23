package apimanagement;

public class URLType {
	private String typeString;
	private String root="https://api.eveonline.com";
	public URLType(String typeString){
		this.typeString=root+typeString;
	}
	
	public String getString(){
		return typeString;
	}
}
