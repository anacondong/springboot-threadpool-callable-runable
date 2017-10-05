package com.sample.concurrency.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.callabletask.CallableWorker;
import com.sample.runabletask.RunableWorker;


@RestController
public class WebController {

	@Autowired
	ThreadPoolTaskExecutor threadPool;
	
	@RequestMapping("/call")
	public String process(){
		
		String msg = "";
		List<Future<String>> futureList = new ArrayList<>();
		for(int threadNumber = 0; threadNumber < 5; threadNumber ++){
			CallableWorker callableTask = new CallableWorker(String.valueOf(threadNumber));
			Future<String> result = threadPool.submit(callableTask);
			futureList.add(result);
		}
		
		for(Future<String> future: futureList){
			try {
				msg += future.get() + "<br/>";
			} catch (Exception e){}
		}
		
		return msg;
	}
	
	
	@RequestMapping("/run")
	public String run(){
		for(int threadNumber = 0; threadNumber < 5; threadNumber ++){
			Runnable runableTask = new RunableWorker(String.valueOf(threadNumber));
			threadPool.submit(runableTask);
		}
			return "Runable Worker : Called";
	}
	
	
}

