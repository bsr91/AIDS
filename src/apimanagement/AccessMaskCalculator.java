package apimanagement;

import java.util.ArrayList;

public class AccessMaskCalculator {
    public static final AccessMask ACCOUNTBALANCE=new AccessMask(1,"AccountBalance");
    public static final AccessMask ASSETLIST=new AccessMask(2,"AssetList");
    public static final AccessMask MEMBERMEDALS=new AccessMask(4,"MemberMedals");
    public static final AccessMask CORPORATIONSHEET=new AccessMask(8,"CorpSheet");
    public static final AccessMask CONTACTLIST=new AccessMask(16,"ContactList");
    public static final AccessMask CONTAINERLOG=new AccessMask(32,"ContainerLog");
    public static final AccessMask FACWARSTATS=new AccessMask(64,"FacWarStats");
    public static final AccessMask INDUSTRYJOBS=new AccessMask(128,"IndustryJobs");
    public static final AccessMask KILLLOG=new AccessMask(256,"KillLog");
    public static final AccessMask MEMBERSECURITY=new AccessMask(512,"MemberSecurity");
    public static final AccessMask MEMBERSECURITYLOG=new AccessMask(1024,"MemberSecurityLog");
    public static final AccessMask MEMBERTRACKING=new AccessMask(2048,"MemberTrackings");
    public static final AccessMask MARKETORDERS=new AccessMask(4096,"MarketOrders");
    public static final AccessMask MEDALS=new AccessMask(8192,"Medals");
    public static final AccessMask OUTPOSTLIST=new AccessMask(16384,"OutpostList");
    public static final AccessMask OUTPOSTSERVICEDETAIL=new AccessMask(32768,"OutpostServiceDetail");
    public static final AccessMask SHAREHOLDERS=new AccessMask(65536,"ShareHolders");
    public static final AccessMask STARBASEDETAIL=new AccessMask(131072,"StarbaseDetail");
    public static final AccessMask STANDINGS=new AccessMask(262144,"Standings");
    public static final AccessMask STARBASELIST=new AccessMask(524288,"StarbaseList");
    public static final AccessMask WALLETJOURNAL=new AccessMask(1048576,"WalletJournal");
    public static final AccessMask WALLETTRANSACTIONS=new AccessMask(2097152,"WalletTransactions");
    public static final AccessMask TITLES=new AccessMask(4194304,"Titles");
    public static final AccessMask LOCATIONS=new AccessMask(16777216,"Locations");
            
    private ArrayList<AccessMask> corpMaskMap = new ArrayList<AccessMask>();
    
    public AccessMaskCalculator(){
    	corpMaskMap.add(ACCOUNTBALANCE);
        corpMaskMap.add(ASSETLIST);
        corpMaskMap.add(MEMBERMEDALS);
        corpMaskMap.add(CORPORATIONSHEET);
        corpMaskMap.add(CONTACTLIST);
        corpMaskMap.add(CONTAINERLOG);
        corpMaskMap.add(FACWARSTATS);
        corpMaskMap.add(INDUSTRYJOBS);
        corpMaskMap.add(KILLLOG);
        corpMaskMap.add(MEMBERSECURITY);
        corpMaskMap.add(MEMBERSECURITYLOG);
        corpMaskMap.add(MEMBERTRACKING);
        corpMaskMap.add(MARKETORDERS);
        corpMaskMap.add(MEDALS);
        corpMaskMap.add(OUTPOSTLIST);
        corpMaskMap.add(OUTPOSTSERVICEDETAIL);  
        corpMaskMap.add(SHAREHOLDERS);
        corpMaskMap.add(STARBASEDETAIL);
        corpMaskMap.add(STARBASELIST);
        corpMaskMap.add(STANDINGS);
        corpMaskMap.add(WALLETJOURNAL);
        corpMaskMap.add(WALLETTRANSACTIONS);
        corpMaskMap.add(TITLES);
        corpMaskMap.add(LOCATIONS);
    }
    public ArrayList<AccessMask> getAllMasks(){
        return corpMaskMap;
    }
    
    /**
     * Checks a keymask has access to a particular accessMask
     * @param accessMask
     * @param keyMask
     * @return true if access is granted, false otherwise
     */
    public boolean confirmAccess(AccessMask accessMask, int keyMask){
    	int mask=accessMask.getMask();
    	if((mask & keyMask)!=0){
    		return true;
    	}else return false;
    }
    
    /**
     * Sends an array of AccessMasks to be confirmed at confirmAccess()
     * @param maskList
     * @param keyMask
     * @return false if any AccessMask is not confirmed, true otherwise
     */
    public boolean confirmAll(ArrayList<AccessMask> maskList, int keyMask){
    	for(AccessMask mask:maskList){
    		if(confirmAccess(mask,keyMask)){
    			continue;
    		}else return false;
    	}
    	return true;
    }
    
    /**
     * Runs a keymask through confirmAccess() and prints results to console
     * @param keyMask
     */
    public void testMask(int keyMask){
    	System.out.println("----- Checking Access Key: "+keyMask+" -----");
    	for(AccessMask mask:getAllMasks()){
    		if(confirmAccess(mask,keyMask)){
    			System.out.println(mask.getName());
    		}
    	}
    	System.out.println("----- Complete -----");
    }
    /**
     * Catches String keymasks and redirects to testMask(Integer)
     * @param keyMask
     */
    public void testMask(String keyMask){
    	int ikeyMask=Integer.parseInt(keyMask);
    	testMask(ikeyMask);
    }
}
