
public class Alphabetizer {
	
	int indices[];
	CircularShifter shifter;
	
	//finds the alphabetic ordering of the shifter
	public void alpha(CircularShifter shifter) {
		this.shifter = shifter;
		
		//determine alphabetic order
		String words[] = new String[shifter.getLineCount()];
		for (int i = 0; i < words.length; i++) {
			words[i] = shifter.getWord(i, 0);
		}
		indices = makeSortedIndexArray(words);
	}
	
	//returns the line from the shifter with the index adjusted to be alphabetized
	public String getLine(int lineNum) {
		
		//handle out of bounds lineNum
		if (lineNum >= shifter.getLineCount()) {
			return "";
		}
		
		//get the line and convert it to a string
		String line = shifter.getWord(indices[lineNum], 0);
		for (int i = 1; i < shifter.getWordCount(indices[lineNum]); i++) {
			line += " ";
			line += shifter.getWord(indices[lineNum], i);
		}
		
		return line;
	}
	
	//return the number of lines
	public int getLineCount() {
		return shifter.getLineCount();
	}
	
	//quick and dirty index array generator
	//(I didn't want to distract from the architecture with a custom comparator class)
	private int[] makeSortedIndexArray(String[] words) {
		
		//initialize the index array
		int indices[] = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			indices[i] = i;
		}
		
		//sort indices based on the element in words pointed to by the index
		int temp;
		boolean swapped;
		for (int i = 0; i < indices.length - 1; i++) {
			swapped = false;
			for (int j = 0; j < indices.length - i - 1; j++) {
				if (words[indices[j]].compareTo(words[indices[j + 1]]) > 0) {
	                     
					//swap elements
					temp = indices[j];
					indices[j] = indices[j + 1];
					indices[j + 1] = temp;
					swapped = true;
				}
			}
	 
			//if no elements were swapped, break
			if (swapped == false)
				break;
		}
		
		return indices;
	}
}
