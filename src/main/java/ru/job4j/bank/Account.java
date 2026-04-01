package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает банковский счёт пользователя.
 * Содержит реквизиты счёта и текущий баланс.
 *
 * @author bamvam
 */
public class Account {
    /**
     * Уникальные реквизиты счёта (номер счёта).
     */
    private String requisite;

    /**
     * Текущий баланс счёта.
     */
    private double balance;

    /**
     * Конструктор создаёт новый банковский счёт.
     *
     * @param requisite реквизиты счёта
     * @param balance   начальный баланс счёта
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Возвращает реквизиты счёта.
     *
     * @return реквизиты счёта
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Устанавливает новые реквизиты счёта.
     *
     * @param requisite новые реквизиты
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Возвращает текущий баланс счёта.
     *
     * @return баланс счёта
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Устанавливает новый баланс счёта.
     *
     * @param balance новый баланс
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Сравнивает два счёта по реквизитам.
     * Счета считаются равными, если их реквизиты совпадают.
     *
     * @param o объект для сравнения
     * @return true если реквизиты равны, иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Возвращает хеш-код счёта на основе реквизитов.
     *
     * @return хеш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}