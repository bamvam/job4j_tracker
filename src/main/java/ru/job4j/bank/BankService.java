package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Сервис управления банковской системой.
 * <p>
 * Предоставляет функционал для:
 * <ul>
 *   <li>Регистрации пользователей</li>
 *   <li>Удаления пользователей</li>
 *   <li>Добавления банковских счетов пользователям</li>
 *   <li>Перевода денег между счетами</li>
 * </ul>
 * <p>
 * Для хранения данных используется структура Map<User, List<Account>>,
 * где ключом является пользователь, а значением — список его счетов.
 *
 * @author bamvam
 */
public class BankService {
    /**
     * Карта всех пользователей системы с привязанными к ним счетами.
     * Ключ — объект User, значение — список объектов Account.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет нового пользователя в систему.
     * <p>
     * Если пользователь с таким паспортом уже существует,
     * новый не добавляется (дубликаты не допускаются).
     *
     * @param user пользователь для добавления
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляет пользователя из системы по номеру паспорта.
     * <p>
     * При удалении пользователя удаляются все его счета.
     *
     * @param passport номер паспорта пользователя для удаления
     */
    public void deleteUser(String passport) {
        User user = findByPassport(passport);
        if (user != null) {
            users.remove(user);
        }
    }

    /**
     * Добавляет новый банковский счёт пользователю.
     * <p>
     * Счёт добавляется только если:
     * <ul>
     *   <li>Пользователь с таким паспортом найден</li>
     *   <li>Счёт с такими реквизитами ещё не добавлен этому пользователю</li>
     * </ul>
     *
     * @param passport номер паспорта пользователя
     * @param account  банковский счёт для добавления
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Находит пользователя в системе по номеру паспорта.
     *
     * @param passport номер паспорта для поиска
     * @return объект User если найден, иначе null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Находит банковский счёт пользователя по реквизитам.
     *
     * @param passport  номер паспорта пользователя
     * @param requisite реквизиты счёта для поиска
     * @return объект Account если найден, иначе null
     */
    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account acc : accounts) {
                if (acc.getRequisite().equals(requisite)) {
                    account = acc;
                    break;
                }
            }
        }
        return account;
    }

    /**
     * Выполняет перевод денег между двумя банковскими счетами.
     * <p>
     * Перевод выполняется только если:
     * <ul>
     *   <li>Оба счёта найдены в системе</li>
     *   <li>На счёте отправителя достаточно средств</li>
     * </ul>
     * При успешном переводе сумма списывается со счёта отправителя
     * и зачисляется на счёт получателя.
     *
     * @param sourcePassport       паспорт отправителя
     * @param sourceRequisite      реквизиты счёта отправителя
     * @param destinationPassport  паспорт получателя
     * @param destinationRequisite реквизиты счёта получателя
     * @param amount               сумма перевода
     * @return true если перевод успешен, иначе false
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);

        if (sourceAccount != null && destinationAccount != null
                && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            result = true;
        }
        return result;
    }

    /**
     * Возвращает список всех счетов пользователя.
     *
     * @param user пользователь для получения счетов
     * @return список счетов или null если пользователь не найден
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}