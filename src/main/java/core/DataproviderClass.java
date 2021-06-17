package core;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataproviderClass {
	@DataProvider(name = "scenarios")
	public Object[][] getDataFromDataprovider(Method m) {
		if (m.getName().equalsIgnoreCase("schemaGetProfileEH")) {
			return new Object[][] { { "eh_01" }, { "eh_02" }, { "eh_03" }, { "eh_04" }, { "eh_05" }, { "eh_06" } };
		} else {
			return new Object[][] { { "01" }, { "02" }, { "03" }, { "04" }, { "05" } };
		}
	}
}
