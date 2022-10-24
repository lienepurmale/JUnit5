package junit5Tests;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class ParameterizedTests {

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1, 5, 8})
    void intValues(int theParam) {
        System.out.println("theParam = " + theParam);   //soutp as a short-cut
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    // works as combo @NullAndEmptySource
    @ValueSource(strings = {"first string", "second string"})
    void stringValues(String theParam) {
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve, rogers", " captain, marvel", "bucky, barnes"})
    void csvSource_StringString(String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve,5, true", "captain, 24, false", "bucky, 363, true"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }

    @ParameterizedTest
    @CsvSource(value = {"captain america, 'steve, rogers' ", "winter soldier, 'bucky, barnes' "})
    void csvSource_StringWithComma(String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve?rogers", "bucky?barnes"}, delimiter = '?')
    void csvSource_StringWithDifferentDelimiter(String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/Params/shoppinglist.csv", "src/test/resources/Params/shoppinglist2.csv"}, numLinesToSkip = 1)
    void csvFileSource(String name, double price, int quantity, String unit, String provider) {
        System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity + ", unit = " + unit + ", provider = " + provider);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/Params/shoppinglist3.csv"}, numLinesToSkip = 1, delimiterString = "___")
    void csvFileSource2(String name, double price, int quantity, String unit, String provider) {
        System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity + ", unit = " + unit + ", provider = " + provider);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceString")
    void methodSource_String(String param1) {
        System.out.println("param1 = " + param1);

    }

    List<String> sourceString() {
        //processing done here
        return Arrays.asList("tomato", "carrot", "cabbage");
    }

    @ParameterizedTest
    @MethodSource(value = "sourceStringAsStream")
    void methodSource_StringAsStream(String param1) {
        System.out.println("param1 = " + param1);

    }
    Stream<String>sourceStringAsStream(){
        return Stream.of("apple", "pear");
    }

    @ParameterizedTest
    @MethodSource(value="sourceListStringDouble")
    void methodSource_StringDoubleList(String param1, double param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    List<Arguments>sourceListStringDouble(){
        //processing done here
        return Arrays.asList(arguments("tomato", 2.0), arguments("carrot", 3.6));
    }

    @ParameterizedTest
    @MethodSource(value="sourceStream_StringDouble")
    void methodSource_StringDoubleStream(String param1, double param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    Stream<Arguments> sourceStream_StringDouble(){
        return Stream.of(arguments("apple", 9.2), arguments("banana" , 2.7));
    }

}
