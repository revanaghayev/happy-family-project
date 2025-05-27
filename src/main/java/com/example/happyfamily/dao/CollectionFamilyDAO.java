package com.example.happyfamily.dao;

import com.example.happyfamily.entities.Family;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDAO implements FamilyDAO {

    public final List<Family> families = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return this.families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if (index > 0 && index < families.size()) {
            return families.get(index);
        }
        return null;
    }

    @Override
    public boolean deleteFamilyByIndex(int index) {
        if (index > 0 && index < families.size()) {
            return families.remove(families.get(index));
        }
        return false;
    }

    @Override
    public boolean deleteFamily(Family family) {
        return families.remove(family);
    }

    @Override
    public boolean saveFamily(Family family) {
        if (family == null) return false;
        int index = families.indexOf(family);
        if (index >= 0 ) {
            families.set(index, family);
        }else {
            families.add(family);
        }
        return true;
    }
}
