

public class cardTest{
	public static void main(String args[]) {
		int[] deck = new int[52];
		for (int i = 0; i < deck.length; ++i) deck[i] = i;

		CardDeck.Shuffle(deck, 100);

		int[] arr2 = new int[4];

		System.arraycopy(deck, 0, arr2, 0, 4);

		for(int i = 0; i < 4; ++i) System.out.print(arr2[i] + " ");
		java.util.Arrays.sort(arr2);

		System.out.println(java.util.Arrays.toString(arr2));
	}
}