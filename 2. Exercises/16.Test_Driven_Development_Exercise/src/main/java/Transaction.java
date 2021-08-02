public interface Transaction extends Comparable<TransactionImpl> {
    int getId();

    TransactionStatus getStatus();

    String getFrom();

    String getTo();

    double getAmount();

    void setStatus(TransactionStatus status);
}
