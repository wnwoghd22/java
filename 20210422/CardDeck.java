public class CardDeck{
	private static char[] suits = { '\u2660', '\u2665', '\u2666', '\u2663' };
	private static String[] ranks = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

	public static void Shuffle(int[] deck, int count) { 
		for(int i = 0; i < count; ++i) {
			int r1 = (int)(Math.random() * deck.length), r2 = (int)(Math.random() * deck.length);
			int temp = deck[r1]; deck[r1] = deck[r2]; deck[r2] = temp;
		}

		for(int i = 0; i < 4; ++i)
			System.out.println(deck[i] + " : " + suits[deck[i] / 13] + ranks[deck[i] % 13]);
	}
}