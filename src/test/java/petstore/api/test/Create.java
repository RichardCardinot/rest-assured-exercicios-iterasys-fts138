package petstore.api.test;

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import petstore.api.entities.CategoryEntity;
import petstore.api.entities.PetEntity;
import petstore.api.entities.TagEntity;
import petstore.api.entities.UserEntity;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Create {
    String message, name;

    Gson gson = new Gson();

    @Test
    public void testCreateUser() {
        // Arrange
        UserEntity userEntity = new UserEntity("AnaMaria", "Ana","Maria", "ana@maria.com", "P@ssw0rd", "22554466", 0);

        String jsonBody = gson.toJson(userEntity);

        // Act
        Response response = (Response)
                given()
                    .contentType("application/json")
                    .log().all()
                    .body(jsonBody)
                .when()
                    .post("https://petstore.swagger.io/v2/user")
        // Assert
                .then()
                    .log().all()
                    .statusCode(200)
                    .extract()
                ;

        message = response.jsonPath().getString("message");

        System.out.println("Message extraida: " + message);

    }

    @Test
    public void testCreatePet() {
        // Arrange
        CategoryEntity category = new CategoryEntity(1, "Cachorros");

        ArrayList<String> urls = new ArrayList<>();
        urls.add("https://image.cachorrogato.com.br/thumb/500/500/1/imagens/racas/imagem209.jpg");
        urls.add("https://blog.polipet.com.br/wp-content/uploads/2023/04/Screenshot_2.jpg");

        ArrayList<TagEntity> tags = new ArrayList<>();
        tags.add(new TagEntity(1, "Pelagem Escura"));
        tags.add(new TagEntity(2, "Porte Medio"));

        PetEntity petEntity = new PetEntity(1, category, "Leona", urls, tags, "disponivel");

        String jsonBody = gson.toJson(petEntity);

        // Act
        Response response = (Response)
                given()
                    .contentType("application/json")
                    .log().all()
                    .body(jsonBody)
                .when()
                    .post("https://petstore.swagger.io/v2/pet")
        // Assert
                .then()
                    .log().all()
                    .statusCode(200)
                    .body("name", is(petEntity.getName()))
                    .extract()
                ;

        name = response.jsonPath().getString("name");

        System.out.println("Nome extraido: " + name);
    }

}
