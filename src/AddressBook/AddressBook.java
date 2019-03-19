package AddressBook;

import java.util.*;

class AddressBook {

    private Map<String, Address> humanAddress = new HashMap<>();

    Map<String, Address> get() {
        return humanAddress;
    }

    void addPersonAddress(String name, Address address) {           // метод добавления пары человек - адрес
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Нельзя вводить человека без имени");
        } else {
            if (humanAddress.containsKey(name)) {
                throw new IllegalArgumentException("Такой человек уже записан в адресную книгу.");
            } else {
                humanAddress.put(name, address);
            }
        }
    }

    void deleteName(String name) {                                                      //метод удаления человека
        if (humanAddress.containsKey(name)) {
            humanAddress.remove(name);
        } else {
            throw new IllegalArgumentException("Такого человека и так нет.");
        }

    }

    void change(String name, Address address) {                           // метод изменения адреса человека
        if (humanAddress.containsKey(name)) {
            humanAddress.replace(name, address);
        } else {
            throw new IllegalArgumentException("Такого человека нет в адресной книге. Изменить адрес невозможно");
        }

    }

    String searchAddress(String name) {                                        // метод получения адреса человека
        if (humanAddress.containsKey(name))
            return humanAddress.get(name).toString();
        throw new IllegalArgumentException("Такого человека нет");
    }


    List<String> searchOnStreet(String street) {                                    //метод поиска людей, живущих на
        List<String> listOfPersonOnStreet = new ArrayList<>();                      //заданной улице
        for (Map.Entry<String, Address> addressBook : humanAddress.entrySet()) {
            if (Objects.equals(addressBook.getValue().getStreet(), street)) {
                listOfPersonOnStreet.add(addressBook.getKey());
            }
        }
        return listOfPersonOnStreet;
    }

    List<String> searchOnHouse(String street, int house) {                           //метод поиска людей, живущих в
        List<String> listOfPersonOnHouse = new ArrayList<>();                        //заданном доме
        for (Map.Entry<String, Address> addressBook : humanAddress.entrySet()) {
            if (Objects.equals(addressBook.getValue().getStreet(), street) &&
                    addressBook.getValue().getHouse() == house) {
                listOfPersonOnHouse.add(addressBook.getKey());
            }
        }
        return listOfPersonOnHouse;
    }
}
