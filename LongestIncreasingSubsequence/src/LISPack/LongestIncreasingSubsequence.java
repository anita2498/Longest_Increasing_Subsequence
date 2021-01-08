package LISPack;
import java.util.*;

public class LongestIncreasingSubsequence {

    int[] numbers = {2,3,4,6,1,9,12,14,16,37,99,98,97,0,-1,10};

	    public Integer[] getLongestIncreasingSubsequence() {

	        List<Integer[]> sequences = new ArrayList<>();
	        Stack<Integer> entries = new Stack<>();
	        for (int r = 0; r < this.numbers.length; r++) {
                Integer entry = this.numbers[r];
                if (entries.empty()) {
	                entries.push(entry);
	                continue;
	            }
	            Integer previous = entries.peek();
	            if (previous < entry) {
	                entries.push(entry);
	            }
	            boolean atTheEnd = (r == this.numbers.length - 1);
	            if (previous >= entry || atTheEnd) {
	                sequences.add(toArray(entries));
	                entries.push(entry);
	            }
	        }
	        return longest(sequences);
	    }
	    
	    public Integer[] longest(List<Integer[]> candidates) {
	        TreeMap<Integer, Integer[]> byLength = new TreeMap<>();
	        for (Integer[] candidate: candidates) {
	            byLength.put(candidate.length, candidate);
	        }
	        return byLength.lastEntry().getValue();
	    }
	    
	    private Integer[] toArray(Stack<Integer> entries) {
	        Integer[] sequence = new Integer[entries.size()];
	        int idx = entries.size() - 1;
	        Integer sequenceEntry = entries.pop();
	        while (sequenceEntry != null) {
	            sequence[idx] = sequenceEntry;
	            try {
	                sequenceEntry = entries.pop();
	            } catch (EmptyStackException e) {
	                break;
	            }
	            idx--;
	        }
	        return sequence;
	    }


}
