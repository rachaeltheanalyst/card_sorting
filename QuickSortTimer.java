import java.util.ArrayDeque;

/**
 *  Program pretends to sort cards, omitting graphics
 */
public class QuickSortTimer {

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
   *  Sort the Cards in the list by using quick sort algorithm
   *  @param unsorted unsorted list of Card
   *  @return the sorted CardPile
   */
  public static CardPile sort(CardPile unsorted) {

    // stop condition is a list with 0 or 1 elements
    if (unsorted.isEmpty() || unsorted.size() <= 1) {
      return unsorted;
    }

    // create two partitions
    CardPile smaller = new CardPile();
    CardPile bigger = new CardPile();

    // take the first element as the pivot
    CardPile pivot = new CardPile();
    Card pivotCard = unsorted.getFirst();
    pivot.addFirst(pivotCard);

    // pull the remaining elements off the list one at a time and append them to either of two new sublists:
    // one for elements less than the pivot and one for elements greater than or equal to the pivot.
    for (int i = unsorted.size() - 1; i >= 1; i--) {
      if (unsorted.get(i).compareTo(pivotCard) < 0) {
        smaller.addFirst(unsorted.get(i));
      } else {
        bigger.addFirst(unsorted.get(i));
      }
    }

    // the assembled result
    CardPile result = new CardPile();

    // make recursive calls on the partitions
    CardPile smallerPile = sort(smaller);
    CardPile biggerPile = sort(bigger);

    // glue the results back together with the pivot in the middle
    result.append(smallerPile);
    result.append(pivot);
    result.append(biggerPile);

    // return the sorted result here
    return result;
  }
}


