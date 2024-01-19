import java.io.FileNotFoundException;

public class KWIC {

	public static void main(String[] args) {
		
		//run the object oriented implementation for KWIC
		try {
			execute("inputMedium.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Input Medium could not be located.");
		}
	}
	
	public static void execute(String file) throws FileNotFoundException {
		LineStorage lines = new LineStorage();
		Input input = new Input();
		CircularShifter shifter = new CircularShifter();
		Alphabetizer alphabetizer = new Alphabetizer();
		Output output = new Output();
		
		input.parse(file, lines);
		shifter.setup(lines);
		alphabetizer.alpha(shifter);
		output.print(alphabetizer);
	}

}
