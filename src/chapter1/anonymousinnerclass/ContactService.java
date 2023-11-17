package chapter1.anonymousinnerclass;

import java.util.ArrayList;
import java.util.List;

public class ContactService {

    //we can use this anonymous inner class to reduce boilerplate code
    public List<Contact> findContacts(List<Contact> contacts, FilterCriteria criteria) {
        List<Contact> matchedContacts = new ArrayList<>();

        for (Contact contact: contacts) {
            if (criteria.match(contact)) {
                matchedContacts.add(contact);
            }
        }

        return matchedContacts;
    }




    public List<Contact> findContactAgedBetween18And25(List<Contact> contacts) {
        List<Contact> contactAgedBetween18And25 = new ArrayList<>();

        for (Contact contact: contacts) {
            if (18 <= contact.getAge() && contact.getAge() <= 25) {
                contactAgedBetween18And25.add(contact);
            }
        }

        return contactAgedBetween18And25;
    }
    public List<Contact> findMaleContactAgeBetween18And25(List<Contact> contacts) {
        List<Contact> maleAgedBetween18And25 = new ArrayList<>();

        for (Contact contact : contacts) {
            if (18 <= contact.getAge() && contact.getAge() <= 25 && contact.getSex() == Contact.Sex.MALE) {
                maleAgedBetween18And25.add(contact);
            }
        }

        return maleAgedBetween18And25;
    }
    public List<Contact> findFemaleContactAgeBetween18And25(List<Contact> contacts) {
        List<Contact> femaleAgedBetween18And25 = new ArrayList<>();

        for (Contact contact : contacts) {
            if (18 <= contact.getAge() && contact.getAge() <= 25 && contact.getSex() == Contact.Sex.FEMALE) {
                femaleAgedBetween18And25.add(contact);
            }
        }

        return femaleAgedBetween18And25;
    }
}
