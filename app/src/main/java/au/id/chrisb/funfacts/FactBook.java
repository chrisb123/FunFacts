package au.id.chrisb.funfacts;


import java.util.Random;

/**
 * Created by chris on 6/03/2015.
 */
public class FactBook {


    public String[] mFacts = {
            "Ants might take a crap in the morning, if they feel like it",
            "Chicken eggs dont weigh 10kg im guessing",
            "Olympic rings are actually square ish... with round corners",
            "This app did not just crash",
            "Fact four is fact number 5 in the list I made up",
            "I made up the previous fact",
            "You just hit that button below",
            "Animals is spelt animals",
            "The delorean is a real car",
            "This is the last fact in the array, well it was then I added more facts",
            "I can not see in the toilet unless i turn the light on",
            "These colors are random",
            "I made a spelling mistake somewhere",
            "I've just added some facts",
            "I'm listening to some live song writing this garbage",
            "Miissiissiippii is not spelt with 8 eyes, its also spelt wrong",
            "",
            "One of the facts in this list is blank",
            "Im running out of ideas for facts",
            "You want pay money for an app like this",
            "lon",
            "lat",
            "Im steeling your battery power one click at a time",
            "If you think of ideas or facts email me",
            "I have grammar errors too"
    };


    public String getFact() {


        // buton clicked update fact
        String fact = "";
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mFacts.length);

        fact = mFacts[randomNumber];

        return fact;
    }
}
