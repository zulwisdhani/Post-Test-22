package com.juaracoding;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class TestMovie {

    @Test
    public void testGetPopuler() {
        given().queryParam("api_key", "8d872a70a3ef643a4832393681bba338")
                .when()
                .get("https://api.themoviedb.org/3/tv/popular").
                then().
                log().all();
    }

    @Test
    public void testGetMovieNowPlaying(){
        given().queryParam("api_key", "8d872a70a3ef643a4832393681bba338")
                .when()
                .get("https://api.themoviedb.org/3/movie/now_playing").
                then().
                log().all();

    }

    @Test
    public void postMovieRating(){
        float rating = 9.5f;
        JSONObject request = new JSONObject();
        request.put("value",rating);
        System.out.println(request.toJSONString());
        given()
                .header("Authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4ZDg3MmE3MGEzZWY2NDNhNDgzMjM5MzY4MWJiYTMzOCIsInN1YiI6IjY0ODFlOGE3ZDJiMjA5MDBjYTFkYTU5MiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.Pl_dA5UkLF7_QCgsd9i8c5OFmeLBLm2ObBzkNmTh4OQ")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("https://api.themoviedb.org/3/movie/569094/rating")
                .then()
                .statusCode(201)
                .log().all();
    }
}

