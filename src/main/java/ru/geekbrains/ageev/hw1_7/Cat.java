package ru.geekbrains.ageev.hw1_7;

public class Cat {

    private String name;
    private int appetite;
    private boolean fullness;

    public Cat(String name, int appetite, boolean fullness) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = fullness;
    }

    public void eat(Plate p) {
        if (p.getFood() >= appetite){
            p.decreaseFood(appetite);
            fullness = true;
            System.out.printf("Кот %s наелся!\n", getName());
        }
        else {
            System.out.printf("Недостаточно еды в тарелке для кота %s!\n", getName());
        }
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isFullness() {
        return fullness;
    }

    public void checkFulness(){
        if (isFullness() == true){
            System.out.printf("Кот %s наелся!\n", getName());
        }
        else {
            System.out.printf("Кот %s остался голодным\n", getName());
        }
    }
}
