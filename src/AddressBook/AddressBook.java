package AddressBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBook {

    Map<String, ArrayList<String>> humanAddress = new HashMap<>();

    public Map<String, ArrayList<String>> get() {
        return humanAddress;
    }

    public void addPersonAddress(String name, List<String> address) {           // метод добавления пары человек - адрес
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Нельзя вводить человека без имени");
        } else {
            if (humanAddress.containsKey(name)) {
                throw new IllegalArgumentException("Такой человек уже записан в адресную книгу.");
            } else {
                if(Integer.parseInt(address.get(1)) > 0 && Integer.parseInt(address.get(2)) > 0 ) {
                    humanAddress.put(name, (ArrayList<String>) address);
                } else {
                    throw new IllegalArgumentException("Неправильный формат ввода квартиры или дома.");
                }

            }
        }


    }

    public void deleteName(String name) {                                                      //метод удаления человека
        if (humanAddress.containsKey(name)) {
            humanAddress.remove(name);
        } else {
            throw new IllegalArgumentException("Такого человека и так нет.");
        }

    }

    public void change(String name, List<String> address) {                           // метод изменения адреса человека
        if (humanAddress.containsKey(name)) {
            humanAddress.get(name).remove(address);
            ArrayList<String> listAddress = new ArrayList<>();
            listAddress.addAll(address);
            humanAddress.put(name, listAddress);
        } else {
            throw new IllegalArgumentException("Такого человека нет в адресной книге. Изменить адрес невозможно");
        }

    }

    public String searchAddress(String name) {                                        // метод получения адреса человека
        if (humanAddress.containsKey(name))
            return humanAddress.get(name).toString();
        throw new IllegalArgumentException("Такого человека нет");
    }

    public String search(String address) {
        for (Map.Entry entry : humanAddress.entrySet()) {                       // метод получения списка людей, живущих
            if (entry.getValue().toString().contains(address))                   //на заданной улице или в заданном доме
                return entry.getKey().toString();
        }
        throw new IllegalArgumentException("Такого адреса нет");
    }









}
