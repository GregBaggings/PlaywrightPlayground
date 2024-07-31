package testdata;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import util.TestCaseKeys;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;

public class JsonArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        Gson gson = new Gson();
        Type listType = new TypeToken<Map<String, TestData>>() {}.getType();
        Map<String, TestData> testDataMap = gson.fromJson(Files.readString(Paths.get("src/test/resources/testdata.json")), listType);

        TestCaseKeys testCaseKeysAnnotation = extensionContext.getTestMethod().orElseThrow(() -> new IllegalStateException("Test method was not found")).getAnnotation(TestCaseKeys.class);
        String[] testCaseKeys = testCaseKeysAnnotation.value();

        return Stream.of(testCaseKeys).filter(testDataMap::containsKey).map(key -> Arguments.of(testDataMap.get(key)));
    }
}
