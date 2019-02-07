public class PetMain {
    public static void main(String[] args) {
        Pet instance1 = new Pet();
        instance1.setName("asdf");
        instance1.setAnimal("dog");
        instance1.setAge(5);

        System.out.println(instance1.getName() + " " + instance1.getAnimal() + " " + instance1.getAge());
    }
}