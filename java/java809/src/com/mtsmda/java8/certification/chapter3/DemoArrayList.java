package com.mtsmda.java8.certification.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by dminzat on 7/13/2016.
 */
public class DemoArrayList {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        System.out.println(integers.size());
        List<String> strings = new ArrayList<>(19);
        strings.add("bbb");
        System.out.println(strings.toString());
        System.out.println(strings.size());
        try {
            new ArrayList<>(-9);
        } catch (RuntimeException e) {
            System.out.println(e.getClass().getCanonicalName());
            System.out.println(e.getMessage());
        }

        System.out.println("---------------------------");
        List<Integer> integerList = new ArrayList<>();
        System.out.println(integerList.add(19));
        System.out.println(integerList.add(29));
        integerList.add(0, 9);
        integerList.add(integerList.size(), 99);
        integerList.add(99);
        integerList.add(9783);
        System.out.println(integerList);

        System.out.println(integerList.remove(new Integer(9783)));
        System.out.println(integerList.remove(new Integer(99)));
        System.out.println(integerList);
        System.out.println(integerList.remove(integerList.size() - 1));
        System.out.println(integerList);

        Person personIon = new Person("Ion", "Ionica");
        Person personIvan = new Person("Ivan", "Ivanov");
        Person personPetr = new Person("Petr", "Petrov");
        List<Person> persons = new ArrayList<>();
        persons.add(personIon);
        persons.add(personIvan);
        persons.add(personPetr);

        System.out.println(persons);
        Person personIonCopy = new Person(personIon.getFirstname(), personIon.getLastname());
        //Person class uncomment equals and hashcode methods
//        System.out.println(persons.remove(personIonCopy));
//        System.out.println(persons.remove(1));
        System.out.println(persons);

//        System.out.println(persons.set(0, new Person("Vasilii", "Vasiliev")));
//        System.out.println("after set " + persons);
        /*List<Person> personListCopy = persons;
        System.out.println(personListCopy.size());
        System.out.println(persons.size());*/
        /*personListCopy.clear();
        System.out.println(personListCopy.size());
        System.out.println(persons.size());*/
        System.out.println(persons.contains(new Person(personIon.getFirstname(), personIon.getLastname())));


        System.out.println("-----list equals");
        List<Character> characters = new ArrayList<>();
        characters.add(new Character('c'));
        characters.add(new Character('h'));
        characters.add(new Character('a'));
        characters.add(new Character('r'));

        List<Character> characters1 = new ArrayList<>();
        characters1.add(characters.get(0));
        System.out.println(characters.equals(characters1));
        characters1.add(characters.get(1));
        characters1.add(characters.get(2));
        characters1.add(characters.get(3));
        System.out.println(characters.equals(characters1));

        System.out.println("array to list and vice versa");
        List<String> stringList = new ArrayList<>();
        stringList.add("Barcelona");
        stringList.add("Milan");
        stringList.add("Chelsea");

        System.out.println("list = " + stringList.size());
        Object[] objects = stringList.toArray();
        System.out.println("object array = " + objects.length);

//        String[] strings1 = stringList.toArray(new String[]{});
//        String[] strings1 = stringList.toArray(null);
//        String[] strings1 = stringList.toArray(new String[2]);
        String[] strings1 = stringList.toArray(new String[29]);
        stringList.add("Ivanov");
        System.out.println(strings1[strings1.length - 1]);
        System.out.println("array = " + strings1.length);
        System.out.println("list = " + stringList.size());
        System.out.println("object array = " + objects.length);


        //backed list
        String [] arrayStrings = {"hello", "java"};
        List<String> stringListByArray = Arrays.asList(arrayStrings);
        System.out.println("array - " + arrayStrings.length);
        System.out.println("list by array - " + stringListByArray.size());
        stringListByArray.set(1, "String");
        arrayStrings[0] = "new";
        for (String c : arrayStrings){
            System.out.print(c + " ");
        }
        System.out.println();
        System.out.println(stringListByArray.toString());
        try {
            stringListByArray.remove(0);
        }
        catch (UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }

        List<Integer> integerList1 = new ArrayList<>();
        integerList1.add(18);
        integerList1.add(81);
        integerList1.add(1532);
        integerList1.add(171);
        integerList1.add(12018);
        System.out.println(integerList1.toString());
        Collections.sort(integerList1);
        System.out.println(integerList1.toString());

    }

    private static class Person {
        private String firstname;
        private String lastname;

        public Person(String firstname, String lastname) {
            this.firstname = firstname;
            this.lastname = lastname;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        /*@Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (!firstname.equals(person.firstname)) return false;
            return lastname.equals(person.lastname);

        }

        @Override
        public int hashCode() {
            int result = firstname.hashCode();
            result = 31 * result + lastname.hashCode();
            return result;
        }
*/
        @Override
        public String toString() {
            return "Person{" +
                    "firstname='" + firstname + '\'' +
                    ", lastname='" + lastname + '\'' +
                    '}';
        }
    }
}