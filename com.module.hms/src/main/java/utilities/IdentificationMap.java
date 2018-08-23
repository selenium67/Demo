package utilities;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class IdentificationMap {

	@Test
	public void getValueData() {
		
		Map<String, String> data = new HashMap<String,String>();
		
		data.put("UserName", "admin");
		data.put("Password", "admin");
		
		
		data.put("UserName", "demo");
		data.put("Password", "test");
		
		
		System.out.println(data.get("30"));
		System.out.println(data.get("28"));
		System.out.println(data.get("10M"));
		
	}
}
