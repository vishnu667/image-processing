package org.cybergen.videoanalytics;

import org.cybergen.videoanalytics.utils.ImageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;

public class TestClass {
    private static final Logger log = LoggerFactory.getLogger(TestClass.class);
    public static void main(String args[]){

        BufferedImage image1 = ImageUtils.getImageFromFile("src/test/resources/image1.png");

        BufferedImage image2 = ImageUtils.getImageFromFile("src/test/resources/image2.png");

        BufferedImage greyImage1 = ImageUtils.imageToGreyScale(image1);
        BufferedImage greyImage2 = ImageUtils.imageToGreyScale(image2);
        int[][] data1 = ImageUtils.imageTo2D(greyImage1);
        int[][] data2 = ImageUtils.imageTo2D(greyImage2);
        log.info("height1 " + greyImage1.getHeight());
        log.info("height2 " + greyImage2.getHeight());
        log.info("width1 " + greyImage1.getWidth());
        log.info("width2 " + greyImage2.getWidth());
        compareImages(data1,data1);
	}

    public static void compareImages(int[][] imageA,int[][] imageB){
        int widthA = imageA.length;
        int widthB = imageB.length;
        int heightA = imageA[0].length;
        int heightB = imageB[0].length;
        int[][] result = new int[heightA][widthA];

        for(int i=0;i< widthA;i++){
            for(int j=0 ; j<heightA ; j++){
                if(imageA[i][j]==imageB[i][j]){
                    result[i][j]= 1;
                }else {
                    result[i][j]= 0;
                }

            }
            System.out.println(result[0][1]);
        }
    }

}
