/**
 *  Program pretends to sort cards, omitting graphics
 */
public class SelectionSortTimer {

  /** Starts the program running */
  public static void main(String args[]) {
    
    if (args.length<1) {
      System.err.println("Please specify how many cards to sort!");
    } else {
      Card[] deck = Card.newDeck(true);
      CardPile cards = new CardPile();
      
      for (int i = 0; i < Integer.parseInt(args[0]); i++) {
        cards.add(deck[(int)(52*Math.random())]);
      }
      sort(cards);
    }
  }

  /**
   *  Sort the Cards in the list by using selection sort algorithm
   *  @param unsorted unsorted list of Card
   *  @return the sorted CardPile
   */
  public static CardPile sort(CardPile unsorted) {

    // here is the result list you will be creating
    CardPile sorted = new CardPile();

    // loop until unsorted is empty:
    while (!unsorted.isEmpty()) {
      // Scan unsorted for the smallest remaining element.
      int smallestElementIdx = scanUnsorted(unsorted);

      // remove that element from unsorted and add it to the tail of sorted.
      Card smallestElement = unsorted.get(smallestElementIdx);
      unsorted.remove(smallestElementIdx);
      sorted.addLast(smallestElement);

    }
    // return the sorted result here
    return sorted;
  }

  /**
   *  Find the index of the smallest element in the unsorted list
   *  @param unsorted the unsorted list
   *  @return the index of the smallest element in the unsorted list
   */
  private static int scanUnsorted(CardPile unsorted) {
    Card smallestCard = unsorted.get(0);
    int smallestCardIdx = 0;
    // loop through all the nodes
    for (int i = 1; i < unsorted.size(); i++) {
      // keeping the index of the smallest element
      if (unsorted.get(i).compareTo(smallestCard) < 0 ) {
        smallestCard = unsorted.get(i);
        smallestCardIdx = i;
      }
    }
    // return the index of the smallest element
    return smallestCardIdx;
  }
}
