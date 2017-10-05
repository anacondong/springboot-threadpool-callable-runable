package com.sample.runabletask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RunableWorker implements RunnableFuture<String>{

	String name;
	
	public RunableWorker(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		process();
		String message = String.format("RunableWorker name : %s called !!", name);
		System.out.println(message);
	}
	
	private void process(){ 
		for(int taskId=0; taskId < 10; taskId++){
			String message = String.format("RunableWorker name: %s is processing a taskId: %d",name, taskId);
			System.out.println(message);
		}
	}

	
	@Override
	public boolean cancel(boolean mayInterruptIfRunning) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCancelled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String get() throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
