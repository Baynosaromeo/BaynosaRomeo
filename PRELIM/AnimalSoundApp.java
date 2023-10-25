import java.util.Scanner;

class Animal {
    String name;
    String sound;

    public Animal(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }

    public String makeSound() {
        return sound;
    }
}

class Dog extends Animal {
    public Dog() {
        super("Dog", "awww awwww awww!");
    }
}

class Cat extends Animal {
    public Cat() {
        super("Cat", "meoww meoww meowww!");
    }
}

class Duck extends Animal {
    public Duck() {
        super("Duck", "Quack!");
    }
}

class Chicken extends Animal {
    public Chicken() {
        super("Chicken", "Togg to ga okkkk!");
    }
}

public class AnimalSoundApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Animal Sound App!");

        while (true) {             System.out.println("\nChoose an animal (1 Dog, 2 Cat, 3 Duck, 4 Chicken, 0 Exit):");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Goodbye!");
                break;             }

            Animal selectedAnimal = null;

            switch (choice) {
                case 1:
                    selectedAnimal = new Dog();
                    break;
                case 2:
                    selectedAnimal = new Cat();
                    break;
                case 3:
                    selectedAnimal = new Duck();
                    break;
                case 4:
                    selectedAnimal = new Chicken();
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    continue;             }

            System.out.println(selectedAnimal.name + " says: " + selectedAnimal.makeSound());
        }
        
        scanner.close();
    }
}
