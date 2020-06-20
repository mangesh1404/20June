package com.PriorityEx;

import org.testng.annotations.Test;

public class PriorityTest1 {

	@Test(priority = 1)
	public void test1() {
		System.out.println("i am in Prioritytest with priority=1");
	}
	@Test(priority = 2)
	public void test2() {
		System.out.println("i am in Prioritytest as test2 with priority=2");
	}
	@Test(priority = 3)
	public void test3() {
		System.out.println("i am in Prioritytest as test3 with priority=3");
	}
	@Test(priority = -1)
	public void aa() {
		System.out.println("i am in Prioritytest as aaa with no priority");
	}
	@Test(priority = -1)
	public void bb() {
		System.out.println("i am in Prioritytest as bbb with  no priority");
	}
}
