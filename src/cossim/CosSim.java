package cossim;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CosSim {

	//zwraca HashMap w ktorej sa wszystkie unikatowe slowa wystepujace w stringu i ilosci ich wystapien
	public static Map<String, Integer> getWordFrequencyMap(String[] words) {
		Map<String, Integer> wordFrequencyMap = new HashMap<>();
		for (String word : words) {
			Integer n = wordFrequencyMap.get(word);
			n = (n == null) ? 1 : ++n;
			wordFrequencyMap.put(word, n);
		}
		return wordFrequencyMap;
	}

	public static double cosineSimilarity(String text1, String text2) {
		text1 = text1.toLowerCase();
		text2 = text2.toLowerCase();
		// Zamienianie stringow na wektory
		Map<String, Integer> a = getWordFrequencyMap(text1.split("[\\p{Punct}\\s]+"));
		Map<String, Integer> b = getWordFrequencyMap(text2.split("[\\p{Punct}\\s]+"));

		// Hashset zawiera unikatowe slowa wystepujace w oby dwoch stringach
		HashSet<String> intersection = new HashSet<>(a.keySet());
		intersection.retainAll(b.keySet());

		double dotProduct = 0, magnitudeA = 0, magnitudeB = 0;

		// obliczanie iloczynu skalarnego
		for (String item : intersection) {
			dotProduct += a.get(item) * b.get(item);
		}

		// liczymy metryke eukledisowa vektora a
		for (String k : a.keySet()) {
			magnitudeA += Math.pow(a.get(k), 2);
		}

		// liczymy metryke eukledisowa vektora b
		for (String k : b.keySet()) {
			magnitudeB += Math.pow(b.get(k), 2);
		}

		// zwracamy miare kosunowa
		return dotProduct / Math.sqrt(magnitudeA * magnitudeB);
	}
}