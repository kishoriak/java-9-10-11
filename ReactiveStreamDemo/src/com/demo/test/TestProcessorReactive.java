package com.demo.test;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

import com.demo.bean.Employee;
import com.demo.bean.Freelancer;
import com.demo.processor.EmployeeProcessor;
import com.demo.service.EmployeeService;
import com.demo.service.FreelanceSubscriber;


public class TestProcessorReactive {

	public static void main(String[] args) throws InterruptedException {
		// Create End Publisher
		SubmissionPublisher<Employee> publisher = new SubmissionPublisher<>();

		// Create Processor
		EmployeeProcessor transformProcessor = new EmployeeProcessor(s -> {
			return new Freelancer(s.getId(), s.getId() + 100, s.getName());
		});

		//Create End Subscriber
		FreelanceSubscriber subs = new FreelanceSubscriber();

		//Create chain of publisher, processor and subscriber
		publisher.subscribe(transformProcessor); // publisher to processor
		transformProcessor.subscribe(subs); // processor to subscriber

		List<Employee> emps = EmployeeService.getEmps();

		// Publish items
		System.out.println("Publishing Items to Subscriber");
		emps.stream().forEach(i -> publisher.submit(i));

		// Logic to wait for messages processing to finish
		while (emps.size() != subs.getCounter()) {
			Thread.sleep(10);
		}

		// Closing publishers
		publisher.close();
		transformProcessor.close();

		System.out.println("Exiting the app");
	}

}