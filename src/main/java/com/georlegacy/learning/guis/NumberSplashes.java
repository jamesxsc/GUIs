package com.georlegacy.learning.guis;

import java.util.HashMap;

public class NumberSplashes extends HashMap<Integer, String> {

    public NumberSplashes() {
        this.put(0, "You've been bad haven't you... damaging my root code.");
        this.put(1, "First click, come on, there's many more clicks to go.");
        this.put(2, "When I said \"many more\" I meant MANY, not one more!");
        this.put(3, "Three, really? MORE MORE MORE CLICKS!");
        this.put(4, "Nearly five, that'll be a milestone with you.");
        this.put(5, "Five! Thank goodness! See if you can get more.");
        this.put(6, "Still going? Well done!");
        this.put(10, "Double the first true milestone, never thought you'd get this far.");
        this.put(42, "WOW, you\'ve reached the Answer to Life, The Universe, and Everything!");
        this.put(90, "10 more to go and your done!");
        this.put(95, "5 More till you can stop!");
        this.put(96, "4 Till the end!");
        this.put(97, "3!!!");
        this.put(98, "2!!!!!!!!");
        this.put(99, "1!");
        this.put(100, "Lol, you actually thought you where done? :P");
        this.put(101, "Wow your life is sad");
        this.put(102, "Ow your still going?");
        this.put(105, "Well Ill tell you, ");
        this.put(109, "The end is near!");
        this.put(110, "or not...");
        this.put(111, "3 Number Combo!!");
        this.put(123, "Wasn\'t that as easy as 1, 2, 3!");
    }

    private static final String DEFAULT = "Keep clicking... You'll get there.";

    public String get(Integer key) {
        if (this.containsKey(key))
            return this.get(key);
        else
            return DEFAULT;
    }

}
