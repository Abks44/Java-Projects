import java.util.HashMap;

public class IDandPasswords {

	HashMap<String, String> logininfo = new HashMap<String, String>();

	 IDandPasswords() {
		 logininfo.put("Abks", "cake");
		 logininfo.put("Bro", "abcd");
		 logininfo.put("Broversus", "1234");
	 }
	 
	 protected HashMap getLoginInfo() {
		 return logininfo;
	 }
}