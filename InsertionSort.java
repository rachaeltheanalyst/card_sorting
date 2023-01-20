/**
 *  Class that implements insertion sort algorithm
 */
public class InsertionSort {
  /**
   *  Sort the Cards in the list by using insertion sort algorithm
   *  @param unsorted unsorted list of Card
   *  @param record an object of SortRecorder class for displaying graphical snapshot of merge steps
   *  @return the sorted CardPile
   */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    record.add(unsorted);

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

      // register the new state with the recorder:
      record.next();         // tell it this is a new step
      record.add(sorted);   // the allegedly sorted pile
      record.add(unsorted);  // the unsorted pile
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

