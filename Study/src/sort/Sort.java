package sort;

public class Sort {

	/**
	 * �������������ֵ
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
	 * ð������
	 * �㷨���ȶ��ģ�ʱ�临�Ӷ�ΪO(n^2)
	 * ��������Ҳ����˳���Ƿ��ģ�������򷽷�ҲҪ�Ƚ�n(n-1)/2������n(n-1)/2
	 * ��õ�������Ѿ�������õģ�����Ҳ��Ҫ�Ƚ�n(n-1)/2������0��
	 * 1+2+3+4+...+(n-1)=n(n-1)/2
	 */
	public void BubbleSort(int[] array){
		
		for(int i=0;i<array.length-1;i++){		
			for(int j=array.length-2;j>=i;j--){
				// �㷨���ȶ��ģ�������˴���<��Ϊ<=����ô�㷨���ǲ��ȶ���
				if(array[j] < array[i+1]){
					swap(array,j,j+1);
				}
			}
		}
	}
	
	/**
	 * ��ѡ�����򣬼����˽����Ĵ�����ʱ�临�Ӷ�ΪO(n^2)��������������ð������
	 * ���������Ƚ�n(n-1)/2�Σ�����n-1��
	 * ��õ�������Ƚ�n(n-1)/2�Σ�����0��
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
	 * ֱ�Ӳ�������
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
