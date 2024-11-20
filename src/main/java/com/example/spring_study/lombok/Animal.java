package com.example.spring_study.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * Represents an animal with age and name attributes.
 * Lombok annotations used:
 * - @NoArgsConstructor: Generates a no-arguments constructor.
 * - @AllArgsConstructor: Generates a constructor with arguments for all fields.
 * - @Builder: Implements the builder pattern for creating instances of this class.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Animal {
    int age;
    String name;
}