package exceptions;

import apimanagement.AuthorizationKey;

public class InvalidAPIKeyException extends Exception {
	private static final long serialVersionUID = -4337223239548890491L;
	
	private AuthorizationKey key;
	public static final String INVALIDURL="INVALID URL";
	public static final String INCOMPLETEMASK="INCOMPLETE MASK";
	public static final String BADACCESSTYPE="BAD ACCESS TYPE";

	private String type;
	public InvalidAPIKeyException(AuthorizationKey key, String type){
		super("Invalid API Key");
		this.key=key;
		this.type=type;
	}
	public AuthorizationKey getKey(){
		return key;
	}
	public String getType(){
		return type;
	}
	public void report(){
		System.out.println("Invalid API Key \n"+
				"ID: "+getKey().getKeyID()+"\n"+
				"VCode: "+getKey().getVCode()+"\n"+
				"Type: "+getType());
	}
}
