package Scheduling;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import entity.job;

/*
 * 单道批处理
 */
public class Single {
	public static void single(){
		List<job> list = new ArrayList<job>();
		List<job> list_W = new ArrayList<job>();//就绪队列
		List<job> list_R = new ArrayList<job>();//执行队列
		List<job> list_F = new ArrayList<job>();//结束队列
		SingleUtil.init(list);
//		System.out.println("*********************************************");
//		System.out.println("普通队列如下:");
//		SingleUtil.print(list);
//		//就绪队列
//		SingleUtil.list_c_W(list,list_W);
//		System.out.println("*********************************************");
//		System.out.println("就绪队列如下:");
//		//选择作业调度方法
//		SingleUtil.select(list_W);
//		//执行队列，结束队列
//		SingleUtil.M_c_R_c_FS(list_R,list_W,list_F);		
//		//输出
//		SingleUtil.print(list_F);
		System.out.println("*********************************************************************************************************************");
		System.out.println("普通队列如下:");
		SingleUtil.print(list);
		int time = 0;
		int answer = -1;
		int n = SingleUtil.select();
		while(true){			
			SingleUtil.list_c_W(list,list_W,time);
			SingleUtil.M_c_R(list_R, list_W, time,n);
			for (int i = 0; i < list_R.size(); i++) {
				list_R.get(i).setServerTime(time-list_R.get(i).getEnterTime());
				if((time-list_R.get(i).getEnterTime()) == list_R.get(i).getNeededTime()){
					list_R.get(i).setStatus("Finish");			
				}
			}
			answer = SingleUtil.R_c_F(list_R, list_F);
			if(answer == 1) break;
			
			System.out.println("*********************************************************************************************************************");
			System.out.println("当time="+time+"的时候：");
			System.out.println("就绪队列为：");
			SingleUtil.print(list_W);
			System.out.println("执行队列为：");
			SingleUtil.print(list_R);
			System.out.println("结束队列为：");
			SingleUtil.print(list_F);
			time++;
		}
	} 
	
	
}
