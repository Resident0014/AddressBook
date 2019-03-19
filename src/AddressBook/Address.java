package AddressBook;

public class Address {
    private String street;
    private int house;
    private int flat;

    Address(String street, int house, int flat) {
        if (street.isEmpty() || house <=0 || flat <=0) {
            throw new IllegalArgumentException("Адрес введен неправильно.");
        }
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    String getStreet() {
        return this.street;
    }

    int getHouse() {
        return this.house;
    }


    @Override
    public String toString() {
        return "ул. " + street + ", д. " + house + ", кв. " + flat;
    }
}
