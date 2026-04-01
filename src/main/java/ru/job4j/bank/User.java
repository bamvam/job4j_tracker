package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает пользователя банковской системы.
 * Содержит паспортные данные и ФИО пользователя.
 *
 * @author bamvam
 */
public class User {
    /**
     * Номер паспорта пользователя (уникальный идентификатор).
     */
    private String passport;

    /**
     * ФИО пользователя.
     */
    private String username;

    /**
     * Конструктор создаёт нового пользователя.
     *
     * @param passport номер паспорта
     * @param username ФИО пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Возвращает номер паспорта пользователя.
     *
     * @return номер паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Устанавливает новый номер паспорта.
     *
     * @param паспорт новый номер паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Возвращает ФИО пользователя.
     *
     * @return ФИО пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Устанавливает новое ФИО пользователя.
     *
     * @param username новое ФИО
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Сравнивает двух пользователей по номеру паспорта.
     * Пользователи считаются равными, если их паспорта совпадают.
     *
     * @param o объект для сравнения
     * @return true если паспорта равны, иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Возвращает хеш-код пользователя на основе номера паспорта.
     *
     * @return хеш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}