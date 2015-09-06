package org.cybergen.videoanalytics;

import org.cybergen.videoanalytics.utils.ImageUtils;

import java.awt.image.BufferedImage;

public class TestClass {
	public static void main(String args[]){

        BufferedImage image1 = ImageUtils.getImageFromFile("src/test/resources/image1.png");

        BufferedImage image2 = ImageUtils.getImageFromFile("src/test/resources/image2.png");

        ImageUtils.imageToGreyScale(image1);
        ImageUtils.viewImage(image1);

	}
}
