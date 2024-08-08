package com.nt.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ReportGenerator {

	public ReportGenerator() {
		System.out.println("start time before scheduled" + new Date());
	}
/*	// every minute exactly second have specified second worked
	@Scheduled(cron = "15 * * * * *")
	public void generatingSales1() {

		System.out.println("sales Report on shop2:: " + new Date());
	}
	// every hour exactly minute have specified minute worked
	@Scheduled(cron = "* 26 * * * *")
	public void generatingSales1() {

		System.out.println("sales Report on shop2:: " + new Date());
	}
	
	// every day exactly time(17 i.e 5 PM have specified hour worked with all time
		@Scheduled(cron = "0 32 17 * * *")
		public void generatingSales1() {

			System.out.println("sales Report on shop2:: " + new Date());
		}
	*/
	// every day exactly time(17 i.e 5 PM)) and exactly date of the month have specified hour worked with all time
			@Scheduled(cron = "0 38 17 29 * *")
			public void generatingSales1() {

				System.out.println("sales Report on shop2:: " + new Date());
			}
	
}