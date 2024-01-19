import java.util.ArrayList;
import java.util.List;

public class LineStorage {
	
	List<List<String>> lines; //list of lines, which are lists of words
	
	public LineStorage() {
		lines = new ArrayList<List<String>>(); //create data structure for lines
		lines.add(new ArrayList<String>()); //initialize first line
		lines.get(0).add(""); //initialize first word
	}
	
	//receives characters and inserts them into the data structure
	public void addChar(char nChar) {
		switch (nChar) {
		case ' ': //start new word
			lines.get(lines.size()-1).add("");
			break;
		case '\n': //start new line with an initialized word
			lines.add(new ArrayList<String>());
			lines.get(lines.size()-1).add("");
			break;
		default: //append char to last word
			List<String> lastLine = lines.get(lines.size()-1);
			int lastWordIndex = lastLine.size()-1;
			lastLine.set(lastWordIndex, lastLine.get(lastWordIndex) + nChar);
			break;
		}
	}
	
	//return the word if it exists
	public String getWord(int lineNum, int wordNum) {
		
		//handle out of bounds
		if (lines.size() <= lineNum || lines.get(lineNum).size() <= wordNum) {
			return "";
		}
		return lines.get(lineNum).get(wordNum);
	}
	
	//return the number of words in a line
	public int getWordCount(int lineNum) {
		
		//handle out of bounds
		if (lines.size() <= lineNum) {
			return -1;
		}
		
		//ignore trailing blank words
		if (lines.get(lineNum).get(lines.get(lineNum).size()-1) == "") {
			return lines.get(lineNum).size() - 1;
		} else {
			return lines.get(lineNum).size();
		}
	}
	
	//return the number of lines
	public int getLineCount() {
		
		//ignore trailing blank lines
		List<String> lastLine = lines.get(lines.size()-1);
		if (lastLine.size() == 0 || (lastLine.size() == 1 && lastLine.get(0) == "")) {
			return lines.size() -1;
		} else {
			return lines.size();
		}
	}
	
	//print the data structure to system.out
	public void consoleDump() {
		for (List<String> line : lines) {
			for (String word : line) {
				System.out.print(word + ' ');
			}
			System.out.println();
		}
	}
}
