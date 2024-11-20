package com.example.spring_study.lombok;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Lombok annotations used:
 * - @Getter: Generates getter methods for all fields.
 * - @Setter: Generates setter methods for all fields.
 * - @ToString: Generates a toString() method to represent the object in string format.
 */
@Getter
@Setter
@ToString
public class Person {
    int hairStyle;
    int skin;
    int top;
    int bottom;
    int shoes;

    public Person(int hairStyle, int skin, int top, int bottom, int shoes) {
        this.hairStyle = hairStyle;
        this.skin = skin;
        this.top = top;
        this.bottom = bottom;
        this.shoes = shoes;
    }
}
