package pl.swislowski.kamil.java.core;

import java.util.Arrays;
import java.util.logging.Logger;

public class BytesManipulation {
    private static final Logger LOGGER = Logger.getLogger(BytesManipulation.class.getName());

    public byte[] replaceBytes(byte[] bytes, byte[] wantedBytes, byte[] swapBytes) {

        if (bytes != null && wantedBytes != null && swapBytes != null
                && wantedBytes.length > 0 && swapBytes.length > 0) {

            int startIndex = findStartIndex(bytes, wantedBytes);

            int length = wantedBytes.length;
            if (swapBytes.length > wantedBytes.length) {
                length = swapBytes.length;
            }

            for (int i = startIndex; i < startIndex + length; i++) {
//            System.out.println("bytes[" + i + "] = " + bytes[i]);
//                System.out.println("bytes[" + i + "] = " + (char) bytes[i]);
//            System.out.println(bytes[i]);
//            bytes[i] = (byte)'x';

                int index = i - startIndex;
                if (index < swapBytes.length) {
                    bytes[i] = swapBytes[index];
                }

                //01234567891011
                //bbbbwwwwwbbb
                //....sssss...
            }
//TODO : zamienić na swapBytes zamiast xxxxxxxx.
            System.out.println(Arrays.toString(bytes));
            System.out.println(new String(bytes));


        }
        return bytes;
    }

    int findStartIndex(byte[] bytes, byte[] wantedBytes) {
//        LOGGER.info("replace method invocation external class ##############");
        for (int i = 0; i < bytes.length - wantedBytes.length + 1; ++i) {
            boolean found = true;
            for (int j = 0; j < wantedBytes.length; ++j) {
                if (bytes[i + j] != wantedBytes[j]) {
                    found = false;
                    break;
                }
            }
            if (found) return i;
        }
        return -1;
    }

}
