package MidEco;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ParseWordList {

	final static String FILE_NAME = "WordList.txt";
	final static Charset ENCODING = StandardCharsets.UTF_8;
	final static int FIRST_NAME_SIZE = 4;
	final static int LAST_NAME_SIZE = 6;
	final static List<String> VOWELS = Arrays.asList("A", "E", "I", "O", "U");
	final protected static HashMap<Integer, String> wordHashMap = new HashMap<Integer, String>();
	protected static List<String> lines = new ArrayList<String>();

	protected List<String> getLines() {
		return lines;
	}

	protected static void setLines(List<String> lines) {
		ParseWordList.lines = lines;
	}

	protected static HashMap<Integer, String> getWordhashmap() {
		return wordHashMap;
	}

	// Imports a text file and converts it to a List.
	protected void importWordList() throws IOException {
		lines = readFile(FILE_NAME);
		log(lines);
		lines.add("This is a line added in code.");
	}

	// Reads the imported text file.
	protected List<String> readFile(String fileName) throws IOException {
		Path path = Paths.get(fileName);
		return Files.readAllLines(path, ENCODING);
	}

	// Populates the HashMap wordList<iterated int,toString()>.
	protected void populateWordListHashMap() {
		// System.out.println(lines.size());
		int hashMapKey = 0;
		for (int i = 0; i < lines.size(); i++) {
			if (validateWord(lines.get(i))) {
				wordHashMap.put(hashMapKey, lines.get(i));
				hashMapKey++;
			}
		}
		for (int i = 0; i < wordHashMap.size(); i++) {
			System.out.println(wordHashMap.get(i));
		}
		System.out.println(wordHashMap.size());

	}

	// Validates that the String is a 4-letter or 6-letter word that is a
	// comprised of consonant+vowels pairs.
	protected static boolean validateWord(String word) {
		if (validateWordSize(word) && validateWordPatternIsConsonantVowelPair(word)) {
			return true;
		}
		return false;
	}

	// Validates that word is either 4-letter or 6-letter word.
	protected static boolean validateWordSize(String word) {
		if (FIRST_NAME_SIZE == splitString(word).size() || LAST_NAME_SIZE == splitString(word).size()) {
			return true;
		}
		return false;
	}

	private static boolean validateWordPatternIsConsonantVowelPair(String word) {
		for (int i = 0; i < splitString(word).size(); i++) {
			if ((i & 1) == 0) {
				if (VOWELS.contains(splitString(word).get(i).toUpperCase())) {
					return false;
				}
			} else {
				if (!VOWELS.contains(splitString(word).get(i).toUpperCase())) {
					return false;
				}
			}
		}
		return true;
	}

	protected static ArrayList<String> splitString(String word) {
		ArrayList<String> splitString = new ArrayList<>();
		String[] splitWord = word.split("");
		for (String splitLetter : splitWord) {
			if (Character.isLetter(splitLetter.charAt(0))) {
				splitString.add(splitLetter);
			}
		}
		return splitString;
	}

	protected void writeBookOfForbiddenNames() {
		// TODO
	}

	protected static void log(Object line) {
		System.out.println(String.valueOf(line));
	}
}
