package test;

import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by tcf24 on 2016/5/7.
 */
public class ImgHelper {

    public static String encode(byte[] bytes){
        return new BASE64Encoder().encode(bytes);
    }

    public static String encodeImg(String imgUrl) throws IOException {
        FileInputStream fis = new FileInputStream(new File(imgUrl));
        byte[] bytes = new byte[fis.available()];

        fis.read(bytes);

        return encode(bytes);
    }

    public static void main(String[] args) {
        String imgUrl = "etc/img01.jpg";
        try {
            String data = encodeImg(imgUrl);

            System.out.println(data);
            System.out.println("length is :  " + data.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
