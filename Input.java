import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Input {
	
	//read in data from the input medium and feed it into line storage
	public void parse(String file, LineStorage lines) throws FileNotFoundException {
		
		//create a scanner for the input medium
		InputStream inputMedium = getClass().getResourceAsStream(file);
		Scanner scanner = new Scanner(inputMedium);
		
		//read from the input medium and add data to line storage
		String line;
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			for (int i = 0; i < line.length(); i++) {
				lines.addChar(line.charAt(i));
			}
			lines.addChar('\n');
		}
		
		scanner.close();
	}
}
