package cossim;

import cossim.CosSim;

public class Main {
	public static void main(String[] args) {
		String A = "ala ma kota";
		String B = "kota ma ala";
		double similarity;
		similarity = CosSim.cosineSimilarity(A,B);
		System.out.println(similarity);
	}
}
