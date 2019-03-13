package Test_for_AddressBook;

import AddressBook.AddressBook;
import  org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Test_for_AddressBook {

    private static AddressBook createAddressBook() {
        AddressBook addressBook = new AddressBook();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        List<String> list4 = new ArrayList<>();
        List<String> list5 = new ArrayList<>();
        list1.add("Umtiti street");
        list1.add("221");
        list1.add("56");
        list2.add("Pogba street");
        list2.add("32");
        list2.add("114");
        list3.add("Nevskiy street");
        list3.add("333");
        list3.add("4");
        list4.add("Endshpil street");
        list4.add("5");
        list4.add("776");
        list5.add("Russetilskiy street");
        list5.add("23");
        list5.add("17");

        addressBook.addPersonAddress("Savage", list1);
        addressBook.addPersonAddress("Skott", list2);
        addressBook.addPersonAddress("Ronaldo", list3);
        addressBook.addPersonAddress("Matic", list4);
        addressBook.addPersonAddress("Neymar", list5);

        return addressBook;
    }



   @Test
   void addPersonAddress() {
        AddressBook addressBook = createAddressBook();
        List<String> list6 = new ArrayList<>();
        List<String> list7 = new ArrayList<>();
        List<String> list8 = new ArrayList<>();
        List<String> list9 = new ArrayList<>();
        List<String> list22 = new ArrayList<>();
        List<String> list23 = new ArrayList<>();
        list6.add("Morata street");
        list6.add("55");
        list6.add("89");
        list7.add("Petrodskaya street");
        list7.add("42");
        list7.add("19");
        list8.add("Gastronomskaya street");
        list8.add("77");
        list8.add("66");
        list9.add("Arabskaya");
        list9.add("9");
        list9.add("46");
        list9.add("Garage");
        list9.add("-9");
        list9.add("46");
        list9.add("Padik");
        list9.add("9");
        list9.add("-46");
        addressBook.addPersonAddress("Abuma", list6);
        addressBook.addPersonAddress("Azmun", list7);

        assertEquals(7, addressBook.get().size());
        assertThrows(IllegalArgumentException.class, () -> addressBook.addPersonAddress("Ronaldo", list8));
        assertThrows(IllegalArgumentException.class, () -> addressBook.addPersonAddress("", list9));
        assertThrows(IllegalArgumentException.class, () -> addressBook.addPersonAddress("Ronaldo", list22));
        assertThrows(IllegalArgumentException.class, () -> addressBook.addPersonAddress("Ronaldo", list23));

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
        List<String> list10 = new ArrayList<>();
        list10.add("Arbat");
        list10.add("1");
        list10.add("2");

        addressBook.change("Ronaldo", list10);
        assertThrows(IllegalArgumentException.class, () -> addressBook.change("Ronaldu", list10));
        assertEquals(list10.toString(), addressBook.searchAddress("Ronaldo"));
   }


   @Test
    void searchAddress() {
        AddressBook addressBook = createAddressBook();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.add("Umtiti street");
        list1.add("221");
        list1.add("56");
        list2.add("Pogba street");
        list2.add("32");
        list2.add("114");
        assertEquals(list1.toString(), addressBook.searchAddress("Savage"));
        assertEquals(list2.toString(), addressBook.searchAddress("Skott"));
   }


   @Test
    void search() {
        AddressBook addressBook = createAddressBook();
        assertEquals("Ronaldo", addressBook.search("Nevskiy street"));
        assertEquals("Ronaldo", addressBook.search("333"));
   }






}
