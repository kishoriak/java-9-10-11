package com.demo.test;
import java.util.List;
import java.util.concurrent.SubmissionPublisher;

import com.demo.bean.Employee;
import com.demo.service.EmployeeService;
import com.demo.subscriber.EmployeeSubscriber;


public class TestReactive {
	public static void main(String args[]) throws InterruptedException {

				// Create Publisher
				SubmissionPublisher<Employee> publisher = new SubmissionPublisher<>();

				// Register Subscriber

				EmployeeSubscriber subs = new EmployeeSubscriber();
				publisher.subscribe(subs);
				
				//EmployeeSubscriber subs1 = new EmployeeSubscriber();
				//publisher.subscribe(subs1);

				List<Employee> emps = EmployeeService.getEmps();

				// Publish items
				System.out.println("Publishing Items to Subscriber");
				emps.stream().forEach(i -> publisher.submit(i));

				// logic to wait till processing of all messages are over
				while (emps.size() != subs.getCounter()) {
					Thread.sleep(10);
				}
				// close the Publisher
				publisher.close();

				System.out.println("Exiting the app");

			}

}
