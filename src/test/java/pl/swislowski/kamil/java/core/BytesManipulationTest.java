package pl.swislowski.kamil.java.core;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

class BytesManipulationTest {

    private static final String FILTERED_FILE_CORRECT_EXTENSION = "exe";

    @Test
    void replace2() throws IOException {
        //given:
        BytesManipulation bytesManipulation = new BytesManipulation();
        byte[] bytes = Files.readAllBytes(Paths.get("src/test/resources/model/model.txt"));
        byte[] wantedBytes = {84, 114, 97, 108, 97, 108, 97};
        //when:
        int replace = bytesManipulation.findStartIndex(bytes, wantedBytes);
        System.out.println(replace);
        //then:
    }

    @Test
    void replaceBytes() throws IOException {
        //given:
        BytesManipulation bytesManipulation = new BytesManipulation();
        byte[] bytes = Files.readAllBytes(Paths.get("src/test/resources/model/model.txt"));
        byte[] wantedBytes = {84, 114, 97, 108, 97, 108, 97};
        //when:
        bytesManipulation.replaceBytes(bytes, wantedBytes, null);
    }

    @Test
    void givenBytesWantedSwapWithSameSize_whenReplaceBytes_thenReplaceCorrect() throws IOException {
        //given:
        BytesManipulation bytesManipulation = new BytesManipulation();
        byte[] bytes = Files.readAllBytes(Paths.get("src/test/resources/model/model.txt"));
        byte[] wantedBytes = {84, 114, 97, 108, 97, 108, 97};
        byte[] swapBytes = {22, 23, 44, 55, 66, 77, 87};
        //when:
        bytesManipulation.replaceBytes(bytes, wantedBytes, swapBytes);
    }

    @Test
    void givenBytesWantedSwapWithSmallerSize_whenReplaceBytes_thenReplaceCorrect() throws IOException {
        //given:
        BytesManipulation bytesManipulation = new BytesManipulation();
        byte[] bytes = Files.readAllBytes(Paths.get("src/test/resources/model/model.txt"));
        byte[] wantedBytes = {84, 114, 97, 108, 97, 108, 97};
        byte[] swapBytes = {22, 23, 44, 55, 66};
        //when:
        bytesManipulation.replaceBytes(bytes, wantedBytes, swapBytes);
    }

    @Test
    void givenBytesWantedSwapWithSmallerSize2_whenReplaceBytes_thenReplaceCorrect() throws IOException {
        //given:
        BytesManipulation bytesManipulation = new BytesManipulation();
        byte[] bytes = Files.readAllBytes(Paths.get("src/test/resources/model/data.txt"));
        byte[] wantedBytes = {97, 32, 107, 111, 116, 97, 46, 32};
        byte[] swapBytes = {11, 22, 33, 55, 66};
        //when:
        bytesManipulation.replaceBytes(bytes, wantedBytes, swapBytes);
    }

    @Test
    void givenBytesWantedSwapWithGreaterSize_whenReplaceBytes_thenReplaceCorrect() throws IOException {
        //given:
        BytesManipulation bytesManipulation = new BytesManipulation();
        byte[] bytes = Files.readAllBytes(Paths.get("src/test/resources/model/model.txt"));
        byte[] wantedBytes = {84, 114, 97, 108, 97, 108, 97};
        byte[] swapBytes = {22, 23, 44, 55, 66, 77, 87, 96, 99};
        //when:
        bytesManipulation.replaceBytes(bytes, wantedBytes, swapBytes);
    }

    @Test
    void givenBytesWantedSwapEmpty_whenReplaceBytes_thenReplaceCorrect() throws IOException {
        //given:
        BytesManipulation bytesManipulation = new BytesManipulation();
        byte[] bytes = Files.readAllBytes(Paths.get("src/test/resources/model/model.txt"));
        byte[] wantedBytes = {84, 114, 97, 108, 97, 108, 97};
        byte[] swapBytes = {};
        //when:
        bytesManipulation.replaceBytes(bytes, wantedBytes, swapBytes);
    }

    @Test
    void givenBytesWantedEmptySwapEmpty_whenReplaceBytes_thenReplaceCorrect() throws IOException {
        //given:
        BytesManipulation bytesManipulation = new BytesManipulation();
        byte[] bytes = Files.readAllBytes(Paths.get("src/test/resources/model/model.txt"));
        byte[] wantedBytes = {};
        byte[] swapBytes = {};
        //when:
        bytesManipulation.replaceBytes(bytes, wantedBytes, swapBytes);
    }

    @Test
    void givenBytesWantedEmptySwap_whenReplaceBytes_thenReplaceCorrect() throws IOException {
        //given:
        BytesManipulation bytesManipulation = new BytesManipulation();
        byte[] bytes = Files.readAllBytes(Paths.get("src/test/resources/model/model.txt"));
        byte[] wantedBytes = {};
        byte[] swapBytes = {22, 23, 44, 55, 66, 77, 87, 96, 99};
        //when:
        bytesManipulation.replaceBytes(bytes, wantedBytes, swapBytes);
    }

    @Test
    void replace() throws IOException {
        //given:
        BytesManipulation bytesManipulation = new BytesManipulation();
        byte[] bytes = {84, 114, 97, 108, 97, 108, 97};
        byte[] readAllBytes = Files.readAllBytes(Paths.get("src/test/resources/model/model.txt"));
        byte[] readAllBytesFromIco = Files.readAllBytes(Paths.get("src/test/resources/idea.ico"));

        //when:
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(readAllBytes));
//        System.out.println(Arrays.toString(readAllBytesFromIco));

        Path tempPathCorrect = Files.createTempFile("hello", FILTERED_FILE_CORRECT_EXTENSION);
        Path written = Files.write(tempPathCorrect, bytes);
        System.out.println(written);
    }
}