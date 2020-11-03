package pl.swislowski.kamil.java.core;

import org.junit.jupiter.api.Test;

import java.io.File;
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

    @Test
    void replaceInLoop() throws IOException {
        //given:
        BytesManipulation bytesManipulation = new BytesManipulation();
        byte[] firstBytes = Files.readAllBytes(Paths.get("src/test/resources/model/model.txt"));
        byte[] secondBytes = Files.readAllBytes(Paths.get("src/test/resources/model/data.txt"));
        byte[] wantedBytes = {84, 114, 97, 108, 97, 108, 97};
        byte[] swapBytes = {22, 23, 44, 55, 66, 77, 87, 96, 99};
        //when:
        byte[] firstReplacedBytes = bytesManipulation.replaceBytes(firstBytes, wantedBytes, swapBytes);
        byte[] secondReplacedBytes = bytesManipulation.replaceBytes(secondBytes, wantedBytes, swapBytes);

    }

    @Test
    void test() throws IOException {
        //given:
        BytesManipulation bytesManipulation = new BytesManipulation();
        byte[] readAllBytesFromIco = Files.readAllBytes(Paths.get("src/test/resources/idea.ico"));
        byte[] wantedBytes = {-87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, -87, -87, -87, -1, 67, 67, 67, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 11, 11, 11, -1, 22, 17, 12, -1, -47, 113, 28, -1, -36, 119, 29, -1, -27, 123, 30, -1, -22, 126, 31, -1, -18, -128, 31, -1, -18, -128, 31, -1, -18, -128, 31, -1, -18, -128, 30, -1, -18, -128, 30, -1, -18, -128, 30, -1, -18, -128, 30, -1, -18, -128, 30, -1, -18, -128, 30, -1, -17, -128, 29, -1, -17, -128, 29, -1, -17, -128, 29, -1, -17, -128, 29, -1, -17, -127, 29, -1, -17, -127, 28, -1, -17, -127, 28, -1, -17, -127, 28, -1, -17, -127, 28, -1, -16, -127, 28, -1, -16, -127, 28, -1, -16, -127, 27, -1, -16, -127, 27, -1, -16, -127, 27, -1, -16, -127, 27, -1, -16, -127, 27, -1, -16, -127, 26, -1, -16, -127, 26, -1, -16, -127, 26, -1, -16, -127, 26, -1, -16, -127, 26, -1, -16, -127, 26, -1, -16, -127, 25, -1, -16, -127, 25, -1, -16, -127, 25, -1, -16, -126, 25, -1, -16, -126, 25, -1, -16, -126, 24, -1, -16, -126, 24, -1, -15, -126, 24, -1, -15, -126, 24, -1, -15, -126, 24, -1, -15, -126, 24, -1, -15, -126, 23, -1, -15, -126, 23, -1, -44, 116, 71, 113};
        byte[] swapBytes = {11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66,11, 22, 33, 44, 55, 66};
        Path tempFilePath = Files.createTempFile( "xxx", "yyy");
//        System.out.println(Arrays.toString(readAllBytesFromIco));
        //when:
        byte[] bytes = bytesManipulation.replaceBytes(readAllBytesFromIco, wantedBytes, swapBytes);
        Path write = Files.write(tempFilePath, bytes);
        File file = write.toFile();
        System.out.println(write);
    }
}