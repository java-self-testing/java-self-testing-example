package cn.printf.demos.tdd;

import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageUtil {

    public static final int DEFAULT_WIDTH = 60;
    public static final int DEFAULT_HEIGHT = 60;
    public static final String DEFAULT_FONT = "Default";

    public static String watermarkImage(String text, Color color) {
        int fontSize = 16;
        int width = DEFAULT_WIDTH;
        int height = DEFAULT_HEIGHT;
        Font font = new Font(DEFAULT_FONT, Font.PLAIN, fontSize);

        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_BGR);
        Graphics graphics = image.getGraphics();
        graphics.setClip(0, 0, width, height);
        graphics.setColor(color);
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(Color.white);
        // 设置画笔字体
        graphics.setFont(font);
        Rectangle clip = graphics.getClipBounds();
        FontMetrics fontMetrics = graphics.getFontMetrics(font);

        int ascent = fontMetrics.getAscent();
        int descent = fontMetrics.getDescent();
        int y = (clip.height - (ascent + descent)) / 2 + ascent;
        int x = (width - fontSize * text.length()) / 2;
        graphics.drawString(text, x, y);
        graphics.dispose();
        // 输出 jpeg 图片
        return bufferedImageToBase64(image);
    }

    private static String bufferedImageToBase64(BufferedImage image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpeg", baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = baos.toByteArray();
        BASE64Encoder encoder = new BASE64Encoder();
        String base64 = encoder.encodeBuffer(bytes).trim();
        return "data:image/jpeg;base64," + base64;
    }
}
