package LISPack;

public class Main {
	
	 public static void main(String[] args) {
	      longestSubSequence();
    }
	
 public static void longestSubSequence() {
	 LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();

     Integer[] result = longestIncreasingSubsequence.getLongestIncreasingSubsequence();

     System.out.println ("Winning sequence is");
     for (Integer i : result) {
         System.out.println ("number: " + i);
     }
     System.out.println ("End of sequence");
}
}

