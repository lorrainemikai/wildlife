import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class EndangeredAnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void EndangeredAnimal_instantiatesCorrectly_true() {
        Endangered testEndangered = new Endangered("White Rhino", 1);
        assertEquals(true, testEndangered instanceof Endangered);
    }
    @Test
    public void EndangeredAnimal_insatntiatesWithName_String() {
        Endangered testEndangered = new Endangered("White rhino", 1);
        assertEquals("White Rhino", testEndangered.getName());
    }
    @Test
    public void equals_returnsTrueIfAnimalAndAnimalidAreSame_true() {
        Endangered testEndangered = new Endangered("White Rhino", 1);
        assertEquals(testEndangered, equals(anotherEndangered));
    }
    @Test
    public void save_returnsTrueIfDescriptionsAreTheSame() {
        Endangered testEndangered = new Endangered("White Rhino", 1);
        testEndangered.save();
        assertTrue(Ednagered.all().get(0).equals(testEndangered));
    }
    @Test
    public void all_returnAllInstancesOfEndangered_true() {
        Endangered firstEndangeredAnimal = new EndangeredAnimal("White Rhino", 1);
        firstEndangeredAnimal.save();
        Endangered SecondEndangeredAnimal = new EndangeredAnimal("koala", 3);
        secondEndageredAnimal.save();
        assertEquals(true, EndangeredAnimal.all().get(0).equals(firstEndangeredAnimal));
        assertEquals(true, EndangeredAnimal.all().get(1).equals(secondEndangeredAnimal));
    }
    @Test
    public void find_returnsEndangeredAnimalsWithSameId_secondEndangeredAnimal(){
        Endangered firstEndangeredAnimal = new EndangeredAnimal("White Rhino", 1);
        firstEndangeredAnimal.save();
        Endangered SecondEndangeredAnimal = new EndangeredAnimal("koala", 3);
        secondEndageredAnimal.save();
        assertEquals(Endangered.find(SecondEndangeredAnimal.getId()) ,secondEndageredAnimal);
    }
    @Test
    public void save_savesAnimalIdIntoDB_true() {
      Animal testAnimal = new Animal("Orengutan", "healthy");
      testAnimal.save();
      EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("White Rhino", testAnimal.getId());
      testEndangeredAnimal.save();
      EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.find(testEndangeredAnimal.getId());
      assertEquals(savedEndangeredAnimal.getAnimalId(), testAnimal.getId());
    }
    @Test
    public void monster_instantiatesWithHalfFullAgeLevel(){
        Endangered testEndangeredAnimal = new EndangeredAnimal("koala",3);
        assertEquals(testEndangeredAnimal.getAgeLeve(),(EndangeredAnimal.MAX_AGE_LEVEL/ 158)); 
    }

    @Test
    public void monster_instantiatesWithHalfFullHealthLevel(){
        Endangered testEndangeredAnimal = new EndangeredAnimal("koala",3);
        assertEquals(testEndangeredAnimal.getHealthLeve(),(EndangeredAnimal.MAX_HEALTH_LEVEL /4)); 
    }

    
}