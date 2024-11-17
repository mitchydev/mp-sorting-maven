package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * Something that sorts using merge sort.
 *
 * @param <T> The types of values that are sorted.
 *
 * @author Samuel A. Rebelsky
 * @author Mitch Paiva
 */

public class MergeSorter<T> implements Sorter<T> {
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
  public MergeSorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // MergeSorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using merge sort.
   *
   * @param values an array to sort.
   *
   * @post The array has been sorted according to some order (often one given to the constructor).
   * @post For all i, 0 &lt; i &lt; values.length, order.compare(values[i-1], values[i]) &lt;= 0
   */
  @Override
  public void sort(T[] values) {
    if (values.length <= 1) {
      return;
    } // if

    int middle = values.length / 2;

    T[] leftArray = (T[]) new Object[middle];
    T[] rightArray = (T[]) new Object[values.length - middle];

    for (int i = 0; i < middle; i++) {
      leftArray[i] = values[i];
    } // for

    for (int i = middle; i < values.length; i++) {
      rightArray[i - middle] = values[i];
    } // for

    sort(leftArray);
    sort(rightArray);

    merge(values, leftArray, rightArray);

  } // while

  /**
   * Merge the two sorted arrays.
   *
   * @param values
   * @param lArray
   * @param rArray
   */
  public void merge(T[] values, T[] lArray, T[] rArray) {
    int lIndex = 0;
    int rIndex = 0;
    int currIndex = 0;

    for (int i = 0; lIndex < lArray.length && rIndex < rArray.length; currIndex++) {
      if (order.compare(lArray[lIndex], rArray[rIndex]) <= 0) {
        values[currIndex] = lArray[lIndex];
        lIndex++;
      } else {
        values[currIndex] = rArray[rIndex];
        rIndex++;
      } // else
    } // for

    while (lIndex < lArray.length) {
      values[currIndex] = lArray[lIndex];
      lIndex++;
      currIndex++;
    } // while

    while (rIndex < rArray.length) {
      values[currIndex] = rArray[rIndex];
      rIndex++;
      currIndex++;
    } // while
  } // merge
} // class MergeSorter
