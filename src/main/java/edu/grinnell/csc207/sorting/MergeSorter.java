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
   * @param comparator The order in which elements in the array should be ordered
   *                   after sorting.
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
   * @post The array has been sorted according to some order (often one given to
   *       the constructor).
   * @post For all i, 0 &lt; i &lt; values.length, order.compare(values[i-1],
   *       values[i]) &lt;= 0
   */
  @Override
  public void sort(T[] values) {
    T[] helper = (T[]) new Object[values.length];
    mergeSort(values, helper, 0, values.length - 1);
  } // while

  /**
   * Recursively divides and sorts the array.
   *
   * @param values
   * @param helper
   * @param low
   * @param high
   */
  private void mergeSort(T[] values, T[] helper, int low, int high) {
    if (low >= high) {
      return;
    } // if

    int middle = (low + high) / 2;

    mergeSort(values, helper, low, middle);
    mergeSort(values, helper, middle + 1, high);

    merge(values, helper, low, middle, high);
  } // mergeSort

  /**
   * Merge the two sorted arrays.
   *
   * @param values
   * @param helper
   * @param low
   * @param middle
   * @param high
   */
  public void merge(T[] values, T[] helper, int low, int middle, int high) {
    for (int i = low; i <= high; i++) {
      helper[i] = values[i];
    } // for

    int lIndex = low;
    int rIndex = middle + 1;
    int currIndex = low;

    while (lIndex <= middle && rIndex <= high) {
      if (order.compare(helper[lIndex], helper[rIndex]) <= 0) {
        values[currIndex] = helper[lIndex];
        lIndex++;
      } else {
        values[currIndex] = helper[rIndex];
        rIndex++;
      } // else
      currIndex++;
    } // while

    while (lIndex <= middle) {
      values[currIndex] = helper[lIndex];
      lIndex++;
      currIndex++;
    } // while
  } // merge
} // class MergeSorter
