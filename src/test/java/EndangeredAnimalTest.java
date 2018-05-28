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
        public void equals_returnsTrueIfAnimalAndAnimalidAreSame_true(){
            Endangered testEndangered = new Endangered("White Rhino", 1);   
        }
    }