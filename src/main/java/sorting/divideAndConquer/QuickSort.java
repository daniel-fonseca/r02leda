package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean isSortable = false;
		if (leftIndex < rightIndex && rightIndex < array.length) {
			isSortable = true;
		}
		
		if (isSortable) {
			int pivotIndex = particiona(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivotIndex - 1);
			sort(array, pivotIndex + 1, rightIndex);
		}
		
	}
	
	private int particiona(T[] array, int leftIndex, int rightIndex) {
		int range = rightIndex - leftIndex + 1;
		int randomPivotIndex = (int) (Math.random() * range) + leftIndex;
		T aux = array[leftIndex];
		array[leftIndex] = array[randomPivotIndex];
		array[randomPivotIndex] = aux;
		
		T pivot = array[leftIndex];
		int i = leftIndex;
		
		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(pivot) < 0) {
				i++;
				T temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		
		T temp = array[i];
		array[i] = array[leftIndex];
		array[leftIndex] = temp;
		
		return i;
	}
}
