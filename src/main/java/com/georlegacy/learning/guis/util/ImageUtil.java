package com.georlegacy.learning.guis.util;

import com.georlegacy.learning.guis.App;

import javax.swing.*;

public class ImageUtil {

    public ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = App.class.getClassLoader().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

}
