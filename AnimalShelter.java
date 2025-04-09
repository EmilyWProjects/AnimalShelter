//Imports
import java.util.LinkedList;
import java.util.Queue;

//Class
public class AnimalShelter {

    //Queue from linked list
    private Queue<Animal> dogs;
    private Queue<Animal> cats;
    private Queue<Animal> allAnimals; 

    //Constructor
    public AnimalShelter() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
        allAnimals = new LinkedList<>();
    }

    //Add to queue
    public void enqueue(Animal animal) {
        if (animal.getType() == Animal.Type.DOG) {
            dogs.add(animal);
        } else {
            cats.add(animal);
        }
        allAnimals.add(animal);
    }

    //Remove from queue
    public Animal dequeueAny() {
        if (allAnimals.isEmpty()) return null;

        Animal oldest = allAnimals.poll();
        if (oldest.getType() == Animal.Type.DOG) {
            dogs.poll();
        } else {
            cats.poll();
        }
        return oldest;
    }

    public Animal dequeueDog() {
        if (dogs.isEmpty()) return null;

        Animal oldestDog = dogs.poll();
        allAnimals.remove(oldestDog);
        return oldestDog;
    }

    public Animal dequeueCat() {
        if (cats.isEmpty()) return null;

        Animal oldestCat = cats.poll();
        allAnimals.remove(oldestCat);
        return oldestCat;
    }
}

