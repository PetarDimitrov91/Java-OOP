import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class ChainBlockTest {
    // Transaction static final fields;
    private static final int TRANSACTION_ID = 910411;
    private static final TransactionStatus TRANSACTION_STATUS = TransactionStatus.SUCCESSFUL;
    private static final String FROM = "Petar";
    private static final String TO = "Sandra";
    private static final double AMOUNT = 123867.25;

    private static final TransactionStatus ANOTHER_STATUS = TransactionStatus.FAILED;
    private static final int newId = 232123;

    private Transaction transaction;
    private Transaction transaction1;
    private Transaction transaction2;
    private Transaction transaction3;
    private Transaction transaction4;
    private ChainBlock chainBlock;
    private Iterable<Transaction> transactions;

    @Before
    public void setUp() {
        transaction = new TransactionImpl(TRANSACTION_ID, TRANSACTION_STATUS, FROM, TO, AMOUNT);
        transaction1 = new TransactionImpl(432423, TRANSACTION_STATUS, "Sandra", "Petar", 223121.22);
        transaction2 = new TransactionImpl(321312, TRANSACTION_STATUS, "Sandra", "Petar", 352123.25);
        transaction3 = new TransactionImpl(653445, TRANSACTION_STATUS, FROM, TO, 452123.25);
        transaction4 = new TransactionImpl(534345, TRANSACTION_STATUS, "Sandra", "Petar", 552123.25);

        chainBlock = new ChainBlockImpl(transaction);

        this.transactions = Arrays.asList(transaction4, transaction3, transaction2, transaction1, transaction);
    }

    //1 -> add() tests
    @Test
    public void testAddMethodAddsStatusCorrect() {
        chainBlock.add(transaction);
        Assert.assertEquals(transaction, chainBlock.getById(910411));
    }

    @Test
    public void testAddMethodAddsOnlyUniqueKeys() {
        chainBlock.add(transaction);
        chainBlock.add(transaction);
        Assert.assertEquals(1, chainBlock.getCount());
    }

    //2 -> contains(transaction) tests
    @Test
    public void testIfGivenTransactionsIsPresentReturnsTrue() {
        chainBlock.add(transaction);
        Assert.assertTrue(chainBlock.contains(transaction));
    }

    @Test
    public void testIfGivenTransactionsIsNotPresentReturnsFalse() {
        Assert.assertFalse(chainBlock.contains(transaction));
    }

    //3 -> contains(id) tests;
    @Test
    public void testIfTransactionWithGivenIdExistReturnsTrue() {
        chainBlock.add(transaction);
        Assert.assertTrue(chainBlock.contains(TRANSACTION_ID));
    }

    @Test
    public void testIfTransactionWithGivenIdNotExistReturnsFalse() {
        Assert.assertFalse(chainBlock.contains(TRANSACTION_ID));
    }

    // 4 -> getCount() Tests
    @Test
    public void testGetCountMethodReturnsCorrectValue() {
        chainBlock.add(transaction);
        chainBlock.add(transaction);
        Assert.assertEquals(1, chainBlock.getCount());
    }

    //5 -> changeTransactionStatus(id, status)
    @Test
    public void testChangeTransactionStatusSetsCorrectValueToTheStatusField() {

        chainBlock.add(transaction);
        chainBlock.changeTransactionStatus(TRANSACTION_ID, ANOTHER_STATUS);
        Assert.assertEquals(ANOTHER_STATUS, chainBlock.getById(TRANSACTION_ID).getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusThrowsIfNoSuchIdExist() {
        chainBlock.changeTransactionStatus(newId, ANOTHER_STATUS);
    }

    //6 -> removeTransactionById() tests
    @Test
    public void testRemoveTransactionByIdRemovesCorrectlyTheTransactionWhitTheGivenId() {
        chainBlock.add(transaction);
        Assert.assertTrue(chainBlock.contains(transaction.getId()));
        chainBlock.removeTransactionById(TRANSACTION_ID);
        Assert.assertFalse(chainBlock.contains(transaction.getId()));
        Assert.assertEquals(0, chainBlock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionByIdThrowsWhenNoSuchIdExist() {
        chainBlock.add(transaction);
        chainBlock.removeTransactionById(newId);
    }

    //7 -> getById(id) tests
    @Test
    public void testGetByIdMethodReturnsTheCorrectTransaction() {
        chainBlock.add(transaction);
        Assert.assertEquals(transaction, chainBlock.getById(TRANSACTION_ID));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdMethodThrowsWhenNoSuchTransactionExist() {
        chainBlock.add(transaction);
        Assert.assertEquals(transaction, chainBlock.getById(newId));
    }

    // 8 -> getByTransactionStatus(status) tests
    @Test
    public void testGetByTransactionStatusReturnsTheCorrectCollection() {
        addTransactions();
        Assert.assertEquals(transactions, chainBlock.getByTransactionStatus(TRANSACTION_STATUS));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusThrowsWhenNoSuchStatusPresent() {
        addTransactions();
        chainBlock.getByTransactionStatus(ANOTHER_STATUS);
    }

    // 9 -> •	getAllSendersWithTransactionStatus(status) tests
    @Test
    public void testGetAllSendersWithTransactionStatusReturnsTheCorrectCollection() {
        addTransactions();
        Iterable<String> senders = Arrays.asList("Sandra", "Petar", "Sandra", "Sandra", "Petar");
        Assert.assertEquals(senders, chainBlock.getAllSendersWithTransactionStatus(TRANSACTION_STATUS));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatusThrowsWhenNoSuchSendersAreFound() {
        addTransactions();
        chainBlock.getAllSendersWithTransactionStatus(ANOTHER_STATUS);
    }

    // 10 -> getAllReceiversWithTransactionStatus(status) tests

    @Test
    public void testGetAllReceiversWithTransactionStatusReturnsTheCorrectCollection() {
        addTransactions();
        Iterable<String> senders = Arrays.asList("Petar", "Sandra", "Petar", "Petar", "Sandra");
        Assert.assertEquals(senders, chainBlock.getAllReceiversWithTransactionStatus(TRANSACTION_STATUS));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithTransactionStatusThrowsWhenNoSuchSendersAreFound() {
        addTransactions();
        chainBlock.getAllReceiversWithTransactionStatus(ANOTHER_STATUS);
    }

    //11 ->	getAllOrderedByAmountDescendingThenById() tests
    @Test
    public void getAllOrderedByAmountDescendingThenByIdReturnsCorrectCollection() {
        Transaction tr1 = new TransactionImpl(1, TRANSACTION_STATUS, FROM, TO, 400.00);
        Transaction tr2 = new TransactionImpl(2, TRANSACTION_STATUS, FROM, TO, 100.00);
        Transaction tr3 = new TransactionImpl(3, TRANSACTION_STATUS, FROM, TO, 500.00);
        Transaction tr4 = new TransactionImpl(4, TRANSACTION_STATUS, FROM, TO, 500.00);
        Transaction tr5 = new TransactionImpl(5, TRANSACTION_STATUS, FROM, TO, 300.00);

        chainBlock.add(tr1);
        chainBlock.add(tr2);
        chainBlock.add(tr3);
        chainBlock.add(tr4);
        chainBlock.add(tr5);

        Iterable<Transaction> trs = Arrays.asList(tr3, tr4, tr1, tr5, tr2);
        Assert.assertEquals(trs, chainBlock.getAllOrderedByAmountDescendingThenById());
    }

    private void addTransactions() {
        chainBlock.add(transaction2);
        chainBlock.add(transaction);
        chainBlock.add(transaction3);
        chainBlock.add(transaction1);
        chainBlock.add(transaction4);
    }
}
