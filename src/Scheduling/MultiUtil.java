package Scheduling;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Algorithm.sjf;
import entity.job;

public class MultiUtil {

	/**
	 * 初始化
	 * 
	 */
	public static void init(List<job> list) {
//		System.out.println("请输入作业数量：");
//		Scanner input3 = new Scanner(System.in);
//		int num = input3.nextInt();

		
//		for (int i = 0; i < num; i++) {
//			job job = new job();
//			System.out.println("请输入作业名字：");
//			Scanner input = new Scanner(System.in);
//			String name = input.nextLine();
//			job.setName(name);
//			
//			System.out.println("请输入作业需要时间：");
//			Scanner input1 = new Scanner(System.in);
//			int neededTime = input1.nextInt();
//			job.setNeededTime(neededTime);
//			
//			Random rand = new Random();
//			int arriveTime = rand.nextInt(50);
//			job.setArriveTime(arriveTime);
//			
//			job.setServerTime(0);
//			job.setStatus("Wait");
//			job.setWaitTime(0);
//			
//			System.out.println("请输入作业需要内存：");
//			Scanner input2 = new Scanner(System.in);
//			int neededMemory = input2.nextInt();
//			job.setNeededMemory(neededMemory);
//			
//			System.out.println("请输入作业需要磁带机：");
//			Scanner input4 = new Scanner(System.in);
//			int neededMachine = input3.nextInt();
//			job.setNeededMachine(neededMachine);
//			
//			list.add(job);
//		}
		job j = new job();
		j.setName("job1");
		j.setStatus("Wait");
		j.setArriveTime(0);
		j.setNeededTime(15);
		j.setNeededMemory(20);
		j.setNeededMachine(2);
		list.add(j);
		
		job j1 = new job();
		j1.setName("job2");
		j1.setStatus("Wait");
		j1.setArriveTime(20);
		j1.setNeededTime(18);
		j1.setNeededMemory(60);
		j1.setNeededMachine(1);
		list.add(j1);
		
		job j2 = new job();
		j2.setName("job3");
		j2.setStatus("Wait");
		j2.setArriveTime(30);
		j2.setNeededTime(9);
		j2.setNeededMemory(45);
		j2.setNeededMachine(3);
		list.add(j2);
		
		job j3 = new job();
		j3.setName("job4");
		j3.setStatus("Wait");
		j3.setArriveTime(35);
		j3.setNeededTime(12);
		j3.setNeededMemory(10);
		j3.setNeededMachine(2);
		list.add(j3);
		
		job j4 = new job();
		j4.setName("job5");
		j4.setStatus("Wait");
		j4.setArriveTime(45);
		j4.setNeededTime(6);
		j4.setNeededMemory(25);
		j4.setNeededMachine(3);
		list.add(j4);
		
	}
	
	/**
	 * 作业执行
	 * @param list
	 * @param nowtime
	 */
	public static void run(List<job> list,int nowtime){		
		for (int i = 0; i < list.size(); i++) {		
			if((nowtime-list.get(i).getEnterTime()) == list.get(i).getNeededTime()){
				list.get(i).setStatus("Finish");			
			}			
		}				
	}
	
	/**
	 * 输出
	 * @param list
	 */
	public static void print(List<job> list){
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i+1+" :"+list.get(i));
		}
	}
	
	/**
	 * 判断当前时间和作业到达时间
	 * @param time
	 * @param list
	 * @return
	 */
	public static int contain(int time,List<Integer> list){
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) == time){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 从普通队列加入到就绪队列
	 * @param list
	 * @param list_W
	 */
	public static int list_c_W(List<job> list,List<job> list_W,int nowtime){
		//int time = 0;//初始时间	 
		int k ;
		int n = -1;
		       
		while(true){
//			if(list_W.size() != 0){
//	        	n = M_c_R(list_R,list_W,list_F,nowtime);//插入
//	        }
			List<Integer> list_a = new ArrayList<Integer>();
	        for (int i=0; i<list.size(); i++) {
	        	list_a.add(list.get(i).getArriveTime());
	        }
			if(list.size() == 0) break;
			k = contain(nowtime,list_a);
			if(k != -1){
				list_W.add(list.get(k));//时间到了，加入就绪队列
				list.remove(k);
				list_a.remove(k);
			}else{
				break;
			}
			//time++;
			
		}
		return n;
	}
	
	public static void M_c_R_1(List<job> list_R,List<job> list_W,int nowtime){	
		while(true){			
			if(list_W.size()==0) break;
			list_R.add(list_W.get(0));//把就绪队列的第一个加入执行序列
			if(list_R.size() == 0) break;
			list_R.get(list_R.size()-1).setEnterTime(nowtime);
			for (int i = 0; i < list_R.size(); i++) {
				list_R.get(i).setStatus("Run");
			}			
			list_W.remove(0);
			run(list_R,nowtime);  			
		}
	}
	
	/**
	 * 多道批处理
	 * 从就绪队列到运行队列
	 * @param list_R
	 * @param list_W
	 * 
	 */
	public static int M_c_R(List<job> list_R,List<job> list_W,int nowtime){
		int tMemory = 100;
		int tMachine = 5;
		int nowMemory = 0 ;//目前占用的内存
		int nowMachine = 0 ;//目前占用的磁带机	
		int n = 0;
		while(true){
			nowMemory = 0;
			nowMachine = 0;
			for (int i = 0; i < list_R.size(); i++) {				
				nowMemory += list_R.get(i).getNeededMemory();
				nowMachine +=  list_R.get(i).getNeededMachine();
			}
			if(list_R.size()==0){
				M_c_R_1(list_R,list_W,nowtime);
				
				sjf.sjf(list_W);//短作业优先
				if(list_W.size()==0) break;
			}
			if(list_W.size() == 0){
				break;
			}
			if(list_W.get(0).getNeededMemory()+nowMemory<tMemory&&list_W.get(0).getNeededMachine()+nowMachine<tMachine){
				M_c_R_1(list_R,list_W,nowtime);
				sjf.sjf(list_W);//短作业优先 
				if(list_W.size()==0) break;
			}else{
				break;
			}
			
		}
		return n;
	}
	
	/**
	 * 执行队列到结束队列
	 * @param list_R
	 * @param list_F
	 */
	public static int R_c_F(List<job> list_R,List<job> list_F){
		int n = 0 ;
		for (int i = 0; i < list_R.size(); i++) {
			if(list_R.get(i).getStatus().equals("Finish")){
				list_F.add(list_R.get(i));//插入到结束队列
				list_R.remove(i);
			}
			if(list_F.size()==5){
				n = 1;
			}
		}
		return n;
	}
	

	
}
