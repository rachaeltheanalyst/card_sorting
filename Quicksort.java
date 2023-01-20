/**
 *  Class that implements quick sort algorithm
 */
public class Quicksort {
  /**
   *  Sort the Cards in the list by using quick sort algorithm
   *  @param unsorted unsorted list of Card
   *  @param record an object of SortRecorder class for displaying graphical snapshot of merge steps
   *  @return the sorted CardPile
   */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {

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

    // register the partitions with the recorder
    record.add(smaller);
    record.add(pivot);
    record.add(bigger);
    record.next();

    // the assembled result
    CardPile result = new CardPile();

    // make recursive calls on the partitions
    CardPile smallerPile = sort(smaller, record);
    CardPile biggerPile = sort(bigger, record);

    // glue the results back together with the pivot in the middle
    result.append(smallerPile);
    result.append(pivot);
    result.append(biggerPile);

    // record the sorted result
    record.add(result);
    record.next();

    // return the sorted result here
    return result;
  }
}

