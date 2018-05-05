import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.awt.image.MemoryImageSource;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.ImageIcon;

import imagereader.IImageIO;

public class ImplementImageIO implements IImageIO {
	private int bitNum;
	@Override
	public Image myRead(String filePath) throws IOException {
		File file = new File(filePath);
		Image image = null;
		try {
			FileInputStream fis = new FileInputStream(file);  //将file读取到FileInputStream
			byte[] bitMapHead = new byte[14];     	//位图头
			byte[] bitMapInfo = new byte[40];		//位图信息
			
			fis.read(bitMapHead, 0, 14);			//读取位图头
			fis.read(bitMapInfo, 0, 40);			//读取位图信息
			
			int bitMapInfoSize = (int)( (bitMapInfo[23] & 0xff) << 24 | (bitMapInfo[22] & 0xff) << 16  
                    | (bitMapInfo[21] & 0xff) << 8 | (bitMapInfo[20] & 0xff) );  
		
            int bitMapInfoWidth = (int)( (bitMapInfo[7] & 0xff) << 24 | (bitMapInfo[6] & 0xff) << 16  
                    | (bitMapInfo[5] & 0xff) << 8 | (bitMapInfo[4] & 0xff) );  
		
            int bitMapInfoHeight = (int)( (bitMapInfo[11] & 0xff) << 24 | (bitMapInfo[10] & 0xff) << 16  
                    | (bitMapInfo[9] & 0xff) << 8 | (bitMapInfo[8] & 0xff) ); 
            
            bitNum = (int)( (bitMapInfo[15] & 0xff) << 8 | (bitMapInfo[14] & 0xff) );
            if(bitNum == 24) {     //如果是24位彩色图像
            	int emptyByteNum = bitMapInfoSize / bitMapInfoHeight - 3 * bitMapInfoWidth;  
                //感觉这段代码有问题------！！！！！！！！！！！！！
                if(emptyByteNum == 4) {  
                	emptyByteNum = 0;  
                }
                
                int temp = 0;  //待定
                
                int pixelArray[] = new int [bitMapInfoWidth * bitMapInfoHeight];  
                byte bmpTotalByte[] = new byte[bitMapInfoSize];  
                fis.read(bmpTotalByte, 0, bitMapInfoSize);  
                  
                for(int i = bitMapInfoHeight-1; i >= 0; i-- ){  
                    for( int j = 0; j < bitMapInfoWidth; j++ ){  
                        //第一个0xff << 24表示透明度  
                        pixelArray[ bitMapInfoWidth * i + j ] = 0xff << 24  
                                | (bmpTotalByte[temp+2] & 0xff) << 16   
                                | (bmpTotalByte[temp+1] & 0xff) << 8   
                                | (bmpTotalByte[temp] & 0xff) ;  
                          
                        temp += 3;  
                    }  
                    temp += emptyByteNum;  
                }  
                
                image = Toolkit.getDefaultToolkit().createImage((ImageProducer) new MemoryImageSource(  
                        bitMapInfoWidth, bitMapInfoHeight, pixelArray, 0, bitMapInfoWidth));  
            }
            fis.close();  
            return image;  
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Image myWrite(Image image, String savename) throws IOException {
		File file = new File(savename + ".bmp");
		try {
			int height = image.getHeight(null);
			int width = image.getWidth(null);
			
			int fileType;
			if(bitNum == 24) {
				fileType = BufferedImage.TYPE_3BYTE_BGR;
			}
			else {
				fileType = BufferedImage.TYPE_BYTE_GRAY;
			}
			
			BufferedImage bmp = new BufferedImage(width, height, fileType);
			bmp.getGraphics().drawImage(image, 0, 0, null);
			ImageIO.write(bmp, "bmp", file);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return image;
	}
}
