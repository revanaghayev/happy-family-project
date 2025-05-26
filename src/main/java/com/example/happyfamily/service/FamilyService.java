package com.example.happyfamily.service;

import com.example.happyfamily.dao.FamilyDAO;
import com.example.happyfamily.entities.*;
import com.example.happyfamily.enums.DayOfWeek;
import com.example.happyfamily.enums.Gender;

import java.time.LocalDateTime;
import java.util.*;

public class FamilyService {

    private FamilyDAO familyDao;

    public FamilyService(FamilyDAO familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public Family getFamilyByIndex(int index) {
        return familyDao.getFamilyByIndex(index);
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamilyByIndex(index);
    }

    public boolean deleteFamily(Family family) {
        return familyDao.deleteFamily(family);
    }

    public boolean saveFamily(Family family) {
        return familyDao.saveFamily(family);
    }

    public void displayAllFamilies(List<Family> families) {
        if (families == null) {
            System.out.println("No such families to show!");
        } else {
            for (int i = 0; i < families.size(); i++) {
                System.out.println(i + ") " + families.get(i));
            }
        }
    }

    public List<Family> getFamiliesBiggerThan(List<Family> families, int count) {
        if (count <= 0) return Collections.emptyList();

        List<Family> familiesBiggerThan = new ArrayList<>();
        for (Family family : families) {
            if (family.countFamily() > count) {
                familiesBiggerThan.add(family);
            }
        }
        return familiesBiggerThan;
    }

    public List<Family> getFamiliesLesserThan(List<Family> families, int count) {
        if (count <= 0) return Collections.emptyList();

        List<Family> familiesLesserThan = new ArrayList<>();
        for (Family family : families) {
            if (family.countFamily() < count) {
                familiesLesserThan.add(family);
            }
        }
        return familiesLesserThan;
    }

    public Integer countFamiliesWithMemberNumber(List<Family> families, int memberNumber) {
        for (Family family : families) {
            if (family.countFamily() == memberNumber) {
                memberNumber++;
            }
        }
        return memberNumber;
    }

    public void createNewFamily(Woman mother, Man father) {
        Family family = new Family(mother, father);
        saveFamily(family);
    }

    public void bornChild(Family family, String childName, Gender gender) {
        if (family == null) {
            throw new IllegalArgumentException("Family cannot be null.");
        }

        if (childName == null || gender == null) {
            throw new IllegalArgumentException("Child name and gender must not be null.");
        }

        if (family.getFather() == null || family.getMother() == null) {
            throw new IllegalStateException("Both father and mother must be present to generate child.");
        }

        Human child = (gender == Gender.MALE ?
                new Man(childName, family.getFather().getSurname(), LocalDateTime.now().getYear(),
                        ((family.getFather().getIq() + family.getMother().getIq()) / 2),
                        Map.of(DayOfWeek.MONDAY.name(), "Crying everyday for MILK!"), family) :
                new Woman(childName, family.getFather().getSurname(), LocalDateTime.now().getYear(),
                        ((family.getFather().getIq() + family.getMother().getIq()) / 2),
                        Map.of(DayOfWeek.MONDAY.name(), "Crying everyday for MILK!"), family));
        family.addChild(child);
    }

}
