package Algorithm;

import java.util.ArrayList;
import java.util.List;

import entity.job;

/**
 * 先来先服务
 * @author Administrator
 *
 */
public class fcfs {
	/**
	 * 
	 * @param list
	 * @return
	 */
	public static List<job> fcfs(List<job> list) {
		List<job> list1 = new ArrayList<job>();
		int[] arr = new int[list.size()];
		int[] arr1 = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i).getArriveTime();
		}
		arr1 = bubbleSort(arr);
		int k;
		for (int i = 0; i < list.size(); i++) {
			 k = contain(arr1[i],arr);
			 job j = list.get(k);
			 list1.add(i, j);			 
		}
		return list1;
		
	}
	
	/**
	 * 取出数组中对应元素的下标
	 * @param priority
	 * @param pri
	 * @return
	 */
	public static int contain(int arriveTime,int[] arr){
		int i;
		for (i = 0; i < arr.length; i++) {
			if(arriveTime == arr[i]){
				return i;
			}
		}
		return i;		
	}
	/**
	 * 冒泡排序
	 * @param arr
	 * @return
	 */
	public static int[] bubbleSort(int[] arr)
    {
		int temp = 0;
        int size = arr.length;
        for(int i = 0 ; i < size-1; i ++)
        {
        for(int j = 0 ;j < size-1-i ; j++)
        {
            if(arr[j] > arr[j+1])  //交换两数位置
            {
	            temp = arr[j];
	            arr[j] = arr[j+1];
	            arr[j+1] = temp;
            }
        }
        }
		return arr;
    }
	
}
