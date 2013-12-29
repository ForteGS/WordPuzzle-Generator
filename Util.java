import java.util.Random;
import java.util.Scanner;

/**
 * A collection of utility methods that must be used by your WordSearch program
 * to facilitate our ability to accurate test your results.
 * 
 * Do not edit, except to add word lists.  Leave existing word lists in place.
 */
public class Util {

	/** 
	 * Max number of times your WordSearch will attempt to randomly
	 * place a word in the word search field.  This is intended to 
	 * avoid the potential for an infinite loop should a word not 
	 * be able to placed without conflict in the current version of 
	 * the puzzle.
	 */
	public static final int SEARCH_CAP = 3;

	/** 
	 * A seed value is used to create a deterministic random number generator.
	 * A different seed value will mean a different order of random numbers
	 * are generated. But, using the same seed value in multiple runs,
	 * should mean that the same numbers are "randomly" generated each time.
	 * 
	 * This is useful for testing different parts of your program.
	 */
	public static final int SEED = 10;

	/** 
	 * Use this Random Number Generator for all random numbers
	 * that must be generated.
	 */
	public static final Random RNG = new Random(SEED);

	/** 
	 * Use this Scanner object for all user input.
	 * Do not create your own scanner instance.
	 */
	public static final Scanner input = new Scanner(System.in);

	/** 
	 * An empty word list.
	 * It is a non-null String array with a length of zero.
	 */
	public static final String [] EMPTY_LIST = { };


	// Constants used for directions.  Do not redefine these constants in your
	// program.  Use the constants by name, or risk losing points when we
	// change the values of these constants during testing.

	/** Indicates that word will be placed going up (North) in the puzzle. */
	public static final int NORTH = 1;

	/** Indicates that word will be placed going up and right (Northeast) in the puzzle. */
	public static final int NORTH_EAST = 2;

	/** Indicates that word will be placed going right (East) in the puzzle. */
	public static final int EAST = 3;

	/** Indicates that word will be placed going down and right (Southeast) in the puzzle. */
	public static final int SOUTH_EAST = 4;

	/** Indicates that word will be placed going down (South) in the puzzle. */
	public static final int SOUTH = 5;

	/** Indicates that word will be placed going down and left (Southwest) in the puzzle. */
	public static final int SOUTH_WEST = 6;

	/** Indicates that word will be placed going left (West) in the puzzle. */
	public static final int WEST = 7;

	/** Indicates that word will be placed going up and left (Northwest) in the puzzle. */
	public static final int NORTH_WEST = 8;


	/** 
	 *  List of all possible directions. Use this array when searching for a direction
	 *  to place a word.
	 */
	public static final int[] DIRECTIONS = {NORTH, NORTH_EAST, EAST, SOUTH_EAST,
		SOUTH, SOUTH_WEST, WEST, NORTH_WEST};

	/** Indicates number of possible directions that words can be placed. */
	public static final int NUM_DIRECTIONS = DIRECTIONS.length;

	/**
	 * A 2D array of Strings representing a list of word lists. When the user wants to select 
	 * a predefined list, the number they enter corresponds to the lists here. If they enter 
	 * "1", the list used will be WORD_LIST[0]. 
	 */
	private static final String[][] WORD_LIST = {
		{"java","is","fun"},                              // LIST 1
		{"smoke"},                                        // LIST 2
		{"smoke", "hatch", "tiger", "chair", "pound",     // LIST 3
			"stoic", "canoe", "under", "oasis", "album"},
		{"import", "public", "static", "final", "int",    // LIST 4
				"class", "if", "else", "return", "char", 
				"double","boolean","java"
		}
	};

	/** Returns the number of available predefined WORD LISTS. */
	public static int getNumLists() { 
		return WORD_LIST.length; 
	}

	/** 
	 * Select one of the available wordlists.
	 * 
	 * @param listNum  An integer value from 1 to number of lists
	 * that have been predefined.
	 * @return A one dimensional array of String sequences or an
	 * empty String array if the list number was not valid.
	 */
	public static String[] getList(int listNum) {
		if ( listNum >= 1 && listNum <= WORD_LIST.length )
			return WORD_LIST[listNum-1];
		else
			return EMPTY_LIST;  // no word list at that index
	}

	/** 
	 * Converts all characters to lowercase and removes any non alphabetic 
	 * characters.  Must be called to ensure no invalid words are added to the
	 * word search.
	 * 
	 * The Util.sanitize() method works on a line at a time. If the user enters
	 * words with spaces or non-alphabetical characters, 
	 * they will simply be removed. 
	 * 
	 * For example, if the argument is the string "Word Search", 
	 * then the String "wordsearch" is what is returned.
	 * 
	 * @param word The word or phrase to sanitize
	 * @return A word with only the letters a-z and without invalid characters.
	 */
	public static String sanitize(String word){
		word = word.toLowerCase(); // only lowercase letters are valid
		String sanitizedWord = "";
		for( int i = 0; i < word.length(); i++ ){
			char c = word.charAt(i);
			if( c >= 'a' && c <= 'z' )
				sanitizedWord += c; // append next valid character
		}
		return sanitizedWord;
	}


}