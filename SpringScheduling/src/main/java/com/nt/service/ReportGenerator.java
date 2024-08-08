package com.nt.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ReportGenerator {
	
	public ReportGenerator(){
		System.out.println("start time before scheduled"+new Date());
	}
	/*@Scheduled(initialDelay = 2000)
	public void generatingSales() {
		System.out.println("sales Report on shop1:: "+new Date());
	}
	@Scheduled(initialDelay = 2000,fixedDelay = 3000)
	public void generatingSales1() {
		System.out.println("sales Report on shop2:: "+new Date());
	} 
	//only fixedDelay are allowed cursor directly started
	@Scheduled(fixedDelay = 3000)
	public void generatingSales1() {
		System.out.println("sales Report on shop2:: "+new Date());
	}   
	//FixedDelayString also work
	@Scheduled(fixedDelayString = "3000")
	public void generatingSales1() {
		System.out.println("sales Report on shop2:: "+new Date());
	}  
	
	//we add here fixedDelay and sleep then total Time taken=fixedDelay+sleep Time
	@Scheduled(fixedDelayString = "3000")
	public void generatingSales1() {
		
		try {
			Thread.sleep(15000);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("sales Report on shop2:: "+new Date());
	} 
	
	// fixed Rate    (15 sec gap)
	@Scheduled(fixedRate = 10000)
	public void generatingSales1() {
		
		try {
			Thread.sleep(15000);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("sales Report on shop2:: "+new Date());
	}
	// fixed Rate    (10 sec gap taken)
		@Scheduled(fixedRate = 10000)
		public void generatingSales1() {
			
			try {
				Thread.sleep(5000);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			System.out.println("sales Report on shop2:: "+new Date());
		}*/
	
	//	@Scheduled(initialDelay = 2000,fixedDelay = 5000)  //intialy taken 2 send after taken 5 sec
	//   @Scheduled(initialDelay = 2000,fixedRate = 5000)   //intialy taken 2 send after taken 5 sec  
		public void generatingSales1() {
			
			
			System.out.println("sales Report on shop2:: "+new Date());
		}
	
	
	
}