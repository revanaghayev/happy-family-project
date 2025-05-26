package com.example.happyfamily.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestPet {

    @Test
    public void testEquals_sameValues_shouldReturnTrue() {
        Pet pet1 = new Dog("Rex");
        Pet pet2 = new Dog("Rex");

        assertEquals(pet1, pet2);
        assertTrue(pet1.equals(pet2));
    }

    @Test
    public void testEquals_differentValues_shouldReturnFalse() {
        Pet pet1 = new Dog("Rex");
        Pet pet2 = new RoboCat("Kisa");
        Pet pet3 = new Dog("Jackie Chan");

        assertNotEquals(pet1, pet2);
        assertNotEquals(pet1, pet3);
        assertFalse(pet1.equals(pet2));
        assertFalse(pet1.equals(pet3));
    }

    @Test
    public void testEquals_null_shouldReturnFalse() {
        Pet pet1 = new Dog("Rex");
        Pet pet3 = new Dog(null);

        assertNotEquals(pet1, pet3);
    }

    @Test
    public void testHashcode_sameValues_shouldBeEqual() {
        Pet pet1 = new Dog("Rex");
        Pet pet3 = new Dog("Rex");

        assertEquals(pet1.hashCode(), pet3.hashCode());
    }

    @Test
    public void testHashcode_differentValues_shouldBeDifferent() {
        Pet pet1 = new Dog("Rex");
        Pet pet3 = new Dog("Rex");

        assertNotEquals(pet1.hashCode(), pet3.hashCode());
    }
}
