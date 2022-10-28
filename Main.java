import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class Main {

	public static void main(String[] args) {

		// Title thing
		System.out.println("---------------------------------------");
		System.out.println("Convert an image to ASCII art");
		System.out.println("---------------------------------------\n\n");
		
		String output = "";

		try {

			// Get the image
			String imagePath = "./image.jpg";
			File imageFile = new File(imagePath);
			BufferedImage image = ImageIO.read(imageFile);

			// Get image info
			int imageWidth = image.getWidth();
			int imageHeight = image.getHeight();

			// Ascii settings
			String asciiCharacters = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'.";
			double asciiLength = asciiCharacters.length();
			double maxBrightness = 255;

			// Get the colors of each pixel
			for (int y = 0; y < imageHeight; y++) {
				for (int x = 0; x < imageWidth; x++) {
					
					// Extract the RGB
					int pixelColor = image.getRGB(x, y);
					Color color = new Color(pixelColor, true);
					
					// Get the color info
					int red = color.getRed();
					int green = color.getGreen();
					int blue = color.getBlue();
					double brightness = (0.2126 * red + 0.7152 * green + 0.0722 * blue);

					// Get the ascii character
					int asciiIndex = (int) (brightness * (asciiLength / maxBrightness));
					char asciiCharacter = asciiCharacters.charAt(asciiIndex);
					output += asciiCharacter;
				}

				// Add a new line
				output += "\n";
			}

		} catch (Exception e) {
			System.out.println("There was an issue when trying to load the image:");
			e.printStackTrace();
		}

		System.out.println("Generated ascii");
		addOutput(output);
		System.out.println("Wrote to file");
		
	}

	static void addOutput(String text) {

        try {

            // Get the file
            String filePath = "output.txt";
            File file = new File(filePath);
            
            // Make a new file
            file.createNewFile();

            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(text);
            writer.close();


        } catch(IOException e) {
            System.out.println("Error when handling file");
            e.printStackTrace();
        }

    }

}