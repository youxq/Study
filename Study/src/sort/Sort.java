package sort;

public class Sort {

	/**
	 * 交换数组的两个值
	 * @param array
	 * @param i
	 * @param j
	 */
	public void swap(int[] array,int i,int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	/**
	 * 冒泡排序
	 * 算法是稳定的，时间复杂度为O(n^2)
	 * 最坏的情况，也就是顺序是反的，这个排序方法也要比较n(n-1)/2，交换n(n-1)/2
	 * 最好的情况，已经是排序好的，但是也需要比较n(n-1)/2，交换0次
	 * 1+2+3+4+...+(n-1)=n(n-1)/2
	 */
	public void BubbleSort(int[] array){
		
		for(int i=0;i<array.length-1;i++){		
			for(int j=array.length-2;j>=i;j--){
				// 算法是稳定的，如果将此处的<改为<=，那么算法就是不稳定的
				if(array[j] < array[i+1]){
					swap(array,j,j+1);
				}
			}
		}
	}
	
	/**
	 * 简单选择排序，减少了交换的次数，时间复杂度为O(n^2)，性能上略优于冒泡排序
	 * 最坏的情况，比较n(n-1)/2次，交换n-1次
	 * 最好的情况，比较n(n-1)/2次，交换0次
	 */
	public void SelectSort(int[] array){
		
		int min;
		for(int i=0;i<array.length-1;i++){
			min = i;
			for(int j=i+1;j<array.length;j++){
				if(array[min] > array[j]){
					min = j;
				}
			}
			if(i != min){
				swap(array,min,i);
			}
		}
	}
	
	/**
	 * 直接插入排序
	 * 
	 */
	public void InsertSort(int[] array){
		
		int i,j;
		for(i=1;i<array.length;i++){
			if(array[i] < array[i-1]){
				int temp = array[i+1];
				for(j=i-1;array[j]>temp&&j>=0;j--){
					array[j+1] = array[j];
				}
				array[j+1] = temp;
				
			}
		}
	}
}
