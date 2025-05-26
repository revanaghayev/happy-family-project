package com.example.happyfamily.dao;

import com.example.happyfamily.entities.Family;

import java.util.List;

public interface FamilyDAO {
    List<Family> getAllFamilies();
    Family getFamilyByIndex(int index);
    boolean deleteFamilyByIndex(int index);
    boolean deleteFamily(Family family);
    boolean saveFamily(Family family);
}
