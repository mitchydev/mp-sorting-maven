package edu.grinnell.csc207.sorting;

import edu.grinnell.csc207.util.ArrayUtils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects. Please do not use this class directly. Rather, you should subclass it
 * and initialize stringSorter and intSorter in a static @BeforeAll method.
 *
 * @author Mitchell Paiva
 * @uathor Samuel A. Rebelsky
 */
public class TestSorter {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  /**
   * The sorter we use to sort arrays of strings.
   */
  static Sorter<String> stringSorter = null;

  /**
   * The sorter we use to sort arrays of integers.
   */
  static Sorter<Integer> intSorter = null;

  // +-----------+---------------------------------------------------
  // | Utilities |
  // +-----------+

  /**
   * Given a sorted array and a permutation of the array, sort the permutation and assert that it
   * equals the original.
   *
   * @param <T> The type of values in the array.
   * @param sorted The sorted array.
   * @param perm The permuted sorted array.
   * @param sorter The thing to use to sort.
   */
  public <T> void assertSorts(T[] sorted, T[] perm, Sorter<? super T> sorter) {
    T[] tmp = perm.clone();
    sorter.sort(perm);
    assertArrayEquals(sorted, perm, () -> String.format("sort(%s) yields %s rather than %s",
        Arrays.toString(tmp), Arrays.toString(perm), Arrays.toString(sorted)));
  } // assertSorts

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  /**
   * A fake test. I've forgotten why I've included this here. Probably just to make sure that some
   * test succeeds.
   */
  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  /**
   * Ensure that an array that is already in order gets sorted correctly.
   */
  @Test
  public void orderedStringTest() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = {"alpha", "bravo", "charlie", "delta", "foxtrot"};
    String[] expected = original.clone();
    assertSorts(expected, original, stringSorter);
  } // orderedStringTest

  /**
   * Ensure that an array that is ordered backwards gets sorted correctly.
   */
  @Test
  public void reverseOrderedStringTest() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = {"foxtrot", "delta", "charlie", "bravo", "alpha"};
    String[] expected = {"alpha", "bravo", "charlie", "delta", "foxtrot"};
    assertSorts(expected, original, stringSorter);
  } // orderedStringTest

  /**
   * Ensure that a randomly permuted version of a moderate-sized array sorts correctly.
   */
  @Test
  public void permutedIntegersTest() {
    int SIZE = 100;
    if (null == intSorter) {
      return;
    } // if
    Integer[] original = new Integer[SIZE];
    for (int i = 0; i < SIZE; i++) {
      original[i] = i;
    } // for
    Integer[] expected = original.clone();
    ArrayUtils.permute(original);
    assertSorts(expected, original, intSorter);
  } // permutedIntegers

  /**
   * Ensure that an array of all the same is sorted.
   */
  @Test
  public void sameElements() {
    if (null == intSorter) {
      return;
    }
    Integer[] original = {7, 7, 7, 7, 7, 7};
    Integer[] expected = {7, 7, 7, 7, 7, 7};
    assertSorts(original, expected, intSorter);

  } // sameElements

  /**
   * Ensure that an array of all the same is sorted.
   */
  @Test
  public void negElements() {
    if (null == intSorter) {
      return;
    }
    Integer[] original = {-3, -7, 6, 1, -1, 7};
    Integer[] expected = {-7, -3, -1, 1, 6, 7};
    assertSorts(expected, original, intSorter);

  } // negElements

  /**
   * Ensure that an array of all the same is sorted.
   */
  @Test
  public void similarArray() {
    if (null == intSorter) {
      return;
    }
    Integer[] original = {7, 7, 7, 7, 7, 1};
    Integer[] expected = {1, 7, 7, 7, 7, 7};
    assertSorts(expected, original, intSorter);

  } // similarArray

  /**
   * Ensure that an array of all the same is sorted.
   */
  @Test
  public void singleElementTest() {
    if (null == intSorter) {
      return;
    }
    Integer[] original = {7};
    Integer[] expected = {7};
    assertSorts(expected, original, intSorter);

  } // singleElementTest

  /**
   * Ensure that an array of all the same is sorted.
   */
  @Test
  public void lotsOfElements() {
    if (null == intSorter) {
      return;
    } // if
    Integer[] original = {1, 5, 6, 3, 2, -1, 2, 1, 7, 8, 9, 10, 4, 7, 10, 3, 1, -1, -5, -49, 6, 10};
    Integer[] expected = {-49, -5, -1, -1, 1, 1, 1, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 9, 10, 10, 10};
    assertSorts(expected, original, intSorter);
  } // lotsOfElements

   /**
   * Test permuted strings.
   */
  @Test
    public void permutedStrings() {
      if (null == stringSorter) {
        return;
      } // if
      String[] original = {"I", "love", "CSC"};
      String[] expected = original.clone();
      Arrays.sort(expected);

      for (int i = 0; i < 2; i++) {
        String[] newPerm = original.clone();
        ArrayUtils.permute(newPerm);
        assertSorts(expected, newPerm, stringSorter);
    } // for
  } // permutedStrings
} // class TestSorter


