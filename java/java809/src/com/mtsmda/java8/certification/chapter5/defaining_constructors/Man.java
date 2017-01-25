package com.mtsmda.java8.certification.chapter5.defaining_constructors;

import java.util.List;

/**
 * Created by dminzat on 7/20/2016.
 */
public class Man {

    private String firstName;
    private String lastName;

    public Man() {
        System.out.println("call 1");
    }

    public Man(String firstName) {
        super();
        this.firstName = firstName;
    }

    public Man(String firstName, String lastName) {
        this(firstName);
        this.lastName = lastName;
    }

    public static void main(String[] args) {
        Man javaMan = new JavaProgrammer();
        System.out.println(javaMan.firstName);

        System.out.println("*****************");
        new CodeIgnaterPHPProgrammer();
        System.out.println("*****************");
        new Eclass();
    }

}

class Programmer extends Man {

    private int level;

    public Programmer() {
        System.out.println("call 2");
    }

    public Programmer(String firstName) {
        super(firstName);
    }

    public Programmer(String firstName, int level) {
        this(firstName);
        this.level = level;
    }

}

class JavaProgrammer extends Programmer {

    public JavaProgrammer() {
        super(/*""*/);
        System.out.println("call 3");
    }

    private void print() {

    }

}

class DotNetProgrammer extends Programmer {

    private List<String> dotNetTehnologies;

    public DotNetProgrammer() {
        System.out.println("call 3");
    }

    public DotNetProgrammer(String firstName, int level, List<String> dotNetTehnologies) {
        super(firstName, level);
        this.dotNetTehnologies = dotNetTehnologies;
    }

}

class PHPProgrammer extends Programmer {

    public PHPProgrammer() {
        super("");
        System.out.println("call 3");
    }
}

class CodeIgnaterPHPProgrammer extends PHPProgrammer {

    public CodeIgnaterPHPProgrammer() {
        super();
        System.out.println("call 4");
    }
}

class Aclass{

    public Aclass() {
        System.out.println("#1");
    }
}

class Bclass extends Aclass{

    public Bclass() {
        System.out.println("#2");
    }
}

class Cclass extends Bclass{

    public Cclass() {
        System.out.println("#3");
    }
}

class Dclass extends Cclass{

    public Dclass() {
        System.out.println("#4");
    }
}

class Eclass extends Dclass{

    public Eclass() {
        System.out.println("#5");
    }
}