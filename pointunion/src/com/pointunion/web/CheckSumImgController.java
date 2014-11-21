package com.pointunion.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class CheckSumImgController implements Controller {
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.reset();
		// ����ҳ�治����
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/gif");

		// ���ڴ��д���ͼ��
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// ��ȡͼ��������
		Graphics2D g = (Graphics2D) image.getGraphics();

		// ���������
		Random random = new Random();

		// �趨����ɫ
		g.setColor(getRandColor(200, 250)); // ---1

		g.fillRect(0, 0, width, height);

		// �趨����
		g.setFont(mFont);

		// ���߿�
		g.setColor(getRandColor(0, 20)); // ---2
		g.drawRect(0, 0, width - 1, height - 1);

		// ������������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽
		for (int i = 0; i < count; i++) {
			g.setColor(getRandColor(150, 200)); // ---3
			int x = random.nextInt(width - lineWidth - 1) + 1; // ��֤���ڱ߿�֮��
			int y = random.nextInt(height - lineWidth - 1) + 1;
			int xl = random.nextInt(lineWidth);
			int yl = random.nextInt(lineWidth);
			g.drawLine(x, y, x + xl, y + yl);
		}

		// ȡ�����������֤��(6λ����)
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
			// ����֤����ʾ��ͼ����,���ú�����������ɫ��ͬ����������Ϊ����̫�ӽ�������ֻ��ֱ������
			g.setColor(new Color(20 + random.nextInt(130), 20 + random.nextInt(130), 20 + random.nextInt(130))); // --4--50-100
			g.drawString(rand, (13 * i) + 6, 16);
		}

		// ����֤�����SESSION
		request.getSession().setAttribute("checkSum", sRand);
		// ͼ����Ч
		g.dispose();
		// ���ͼ��ҳ��
		ImageIO.write(image, "PNG", response.getOutputStream());
		return null;
	}

	private Font mFont = new Font("Arial Black", Font.PLAIN, 15); // ��������
	private int lineWidth = 2; // �����ߵĳ���=1.414*lineWidth
	private int width = 60; // ����ͼ�δ�С
	private int height = 20; // ����ͼ�δ�С
	private int count = 200;

	private Color getRandColor(int fc, int bc) { // ȡ�ø�����Χ�����ɫ
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}

		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
}
