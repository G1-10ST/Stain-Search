import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class SpotStain {
	BufferedImage image;
	   int width;
	   int height;
	   int count=0;
	   
	   public SpotStain() {
	      try {
	         image = ImageIO.read(getClass().getResource("/test11.png"));
	         width = image.getWidth();
	         height = image.getHeight();
	         
	         int cloth[];
	         int xc[];
	         int yc[];
	         int s=height*width;
	         cloth=new int[s];
	         xc=new int[s];
	         yc=new int[s];
	         int p=0,i,j,k=0;
	         for(i=0; i<height; i++) {
	         
	            for( j=0; j<width; j++) {
	            
	               Color c = new Color(image.getRGB(j, i));
	               if(c.getRed()!=0 || c.getGreen()!=0 || c.getBlue()!=0 )
	               {  
	                  cloth[p]=0;
	                  xc[p]=j;
	                  yc[p]=i;
	                  p++;
	                  
	            
	            }
	            else
	            {
	               cloth[s-1-k]=1;
	               xc[s-1-k]=j;
	               yc[s-1-k]=i;
	               k++;
	            }
	         }
	         }
	         int m=SpotSearch.search(cloth,0,s-1,1);
	         System.out.println("Width: "+width+" Height : "+height);
	         for(i=0;i<s;i++)
	         {
	        	 if(cloth[i]==1)
	        	 {
	        		 count++;
	        	 } 
	         }
	         int f=1;
	         System.out.println("Black Pixel Count : "+count);
	         System.out.println("Co-ordinates of Black Pixels (x-coordinate,y-coordinate)");
	         for(i=m;i<s-1;i++)
	         {
	        	 if(xc[i+1]-xc[i]>1 || yc[i+1]-yc[i]>1)
	        	 {
	        		 System.out.println(f +" ~ (" + xc[i] + " ,  " + yc[i]+ ")");
	        		 f++;
	        	 } 
	         }
	      }catch (Exception e) {
	    	  System.out.println("Could not load Image");
	      }
	         
	   

}

   
   public static void main(String args[]) throws Exception {
      new SpotStain();
   }
}