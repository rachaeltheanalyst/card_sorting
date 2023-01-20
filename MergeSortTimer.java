import java.util.ArrayDeque;

/**
 *  Program pretends to sort cards, omitting graphics
 */
public class MergeSortTimer {

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
   *  Sort the Cards in the list by using merge sort algorithm
   *  @param unsorted unsorted list of Card
   *  @return the sorted CardPile
   */
  public static CardPile sort(CardPile unsorted) {

    ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>();

    // placing each element of unsorted into its own new singleton CardPile
    // and add all those piles to a queue.
    for (int i = 1; i < unsorted.size(); i++) {
      CardPile cardsPile = new CardPile();
      cardsPile.addFirst(unsorted.get(i));
      queue.add(cardsPile);
    }
    // while more than one list remains on the queue
    CardPile firstPile, secondPile, mergedPile;
    while (queue.size()>1) {
      // take the smaller of the two off the front of the queue
      firstPile = queue.removeFirst();
      secondPile = queue.removeFirst();
      // call sortPreservingMerge to merge them
      mergedPile = sortPreservingMerge(firstPile, secondPile);
      // put the merged CardPile at the end of the queue
      queue.addLast(mergedPile);
    }
    // return the sorted result here
    return queue.remove();
  }

  /**
   *  Merge the 2 card lists by using merge sort algorithm
   *  @param firstPile 1st CardPile to be merged
   *  @param secondPile 2nd CardPile to be merged
   *  @return the merged CardPile
   */
  private static CardPile sortPreservingMerge(CardPile firstPile, CardPile secondPile) {
    CardPile mergedPile = new CardPile();

    // while neither firstPile nor secondPile are empty
    while (!firstPile.isEmpty() && !secondPile.isEmpty()) {
      // if first Card in firstPile smaller than first Card in secondPile
      if (firstPile.getFirst().compareTo(secondPile.getFirst()) < 0 ) {
        // add the first Card in firstPile to the mergedPile
        mergedPile.addLast(firstPile.removeFirst());
      } else {
        // add the first Card in secondPile to the mergedPile
        mergedPile.addLast(secondPile.removeFirst());
      }
    }
    // append any remaining firstPile or secondPile to mergedPile
    if (!firstPile.isEmpty()) {
      mergedPile.append(firstPile);
    } else if (!secondPile.isEmpty()) {
      mergedPile.append(secondPile);
    }
    return mergedPile;
  }
}


