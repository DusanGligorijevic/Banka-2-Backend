package rs.edu.raf.si.bank2.main.exceptions;

public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException(String fromCurrencyCode, String toCurrencyCode, Integer amount) {
        super("You don't have enough money in currency "
                + fromCurrencyCode
                + " in order to buy "
                + amount
                + " "
                + toCurrencyCode);
    }

    public NotEnoughMoneyException() {
        super("You don't have enough money for this operation.");
    }
}
