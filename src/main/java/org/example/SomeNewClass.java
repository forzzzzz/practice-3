package org.example;

class SomeNewClass implements Displayable {
    private final String data;

    public SomeNewClass(String data) {
        this.data = data;
    }

    @Override
    public void display(String format) {
        System.out.println("Data: " + data);
    }
}
