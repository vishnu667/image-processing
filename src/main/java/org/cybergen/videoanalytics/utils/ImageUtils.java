package org.cybergen.videoanalytics.utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
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

    public static int[][] imageTo2D(BufferedImage image) {

        int height = image.getHeight();
        int width = image.getWidth();

        boolean hasAlpha = image.getAlphaRaster() != null;
        final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        int[][] result = new int[height][width];

        if (hasAlpha) {
            final int pixelLength = 4;
            for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
                int argb = 0;
                argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
                argb += ((int) pixels[pixel + 1] & 0xff); // blue
                argb += (((int) pixels[pixel + 2] & 0xff) << 8); // green
                argb += (((int) pixels[pixel + 3] & 0xff) << 16); // red
                result[row][col] = argb;
                col++;
                if (col == width) {
                    col = 0;
                    row++;
                }
            }
        } else {
            final int pixelLength = 3;
            for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
                int argb = 0;
                argb += -16777216; // 255 alpha
                argb += ((int) pixels[pixel] & 0xff); // blue
                argb += (((int) pixels[pixel + 1] & 0xff) << 8); // green
                argb += (((int) pixels[pixel + 2] & 0xff) << 16); // red
                result[row][col] = argb;
                col++;
                if (col == width) {
                    col = 0;
                    row++;
                }
            }
        }
        return result;
    }

}
