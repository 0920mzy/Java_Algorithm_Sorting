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

	public static void shell_pass(int array[], int d, int n)
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
		int array[] = { 12, 34, 89, 90, 89, 1, 78, 56, 2, 2, 12, 23, 34, 99, 89, 56, 67, 10, 45 };
		System.out.println("before sorting:" + Arrays.toString(array));
		shell_sorting(array, array.length);
		// insert_sorting(array, array.length);
		System.out.println("after sorting:" + Arrays.toString(array));
	}
}
