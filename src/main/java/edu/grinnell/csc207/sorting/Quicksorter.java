package edu.grinnell.csc207.sorting;

import java.util.Comparator;
import java.util.Random;

/**
 * Something that sorts using Quicksort.
 *
 * @param <T> The types of values that are sorted.
 *
 * @author Samuel A. Rebelsky
 * @author Mitch Paiva
 */

public class Quicksorter<T> implements Sorter<T> {
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
  public Quicksorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // Quicksorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using Quicksort.
   *
   * @param values an array to sort.
   *
   * @post The array has been sorted according to some order (often one given to the constructor).
   * @post For all i, 0 &lt; i &lt; values.length, order.compare(values[i-1], values[i]) &lt;= 0.
   */
  @Override
  public void sort(T[] values) {
    quicksort(values, 0, values.length - 1);
  } // sort(T[])

  /**
   * The main driver for the quicksort algorithm.
   *
   * @param values an array to sort.
   * @param lb
   * @param ub
   *
   */
  public void quicksort(T[] values, int lb, int ub) {
    if (lb >= ub) {
      return;
    } // if
    int[] dnfBpunds = partition(values, lb, ub);
    quicksort(values, lb, dnfBpunds[0] - 1);
    quicksort(values, dnfBpunds[1] + 1, ub);
  } // quicksort

  /**
   * Divides the array into three sections using a pivot with the comparator.
   *
   * @param values an array to sort.
   * @param lb
   * @param ub
   *
   * @return int[]
   *
   */
  public int[] partition(T[] values, int lb, int ub) {
    Random rand = new Random();
    int pIndex = lb + rand.nextInt(ub - lb + 1);
    T pivot = values[pIndex];
    swap(values, pIndex, lb);

    int lessThan = lb;
    int greaterThan = ub;
    int i = lb + 1;

    while (i <= greaterThan) {
      if (order.compare(values[i], pivot) < 0) {
        swap(values, i, lessThan);
        lessThan++;
        i++;
      } else if (order.compare(values[i], pivot) > 0) {
        swap(values, i, greaterThan);
        greaterThan--;
      } else {
        i++;
      } // else
    } // while

    return new int[] {lessThan, greaterThan};
  } // partition

  /**
   * Reorders elements.
   *
   * @param arr
   * @param i
   * @param j
   *
   */
  public void swap(T[] arr, int i, int j) {
    T tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  } // swap
} // class Quicksorter
