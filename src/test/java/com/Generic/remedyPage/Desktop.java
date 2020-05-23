package com.Generic.remedyPage;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;



public class Desktop {
	public static void getScreenShot(){
		SimpleDateFormat s=new SimpleDateFormat("dd-MM-yy-HH-mm-ss");
		String Date = s.format(new Date());
		try{
			Dimension desktopsize = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle r=new Rectangle(desktopsize);
			Robot robot=new Robot();
			BufferedImage img = robot.createScreenCapture(r);
			ImageIO.write(img, "jpeg", new File("./ScreenShot/success_"+Date+".jpeg"));
			
		}
		catch(Exception e){
			
		}
	}

}
