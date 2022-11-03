
package utils;


public class ImageUtils {
    
    public static String getImagePath() {
        return "./src/main/resources/images";
    }
	
    public static String createImagePath(String image) {
        return createImagePath(image, "png");
    }

    public static String createImagePath(String image, String extensao) {
        return getImagePath()+"/"+image+"."+extensao;
    }
}
