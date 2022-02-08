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
        Graphics g = image.getGraphics();
        g.setClip(0, 0, width, height);
        g.setColor(color);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.white);
        g.setFont(font);
        Rectangle clip = g.getClipBounds();
        FontMetrics fm = g.getFontMetrics(font);

        int ascent = fm.getAscent();
        int descent = fm.getDescent();
        int y = (clip.height - (ascent + descent)) / 2 + ascent;
        int x = (width - fontSize * text.length()) / 2;
        g.drawString(text, x, y);
        g.dispose();

        return bufferedImageToBase64(image);
    }

    private static String bufferedImageToBase64(BufferedImage image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = baos.toByteArray();
        BASE64Encoder encoder = new BASE64Encoder();
        String base64 = encoder.encodeBuffer(bytes).trim();
        return "data:image/jpg;base64," + base64;
    }
}
