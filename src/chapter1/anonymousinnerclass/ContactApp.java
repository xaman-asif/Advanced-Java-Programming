package chapter1.anonymousinnerclass;

import java.util.List;

public class ContactApp {
    public static void main(String[] args) {
        List<Contact> contactList = List.of(new Contact("Will Smith", "will@gmail.com", 50, Contact.Sex.MALE),
                new Contact("Ellen DeGeneres", "elen@gmail.com", 60, Contact.Sex.FEMALE),
                new Contact("Sheldon Cooper", "shelly@gmail.com", 10, Contact.Sex.MALE),
                new Contact("Nuhash Humayun", "nuhash@gmail.com", 23, Contact.Sex.MALE));

        ContactService contactService = new ContactService();


        List<Contact> contactAged18To25 = contactService.findContacts(contactList, new FilterCriteria() {
            @Override
            public boolean match(Contact contact) {
                return 18 <= contact.getAge() && contact.getAge() <= 25;
            }
        });

        //we can even do this in lambda expression
        List<Contact> contactAged18To25Female = contactService.findContacts(contactList, (Contact contact) -> {
                return 18 <= contact.getAge() && contact.getAge() <= 25 && contact.getSex() == Contact.Sex.FEMALE;
        });
    }
}
