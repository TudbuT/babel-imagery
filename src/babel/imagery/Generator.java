package babel.imagery;

import java.util.Random;
import java.awt.image.BufferedImage;

public class Generator {
    private Random random;

    public Generator(Random random) {
        this.random = random;
    }
    
    public BufferedImage generate() {
        BufferedImage image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
        for(int n = 0; n < 10; n++) {
            Strand strand = new Strand();
            strand.init(random);
            for(int i = 0; i < 5000; i++) {
                strand.randomMotion(random);
                strand.move();
                image.setRGB(strand.getX(500), strand.getY(500), strand.getColor());
            }
        }
        return image;
    }
}
