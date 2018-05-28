import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class EndangeredAnimal {

    private String name;
    public EndangeredAnimal(String name,int animalId){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    @Override
    public boolean equals(Object otherEndangered){
        if (!(otherEndangered instanceof EndangeredAnimal)){
            return false;
        }else{
            EndangeredAnimal newEndangeredAnimal = (EndangeredAnimal)otherEndangered;
            return this.getName().equals(newEndangeredAnimal.getName())&&
            this.getAnimalId()==newEndangeredAnimal.getAnimalId();
        }
    }
    public void save() {
        try(Connection con = DB.sql2o.open()) {
          String sql = "INSERT INTO endangered (name, personid) VALUES (:name, :personId)";
          this.id = (int) con.createQuery(sql, true)
            .addParameter("name", this.name)
            .addParameter("animalId", this.animalId)
            .executeUpdate()
            .getKey();
        }
      }
      public static List<EndangeredAnimal> all() {
        String sql = "SELECT * FROM endagered";
        try(Connection con = DB.sql2o.open()) {
          return con.createQuery(sql).executeAndFetch(EndangeredAnimal.class);
        }
      }
    public static EndangeredAnimal find(int id){
        try(Connection con=DB.sql2o.open()){
            String sql = "SELECT * FROM endangered where id=:id";
            EndangeredAnimal endangered = con.createQuery(sql)
            .addParameter("id", id)
            .executeAndFetchFirst(EndangeredAnimal.class);
            return endangeredAnimal;

        }
    }  
}