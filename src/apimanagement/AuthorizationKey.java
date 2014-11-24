package apimanagement;

public class AuthorizationKey {
	private int keyID;
	private String vCode;
	
	private int accessMask;
	private String accessType;
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
	
	public int getAccessMask() {
		return accessMask;
	}
	public void setAccessMask(String accessMask) {
		this.accessMask=Integer.parseInt(accessMask);
	}
	public void setAccessMask(int accessMask){
		this.accessMask=accessMask;
	}
	public String getAccessType() {
		return accessType;
	}
	public void setAccessType(String accessType) {
		this.accessType=accessType;
	}
}
