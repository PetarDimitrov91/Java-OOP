import java.util.*;
import java.util.stream.Collectors;

public class ChainBlockImpl implements ChainBlock {

    private Map<Integer, Transaction> records;

    public ChainBlockImpl(Transaction transaction) {
        this.records = new LinkedHashMap<>();
    }

    @Override
    public void add(Transaction transaction) {
        if (!records.containsKey(transaction.getId())) {
            records.put(transaction.getId(), transaction);
        }
    }

    @Override
    public boolean contains(Transaction transaction) {
        return records.containsValue(transaction);
    }

    @Override
    public boolean contains(int id) {
        return records.containsKey(id);
    }

    @Override
    public int getCount() {
        return records.size();
    }

    @Override
    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (records.containsKey(id)) {
            records.get(id).setStatus(newStatus);
        } else {
            throw new IllegalArgumentException("No such Id exist");
        }
    }

    @Override
    public void removeTransactionById(int id) {
        if (records.containsKey(id)) {
            records.remove(id);
        } else {
            throw new IllegalArgumentException("No such Id exist");
        }
    }

    @Override
    public Transaction getById(int id) {
        return records.entrySet()
                .stream()
                .filter(e -> e.getKey() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .getValue();
    }

    @Override
    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        return records.values()
                .stream()
                .filter(e -> e.getStatus().equals(status))
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        return null;
    }

    @Override
    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        return null;
    }

    @Override
    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return null;
    }

    @Override
    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        return null;
    }

    @Override
    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        return null;
    }

    @Override
    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    @Override
    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    @Override
    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    @Override
    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    @Override
    public Iterator<Transaction> iterator() {
        return null;
    }
}
