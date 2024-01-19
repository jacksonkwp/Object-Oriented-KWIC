
public class CircularShifter {
	
	LineStorage lines;
	
	//circularly permute all lines in lines
	public void setup(LineStorage lines) {
		this.lines = lines;
		
		//circularly permute each line
		int initialLineCount = lines.getLineCount();
		for (int i = 0; i < initialLineCount; i++) {
			
			//create all permutations of line i
			int wordCount = lines.getWordCount(i);
			for (int j = 1; j < wordCount; j++) {
				
				//create rotated line to start with jth word of line i
				String line = "";
				for (int k = 0; k < wordCount; k++) {
					line += lines.getWord(i, (j+k)%wordCount);
					line += " ";
				}
				
				//store shifted line
				for (int k = 0; k < line.length(); k++) {
					lines.addChar(line.charAt(k));
				}
				lines.addChar('\n');
			}
		}
	}
	
	//return the word if it exists
	public String getWord(int lineNum, int wordNum) {
		return lines.getWord(lineNum, wordNum);
	}
		
	//return the number of words in a line
	public int getWordCount(int lineNum) {
		return lines.getWordCount(lineNum);
	}
		
	//return the number of lines
	public int getLineCount() {
		return lines.getLineCount();
	}
}
