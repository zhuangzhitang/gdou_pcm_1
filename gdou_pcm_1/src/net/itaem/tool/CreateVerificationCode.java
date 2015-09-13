package net.itaem.tool;

import java.util.Random;

/*
 * 生成验证码的类。
 * @author zaopeng
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class CreateVerificationCode {

	public static final String RANDOMCODEKEY = "RANDOMVALIDATECODEKEY";// 放到session中的key
	private Random random = new Random();
	private String randString = "023456789ABCDEFGHJKLMNOPQRSTUVWXYZ";// 随机产生的字符串

	private int width = 80;// 图片宽
	private int height = 24;// 图片高
	private int lineSize = 240;// 干扰线数量
	private int stringNum = 4;// 随机产生字符数量

	/**
	 * 生成随机图片
	 * @throws IOException 
	 */
	public String getRandcode(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
		response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expire", 0);

		
		// BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();// 产生Image对象的Graphics对象,改对象可以在图像上进行各种绘制操作
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
		g.setColor(getRandColor(110, 133));
		// 绘制干扰线
		for (int i = 0; i <= lineSize; i++) {
			drowLine(g);
		}
		// 绘制随机字符
		String randomString = "";
		for (int i = 1; i <= stringNum; i++) {
			randomString = drowString(g, randomString, i);
		}
		
		//System.out.println("生成验证码：" + randomString);
		g.dispose();

		try {
			 //response.setContentType("image/jpeg"); 
			ImageIO.write(image, "JPEG", response.getOutputStream());// 将内存中的图片通过流动形式输出到客户端
		} catch (Exception e) {
			System.out.println("生成验证码图片出错误了！");
			e.printStackTrace();
		}
		return randomString ;
	}

	/*
	 * 获得随机颜色
	 */
	private Color getRandColor(int fc, int bc) {
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc - 16);
		int g = fc + random.nextInt(bc - fc - 14);
		int b = fc + random.nextInt(bc - fc - 18);
		return new Color(r, g, b);
	}

	/*
	 * 绘制干扰线
	 */
	private void drowLine(Graphics g) {
		int x = random.nextInt(width);
		int y = random.nextInt(height);
		int xl = random.nextInt(13);
		int yl = random.nextInt(15);
		g.drawLine(x, y, x + xl, y + yl);
	}

	/*
	 * 绘制字符串
	 */
	private String drowString(Graphics g, String randomString, int i) {
		g.setFont(getFont());
		g.setColor(new Color(random.nextInt(101), random.nextInt(111), random
				.nextInt(121)));
		String rand = String.valueOf(getRandomString(random.nextInt(randString
				.length())));
		randomString += rand;
		g.translate(random.nextInt(3), random.nextInt(3));
		g.drawString(rand, 13 * i, 16);
		return randomString;
	}

	/*
	 * 获得字体
	 */
	private Font getFont() {
		return new Font("Fixedsys", Font.CENTER_BASELINE, 18);
	}

	/*
	 * 获取随机的字符
	 */
	private String getRandomString(int num) {
		return String.valueOf(randString.charAt(num));
	}
}
