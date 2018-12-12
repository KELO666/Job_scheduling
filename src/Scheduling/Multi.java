package Scheduling;

import java.util.ArrayList;
import java.util.List;

import entity.job;

/*
 * 多道批处理
 */
public class Multi {
	public static void multi(){
		List<job> list = new ArrayList<job>();
		List<job> list_W = new ArrayList<job>();//就绪队列
		List<job> list_R = new ArrayList<job>();//执行队列
		List<job> list_F = new ArrayList<job>();//结束队列
		MultiUtil.init(list);
		System.out.println("*********************************************************************************************************************");
		System.out.println("普通队列如下:");
		MultiUtil.print(list);
		int time = 0;
		int answer = -1;
		while(true){			
			MultiUtil.list_c_W(list,list_W,time);
			MultiUtil.M_c_R(list_R, list_W, time);
			for (int i = 0; i < list_R.size(); i++) {
				list_R.get(i).setServerTime(time-list_R.get(i).getEnterTime());
				if((time-list_R.get(i).getEnterTime()) == list_R.get(i).getNeededTime()){
					list_R.get(i).setStatus("Finish");			
				}
			}
			answer = MultiUtil.R_c_F(list_R, list_F);
			if(answer == 1) break;
			
			System.out.println("*********************************************************************************************************************");
			System.out.println("当time="+time+"的时候：");
			System.out.println("就绪队列为：");
			MultiUtil.print(list_W);
			System.out.println("执行队列为：");
			MultiUtil.print(list_R);
			System.out.println("结束队列为：");
			MultiUtil.print(list_F);
			time++;
		}
		

	}
}
