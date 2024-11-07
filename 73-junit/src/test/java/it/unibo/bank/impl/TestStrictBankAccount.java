package it.unibo.bank.impl;

import it.unibo.bank.api.AccountHolder;
import it.unibo.bank.api.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for the {@link StrictBankAccount} class.
 */
class TestStrictBankAccount {

    // Create a new AccountHolder and a StrictBankAccount for it each time tests are executed.
    private AccountHolder mRossi;
    private BankAccount bankAccount;

    /**
     * Prepare the tests.
     */
    @BeforeEach
    public void setUp() {
        this.mRossi = new AccountHolder("Marco", "Rossi", 0);
        this.bankAccount = new StrictBankAccount(mRossi, 0);
    }

    /**
     * Test the initial state of the StrictBankAccount.
     */
    @Test
    public void testInitialization() {
        assertEquals("Marco", mRossi.getName());
        assertEquals("Rossi", mRossi.getSurname());
        assertEquals(0, mRossi.getUserID());
        assertEquals(0, bankAccount.getBalance());
        assertEquals(mRossi, bankAccount.getAccountHolder());
    }

    /**
     * Perform a deposit of 100€, compute the management fees, and check that the balance is correctly reduced.
     */
    @Test
    public void testManagementFees() {
        bankAccount.deposit(0, 100);
        assertEquals(100, bankAccount.getBalance());
        /*for(int i =1; i < 50; i++){
            if(i < 20){
                bankAccount.chargeManagementFees(0);
                assertEquals(99.9- i * 5, bankAccount.getBalance());  
            }else{
                bankAccount.chargeManagementFees(0);
                assertEquals(4.900000000000006, bankAccount.getBalance());
            }
        }
            */
            bankAccount.chargeManagementFees(0);
            assertEquals(94.9, bankAccount.getBalance());
            bankAccount.withdraw(0, 90);
            assertEquals((94.9-90), bankAccount.getBalance());
            bankAccount.chargeManagementFees(0);
            assertEquals(94.9-90, bankAccount.getBalance());


    }

    /**
     * Test that withdrawing a negative amount causes a failure.
     */
    @Test
    public void testNegativeWithdraw() {
        assertThrows(IllegalArgumentException.class, () ->{
            bankAccount.withdraw(0, -75);
        });
    }

    /**
     * Test that withdrawing more money than it is in the account is not allowed.
     */
    @Test
    public void testWithdrawingTooMuch() {
        assertThrows(IllegalArgumentException.class, () ->{
            bankAccount.withdraw(0, 3000);
        });
    }
}
