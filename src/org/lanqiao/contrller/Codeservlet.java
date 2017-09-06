package org.lanqiao.contrller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Codeservlet
 */
@WebServlet(name = "codeservlet", urlPatterns = { "/codes.do" })
public class Codeservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//验证码 动态生成内存中的一张验证图（图片显示的是验证字符）：
		String chars = "wqertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM123456789";
		//创建一个随机器对象
		Random rand = new Random();
		String codes = "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			int index = rand.nextInt(61);//[0,61]
			sb.append(chars.charAt(index));
		}
//		response.getWriter().write(sb.toString());
		codes = sb.toString();
		//2、生成一个内存中的图片，再图片中写入验证字符；
		//A、创建一个内存中的文件
		BufferedImage bufferedImage = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
		//B、绘制图片；
		//拿到一个画笔-->绘制图片及图片内容；
		Graphics g = bufferedImage.getGraphics();

		//填充颜色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 100, 30);//填充白色背景
		//画边框；
		g.setColor(Color.red);
		g.drawRect(1, 1, 88, 28);
		
		//画里面验证字符
		g.setFont(new Font("宋体", Font.BOLD, 20));
		//画干扰线
		g.setColor(Color.GREEN);
		for (int i = 0; i < 4; i++) {
			g.drawLine(rand.nextInt(90), rand.nextInt(30), rand.nextInt(90), rand.nextInt(30));
		}
		g.drawString(codes, 20, 20);//px
		//讲验证字符放到session里面
		request.getSession().setAttribute("code", codes);
		
		
		//输出图片；
		//指定输出为图片格式数据
		response.setContentType("image/jpeg");
		ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
		response.getOutputStream().flush();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
