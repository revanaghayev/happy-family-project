package entities;

import java.util.Arrays;
import java.util.Objects;

public class Family {

    private final Human mother;
    private final Human father;
    private Human[] children;
    private Pet pet;

    static {
        System.out.println("Family object loaded!");
    }

    {
        System.out.println("Family object created!");
    }

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];
    }

    public boolean addChild(Human human) {
        if (human == null || human.contains(human, children)){
            System.out.println("Invalid input!");
            return false;
        }

        Human[] newChildren = Arrays.copyOf(children, children.length+1);
        newChildren[children.length] = human;
        this.children = newChildren;
        System.out.println("Added successfully!");
        return true;
    }

    public boolean deleteChild(int deleteIndex) {
        if (children == null || deleteIndex < 0 || deleteIndex >= children.length || children[deleteIndex] == null ) {
            System.out.println("Not deleted any child object!");
            return false;
        }

        Human[] newChildren = new Human[children.length - 1];
        System.arraycopy(children, 0, newChildren, 0, deleteIndex);
        System.arraycopy(children, deleteIndex + 1, newChildren, deleteIndex, children.length - deleteIndex - 1);
        this.children = newChildren;
        System.out.println("Deleted successfully!");
        return true;
    }

    public boolean deleteChild(Human child) {
        if (children == null || child == null) return false;
        Human[] newChildren = new Human[children.length - 1];
        int j = 0;
        for (int i = 0; i < children.length; i++) {
            if (children[i].equals(child)) {
                return deleteChild(i);
            } else {
                System.out.println("Not deleted any child object!");
                return false;
            }
        }
        return true;
    }

    public int countFamily() {
        int count = 0;
        if (mother != null) count++;
        if (father != null) count++;
        if (children != null) count += children.length;
        if (pet != null) count++;
        return count;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Family family)) return false;
        return Objects.equals(mother, family.mother)
                && Objects.equals(father, family.father)
                && Objects.deepEquals(children, family.children)
                && Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, Arrays.hashCode(children), pet);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("This object has been deleted!");
        super.finalize();
    }

    @Override
    public String toString() {
        return "Family:" +
                " Mother = " + mother +
                ", Father = " + father +
                ", Children = " + Arrays.toString(children) +
                ", Pet = " + pet +
                ';';
    }
}
