public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(20000);
        while (true) {
            try {
                bankAccount.withDraw(6000);
                System.out.println("Снято 6000 сом. Остаток на счете: " + bankAccount.getAmount() + " сом.");
            } catch (LimitException e) {
                System.out.println("Недостаточно денег на счете. Остаток на счете: " + e.getRemainingAmount() + " сом.");
                try {
                    bankAccount.withDraw(e.getRemainingAmount());
                    System.out.println("Снято оставшееся на счете: " + e.getRemainingAmount() + " сом.");
                } catch (LimitException ex) {
                    System.out.println("Произошла ошибка при снятии денег: " + ex.getMessage());
                }
                break;
            }
        }
    }
}
