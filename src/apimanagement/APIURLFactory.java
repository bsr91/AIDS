package apimanagement;

import java.net.MalformedURLException;
import java.net.URL;

public class APIURLFactory{	
	public static final URLType KEYINFO=new URLType("/account/APIKeyInfo.xml.aspx?");
	public static final URLType CALLIST=new URLType("/api/CallList.xml.aspx?");
		
	public URL getURL(URLType type, AuthorizationKey key) throws MalformedURLException{
		String u=type.getString()+"keyID="+key.getKeyID()+"&vCode="+key.getVCode();
		URL url=new URL(u);
		return url;
	}
	public String getURLAsString(URLType type, AuthorizationKey key) throws MalformedURLException{
		return getURL(type,key).toString();
	}
	

}
