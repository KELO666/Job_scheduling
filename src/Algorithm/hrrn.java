package Algorithm;

import java.util.ArrayList;
import java.util.List;

import Scheduling.SingleUtil;
import entity.job;

/*
 * 高响应比优先调度算法
 */
public class hrrn {
	public static List<job> hrrn(List<job> list){
		List<job> list1 = new ArrayList<job>();
		float[] pri = new float[list.size()];
		float[] pri_b = new float[list.size()];
		pri = SingleUtil.priority(list);
		pri_b = bubbleSort(pri);
		int k;
		for (int i = 0; i < list.size(); i++) {
			 k = contain(pri_b[i],pri);
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
	public static int contain(float priority,float[] pri){
		int i;
		for (i = 0; i < pri.length; i++) {
			if(priority == pri[i]){
				return i;
			}
		}
		return i;		
	}
	
	/**
	 * 冒泡排序
	 * @param pri
	 */
	public static float[] bubbleSort(float[] pri)
    {
		float temp = 0;
        int size = pri.length;
        for(int i = 0 ; i < size-1; i ++)
        {
        for(int j = 0 ;j < size-1-i ; j++)
        {
            if(pri[j] > pri[j+1])  //交换两数位置
            {
	            temp = pri[j];
	            pri[j] = pri[j+1];
	            pri[j+1] = temp;
            }
        }
        }
		return pri;
    }
	
}
