import static org.junit.Assert.*;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;

import imagereader.IImageIO;

public class ImageJUnitTest {
	@Before
	public void setUp() throws Exception {}
	
	private IImageIO myImage = new ImplementImageIO();
	private ImplementImageProcessor processor = new ImplementImageProcessor();
	
	@Test
	// test blue of 1.bmp
	public void testBlue1() throws IOException {
		String filePath = "/home/peter/Desktop/bmptest/goal/1_blue_goal.bmp";
		Image imageBlue1 = myImage.myRead(filePath);

		Image blue1 = processor.showChanelB(imageBlue1);

		FileInputStream testFileBlue1 = new FileInputStream(filePath);
		BufferedImage testImageBlue1 = ImageIO.read(testFileBlue1);

		BufferedImage myTestImageBlue1 = new BufferedImage(blue1.getWidth(null), blue1.getHeight(null), BufferedImage.TYPE_INT_BGR);
		myTestImageBlue1.getGraphics().drawImage(blue1, 0, 0, blue1.getWidth(null), blue1.getHeight(null), null);
		// 比较像素
		for (int i = 0; i < testImageBlue1.getWidth(null); i++) {
			for (int j = 0; j < testImageBlue1.getHeight(null); j++) {
				assertEquals(testImageBlue1.getRGB(i, j), myTestImageBlue1.getRGB(i, j));
			}
		}
		// 比较位图宽度高度
		assertEquals(blue1.getWidth(null), testImageBlue1.getWidth(null));
		assertEquals(blue1.getHeight(null), testImageBlue1.getHeight(null));
	}
	
	@Test
	public void testBlue2() throws IOException {
		String filePath = "/home/peter/Desktop/bmptest/goal/2_blue_goal.bmp";
		Image imageBlue1 = myImage.myRead(filePath);

		Image blue1 = processor.showChanelB(imageBlue1);

		FileInputStream testFileBlue1 = new FileInputStream(filePath);
		BufferedImage testImageBlue1 = ImageIO.read(testFileBlue1);

		BufferedImage myTestImageBlue1 = new BufferedImage(blue1.getWidth(null), blue1.getHeight(null), BufferedImage.TYPE_INT_BGR);
		myTestImageBlue1.getGraphics().drawImage(blue1, 0, 0, blue1.getWidth(null), blue1.getHeight(null), null);
		// 比较像素
		for (int i = 0; i < testImageBlue1.getWidth(null); i++) {
			for (int j = 0; j < testImageBlue1.getHeight(null); j++) {
				assertEquals(testImageBlue1.getRGB(i, j), myTestImageBlue1.getRGB(i, j));
			}
		}
		// 比较位图宽度高度
		assertEquals(blue1.getWidth(null), testImageBlue1.getWidth(null));
		assertEquals(blue1.getHeight(null), testImageBlue1.getHeight(null));
	}
	
	@Test
	public void testGray1() throws IOException {
		Image imageGray1 = myImage.myRead("/home/peter/Desktop/bmptest/goal/1_gray_goal.bmp");

		Image gray1 = processor.showGray(imageGray1);

		FileInputStream testFileGray1 = new FileInputStream("/home/peter/Desktop/bmptest/goal/1_gray_goal.bmp");
		BufferedImage testImageGray1 = ImageIO.read(testFileGray1);

		int w = gray1.getWidth(null);
		int h = gray1.getHeight(null);
		BufferedImage myTestImageGray1 = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
		myTestImageGray1.getGraphics().drawImage(gray1, 0, 0, w, h, null);
		// 比较像素
		for (int i = 0; i < testImageGray1.getWidth(null); i++) {
			for (int j = 0; j < testImageGray1.getHeight(null); j++) {
				assertEquals(testImageGray1.getRGB(i, j), myTestImageGray1.getRGB(i, j));
			}
		}
		// 比较位图宽度高度
		assertEquals(gray1.getWidth(null), testImageGray1.getWidth(null));
		assertEquals(gray1.getHeight(null), testImageGray1.getHeight(null));
	}
	
	@Test
	public void testGray2() throws IOException {
		String filePath = "/home/peter/Desktop/bmptest/goal/2_gray_goal.bmp";
		Image imageBlue1 = myImage.myRead(filePath);

		Image blue1 = processor.showGray(imageBlue1);

		FileInputStream testFileBlue1 = new FileInputStream(filePath);
		BufferedImage testImageBlue1 = ImageIO.read(testFileBlue1);

		BufferedImage myTestImageBlue1 = new BufferedImage(blue1.getWidth(null), blue1.getHeight(null), BufferedImage.TYPE_INT_BGR);
		myTestImageBlue1.getGraphics().drawImage(blue1, 0, 0, blue1.getWidth(null), blue1.getHeight(null), null);
		// 比较像素
		for (int i = 0; i < testImageBlue1.getWidth(null); i++) {
			for (int j = 0; j < testImageBlue1.getHeight(null); j++) {
				assertEquals(testImageBlue1.getRGB(i, j), myTestImageBlue1.getRGB(i, j));
			}
		}
		// 比较位图宽度高度
		assertEquals(blue1.getWidth(null), testImageBlue1.getWidth(null));
		assertEquals(blue1.getHeight(null), testImageBlue1.getHeight(null));
	}
	
	@Test
	public void testRed1() throws IOException {
		String filePath = "/home/peter/Desktop/bmptest/goal/1_red_goal.bmp";
		Image imageBlue1 = myImage.myRead(filePath);

		Image blue1 = processor.showChanelR(imageBlue1);

		FileInputStream testFileBlue1 = new FileInputStream(filePath);
		BufferedImage testImageBlue1 = ImageIO.read(testFileBlue1);

		BufferedImage myTestImageBlue1 = new BufferedImage(blue1.getWidth(null), blue1.getHeight(null), BufferedImage.TYPE_INT_BGR);
		myTestImageBlue1.getGraphics().drawImage(blue1, 0, 0, blue1.getWidth(null), blue1.getHeight(null), null);
		// 比较像素
		for (int i = 0; i < testImageBlue1.getWidth(null); i++) {
			for (int j = 0; j < testImageBlue1.getHeight(null); j++) {
				assertEquals(testImageBlue1.getRGB(i, j), myTestImageBlue1.getRGB(i, j));
			}
		}
		// 比较位图宽度高度
		assertEquals(blue1.getWidth(null), testImageBlue1.getWidth(null));
		assertEquals(blue1.getHeight(null), testImageBlue1.getHeight(null));
	}
	
	@Test
	public void testRed2() throws IOException {
		String filePath = "/home/peter/Desktop/bmptest/goal/2_red_goal.bmp";
		Image imageBlue1 = myImage.myRead(filePath);

		Image blue1 = processor.showChanelR(imageBlue1);

		FileInputStream testFileBlue1 = new FileInputStream(filePath);
		BufferedImage testImageBlue1 = ImageIO.read(testFileBlue1);

		BufferedImage myTestImageBlue1 = new BufferedImage(blue1.getWidth(null), blue1.getHeight(null), BufferedImage.TYPE_INT_BGR);
		myTestImageBlue1.getGraphics().drawImage(blue1, 0, 0, blue1.getWidth(null), blue1.getHeight(null), null);
		// 比较像素
		for (int i = 0; i < testImageBlue1.getWidth(null); i++) {
			for (int j = 0; j < testImageBlue1.getHeight(null); j++) {
				assertEquals(testImageBlue1.getRGB(i, j), myTestImageBlue1.getRGB(i, j));
			}
		}
		// 比较位图宽度高度
		assertEquals(blue1.getWidth(null), testImageBlue1.getWidth(null));
		assertEquals(blue1.getHeight(null), testImageBlue1.getHeight(null));
	}
	
	@Test
	public void testGreen1() throws IOException {
		String filePath = "/home/peter/Desktop/bmptest/goal/1_green_goal.bmp";
		Image imageBlue1 = myImage.myRead(filePath);

		Image blue1 = processor.showChanelG(imageBlue1);

		FileInputStream testFileBlue1 = new FileInputStream(filePath);
		BufferedImage testImageBlue1 = ImageIO.read(testFileBlue1);

		BufferedImage myTestImageBlue1 = new BufferedImage(blue1.getWidth(null), blue1.getHeight(null), BufferedImage.TYPE_INT_BGR);
		myTestImageBlue1.getGraphics().drawImage(blue1, 0, 0, blue1.getWidth(null), blue1.getHeight(null), null);
		// 比较像素
		for (int i = 0; i < testImageBlue1.getWidth(null); i++) {
			for (int j = 0; j < testImageBlue1.getHeight(null); j++) {
				assertEquals(testImageBlue1.getRGB(i, j), myTestImageBlue1.getRGB(i, j));
			}
		}
		// 比较位图宽度高度
		assertEquals(blue1.getWidth(null), testImageBlue1.getWidth(null));
		assertEquals(blue1.getHeight(null), testImageBlue1.getHeight(null));
	}
	
	@Test
	public void testGreen2() throws IOException {
		String filePath = "/home/peter/Desktop/bmptest/goal/2_green_goal.bmp";
		Image imageBlue1 = myImage.myRead(filePath);

		Image blue1 = processor.showChanelG(imageBlue1);

		FileInputStream testFileBlue1 = new FileInputStream(filePath);
		BufferedImage testImageBlue1 = ImageIO.read(testFileBlue1);

		BufferedImage myTestImageBlue1 = new BufferedImage(blue1.getWidth(null), blue1.getHeight(null), BufferedImage.TYPE_INT_BGR);
		myTestImageBlue1.getGraphics().drawImage(blue1, 0, 0, blue1.getWidth(null), blue1.getHeight(null), null);
		// 比较像素
		for (int i = 0; i < testImageBlue1.getWidth(null); i++) {
			for (int j = 0; j < testImageBlue1.getHeight(null); j++) {
				assertEquals(testImageBlue1.getRGB(i, j), myTestImageBlue1.getRGB(i, j));
			}
		}
		// 比较位图宽度高度
		assertEquals(blue1.getWidth(null), testImageBlue1.getWidth(null));
		assertEquals(blue1.getHeight(null), testImageBlue1.getHeight(null));
	}
}