package com.taktelon.classspanish.items;

public class VerbItem {
    public final String id;
    public final String verb;
    public final String meaning;

    public VerbItem(String id, String verb, String meaning) {
        this.id = id;
        this.verb = verb;
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return verb;
    }
}
