
public class Output {
	
	//print each line in the alphabetizer to system.out
	public void print(Alphabetizer alphabetizer) {
		for (int i = 0; i < alphabetizer.getLineCount(); i++) {
			System.out.println(alphabetizer.getLine(i));
		}
	}
}
