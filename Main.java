//Imports
import java.util.Scanner;

//Class
public class Main {

    //Main method
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();
        Scanner scanner = new Scanner(System.in);

        //Menu
        while (true) {
            System.out.println("\nAnimal Shelter Management");
            System.out.println("1. Add Animal");
            System.out.println("2. Adopt Any Animal");
            System.out.println("3. Adopt Dog");
            System.out.println("4. Adopt Cat");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            //Switch choice
            switch (choice) {
                case 1:
                    System.out.print("Enter animal name: ");
                    String name = scanner.nextLine();
                    System.out.print("Is it a Dog or a Cat? (DOG/CAT): ");
                    String typeInput = scanner.nextLine().toUpperCase();

                    if (!typeInput.equals("DOG") && !typeInput.equals("CAT")) {
                        System.out.println("Invalid type. Please enter DOG or CAT.");
                        break;
                    }

                    Animal.Type type = Animal.Type.valueOf(typeInput);
                    Animal animal = new Animal(name, type, System.nanoTime());
                    shelter.enqueue(animal);
                    System.out.println(name + " the " + type + " has been added to the shelter.");
                    break;

                case 2:
                    Animal anyAnimal = shelter.dequeueAny();
                    if (anyAnimal != null) {
                        System.out.println("Adopted: " + anyAnimal.getName() + " (Type: " + anyAnimal.getType() + ")");
                    } else {
                        System.out.println("No animals available for adoption.");
                    }
                    break;

                case 3:
                    Animal dog = shelter.dequeueDog();
                    if (dog != null) {
                        System.out.println("This dog is now adopted: " + dog.getName());
                    } else {
                        System.out.println("No dogs currently available for adoption!");
                    }
                    break;

                case 4:
                    Animal cat = shelter.dequeueCat();
                    if (cat != null) {
                        System.out.println("Adopted Cat: " + cat.getName());
                    } else {
                        System.out.println("No cats currently available for adoption!");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for visitinng our shelter! Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again!");
            }
        }
    }
}

