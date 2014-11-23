package exceptions;

import apimanagement.AuthorizationKey;

public class InvalidAPIKeyException extends Exception {
	private static final long serialVersionUID = -4337223239548890491L;
	
	private AuthorizationKey key;

	public InvalidAPIKeyException(AuthorizationKey key){
		super("Invalid API Key");
		this.key=key;
	}
	public AuthorizationKey getKey(){
		return key;
	}
	public void report(){
		System.out.println("Invalid API Key \n"+"ID: "+getKey().getKeyID()+"\n"+"VCode: "+getKey().getVCode());
	}
}
