package apimanagement;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import exceptions.InvalidAPIKeyException;


public class APIManager{
	public static void main(String[] args){
		new APIManager();
		
	}
	public APIManager(){
		AuthorizationKey _key=new AuthorizationKey(2469292,"Ani7BBxR23nXoxP7aE7G6vFRwRNOvMUOehQAnWvBVTYGaZvu78z8xfWSH3B2SOrj");
		try {
			verify(_key);
		} catch (InvalidAPIKeyException e) {
			e.report();
		} 
	}
	
	
	/**
	 * Checks AuthKey has the required AccessMasks and exists
	 * @param key
	 * @throws InvalidAPIKeyException
	 */
	public void verify(AuthorizationKey key) throws InvalidAPIKeyException{
		try {
			String url=new APIURLFactory().getURLAsString(APIURLFactory.KEYINFO,key);
			Document doc=Jsoup.connect(url).get();
			Elements checklist=doc.getElementsByTag("key");
			boolean valid=checklist.size()>0;
			if(!valid){
				throw new InvalidAPIKeyException(key);
			}
			
			
			Element keyrow=checklist.first();			
			String keytype=keyrow.attr("type");
			//TODO: Everything
			
			 /*
			 *AccessMaskCalculator amc=new AccessMaskCalculator();
			 *amc.testMask(keyrow.attr("accessMask"));
			 */
			
			
			
			
			
		} catch (IOException e) {
			throw new InvalidAPIKeyException(key);
		}
		
		
	}
	
}
