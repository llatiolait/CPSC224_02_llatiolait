/*
Luc Latiolait
CPSC 224 02
*/

public class Pet {
    private String name;
    private String animal;
    private int age;

    public void setName(String inputName) {
        name = inputName;
    }

    public void setAnimal(String inputAnimal) {
        animal = inputAnimal;
    }

    public void setAge(int inputAge) {
        age = inputAge;
    }

    public String getName() {
        return name;
    }

    public String getAnimal() {
        return animal;
    }

    public int getAge() {
        return age;
    }
}