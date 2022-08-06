package babel.imagery;

import java.util.Random;
import java.awt.Color;

public class Strand {

    float motionX, motionY;
    float motionMotionX, motionMotionY;
    float x,y;

    float motionR, motionG, motionB;
    float r,g,b;

    public void init(Random random) {
        x = random.nextFloat() * 500;
        y = random.nextFloat() * 500;
        r = random.nextFloat() * 256;
        g = random.nextFloat() * 256;
        b = random.nextFloat() * 256;
    }
    
    public void move() {
        motionX += motionMotionX;
        motionY += motionMotionY;
        float f;
        f = (float) Math.sqrt(motionX * motionX + motionY * motionY);
        if(f < 1)
            f = 1;
        x += motionX / f;
        y += motionY / f;
        f = (float) Math.sqrt(motionR * motionR + motionG * motionG + motionB * motionB);
        if(f < 1)
            f = 1;
        r += motionR / f;
        g += motionG / f;
        b += motionB / f;
        motionX /= 1.2f;
        motionY /= 1.2f;
        motionR /= 1.2f;
        motionG /= 1.2f;
        motionB /= 1.2f;
        motionMotionX /= 1.4f;
        motionMotionY /= 1.4f;
    }

    public void randomMotion(Random random) {
        motionMotionX += (random.nextFloat() - 0.5f) * 4f;
        motionMotionY += (random.nextFloat() - 0.5f) * 4f;
        motionR += (random.nextFloat() - 0.5f) * 16f;
        motionG += (random.nextFloat() - 0.5f) * 16f;
        motionB += (random.nextFloat() - 0.5f) * 16f;
    }

    public int getX(int b) {
        int i = (int) x % b;
        if(i < 0) i += b;
        return i;
    }
    public int getY(int b) {
        int i = (int) y % b;
        if(i < 0) i += b;
        return i;
    }
    public int getColor() {
        return new Color((int)r & 0xFF, (int)g & 0xFF, (int)b & 0xFF).getRGB();
    }

}
