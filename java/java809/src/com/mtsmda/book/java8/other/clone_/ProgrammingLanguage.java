package com.mtsmda.book.java8.other.clone_;

/**
 * Created by dminzat on 11/14/2016.
 */
public class ProgrammingLanguage implements ICloneable<ProgrammingLanguage> {

    private String name;
    private String authorCreator;
    private int since;

    public ProgrammingLanguage() {

    }

    public ProgrammingLanguage(String name, String authorCreator, int since) {
        this.name = name;
        this.authorCreator = authorCreator;
        this.since = since;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorCreator() {
        return authorCreator;
    }

    public void setAuthorCreator(String authorCreator) {
        this.authorCreator = authorCreator;
    }

    public int getSince() {
        return since;
    }

    public void setSince(int since) {
        this.since = since;
    }


    @Override
    public ProgrammingLanguage clone() {
        return new ProgrammingLanguage(this.getName(), this.getAuthorCreator(), this.getSince());
    }

    @Override
    public String toString() {
        return "ProgrammingLanguage{" +
                "name='" + name + '\'' +
                ", authorCreator='" + authorCreator + '\'' +
                ", since=" + since +
                '}';
    }
}