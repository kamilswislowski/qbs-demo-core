package pl.swislowski.kamil.java.core;

import java.util.logging.Logger;

public class BytesManipulation {
    private static final Logger LOGGER = Logger.getLogger(BytesManipulation.class.getName());

    /**
     * Dla danego ciągu bajtów <code>bytes</code> wyszukuje <code>wantedBytes<code/> i zamienia na
     * <code>swapBytes</code>.
     * @param bytes ciąg bajtów do modyfikacji
     * @param wantedBytes wyszukiwany ciąg bajtów
     * @param swapBytes ciąg bajtów na który zamieniamy wyszukiwany ciąg bajtów
     * @return zwraca zmodyfikowany ciąg bajtów
     */
    public byte[] replaceBytes(byte[] bytes, byte[] wantedBytes, byte[] swapBytes) {

        if (bytes != null && wantedBytes != null && swapBytes != null
                && wantedBytes.length > 0 && swapBytes.length > 0) {

            int startIndex = findStartIndex(bytes, wantedBytes);
            if (startIndex != -1) {

                int length = wantedBytes.length;
                if (swapBytes.length > wantedBytes.length) {
                    length = swapBytes.length;
                }

                for (int i = startIndex; i < startIndex + length; i++) {

                    int index = i - startIndex;
                    if (index < swapBytes.length) {
                        bytes[i] = swapBytes[index];
                    }
                }
            }
        }
        return bytes;
    }

    /**
     * Wyszukuje indeks startowy ciągu bajtów <code>wantedBytes</code> w ciągu bajtów <code>bytes</code>.
     * @param bytes przeszukiwany ciąg bajtów
     * @param wantedBytes wyszukiwany ciąg bajtów
     * @return Zwraca indeks startowy wyszukiwanego ciągu bajtów.
     */
    int findStartIndex(byte[] bytes, byte[] wantedBytes) {
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
