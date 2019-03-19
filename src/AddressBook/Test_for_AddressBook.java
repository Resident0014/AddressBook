package AddressBook;


import  org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Test_for_AddressBook {

    private static AddressBook createAddressBook() {
        AddressBook addressBook = new AddressBook();
        addressBook.addPersonAddress("Ronaldo", new Address("Невский проспект", 20, 22));
        addressBook.addPersonAddress("Mbappe", new Address("Невский проспект", 20, 223));
        addressBook.addPersonAddress("Messi", new Address("Невский проспект", 20, 11));
        addressBook.addPersonAddress("Neymar", new Address("Обводная улица", 2, 26));
        addressBook.addPersonAddress("Marcelo", new Address("Геройский проспект", 77, 56));
        return addressBook;
    }



   @Test
   void addPersonAddress() {
        AddressBook addressBook = createAddressBook();
        addressBook.addPersonAddress("Dzuba", new Address("проспект Макарова", 34, 76));
        addressBook.addPersonAddress("Azmun", new Address("улица Правды", 222, 13));

        assertEquals(7, addressBook.get().size());
        assertThrows(IllegalArgumentException.class, () -> addressBook.addPersonAddress("Ronaldo", new Address("проспект Рассела", 34, 43)));
        assertThrows(IllegalArgumentException.class, () -> addressBook.addPersonAddress("", new Address("проспект Мира", 33, 44)));
        assertThrows(IllegalArgumentException.class, () -> addressBook.addPersonAddress("Ronaldo", new Address("проспект Мира", -8, 78)));
        assertThrows(IllegalArgumentException.class, () -> addressBook.addPersonAddress("Ronaldo", new Address("проспект Мира", 8, -77)));

   }


   @Test
    void deleteName() {
        AddressBook addressBook = createAddressBook();
        addressBook.deleteName("Ronaldo");
        assertEquals(4, addressBook.get().size());
        assertThrows(IllegalArgumentException.class, () -> addressBook.deleteName("Ronaldu"));
   }


   @Test
    void change() {
        AddressBook addressBook = createAddressBook();


        addressBook.change("Ronaldo", new Address("Проспект Ветеранов", 89, 99));
        assertThrows(IllegalArgumentException.class, () -> addressBook.change("Ronaldu", new Address("Улица Рабов", 99, 6)));
        assertEquals(new Address("Проспект Ветеранов", 89, 99).toString(), addressBook.searchAddress("Ronaldo"));
   }


   @Test
    void searchAddress() {
        AddressBook addressBook = createAddressBook();
        assertEquals(new Address("Невский проспект", 20, 223).toString(), addressBook.searchAddress("Mbappe"));
        assertEquals(new Address("Обводная улица", 2, 26).toString(), addressBook.searchAddress("Neymar"));
   }


   @Test
    void searchOnStreet() {
        AddressBook addressBook = createAddressBook();
        assertEquals(Arrays.asList("Ronaldo", "Messi", "Mbappe"), addressBook.searchOnStreet("Невский проспект"));
        assertEquals(Collections.emptyList(), addressBook.searchOnStreet("Монополистов"));
        assertEquals(Collections.singletonList("Marcelo"), addressBook.searchOnStreet("Геройский проспект"));
   }


   @Test
    void searchOnHouse() {
       AddressBook addressBook = createAddressBook();
       assertEquals(Arrays.asList("Ronaldo", "Messi", "Mbappe"), addressBook.searchOnHouse("Невский проспект", 20));
       assertEquals(Collections.emptyList(), addressBook.searchOnHouse("АРАРАРАР", 23));
       assertEquals(Collections.singletonList("Neymar"), addressBook.searchOnHouse("Обводная улица", 2));
   }






}
