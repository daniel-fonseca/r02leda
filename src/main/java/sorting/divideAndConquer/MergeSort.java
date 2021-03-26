package sorting.divideAndConquer;

import java.util.Arrays;

import sorting.AbstractSorting;

public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean isSortable = false;
		if (leftIndex < rightIndex && rightIndex < array.length) {
			isSortable = true;
		}
		
		if (leftIndex == rightIndex || !isSortable) {
			return;
		}
		
		int middleIndex = (leftIndex + rightIndex)/2;
		sort(array, leftIndex, middleIndex);
		sort(array, middleIndex + 1, rightIndex);
		
		merge(array, leftIndex, middleIndex, rightIndex);
	}
	
	private void merge(T[] array, int leftIndex, int middleIndex, int rightIndex) {
		T[] helper = Arrays.copyOf(array, array.length);
		int i = leftIndex;
		int j = middleIndex + 1;
		int k = leftIndex;
		
		while (i <= middleIndex && j <= rightIndex) {
			if (helper[i].compareTo(helper[j]) < 0) {
				array[k] = helper[i];
				i++;
			} else {
				array[k] = helper[j];
				j++;
			}
			k++;
		}
		
		while (i <= middleIndex) {
			array[k] = helper[i];
			i++;
			k++;
		}
		
		while (j <= rightIndex) {
			array[k] = helper[j];
			j++;
			k++;
		}
	}

}
