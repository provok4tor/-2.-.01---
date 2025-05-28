package main.java.com.bank;

/**
 * Класс, представляющий клиента банка.
 */
public final class Customer {
    /**
     * Имя клиента.
     */
    private final String name;

    /**
     * Идентификатор паспорта клиента.
     */
    private final String passportId;

    /**
     * Конструктор класса Customer.
     *
     * @param nameParam       Имя клиента.
     * @param passportIdParam Идентификатор паспорта клиента.
     */
    public Customer(final String nameParam, final String passportIdParam) {
        this.name = nameParam;
        this.passportId = passportIdParam;
    }

    /**
     * Возвращает имя клиента.
     *
     * @return Имя клиента.
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает идентификатор паспорта клиента.
     *
     * @return Идентификатор паспорта клиента.
     */
    public String getPassportId() {
        return passportId;
    }
}
