/**
 *  Class that implements insertion sort algorithm
 */
public class SelectionSort {
  /**
   *  Sort the Cards in the list by using selection sort algorithm
   *  @param unsorted unsorted list of Card
   *  @param record an object of SortRecorder class for displaying graphical snapshot of merge steps
   *  @return the sorted CardPile
   */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    record.add(unsorted);

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

      // register the new state with the recorder:
      record.next();         // tell it this is a new step
      record.add(sorted);   // the allegedly sorted pile
      record.add(unsorted);  // the unsorted pile
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

