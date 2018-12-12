package Algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import Scheduling.SingleUtil;
import entity.job;

/*
 * 短作业优先
 */
public class sjf {
	public static void sjf(List<job> list){
		list.sort(Comparator.naturalOrder());	
		for (int i = 0; i < list.size(); i++) {
			SingleUtil.run(list.get(i));
		}
	}
	
}
