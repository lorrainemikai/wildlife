
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.debug.DebugScreen.enableDebugScreen;

import static spark.Spark.*;


public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        ProcessBuilder process = new ProcessBuilder();
        Integer port;


        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        setPort(port);

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("animals", RegularAnimal.all());
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("animals", RegularAnimal.all());
            model.put("template", "templates/animals.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/animals/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/animals-form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/animals/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            try {
                RegularAnimal animal = new RegularAnimal(name);
                animal.save();
            } catch (IllegalArgumentException exception) {
                System.out.println("Please enter an animal name.");
            }
            response.redirect("/animals");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/endangered/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/endangerd-form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/endangered/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            try {
                EndangeredAnimal endangered = new EndangeredAnimal(name, health, age);
                endangered.save();
            } catch (IllegalArgumentException exception) {
                System.out.println("Please enter all input fields.");
            }
            response.redirect("/animals");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/sightings/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("animals", RegularAnimal.all());
            model.put("template", "templates/sightings-form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/sightings/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int animalId = Integer.parseInt(request.queryParams("animal"));
            String location = request.queryParams("location");
            String rangerName = request.queryParams("rangerName");
            try {
                Sighting sighting = new Sighting(location, rangerName, animalId);
            } catch (IllegalArgumentException exception) {
                System.out.println("Please enter Ranger name.");
            }
            response.redirect("/sightings");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("sightings", Sighting.all());
            model.put("Animal", Animal.class);
            model.put("template", "templates/sightings.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/animals/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("animal", Animal.find(Integer.parseInt(request.params(":id"))));
            model.put("endangered", EndangeredAnimal.find(Integer.parseInt(request.params(":id"))));
            model.put("Sighting", Sighting.class);
            model.put("template", "templates/animal.vtl");
            return new ModelAndView(model, layout);
          }, new VelocityTemplateEngine());

        get("/success", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("animals", RegularAnimal.all());
            model.put("template", "templates/success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

          
//         get("/", (request, response) -> {
//             Map<String, Object> model = new HashMap<String, Object>();
//             model.put("template", "templates/index.vtl");
//             return new ModelAndView(model, layout);
//         }, new VelocityTemplateEngine());

//         get("/", (request, response) -> {
//             Map<String, Object> model = new HashMap<String, Object>();
//             model.put("template", "templates/index.vtl");
//             return new ModelAndView(model, layout);
//         }, new VelocityTemplateEngine());

//         get("/", (request, response) -> {
//             Map<String, Object> model = new HashMap<String, Object>();
//             model.put("template", "templates/index.vtl");
//             return new ModelAndView(model, layout);
//         }, new VelocityTemplateEngine());

//         get("/", (request, response) -> {
//             Map<String, Object> model = new HashMap<String, Object>();
//             model.put("template", "templates/index.vtl");
//             return new ModelAndView(model, layout);
//         }, new VelocityTemplateEngine());

//         get("/", (request, response) -> {
//             Map<String, Object> model = new HashMap<String, Object>();
//             model.put("template", "templates/index.vtl");
//             return new ModelAndView(model, layout);
//         }, new VelocityTemplateEngine());
    }
}