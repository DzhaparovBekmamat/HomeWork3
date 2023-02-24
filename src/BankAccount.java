public class BankAccount {
    private double amount;

    public BankAccount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void deposit(double sum) {
        amount += sum;
    }

    public void withDraw(double sum) throws LimitException {
        if (sum > amount) {
            throw new LimitException("Запрашиваемая сумма на снятие больше, чем остаток денег на счете", amount);
        }
        amount -= sum;
    }
}
