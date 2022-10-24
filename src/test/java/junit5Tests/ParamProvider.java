package junit5Tests;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ParamProvider {

    static Stream<Arguments> sourceStream_StringDouble(){
        return Stream.of(arguments("apple", 9.2), arguments("banana" , 2.7));
    }
}
