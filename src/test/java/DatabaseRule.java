import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  @Override
  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_test", "lorraine", "hismikai");
  }

  @Override
  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      String deleteAnimalQuery = "DELETE FROM animal *;";
      String deleteEndangeredQuery = "DELETE FROM endangered *;";
      con.createQuery(deleteAnimalQuery).executeUpdate();
      con.createQuery(deleteEndangeredQuery).executeUpdate();
    }
  }

}