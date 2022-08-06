package babel.imagery;

import java.util.Random;
import java.awt.image.BufferedImage;

public class Generator {
    private Random random;

    public Generator(Random random) {
        this.random = random;
    }
    
    public BufferedImage generate() {
        BufferedImage image = new BufferedImage(2000, 2000, BufferedImage.TYPE_INT_RGB);
        for(int n = 0; n < 100; n++) {
            Strand strand = new Strand();
            strand.init(random, 2000);
            for(int i = 0; i < 5000; i++) {
                strand.randomMotion(random);
                strand.move();
                image.setRGB(strand.getX(2000), strand.getY(2000), strand.getColor());
            }
        }
        return image;
    }
}
