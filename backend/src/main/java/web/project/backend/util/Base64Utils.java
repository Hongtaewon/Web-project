package web.project.backend.util;

import java.util.Base64;

public class Base64Utils {
    private static final String BASE_64_PREFIX_PNG = "data:image/png;base64,";
    private static final String BASE_64_PREFIX_JPEG = "data:image/jpeg;base64,";
    private static final String BASE_64_PREFIX_GIF = "data:image/gif;base64,";

    public static byte[] decodeBase64ToBytes(String imageString) {
        if (imageString.startsWith(BASE_64_PREFIX_PNG))
            return Base64.getDecoder().decode(imageString.substring(BASE_64_PREFIX_PNG.length()));
        else if (imageString.startsWith(BASE_64_PREFIX_JPEG))
            return Base64.getDecoder().decode(imageString.substring(BASE_64_PREFIX_JPEG.length()));
        else if (imageString.startsWith(BASE_64_PREFIX_GIF))
            return Base64.getDecoder().decode(imageString.substring(BASE_64_PREFIX_GIF.length()));
        else
            throw new IllegalStateException("it is not base 64 string");
    }

}