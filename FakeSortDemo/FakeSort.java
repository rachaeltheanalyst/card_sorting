/**
 *  Program pretends to sort cards, and demonstrates use of a recorder.
 *
 */
public class FakeSort {
  
  /** This method actually doesn't sort at all */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
      
    // register the starting configuration with the recorder
    record.add(unsorted);

    // Now move cards from one list to another, 
    // and use the recorder to record the steps along the way.
    // In a real implementation, you would actually sort the list.
    // Here, we just move them in the same order they came in
    CardPile sorted = new CardPile();

    // Card c1 = unsorted.removeFirst();
    // Card c2 = unsorted.removeLast();

    // System.out.println(c1 + " vs. " + c2);
    
    // if (c1.compareTo(c2) > 0) {
    //   System.out.println("C1 is bigger!");
    // } else {
    //   System.out.println("C2 is bigger!");
    // }
      
    while (unsorted.size() > 0) {
      // move one card between piles
      sorted.add(unsorted.removeFirst());

      // register the new state with the recorder:
      record.next();         // tell it this is a new step
      record.add(sorted);   // the allegedly sorted pile
      record.add(unsorted);  // the unsorted pile
    }

    // return the (un)sorted result here
    return sorted;
  }
}