package DesignPatterns.StrategyPattern;

public class MallardDuck extends Duck {
    /*
    绿头鸭使用Quack类处理呱呱叫，所以当performQuack(在抽象类Duck中)被调用时，
    叫的职责被委托给Quack对象
     */
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
