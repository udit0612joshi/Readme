
public class Shop   {
public static void main(String[] args) {
	Phone p = new PhoneBuilder().setOs("Android").setBattery(45000).setRam(3).getPhone();
	System.out.println(p);
}
}
