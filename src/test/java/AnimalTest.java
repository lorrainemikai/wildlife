import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;


public class AnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();
    @Test
    public void animals_instantiatesCorrectly_true() {
        Animal testAnimal = new Animal("Orengutan", "healthy");
        assertEquals(true, testAnimal instanceof Animal);


    }
    @Test
    public void getName_animalInstantiatesWithName_Orengutan() {
        Animal getAnimal = new Animal("Orengutan", "healthy");
        assertEquals("Orengutan", testAnimal.getName());
    }
    @Test
    public void getHealth_personInsantiatesWithEmail_String() {
        Animal testAnimal = new Animal("Orengtan", "healthy");
        assertEquals("healthy", testAnimal.getHealth());
    }
    @Test
    public void all_returnsAllInstancesOfAnimal_true() {
        Animal firstAnimal = new Animal("Orangutan", "healthy");
        firstAnimal.save();
        Animal secondAnimal = new Animal("Dikdik", "ill");
        secondAnimal.save();
        assertEquals(true, Animal.all().get(0).equals(firstAnimal));
        assertEquals(true, Animal.all().get(1).equals(secondAnimal));
    }
    @Test
    public void save_assignsIdToObject() {
        Animal testAnimal = new Animal("Orengutan", "healthy");
        testAnimal.save();
        Animal savedAnimal = Animal.all().get(0);
        assertEquals(testAnimal.getId(), savedAnimal.getId());
    }
    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        Animal firstAnimal = new Animal("Orengutan", "healthy");
        firstAnimal.save();
        Person secondAnimal = new Animal("Dikdik", "ill");
        secondAnimal.save();
        assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
    }

}