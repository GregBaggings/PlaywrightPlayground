package testdata;

import com.microsoft.playwright.options.RequestOptions;
import dto.Planet;
import dto.ResponseDto;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rest.StarWarsService;

import java.util.Random;

public class TestDataHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestDataHandler.class);
    private static final Random RANDOM = new Random();
    private final StarWarsService service = new StarWarsService();

    private int pagination;

    @Step("Gather the test data through API calls")
    public void prepareTestData(TestData testData) {
        // 82 is the number of the characters currently
        int randomIdOfCharacter = RANDOM.nextInt(1, 82);

        setPaginationBasedOn(randomIdOfCharacter);
        int remainder = randomIdOfCharacter % 10;
        LOGGER.info("Pagination: {}, remainder: {}", pagination, remainder);

        ResponseDto characterDto = service.getPeople(RequestOptions.create().setQueryParam("page", pagination));
        String name = characterDto.getResults().get(remainder).getName();
        String homeUrl = characterDto.getResults().get(remainder).getHomeworld();

        Planet planetDto = service.getPlanet(homeUrl);
        LOGGER.info("Name of the character: {}, Planet: {}", name, planetDto.getName());

        CharacterNameForCheckout result = getCharacterName(name);
        LOGGER.info("{} {}", result.firstName(), result.lastName());

        testData.setFirstName(result.firstName);
        testData.setLastName(result.lastName);
        testData.setPlanet(planetDto.getName());
    }

    private static CharacterNameForCheckout getCharacterName(String name) {
        String[] arrOfStr = name.split(" ");
        LOGGER.info(String.valueOf(arrOfStr.length));
        String firstName = arrOfStr[0];
        String lastName;

        // This magic is to handle those names like R2D2 where there is no first and last name.
        if (arrOfStr.length > 1) {
            lastName = arrOfStr[1];
        } else {
            lastName = arrOfStr[0];
        }
        return new CharacterNameForCheckout(firstName, lastName);
    }

    private record CharacterNameForCheckout(String firstName, String lastName) {
    }

    private void setPaginationBasedOn(int index) {
        pagination = index / 10;
        if (pagination == 0) {
            pagination = 1;
        }
    }

}
