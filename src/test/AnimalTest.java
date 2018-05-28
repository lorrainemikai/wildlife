import org.junit.*;
import static org.junit.Assert.*;

public class AnimalTest{
    @Test
    public void animals_instantiatesCorrectly_true(){
        Animal testAnimal = new Animal("Orengutan","healthy");
        assertEquals(true, testAnimal instanceof Animal);
    

    }
    @Test
    public void getName_animalInstantiatesWithName_Orengutan(){
        Animal getAnimal = new Animal("Orengutan", "healthy");
        assertEquals("Orengutan", testAnimal.getName());
    }
    @Test
    public void getHealth_personInsantiatesWithEmail_String() {
        Animal testAnimal = new Animal("Orengtan","healthy");
        assertEquals("healthy", testAnimal.getHealth());
    }
}