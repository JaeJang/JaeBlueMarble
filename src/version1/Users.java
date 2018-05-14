package version1;



/**
 * @author JaeHyeok
 * @version 1.0
 */
public class Users {
	
	private String name;
	private static int usernumber;
	
	public Users(String username){
		
		name = username;
		usernumber++;
		
	}
	
	public String getName(){
		return name;
	}
	
	public int setUsernumber(){
		return usernumber++;
	}
	
	public int getUsernumber(){
		return usernumber;
	}
	
	public String toString(){
		return usernumber + name;
	}

}
