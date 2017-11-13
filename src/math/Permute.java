package math;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * Obtained from https://stackoverflow.com/questions/2920315/permutation-of-array
 */
public class Permute {
	
	private static List<List<Integer>> collectionOfPermutations;
	
	private static void permute(List<Integer> arr){
		permute(arr, 0);
	}
	
	private static void permute(List<Integer> arr, int k) {
		for (int i = k; i < arr.size(); i++) {
			java.util.Collections.swap(arr, i, k);
			permute(arr, k + 1);
			java.util.Collections.swap(arr, k, i);
		}
		if (k == arr.size() - 1) {
			System.out.println(Arrays.toString(arr.toArray()));
			collectionOfPermutations.add(arr);
		}
	}
	
	public static List<List<Integer>> getAllPermutations(List<Integer> arr){
		collectionOfPermutations = new LinkedList<List<Integer>>();
		permute(arr);
		return collectionOfPermutations;
	}
}
