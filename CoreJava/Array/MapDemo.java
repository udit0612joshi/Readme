import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {

	
	
public static void main(String[] args) {
	
	Map<String , String> map = new HashMap<>();
	map.put("name", "udit");
	map.put("city", "indore");

	System.out.println(map);            // implements set so not in same order
	
	
	Set<String> keys = map.keySet();
	
	for(String k : keys)
	{
		System.out.println(map.get(k));
	}
	
	
	
}	
	
}


