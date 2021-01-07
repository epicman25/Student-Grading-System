import java.util.Scanner;

public class Exam {

	public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			float n;
			String name;
			
			try{
				name = scan.nextLine();
				n = scan.nextFloat();
				throw new CovidException(n);
			}
			catch(Exception e){
				
				
			}
		// TODO Auto-generated method stub

	}

}
class CovidException extends Exception{
	CovidException(float temp){
		if(temp>99) {
			System.out.println("Recommonded for COVID-19 Test");
		}
		else {
			System.out.println("You are safe, please follow covid measures");
		}
	}
}