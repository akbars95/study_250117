package com.mtsmda.java8.certification.chapter2.javaOperators;

/**
 * Created by dminzat on 7/6/2016.
 */
public class LogicalOperators {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("IiI");
        if(person != null && person.getName().length() > 1){
            System.out.println("person != null && person.getName().length() > 1");
        }
        person.setName(null);

        try{
            if(person != null & person.getName().length() > 0){
                System.out.println("person != null & person.getName() != null");
            }
        }
        catch (NullPointerException e){
            System.out.println(e.getClass().getName() + " - " + e.getMessage());
        }

        System.out.println("-------------------------");

        String s1 = null;
        String s2 = new String("ABC");
        System.out.println("s1 == s2 = " + (s1 == s2));
        String s3 = s2;
        s2 = null;
        System.out.println("s1 == s2 = " + (s1 == s2));
        System.out.println("-------------------------");

        String s_1 = "ABC";
        String s_2 = new String("ABC");
        String s_3 = "ABC";

        System.out.println("s_1 == s_2 = " + (s_1 == s_2));//f
        System.out.println("s_1 == s_3 = " + (s_1 == s_3));//t
        System.out.println("s_2 == s_3 = " + (s_2 == s_3));//f

        System.out.println("s_2.equals(s_1) = " + (s_2.equals(s_1)));//t
        System.out.println("s_3.equals(s_1) = " + (s_3.equals(s_1)));//t
        System.out.println("s_2.equals(s_3) = " + (s_2.equals(s_3)));//t


        Person person1 = new Person("person1");
        Person person2 = new Person("person2");
        Person person3 = person1;

        System.out.println("/*/*/*/*/*/*/*/*/*/*//*/*/*/*/*/***/*");
        System.out.println("person1 == person3 = " + (person1 == person3));
        person1 = null;
        System.out.println("person1 == person3 = " + (person1 == person3));
        person1 = person3;
        person1.setName("III");
        System.out.println("person1 == person3 = " + (person1 == person3));
        System.out.println(person1.getName().equals(person3.getName()));
    }

}

class Person{
    private String name;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}