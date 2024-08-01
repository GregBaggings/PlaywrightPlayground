package rest;

import com.google.gson.Gson;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.RequestOptions;
import dto.Planet;
import dto.ResponseDto;
import factory.PlaywrightFactory;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static constants.Constants.PEOPLE_API_URL;

public class StarWarsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StarWarsService.class);
    private static final Gson GSON = new Gson();
    private final Page page;

    public StarWarsService() {
        page = PlaywrightFactory.getPage();
    }

    @Step("Get character details")
    public ResponseDto getPeople(RequestOptions requestOptions) {
        APIResponse peopleResponse = page.request().get(PEOPLE_API_URL, requestOptions);
        LOGGER.info("StatusCode of People response: {}", peopleResponse.status());
        Assertions.assertEquals(peopleResponse.status(), 200);
        return GSON.fromJson(peopleResponse.text(), ResponseDto.class);
    }


    @Step("Get planet details")
    public Planet getPlanet(String homeUrl) {
        APIResponse planetResponse = page.request().get(homeUrl);
        LOGGER.debug("StatusCode of Planet response: {}", planetResponse.status());
        Assertions.assertEquals(planetResponse.status(), 200);

        return GSON.fromJson(planetResponse.text(), Planet.class);
    }

}
