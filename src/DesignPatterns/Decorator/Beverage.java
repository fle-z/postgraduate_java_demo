package DesignPatterns.Decorator;

public abstract class Beverage {
    String description = "Unknow Deverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
