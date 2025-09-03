package seleniumsessions;

public class WaitConcept {

	public static void main(String[] args) throws InterruptedException {
	
		
		//wait - sync between the app and script
		
		Thread.sleep(10000);//static wait
		
		//ele is found in 2 secs
		//ele is found in 0 secs
		
		Thread.sleep(3000);

		//ele is found in 7 secs
		
		Thread.sleep(10000);
		
		//ele is found in 2 secs

		
		//selenium wait - dynamic wait:
		//1. Implicitly wait
		//2. Explicit Wait
				//2.a: WebDriverWait
				//2.b: FluentWait
		
		//wait/timeout = 15 secs
		//ELE found = 2 secs -- click 
		//ELE found = 0 secs -- click 
		//ELE found = 12 secs -click
		

		


	}

}
