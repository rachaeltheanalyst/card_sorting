/**
 *  Program pretends to sort cards, omitting graphics
 */
public class InsertionSortTimer {

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
   *  Sort the Cards in the list by using insertion sort algorithm
   *  @param unsorted unsorted list of Card
   *  @return the sorted CardPile
   */
  public static CardPile sort(CardPile unsorted) {

    // Here is the result list you will be creating
    CardPile sorted = new CardPile();

    // loop until unsorted is empty
    while (!unsorted.isEmpty()) {
      // remove the first element from unsorted
      Card cardRemoved = unsorted.removeFirst();

      // if cardRemoved is smaller than smallest (first) element, add it at front
      if (sorted.isEmpty() || sorted.get(0).compareTo(cardRemoved) > 0) {
        sorted.addFirst(cardRemoved);
      } else {
        // find the point where it should go in sorted
        Card cardBeforeInsertion = findSpotInSorted(sorted, cardRemoved);
        // insert the removed element into sorted at this point.
        sorted.insertAfter(cardRemoved, cardBeforeInsertion);
      }
    }
    // return the sorted result here
    return sorted;
  }

  /**
   *  Find the position where it should go in the sorted list
   *  @param sorted the sorted list
   *  @param targetCard the Card to be inserted
   *  @return the Card after which the target card should be inserted
   */
  private static Card findSpotInSorted(CardPile sorted, Card targetCard) {
    int foundCardIndex = 0; // index of the card found
    boolean spotFound = false; // flag to set when card is found

    // loop backwards through list until smaller element found
    for (int i = sorted.size()-1; i >= 0; i--) {
      // find the point where targetCard should go
      if (sorted.get(i).compareTo(targetCard) < 0 && !spotFound) {
        spotFound = true;
        foundCardIndex = i;
      }
    }
    return sorted.get(foundCardIndex);
  }
}


