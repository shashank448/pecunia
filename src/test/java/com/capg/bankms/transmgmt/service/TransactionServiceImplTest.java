package com.capg.bankms.transmgmt.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capg.bankms.transmgmt.dao.TransactionDaoImpl;

public class TransactionServiceImplTest {
	private TransactionServiceImpl service;
	
@BeforeEach
public void setup() {
	service= new TransactionServiceImpl(new TransactionDaoImpl());
}


@AfterEach
public void clear() {
	TransactionDaoImpl.transactionStore.clear();
}

@Test
public void testCreditUsingSlip_1() {
	Assersation.assert
}

}