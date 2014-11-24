package apimanagement;

import java.io.IOException;
import java.util.ArrayList;

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
		ArrayList<AccessMask> maskList=new ArrayList<AccessMask>();
		maskList.add(AccessMaskCalculator.ACCOUNTBALANCE);
		maskList.add(AccessMaskCalculator.ASSETLIST);
		maskList.add(AccessMaskCalculator.INDUSTRYJOBS);
		maskList.add(AccessMaskCalculator.MARKETORDERS);
		maskList.add(AccessMaskCalculator.WALLETJOURNAL);
		maskList.add(AccessMaskCalculator.WALLETTRANSACTIONS);
		try {
			verify(_key,maskList);
		} catch (InvalidAPIKeyException e) {
			e.report();
		} 
	}
	
	
	/**
	 * Checks AuthKey exists and is a corporation key, verifies mask access
	 * @param key
	 * @param maskList
	 * @throws InvalidAPIKeyException
	 */
	public void verify(AuthorizationKey key, ArrayList<AccessMask> maskList) throws InvalidAPIKeyException{
		try {
			String url=new APIURLFactory().getURLAsString(APIURLFactory.KEYINFO,key);
			Document doc=Jsoup.connect(url).get();
			Elements checklist=doc.getElementsByTag("key");
			boolean valid=checklist.size()>0;
			if(!valid){
				throw new InvalidAPIKeyException(key, InvalidAPIKeyException.INVALIDURL);
			}
			
			
			Element keyrow=checklist.first();			
			String keytype=keyrow.attr("type");
			String amask=keyrow.attr("accessMask");
			
			if(keytype.equals("Corporation")){
				key.setAccessMask(amask);
				key.setAccessType(keytype);
				
				AccessMaskCalculator amc=new AccessMaskCalculator();
				if(amc.confirmAll(maskList, key.getAccessMask())){
					/*
					 * Key is correct
					 */
				}else throw new InvalidAPIKeyException(key, InvalidAPIKeyException.INCOMPLETEMASK);
			}else throw new InvalidAPIKeyException(key, InvalidAPIKeyException.BADACCESSTYPE);
		} catch (IOException e) {
			throw new InvalidAPIKeyException(key, InvalidAPIKeyException.INVALIDURL);
		}
		
		
	}
	
}
