import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class ChainBlockTest {
    // Transaction static final fields;
    private static final int TRANSACTION_ID = 910411;
    private static final TransactionStatus STATUS = TransactionStatus.SUCCESSFUL;
    private static final String FROM = "Petar";
    private static final String TO = "Sandra";
    private static final double AMOUNT = 123867.25;

    private static final TransactionStatus newStatus = TransactionStatus.FAILED;
    private static final int newId = 232123;

    private Transaction transaction;
    private Transaction transaction1;
    private Transaction transaction2;
    private Transaction transaction3;
    private Transaction transaction4;
    private ChainBlock chainBlock;

    @Before
    public void setUp() {
        transaction = new TransactionImpl(TRANSACTION_ID, STATUS, FROM, TO, AMOUNT);
        transaction1 = new TransactionImpl(432423, STATUS, FROM, TO, 223121.22);
        transaction2 = new TransactionImpl(321312, STATUS, FROM, TO, 352123.25);
        transaction3 = new TransactionImpl(653445, STATUS, FROM, TO, 452123.25);
        transaction4 = new TransactionImpl(534345, STATUS, FROM, TO, 552123.25);

        chainBlock = new ChainBlockImpl(transaction);
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
        chainBlock.changeTransactionStatus(TRANSACTION_ID, newStatus);
        Assert.assertEquals(newStatus, chainBlock.getById(TRANSACTION_ID).getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusThrowsIfNoSuchIdExist() {
        chainBlock.changeTransactionStatus(newId, newStatus);
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
        Iterable<Transaction> transactions = Arrays.asList(transaction4, transaction3, transaction2, transaction1, transaction);
        chainBlock.add(transaction2);
        chainBlock.add(transaction);
        chainBlock.add(transaction3);
        chainBlock.add(transaction1);
        chainBlock.add(transaction4);
        Assert.assertEquals(transactions, chainBlock.getByTransactionStatus(STATUS));

    }


}
