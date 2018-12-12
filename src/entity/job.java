package entity;

import java.util.Date;

public class job implements Comparable<job> {
	String name;//作业名
	String status;//状态
	int arriveTime;//到达时间
	int enterTime;//进入执行队列的时间
	public int getEnterTime() {
		return enterTime;
	}

	public void setEnterTime(int enterTime) {
		this.enterTime = enterTime;
	}

	int neededTime;//需要的时间
	int serverTime;//服务时间
	int neededMemory;//需要的内存
	int neededMachine;//需要的磁带机
	int waitTime;//等待时间（高响应比优先算法）

	public int getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}
	
	

	@Override
	public String toString() {
		return "job [name=" + name + ", status=" + status + ", arriveTime=" + arriveTime + ", enterTime=" + enterTime
				+ ", neededTime=" + neededTime + ", serverTime=" + serverTime + ", neededMemory=" + neededMemory
				+ ", neededMachine=" + neededMachine + ", waitTime=" + waitTime + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(int arriveTime) {
		this.arriveTime = arriveTime;
	}

	public int getNeededTime() {
		return neededTime;
	}

	public void setNeededTime(int neededTime) {
		this.neededTime = neededTime;
	}

	public int getServerTime() {
		return serverTime;
	}

	public void setServerTime(int serverTime) {
		this.serverTime = serverTime;
	}

	public int getNeededMemory() {
		return neededMemory;
	}

	public void setNeededMemory(int neededMemory) {
		this.neededMemory = neededMemory;
	}

	public int getNeededMachine() {
		return neededMachine;
	}

	public void setNeededMachine(int neededMachine) {
		this.neededMachine = neededMachine;
	}
	
	@Override
	public int compareTo(job o) { 
		//自定义比较方法，如果认为此实体本身大则返回1，否则返回-1
		if(this.neededTime == o.neededTime){
			return 0;
		}else if(this.neededTime < o.neededTime){
			return -1; 
		}else{
			return 1;
		}
				
	}
	
}
