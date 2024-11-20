package com.example.spring_study.lombok;

import lombok.Data;

/**
 * Lombok annotations used:
 * - @Data: Generates getters, setters, toString(), equals(), and hashCode() methods automatically.
 */
@Data
public class Plant {
    private int height;
    private String origin;
    public Plant(int height, String origin) {
        this.height = height;
        this.origin = origin;
    }
}
