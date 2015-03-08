package au.id.chrisb.funfacts;

import java.util.Random;

/**
 * Created by chris on 6/03/2015.
 */
public class bgColor {
    public int getColor() {
        int Color = 0;
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(0xffffff);

        Color = randomNumber + 0xff000000;

        return Color;
    }
}
