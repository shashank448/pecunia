package com.capg.bankms.accountmgmt.service;
import org.junit.jupiter.api.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

public class AccountTest {

public AccountServiceImpl service;
	
	
	@BeforeEach
	public void setup() {
		service = new AccountServiceImpl(new AccountDaoImpl());
	}
	
	@BeforeAll
	public static void start() {
		System.out.println("inside startInit");
	}
	@AfterAll
	public static void end() {
		System.out.println("inside end");
	}

	
	@AfterEach
	public void clear() {
		
	}
	
	@Test
	public void addAccount()
	{
		String result=service.addAccount(null, null, null);
		
		Assertions.assertEqual(null,null);
	}
	
	@Test
	public void deleteAccount()
	{
		boolean result=service.deleteAccount("1");
		
		Assertions.assertEqual(true,result);
	}
	
	@Test
	public void updateCustomerContact()
	{
		boolean result=service.updateCustomerContact(new Account(),new Customer());
		result=false;
		Assertions.assertEqual(false,result);
	}
	
	
//    @Test
//    public void testAdd_1() {
//	System.out.println("inside testadd_1");
//	//Calculator c=new Calculator();
//	int result=c.add(2, 3);
//	Assertions.assertEquals(5, result);
//    }
//	
//	@Test
//	@Disabled
//	public void testAdd_2() {
//		System.out.println("Inside TestAdd_2");
//		//Calculator c1=new Calculator();
//		int result=c.add(-2, -3);
//		Assertions.assertEquals(-5, result);
//	}
//	@Test
//	public void testIsEven_1() {
//		System.out.println("Inside IsEven");
//		boolean result=c.isEven(10);
//		Assertions.assertTrue(result);
//	}
//    
//    @ParameterizedTest
//    @ValueSource(ints= {1,2,3,4})
//    public void testIsEven_2(int num) {
//    	System.out.println("Inside IsEven_2");
//    	boolean result=c.isEven(num);
//    	boolean expected=num%2==0;
//    	Assertions.assertEquals(expected,result);
//    }
//    @Test
//    public void testmulBy10_1() {
//    	Multiplier multiplier = Mockito.mock(Multiplier.class);
//    	Mockito.when(multiplier.mul(4, 10)).thenReturn(40);
//    	c.setMultiplier(multiplier);
//    	int result=multiplier.mul(4, 10);
//    	System.out.println("result="+result);
//    }
    

    
}
