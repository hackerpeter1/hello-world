import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;
import java.awt.image.RGBImageFilter;

import imagereader.IImageProcessor;

public class ImplementImageProcessor implements IImageProcessor {

	@Override
	public Image showChanelB(Image sourceImage) {
		ColorChoose cc = new ColorChoose(3);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image image = tk.createImage(new FilteredImageSource(sourceImage.getSource(), cc));
		return image;
	}

	@Override
	public Image showChanelG(Image sourceImage) {
		ColorChoose cc = new ColorChoose(2);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image image = tk.createImage(new FilteredImageSource(sourceImage.getSource(), cc));
		return image;
	}

	@Override
	public Image showChanelR(Image sourceImage) {
		ColorChoose cc = new ColorChoose(1);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image image = tk.createImage(new FilteredImageSource(sourceImage.getSource(), cc));
		return image;
	}
	
	@Override
	public Image showGray(Image sourceImage) {
		ColorChoose cc = new ColorChoose(10);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image image = tk.createImage(new FilteredImageSource(sourceImage.getSource(), cc));
		return image;
	}

}

class ColorChoose extends RGBImageFilter{  
    private int colorNum;  
  
    public ColorChoose(int function){    //选择使用哪一个转换方式
        colorNum = function;  
        canFilterIndexColorModel = true;  
    }  
      
    public int filterRGB(int x, int y, int rgb){   
        if(colorNum==1){  
            return ( rgb & 0xffff0000 );   //只留下红色，最前面的两位是alpha通道，不用理会
        }else if(colorNum==2){  
            return ( rgb & 0xff00ff00 );   //只留下绿色
        }else if(colorNum==3){  
            return ( rgb & 0xff0000ff );   //只留下蓝色
        }else{  
        	int gray = (int)( ((rgb & 0x00ff0000) >> 16) * 0.299 
    				+ ((rgb & 0x0000ff00) >> 8) * 0.587 
    				+ (rgb & 0x000000ff) * 0.114 );
    return (rgb & 0xff000000) + (gray << 16) + (gray << 8) + gray;  
        }  
    }  
}  
