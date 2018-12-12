package Scheduling;
/*
 * 主界面
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.job;

public class Main {

	public static void main(String[] args) {
		while(true){
			System.out.println("******************************");
			System.out.println("1、单道批处理");
			System.out.println("2、多道批处理");
			System.out.println("3、退出");
			System.out.println("******************************");
			System.out.println("请选择你的系统：");
			Scanner input = new Scanner(System.in);
			int key = input.nextInt();
			List<job> list = new ArrayList<job>();
			switch(key){
				case 1: Single.single();				
						break;
				case 2: System.out.println("总内存为:100,总磁带机为5台。");
						Multi.multi();						
						break;
				case 3: break;
			}
			if(key == 3){
				break;
			}
		}

	}

}
