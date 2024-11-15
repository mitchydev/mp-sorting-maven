package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * A sorting class that utilizes a hybrid sorting algorithm combining
 * merge sort with insertion sort for small subarrays.
 *
 * @param <T>
 *
 * @author Mitch Paiva with heavy assistance from ChatGPT by OpenAI
 */
public class PaivaMitchSort<T> implements Sorter<T> {

  /**
   * The comparator.
   */
  private final Comparator<? super T> comparator;

  /**
   * The threshold.
   */
  private static final int THRESHOLD = 10;


  /**
   * Create a sort instance.
   *
   * @param comparatorVar
   *   Defines the order of elements.
   */
  public PaivaMitchSort(Comparator<T> comparatorVar) {
    this.comparator = comparatorVar;
  } // PaivaMitchSort(Comparator)

  /**
   * Sorts an array in place using a hybrid approach.
   * For larger arrays, it applies merge sort, switching to insertion sort for smaller subarrays.
   *
   * @param values
   */
  @Override
  public void sort(T[] values) {
    hybridSort(values, 0, values.length - 1);
  } // sort(T[])

  /**
   * Recursively applies merge sort or insertion sort based on the threshold.
   *
   * @param values
   * @param left
   * @param right
   */
  private void hybridSort(T[] values, int left, int right) {
    if (right - left + 1 <= THRESHOLD) {
      insertionSort(values, left, right);
    } else {
      int middle = left + (right - left) / 2;
      hybridSort(values, left, middle);
      hybridSort(values, middle + 1, right);
      merge(values, left, middle, right);
    } // else
  } // hybridSort(T[], int, int)

  /**
   * Sorts a subarray in place using insertion sort.
   *
   * @param values
   * @param left
   * @param right
   */
  private void insertionSort(T[] values, int left, int right) {
    for (int i = left + 1; i <= right; i++) {
      T key = values[i];
      int j = i - 1;
      while (j >= left && comparator.compare(values[j], key) > 0) {
        values[j + 1] = values[j];
        j--;
      } // while
      values[j + 1] = key;
    } // for
  } // insertionSort(T[], int, int)

  /**
   * Merges two sorted halves of a subarray.
   *
   * @param values
   * @param left
   * @param middle
   * @param right
   */
  private void merge(T[] values, int left, int middle, int right) {
    int leftSize = middle - left + 1;
    int rightSize = right - middle;

    T[] leftArray = (T[]) new Object[leftSize];
    T[] rightArray = (T[]) new Object[rightSize];

    System.arraycopy(values, left, leftArray, 0, leftSize);
    System.arraycopy(values, middle + 1, rightArray, 0, rightSize);

    int i = 0;
    int j = 0;
    int k = left;

    while (i < leftSize && j < rightSize) {
      if (comparator.compare(leftArray[i], rightArray[j]) <= 0) {
        values[k++] = leftArray[i++];
      } else {
        values[k++] = rightArray[j++];
      } // else
    } // while

    while (i < leftSize) {
      values[k++] = leftArray[i++];
    } // while

    while (j < rightSize) {
      values[k++] = rightArray[j++];
    } // while
  } // merge(T[], int, int, int)
} // class PaivaMitchSort
