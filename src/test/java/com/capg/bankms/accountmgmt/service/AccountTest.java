package com.capg.bankms.accountmgmt.service;
import org.junit.jupiter.api.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

public class AccountTest {

	@BeforeAll
	public static void start() {
		System.out.println("inside startInit");
	}
	@AfterAll
	public static void end() {
		System.out.println("inside end");
	}
	@BeforeEach
	public void setup() {
		
		System.out.println("inside Setup");
	}
	@AfterEach
	public void clear() {
		
	}
    
}
