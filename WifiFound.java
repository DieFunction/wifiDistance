import java.util.Scanner;

public class WifiFound {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		Wifi found = new Wifi();
		System.out.print("Enter The Name Of The Network : ");
		String essid = input.nextLine();
		input.close();
		while(true){
		try{
			Thread.sleep(1000);
			found.setEssid(essid);
			System.out.println(found.distanceWifi());
			}
		catch(Exception x ){
			continue;
		}
	}
	}
}
