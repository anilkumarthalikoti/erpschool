package com.java.erp.webapp.web.common;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class ImageUpload {
	int width = 0;
	int height = 0;
	File fileUpload;
	String folder = "";
	String fileName;
	String actualFileName;
	HttpServletRequest request;

	public ImageUpload() {
	}

	public void uploadImageFile() {
		try {

			String ext = actualFileName.substring(actualFileName.lastIndexOf(".") + 1);
			ext = ext.toLowerCase();

			if (ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("png")
					|| ext.equalsIgnoreCase("gif")) {
				 
				String filePath = this.request.getRealPath("/");
				filePath = filePath + folder;

				File fileToCreate = new File(filePath, fileName + ".jpg");
				FileUtils.copyFile(fileUpload, fileToCreate);

				 
				if (width == 0 && height == 0) {
					
				} else {
					File sourceimage = new File(filePath + "/"
							+ fileName+ ".jpg");

					BufferedImage image = ImageIO.read(sourceimage);
					int imageWidth = image.getWidth();
					int imageHeight = image.getHeight();
					BufferedImage bdest = new BufferedImage(width, height,
							BufferedImage.SCALE_SMOOTH);

					Graphics2D g = bdest.createGraphics();
					AffineTransform at = AffineTransform.getScaleInstance(
							(double) width / image.getWidth(),
							(double) height / image.getHeight());
					g.drawRenderedImage(image, at);

					try {
						ImageIO.write(bdest, "jpg", fileToCreate);

					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}

		} catch (Exception e) {

		}

	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getActualFileName() {
		return actualFileName;
	}

	public void setActualFileName(String actualFileName) {
		this.actualFileName = actualFileName;
	}

}
