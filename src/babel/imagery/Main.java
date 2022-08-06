package babel.imagery;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Generating imagery of babel...");
        Generator generator = new Generator(new Random(Long.parseLong(args[0])));
        for(int i = 1; i <= 100; i++) {
            System.out.print("Generating " + i);

            ImageIO.write(generator.generate(), "png", new FileOutputStream("babel-" + i + ".png"));

            System.out.println("\rGenerated " + i + " successfully");
        }
    }
}
