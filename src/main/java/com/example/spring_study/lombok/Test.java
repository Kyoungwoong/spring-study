package com.example.spring_study.lombok;

public class Test {
    public static void main(String[] args) {
        // @Getter, @Setter
        Person person = new Person(1, 3, 4, 5, 8);
        System.out.println(person.getShoes()); // getShoes() automatically generated
        person.setShoes(84); // setShoes() automatically generated
        System.out.println(person.getShoes());

        // @ToString
        System.out.println("person.toString: " + person.toString()); // toString() automatically generated

        // @NoArgsConstructor / @AllArgsConstructor
        Animal tomy = new Animal(20, "tomy");
        Animal aymee = new Animal(); // Default constructor automatically generated
        System.out.println("tomy = " + tomy); // toString() automatically generated
        System.out.println("aymee = " + aymee); // toString() automatically generated

        // @Builder
        Animal hiro = Animal.builder().age(7).name("hiro").build(); // Using builder pattern
        System.out.println("hiro.toString() = " + hiro); // toString() automatically generated

        // @EqualsAndHashCode, @RequiredArgsConstructor
        Plant plant1 = new Plant(2, "korea");
        Plant plant2 = new Plant(2, "korea");

        // @Data
        System.out.println("plant1 equals plant2: " + plant1.equals(plant2)); // true, since fields are the same
        System.out.println("plant1 hashCode: " + plant1.hashCode()); // Same hashCode for equal objects
        System.out.println("plant2 hashCode: " + plant2.hashCode()); // Same hashCode for equal objects

        // @RequiredArgsConstructor automatically generates a constructor with final fields
        Plant plant3 = new Plant(3, "japan"); // Constructor with height and origin fields
        System.out.println("plant3: " + plant3); // toString() automatically generated
    }
}