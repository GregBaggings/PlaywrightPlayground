package testdata;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JsonArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<TestData>>() {}.getType();
        List<TestData> testDataList = gson.fromJson(Files.readString(Paths.get("src/test/resources/testdata.json")), listType);

        return testDataList.stream().map(testData -> Arguments.of(testData.getUsername(), testData.getPassword()));
    }
}
