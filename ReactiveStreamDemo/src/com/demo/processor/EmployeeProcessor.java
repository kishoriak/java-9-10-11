package com.demo.processor;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

import com.demo.bean.Employee;
import com.demo.bean.Freelancer;



public class EmployeeProcessor extends SubmissionPublisher<Freelancer> implements Processor<Employee, Freelancer> {

	private Subscription subscription;
	private Function<Employee,Freelancer> function;
	
	public EmployeeProcessor(Function<Employee,Freelancer> function) {  
	    super();  
	    this.function = function;  
	  }  
	
	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		subscription.request(1);
	}

	@Override
	public void onNext(Employee emp) {
		submit((Freelancer) function.apply(emp));  
	    subscription.request(1);  
	}

	@Override
	public void onError(Throwable e) {
		e.printStackTrace();
	}

	@Override
	public void onComplete() {
		System.out.println("Done");
	}

}
