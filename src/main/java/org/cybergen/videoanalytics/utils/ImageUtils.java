package org.cybergen.videoanalytics.utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Class org.cybergen.videoanalytics.utils.ImageLoader
 * Created by vishnu667 on 6/9/15.
 */
public class ImageUtils {

    public static BufferedImage getImageFromFile(String path) {

        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void viewImage(BufferedImage image) {

        JFrame editorFrame = new JFrame("Image Demo");
        editorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ImageIcon imageIcon = new ImageIcon(image);
        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);
        editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);
        editorFrame.pack();
        editorFrame.setLocationRelativeTo(null);
        editorFrame.setVisible(true);
    }

    public static BufferedImage imageToGreyScale(BufferedImage sourceImage) {
        BufferedImage newGreyImage = new BufferedImage(sourceImage.getWidth(), sourceImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = newGreyImage.getGraphics();
        g.drawImage(sourceImage, 0, 0, null);
        g.dispose();
        return newGreyImage;
    }



}
