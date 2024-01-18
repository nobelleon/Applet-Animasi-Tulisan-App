/**
 * @(#)Tulisan.java
 *
 * Tulisan Applet application
 *
 * @author nObeLLeon
 * @version 1.00 2020/5/10
 ******************************************************  Program Successful  ************************************************************
 */
 
import java.awt.*;
import java.applet.*;

public class Tulisan extends Applet implements Runnable {
	
	// Inisialisasi 
	int i, j, x, y=0, pp, qq, rr;
	float cahaya = 1;
	int iCahaya = 1;
	boolean k;
	private Image Buffer;
	private Graphics gBuffer;
	Thread AnimTulisan;
	
	public void start(){
		
		if(AnimTulisan == null){
			AnimTulisan = new Thread(this);
			AnimTulisan.start();
		}
	}
	
	public void stop(){
		
		if(AnimTulisan != null){
			AnimTulisan.stop();
			AnimTulisan = null;
		}
	}
	
	public void run(){
		while(true){
			for(x=0; x<150; x++){
				try{
					AnimTulisan.sleep(30);
				}catch(Exception e){}
				if(k=true){
					if(iCahaya > 1000)           //
						k = false;
						iCahaya += 3;
				}
				else{
					if(iCahaya < 10)
						k = true;
						iCahaya -= 3;
				}
				cahaya = (float)iCahaya / 1500;
				repaint();
			}
		}
	}
	
	public void update(Graphics g){
		paint(g);
	}
	
	public void init(){
		
		Buffer = createImage(size().width, size().height);
		gBuffer = Buffer.getGraphics();
		gBuffer.setColor(Color.black);                         // berwarna biru
		gBuffer.fillRect(0, 0, size().width, size().height);
			k = true;
	}
		public void tulisan(){                                // membuat objek/Method tulisan() baru
			pp = x/2;
			qq = x;
			rr = -x/2;
			
		// Membuat latar belakang berwarna biru
			gBuffer.setColor(Color.black);
			gBuffer.fillRect(0, 0, size().width, size().height);
			gBuffer.setColor(Color.blue);
			gBuffer.fillRect(1, 1, size().width-2, size().height-2);
			gBuffer.setFont(new Font("Helvetica", Font.ITALIC, 7));
			gBuffer.setColor(Color.orange);
			
		// Membuat tulisan sebagai latar belakang
				for(i=0; i<280; i+=25){        // 280 -> nama Augmented Reality bertambah ke bawah 
					for(j=0; j<600; j+=75){   
						gBuffer.drawString("Augmented Reality", rr+j, i);
					}
				}
		// Membuat garis Vertikal
				gBuffer.setColor(Color.yellow); 
					for(i=0; i<30; i++){    
						gBuffer.fillRect(pp, y, 1, 290);    //290 garis vertikal bertambah kebawah
						gBuffer.fillRect(pp-300, y, 1, 150);   //
						pp += 15;  
					}
				gBuffer.setFont(new Font("Vivaldi", Font.BOLD, 80));
				gBuffer.setColor(Color.getHSBColor((float)cahaya, (float)1, (float)1));
				gBuffer.drawString(" ~~Nobelleon", 10, 115);
				gBuffer.setColor(Color.green);
			
				gBuffer.setFont(new Font("Vivaldi", Font.BOLD, 80));
				gBuffer.setColor(Color.getHSBColor((float)cahaya, (float)1, (float)1));  // method warna warni
			
				gBuffer.drawString("Mahardhika~~", -6, 215);
				gBuffer.setColor(Color.red);
				
		// Membuat garis Horizontal
				for(i=0; i<20; i++){  
					gBuffer.fillRect(0, qq, 500, 1);   
					gBuffer.fillRect(0, qq-500, 500, 1);  
					qq += 15;
				}	
				
		}
		
		
		public void paint(Graphics g){
			g.drawImage(Buffer, 0, 0, this);
			tulisan();                              // memanggil method tulisan()
		} 

	
}