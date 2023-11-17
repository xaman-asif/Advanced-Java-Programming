package chapter1.anonymousinnerclass.interfaceexample;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public List<Person> filter(List<Person> personList, Filterable filterable) {
    List<Person> filteredPersonList = new ArrayList<>();

    for (Person person : personList) {
      if (filterable.apply(person)) {
        filteredPersonList.add(person);
      }
    }

    return filteredPersonList;
  }

  List<Person> personList = loadPersons();

  private List<Person> loadPersons() {

    return null;
  }

  //here we are passing an anonymous inner class into interface's argument
  List<Person> personOlderThan30 = filter(personList, new Filterable() {
    @Override
    public boolean apply(Person person) {
      return person.getAge() > 30;
    }
  });

  //we can also assign the anonymous inner class into a variable
  Filterable filterable = new Filterable() {
    @Override
    public boolean apply(Person person) {
      return person.getAge() > 50;
    }
  };

  //then do the same operation like before

  List<Person> personOlderThan50 = filter(personList, filterable);

}
