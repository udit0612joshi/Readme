enum mobile{
	APPLE(100),SAMSUNG(99),HTC(80);
	int price; 
	
	 mobile(int p)                                  // Create constructor inside enum and set prices
	 {
		 price =p;
	 }
}

public class MobilEnum {
	
public static void main(String[] args) {
	
	
	System.out.println(mobile.APPLE.price);                        //  Fetch the price of mobile
	System.out.println(mobile.SAMSUNG.price);
	System.out.println(mobile.HTC.ordinal());                       // Fetch the order of enum
	
	
	mobile m[] = mobile.values();
	
	for(mobile k : m)                                               // enum as a array
	{
		System.out.println(k); 
	}
	
	
	
}
}
