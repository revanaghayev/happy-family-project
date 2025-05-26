package com.example.happyfamily.entities;

import java.util.*;

public class Family {

    private final Human mother;
    private final Human father;
    private List<Human> children;
    private Set<Pet> pets;

    static {
        System.out.println(Family.class.getName() + " class loaded successfully!");
    }

    {
        System.out.println(this.getClass().getTypeName() + " object created successfully!");
    }

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
    }

    public boolean addChild(Human human) {
        if (human == null || children.contains(human)){
            System.out.println("Invalid input!");
            return false;
        }

        this.children.add(human);
        System.out.println("Child added successfully!");
        return true;
    }

    public boolean deleteChild(int deleteIndex) {
        if (children == null || deleteIndex < 0 || deleteIndex >= children.size() || children.get(deleteIndex) == null ) {
            System.out.println("Can't delete any child object!");
            return false;
        }

        this.children.remove(deleteIndex);
        System.out.println("Child deleted successfully!");
        return true;
    }

    public boolean deleteChild(Human child) {
        if (children == null || child == null) return false;
        this.children.remove(child);
        return true;
    }

    public int countFamily() {
        int count = 0;
        if (mother != null) count++;
        if (father != null) count++;
        if (children != null) count += children.size();
        if (pets != null) count++;
        return count;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Set<Pet> getPet() {
        return this.pets;
    }

    public void setPet(Set<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Family family)) return false;
        return Objects.equals(mother, family.mother)
                && Objects.equals(father, family.father)
                && Objects.deepEquals(children, family.children)
                && Objects.equals(pets, family.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, children, pets);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("This object has been deleted!");
        super.finalize();
    }

    @Override
    public String toString() {
        return "Family{" +
                " Mother = " + mother +
                ", Father = " + father +
                ", Children = " + children +
                ", Pet = " + pets +
                '}';
    }
}
