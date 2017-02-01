package sorting;

import java.util.Arrays;

public class Sorting 
{
	public static void insert_sorting(int array[], int n)
	{
		int i = 0, j = 0;
		for(i = 2; i <= n; i++)
		{
			if(array[i] < array[i-1])
			{
				array[0] = array[i];
				j = i-1;
				do
				{
					array[j+1] = array[j];
					j--;
				}while(array[0]<array[j]);
				array[j+1] = array[0];
			}
		}
	}
	
	public static void main(String[] args)
	{
		int array[] = {0, 12, 34, 89, 90, 89, 1, 78, 56, 2, 2};
		System.out.println("before sorting:"+ Arrays.toString(array));
		insert_sorting(array, array.length-1);
		System.out.println("after sorting:"+ Arrays.toString(array));
	}
}
