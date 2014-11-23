package apimanagement;

import java.util.ArrayList;

public class AccessMaskCalculator {
    public static final AccessMask ACCOUNTBALANCE=new AccessMask(1,"AccountBalance");
    public static final AccessMask ASSETLIST=new AccessMask(2,"AssetList");
    public static final AccessMask CALENDAREVENTATTENDEES=new AccessMask(4,"CalendarEventAttendees");
    public static final AccessMask CHARACTERSHEET=new AccessMask(8,"CharacterSheet");
    public static final AccessMask CONTACTLIST=new AccessMask(16,"ContactList");
    public static final AccessMask CONTACTNOTIFICATIONS=new AccessMask(32,"ContactNotifications");
    public static final AccessMask FACWARSTATS=new AccessMask(64,"FacWarStats");
    public static final AccessMask INDUSTRYJOBS=new AccessMask(128,"IndustryJobs");
    public static final AccessMask KILLLOG=new AccessMask(256,"KillLog");
    public static final AccessMask MAILBODIES=new AccessMask(512,"MailBodies");
    public static final AccessMask MAILINGLISTS=new AccessMask(1024,"MailingLists");
    public static final AccessMask MAILMESSAGES=new AccessMask(2048,"MailMessages");
    public static final AccessMask MARKETORDERS=new AccessMask(4096,"MarketOrders");
    public static final AccessMask MEDALS=new AccessMask(8192,"Medals");
    public static final AccessMask NOTIFICATIONS=new AccessMask(16384,"Notifications");
    public static final AccessMask NOTIFICATIONTEXTS=new AccessMask(32768,"NotificationTexts");
    public static final AccessMask RESEARCH=new AccessMask(65536,"Research");
    public static final AccessMask SKILLINTRAINING=new AccessMask(131072,"SkillInTraining");
    public static final AccessMask SKILLQUEUE=new AccessMask(262144,"SkillQueue");
    public static final AccessMask STANDINGS=new AccessMask(524288,"Standings");
    public static final AccessMask UPCOMINGCALENDAREVENTS=new AccessMask(1048576,"UpcomingCalendarEvents");
    public static final AccessMask WALLETJOURNAL=new AccessMask(2097152,"WalletJournal");
    public static final AccessMask WALLETTRANSACTIONS=new AccessMask(4194304,"WalletTransactions");
    public static final AccessMask CHARACTERINFOPUBLIC=new AccessMask(8388608,"CharacterInfoPublic");
    public static final AccessMask CHARACTERINFOPRIVATE=new AccessMask(16777216,"CharacterInfoPrivate");
    public static final AccessMask ACCOUNTSTATUS=new AccessMask(33554432,"AccountStatus");
    public static final AccessMask CONTRACTS=new AccessMask(67108864,"Contracts");
    public static final AccessMask LOCATIONS=new AccessMask(134217728,"Locations");
            
    private ArrayList<AccessMask> maskMap = new ArrayList<AccessMask>();
    
    public AccessMaskCalculator(){
    	maskMap.add(ACCOUNTBALANCE);
        maskMap.add(ASSETLIST);
        maskMap.add(CALENDAREVENTATTENDEES);
        maskMap.add(CHARACTERSHEET);
        maskMap.add(CONTACTLIST);
        maskMap.add(CONTACTNOTIFICATIONS);
        maskMap.add(FACWARSTATS);
        maskMap.add(INDUSTRYJOBS);
        maskMap.add(KILLLOG);
        maskMap.add(MAILBODIES);
        maskMap.add(MAILINGLISTS);
        maskMap.add(MAILMESSAGES);
        maskMap.add(MARKETORDERS);
        maskMap.add(NOTIFICATIONS);
        maskMap.add(MEDALS);
        maskMap.add(NOTIFICATIONTEXTS);
        maskMap.add(RESEARCH);
        maskMap.add(SKILLINTRAINING);
        maskMap.add(SKILLQUEUE);
        maskMap.add(STANDINGS);
        maskMap.add(UPCOMINGCALENDAREVENTS);
        maskMap.add(WALLETJOURNAL);
        maskMap.add(WALLETTRANSACTIONS);
        maskMap.add(CHARACTERINFOPUBLIC);
        maskMap.add(CHARACTERINFOPRIVATE);
        maskMap.add(ACCOUNTSTATUS);
        maskMap.add(CONTRACTS);
        maskMap.add(LOCATIONS);
    }
    public ArrayList<AccessMask> getAllMasks(){
        return maskMap;
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
