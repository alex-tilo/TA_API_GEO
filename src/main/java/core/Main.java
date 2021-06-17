package core;

public class Main {

	public static void main(String[] args) {
		System.out.println("USAGE: " + "\n" + "mvn site && open ./target/site/allure-maven-plugin/index.html" + "\n"
				+ "mvn clean site -Dtest=testGeoPlugin && open ./target/site/allure-maven-plugin/index.html"
				+ "");
	}
}
