package com.capg.bankms.transmgmt.dao;

<<<<<<< HEAD
import com.capg.bankms.accountmgmt.entities.Account;
import com.capg.bankms.transmgmt.entities.Cheque;
=======
import java.util.*;

import com.capg.bankms.accountmgmt.entities.Account;
import com.capg.bankms.transmgmt.entities.Cheque;

>>>>>>> d4c4c70ded601002d1f206f73c4649eea47dabff
import com.capg.bankms.transmgmt.entities.Transaction;

public interface TransactionDao {

	Account getAccountById(String id);

	double getBalance(Account account);

	boolean updateBalance(Account account);

	int generateChequeId(Cheque cheque);

	int generateTransactionId(Transaction transaction);

}
