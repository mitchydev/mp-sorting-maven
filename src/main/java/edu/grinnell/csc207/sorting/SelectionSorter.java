package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * Something that sorts using selection sort.
 *
 * @param <T> The types of values that are sorted.
 *
 * @author Samuel A. Rebelsky
 * @author Mitch Paiva
 */

public class SelectionSorter<T> implements Sorter<T> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The way in which elements are ordered.
   */
  Comparator<? super T> order;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter using a particular comparator.
   *
   * @param comparator The order in which elements in the array should be ordered after sorting.
   */
  public SelectionSorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // SelectionSorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * finds the index of the smallest element in the range of the array.
   *
   * @param values
   * @param start
   *
   * @return least.
   */
  public int indexOfSmallest(T[] values, int start) {
    int least = start;
    for (int j = start + 1; j < values.length; j++) {
      if (order.compare(values[j], values[least]) < 0) {
        least = j;
      } // if
    } // for
    return least;
  } // indexOfSmallest

  /**
   * Swaps values in the array.
   *
   * @param values an array to sort.
   * @param i the index of the first element.
   * @param x the index of the second element.
   *
   * @post The array has been sorted according to some order (often one given to the constructor).
   * @post For all i, 0 &lt; i &lt; values.length, order.compare(values[i-1], values[i]) &lt;= 0
   */
  public void swap(T[] values, int i, int x) {
    T temp = values[i];
    values[i] = values[x];
    values[x] = temp;
  }

  /**
   * Sort an array in place using selection sort.
   *
   * @param values an array to sort.
   *
   * @post The array has been sorted according to some order (often one given to the constructor).
   * @post For all i, 0 &lt; i &lt; values.length, order.compare(values[i-1], values[i]) &lt;= 0
   */
  @Override
  public void sort(T[] values) {
    for (int i = 0; i < values.length - 1; i++) {
      int least = indexOfSmallest(values, i);
      swap(values, i, least);
    } // for
  } // sort
} // class SelectionSorter
