package com.example.happyfamily.service;

import com.example.happyfamily.dao.CollectionFamilyDAO;
import com.example.happyfamily.dao.FamilyDAO;
import com.example.happyfamily.entities.*;
import com.example.happyfamily.enums.DayOfWeek;
import com.example.happyfamily.enums.Gender;

import java.time.LocalDateTime;
import java.util.*;

public class FamilyService implements FamilyDAO{

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

    public Family bornChild(Family family, String childName, Gender gender) {
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
        return family;
    }

    public Family adoptChild(Family family, Human adoptedChild) {
        if (family == null && adoptedChild == null)
            throw new IllegalArgumentException("Family or child you given can't be null");
        family.addChild(adoptedChild);
        return family;
    }

    public boolean deleteAllChildrenOlderThan(int birthDate) {
        if (birthDate < 1900 || birthDate > LocalDateTime.now().getYear())
            throw new IllegalArgumentException("Year cannot be lower than 1900 or bigger than current year!");
        List<Family> families = getAllFamilies();

        for (Family family : families) {
            for (int i = 0; i < family.getChildren().size(); i++) {
                if (family.getChildren().get(i).getDateOfBirth() > birthDate) {
                    family.deleteChild(family.getChildren().get(i));
                }
            }
        }
        return true;
    }

    public int count() {
        return getAllFamilies().size();
    }

    public Family getFamilyById(int familyID) {
        if (familyID < 0) throw new IllegalArgumentException("ID given must be at least 0!");
        return getAllFamilies().get(familyID);
    }

    public Set<Pet> getPets(int familyIndex) {
        if (familyIndex < 0) throw new IllegalArgumentException("Index given must be at least 0!");
        return getAllFamilies().get(familyIndex).getPets();
    }

    public boolean addPet(int familyIndex, Pet pet) {
        if (pet == null || familyIndex < 0) throw new NullPointerException("Pet can't be null!");
        getAllFamilies().get(familyIndex).getPets().add(pet);
        return true;
    }
}
