package sorting;

import java.util.Arrays;

public class Sorting
{
	public static void insert_sorting(int array[], int n)
	{
		int tmpArray[] = new int[n + 1];
		tmpArray[0] = 0;
		System.arraycopy(array, 0, tmpArray, 1, n);
		int i = 0, j = 0;
		for (i = 2; i <= n; i++)
		{
			if (tmpArray[i] < tmpArray[i - 1])
			{
				tmpArray[0] = tmpArray[i];
				j = i - 1;
				do
				{
					tmpArray[j + 1] = tmpArray[j];
					j--;
				} while (tmpArray[0] < tmpArray[j]);
				tmpArray[j + 1] = tmpArray[0];
			}
		}
		System.arraycopy(tmpArray, 1, array, 0, n);
	}

	private static void shell_pass(int array[], int d, int n)
	{
		int i = 0, j = 0;
		int temp = 0;
		for (i = d; i < n; i++)
		{
			if (array[i] < array[i-d])
			{
				temp = array[i];
				j = i - d;
				do
				{
					array[j + d] = array[j];
					j = j - d;
				} while (j > 0 && temp < array[j]);
				array[j + d] = temp;
			}
		}
	}
	
	public static void quick_sort(int array[], int n)
	{
		quick_sort_sub(array,0,n-1);
	}
	
	private static int quick_sort_partition(int array[], int low, int high)
	{
		int pivot = array[low];
		while(low<high)
		{
			while(low<high && array[high]>=pivot)
			{
				high--;
			}
			if(low<high)
				array[low++] = array[high];
			
			while(low<high && array[low]<=pivot)
			{
				low++;
			}
			if(low<high)
				array[high--] = array[low];
		}
		array[low] = pivot;
		return low;

	}
	private static void quick_sort_sub(int array[], int low, int high)
	{
		int pivotIndex = 0;
		if(low < high)
		{
			pivotIndex = quick_sort_partition(array, low, high);
			quick_sort_sub(array, low, pivotIndex-1);
			quick_sort_sub(array, pivotIndex+1, high);		
		}
	}

	public static void shell_sorting(int array[], int n)
	{
		int increment = n;
		do
		{
			increment = increment / 3 + 1;
			shell_pass(array, increment, n);
		} while (increment > 1);
	}

	public static void main(String[] args)
	{
		int array[] = { 8,7,4,1,5,9,6,2,3,10 };
		System.out.println("before sorting:" + Arrays.toString(array));
		//shell_sorting(array, array.length);
		// insert_sorting(array, array.length);
		quick_sort(array, array.length);
		System.out.println("after sorting:" + Arrays.toString(array));
	}
}
