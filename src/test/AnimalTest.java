import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

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
    @Override
    public boolean equals(Object otherAnimal){
        if (!(otherAnimal instanceof Animal)){
            return false;
        }else{
            Animal newAnimal = (Animal) otherAnimal;
            return this.getName().equals(newPerson,getName())&&
            this.getHealth().equals(newAnimal.getHealth());
        }


    }
}