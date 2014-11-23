package apimanagement;

public class AuthorizationKey {
	private int keyID;
	private String vCode;
	
	public AuthorizationKey(int keyID, String vCode){
		this.keyID=keyID;
		this.vCode=vCode;
	}
	
	public int getKeyID(){
		return keyID;
	}
	public String getVCode(){
		return vCode;
	}
}
