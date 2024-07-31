package testdata;

import com.google.gson.Gson;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Page;
import dto.Planet;
import dto.ResponseDto;
import factory.PlaywrightFactory;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Random;

import static constants.Constants.*;

public class TestDataHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestDataHandler.class);

    private static final Gson GSON = new Gson();
    private static final Random RANDOM = new Random();

    public static Map<String, String> prepareTestData() {
        Page page = PlaywrightFactory.getPage();
        APIResponse peopleResponse = page.request().get(PEOPLE_API_URL);
        LOGGER.debug("StatusCode: {}", peopleResponse.status());
        Assertions.assertEquals(peopleResponse.status(), 200);
        ResponseDto characterDto = GSON.fromJson(peopleResponse.text(), ResponseDto.class);

        // TODO: Handle pagination?
        int index = RANDOM.nextInt(1, 10);
        LOGGER.info("Character count: {}, random index: {}", characterDto.getCount(), index);

        String name = characterDto.getResults().get(index).getName();
        String homeUrl = characterDto.getResults().get(index).getHomeworld();

        APIResponse planetResponse = page.request().get(homeUrl);
        LOGGER.debug("StatusCode: {}", peopleResponse.status());
        Assertions.assertEquals(planetResponse.status(), 200);

        Planet planetDto = GSON.fromJson(planetResponse.text(), Planet.class);
        LOGGER.info("{}  {}", name, planetDto.getName());

        String[] arrOfStr = name.split(" ");
        LOGGER.info(String.valueOf(arrOfStr.length));
        String firstName = arrOfStr[0];
        String lastName;

        if (arrOfStr.length > 1) {
            lastName = arrOfStr[1];
        } else {
            lastName = arrOfStr[0];
        }
        LOGGER.info("{} {}", firstName, lastName);

        return Map.of(
                FIRST_NAME, firstName,
                LAST_NAME, lastName,
                PLANET, planetDto.getName());
    }

}
