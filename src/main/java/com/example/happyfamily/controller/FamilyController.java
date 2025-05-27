package com.example.happyfamily.controller;

import com.example.happyfamily.entities.*;
import com.example.happyfamily.enums.DayOfWeek;
import com.example.happyfamily.enums.Gender;
import com.example.happyfamily.service.FamilyService;

import java.time.LocalDateTime;
import java.util.*;

public class FamilyController {

    private final FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    public Family getFamilyByIndex(int index) {
        return familyService.getFamilyByIndex(index);
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyService.deleteFamilyByIndex(index);
    }

    public boolean deleteFamily(Family family) {
        return familyService.deleteFamily(family);
    }

    public boolean saveFamily(Family family) {
        return familyService.saveFamily(family);
    }

    public void displayAllFamilies(List<Family> families) {
        familyService.displayAllFamilies(families);
    }

    public List<Family> getFamiliesBiggerThan(List<Family> families, int count) {
        return familyService.getFamiliesBiggerThan(families, count);
    }

    public List<Family> getFamiliesLesserThan(List<Family> families, int count) {
        return familyService.getFamiliesLesserThan(families, count);
    }

    public int countFamiliesWithMemberNumber(List<Family> families, int memberNumber) {
        return familyService.countFamiliesWithMemberNumber(families, memberNumber);
    }

    public void createNewFamily(Woman mother, Man father) {
        familyService.createNewFamily(mother, father);
    }

    public Family bornChild(Family family, String childName, Gender gender) {
        return familyService.bornChild(family, childName, gender);
    }

    public Family adoptChild(Family family, Human adoptedChild) {
        return familyService.adoptChild(family, adoptedChild);
    }

    public boolean deleteAllChildrenOlderThan(int birthDate) {
        return familyService.deleteAllChildrenOlderThan(birthDate);
    }

    public int count() {
        return familyService.count();
    }

    public Family getFamilyById(int familyID) {
        return familyService.getFamilyById(familyID);
    }

    public Set<Pet> getPets(int familyIndex) {
        return familyService.getPets(familyIndex);
    }

    public boolean addPet(int familyIndex, Pet pet) {
        return familyService.addPet(familyIndex, pet);
    }

}
