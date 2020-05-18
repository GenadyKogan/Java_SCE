package game.entities.sportsman;

import game.entities.MobileEntity;
import game.enums.Gender;


public class Sportsman extends MobileEntity {
    private final String name;
    private final double age;
    private final Gender gender;

    public Sportsman(String name, double age, Gender gender, double acceleration, double maxSpeed) {
        super(0, acceleration,maxSpeed);
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    //region Getters & setters
    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }
    
}
