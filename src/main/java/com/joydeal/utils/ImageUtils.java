/**
 * ImageUtils.java
 * [CopyRight]
 * @author leo [leoyonn@gmail.com]
 * @date 2013-7-12 下午5:43:49
 */
package com.joydeal.utils;

import javax.imageio.*;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.stream.MemoryCacheImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Image-related com.joydeal.utils, such as load, display, etc.
 *
 * @author leo
 */
public class ImageUtils {
    public static final String FAKE_UA = "Mozilla/5.0 (X11; Linux i686) AppleWebKit/535.1"
            + " (KHTML, like Gecko) Chrome/13.0.782.218 Safari/535.1";

    public static final Set<String> IMG_SUBS = new HashSet<String>() {
        private static final long serialVersionUID = 1L;

        {
            add("bmp");
            add("gif");
            add("jpeg");
            add("jpg");
            add("png");
            add("tif");
            add("tiff");
        }
    };

    /**
     * load an Image from the filePath, which can be either local or online.
     *
     * @param filePath
     * @return
     * @throws java.io.IOException
     * @throws java.net.MalformedURLException
     */
    public static BufferedImage load(String filePath) throws MalformedURLException, IOException {
        BufferedImage image = null;
        if (filePath.startsWith("http://")) {
            image = ImageIO.read(new URL(filePath));
        } else {
            image = ImageIO.read(new File(filePath));
        }
        return image;
    }

    /**
     * load an Image from file.
     *
     * @param file
     * @return
     * @throws java.io.IOException
     */
    public static BufferedImage load(File file) throws IOException {
        return ImageIO.read(file);
    }

    /**
     * create an image from file-bytes (not pixels!)
     *
     * @param bytes
     * @param filePath
     * @return
     * @throws java.io.IOException
     */
    public static BufferedImage create(byte[] bytes, String filePath) throws IOException {
        // get image from bytes
        ByteArrayInputStream bais = null;
        MemoryCacheImageInputStream mcis = null;
        BufferedImage image = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            mcis = new MemoryCacheImageInputStream(bais);
            image = ImageIO.read(mcis);
        } finally {
            if (image == null && mcis != null) { // ImageIO.read will close on success.
                mcis.close();
            }
        }
        // save bytes to file.
        if (image != null && filePath != null) {
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(filePath);
                fos.write(bytes);
            } finally {
                if (fos != null) {
                    fos.close();
                }
            }
        }
        return image;
    }

    /**
     * create an image from pixels
     *
     * @param pixels
     * @param w
     * @param h
     * @param fmt      "JPEG", "BMP", "GIF", "PNG"...
     * @param filePath if not null, save here.
     * @return
     */
    public static BufferedImage create(int[] pixels, int w, int h, String filePath) {
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        image.setRGB(0, 0, w, h, pixels, 0, w);
        if (filePath != null) {
            try {
                save(image, filePath, 1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return image;
    }

    /**
     * save an image to disk, use quality.
     *
     * @param image
     * @param quality  between 0 and 1.
     * @param filePath
     * @param fmt
     * @return
     * @throws java.io.IOException
     */
    public static boolean save(BufferedImage image, String filePath, float quality)
            throws IOException {
        ImageTypeSpecifier type = ImageTypeSpecifier.createFromRenderedImage(image);
        String ext = Utils.getFileExtFromPath(filePath);
        if (ext == null || !IMG_SUBS.contains(ext)) {
            ext = "jpg";
        }
        Iterator<?> it = ImageIO.getImageWriters(type, ext);
        ImageWriter writer = null;
        if (it.hasNext()) {
            writer = (ImageWriter) it.next();
        }
        if (writer == null) {
            return false;
        }
        IIOImage iioImage = new IIOImage(image, null, null);
        ImageWriteParam param = writer.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        String[] types = param.getCompressionTypes();
        if (types != null && types.length > 0) {
            param.setCompressionType(types[0]);
        }
        param.setCompressionQuality(quality);
        ImageOutputStream outputStream = ImageIO.createImageOutputStream(new File(filePath));
        writer.setOutput(outputStream);
        writer.write(null, iioImage, param);
        return true;
    }

    public static boolean loadAndSave(String urlString, String savePath, int maxRetry) throws IOException {
        URL url = new URL(urlString);
        URLConnection con = url.openConnection();
        con.addRequestProperty("User-Agent", FAKE_UA);
        con.setConnectTimeout(1000);
        con.setReadTimeout(2000);
        BufferedInputStream reader = null;
        BufferedOutputStream writer = null;
        int retry = 0;
        while (retry < maxRetry) {
            try {
                reader = new BufferedInputStream(con.getInputStream());
                break;
            } catch (IOException ex) {
                if (++retry >= maxRetry) {
                    throw ex;
                }
            }
        }
        try {
            writer = new BufferedOutputStream(new FileOutputStream(savePath));
            byte[] buffer = new byte[4096];
            int size = 0;
            while ((size = reader.read(buffer)) > 0) {
                writer.write(buffer, 0, size);
            }
            return true;
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } finally {
                if (writer != null) {
                    writer.close();
                }
            }
        }
    }

    /**
     * scale image to new size: w x h
     *
     * @param image
     * @param w
     * @param h
     * @return
     */
    public static BufferedImage scale(BufferedImage image, int w, int h) {
        java.awt.Image data = image.getScaledInstance(w, h, java.awt.Image.SCALE_DEFAULT);
        BufferedImage newImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics g = newImage.getGraphics();
        g.drawImage(data, 0, 0, null);
        g.dispose();
        return newImage;
    }

    /**
     * don't read file, just judge by name.
     *
     * @param fileName
     * @return
     */
    public static boolean seemsLikeAnImage(String fileName) {
        int s = fileName.lastIndexOf(".");
        if (s < 0 || s >= fileName.length() - 3) {
            return false;
        }
        return (IMG_SUBS.contains(fileName.substring(s + 1)));
    }

    /**
     * read the pixels of an Image for more processing.
     *
     * @param image
     * @return
     */
    public static int[] getPixels(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();
        int pixels[] = new int[w * h];
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                pixels[y * w + x] = image.getRGB(x, y);
            }
        }
        return pixels;
    }

    public static int hsv2rgb(float[] hsv) {
        return Color.HSBtoRGB(hsv[0], hsv[1], hsv[2]);
    }

    /**
     * crop an image of size * ratio in middle.
     *
     * @param inName
     * @param outName
     * @param ratio
     * @throws java.io.IOException
     */
    public static void crop(String inName, String outName, double ratio)
            throws IOException, IllegalArgumentException {
        ImageInputStream iis = ImageIO.createImageInputStream(new FileInputStream(inName));
        Iterator<?> readers = ImageIO.getImageReaders(iis);
        if (!readers.hasNext()) {
            return;
        }
        ImageReader reader = (ImageReader) readers.next();
        reader.setInput(iis, true, true);
        ImageReadParam param = reader.getDefaultReadParam();
        int w = reader.getWidth(0);
        int h = reader.getHeight(0);
        if (ratio > 1) {
            ratio = 1;
        }
        int size = (int) ((w > h ? h : w) * ratio);
        if (size == 0) {
            size = 1;
        }
        Rectangle rect = new Rectangle((w - size) >> 1, (h - size) >> 1, size, size);
        param.setSourceRegion(rect);
        BufferedImage bi = reader.read(0, param);
        save(bi, outName, 1.0f);
    }

    public static void main(String[] args) throws IOException {
//        String url = "http://t1.baidu.com/it/u=1419861424,2031025413&fm=24&gp=0.jpg";
        String url = "http://tu1.mmonly.com/mmonly/2011/201105/270/14.jpg";
        loadAndSave(url, "./tmp3.jpg", 3);
//        BufferedImage i = load(url);
//        save(i, url, "./tmp2.jpg", 1);
    }
}

