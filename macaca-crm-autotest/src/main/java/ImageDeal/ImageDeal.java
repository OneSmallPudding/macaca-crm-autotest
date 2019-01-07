package ImageDeal;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;


/**
 * 图像处理类.
 *
 * @author nagsh
 *
 */
public class ImageDeal {

    String openUrl; // 原始图片打开路径
    String saveUrl; // 新图保存路径
    String saveName; // 新图名称
    String suffix; // 新图类型 仅仅支持gif,jpg,png
    public static final String ROOT_PATH = System.getProperty("user.dir");
    public static final String SCREEN_SHOT_PATH = ROOT_PATH + File.separator + "screenshot";

    public ImageDeal(String openUrl, String saveUrl, String saveName,
                     String suffix) {
        this.openUrl  = openUrl;
        this.saveName = saveName;
        this.saveUrl  = saveUrl;
        this.suffix   = suffix;
    }

    /**
     * 图片缩放.
     *
     * @param width
     *            须要的宽度
     * @param height
     *            须要的高度
     * @throws Exception
     */
    public void zoom(double width, double height) throws Exception {
        double sx = 0.0;
        double sy = 0.0;
        int    len;

        URL url                      = new URL(openUrl);
        URLConnection urlconnection  = url.openConnection();
        InputStream input            =  urlconnection.getInputStream();
        byte[] bs                    = new byte[1024];
        OutputStream os              = new FileOutputStream(SCREEN_SHOT_PATH +"/"+ saveName+"before"+ ".png");
        while((len =input.read(bs)) != -1){
            os.write(bs,0,len);
        }
        os.close();
        input.close();
        File file        = new File(SCREEN_SHOT_PATH +"/"+  saveName+"before"+ ".png");
        if (!file.isFile()) {
            throw new Exception("ImageDeal>>>" + file + " 不是一个图片文件!");
        }
        BufferedImage bi = ImageIO.read(file); // 读取该图片
        // 计算x轴y轴缩放比例--如需等比例缩放，在调用之前确保參数width和height是等比例变化的
        sx                   = (double) width / bi.getWidth();
        sy                   = (double) height / bi.getHeight();

        AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(sx, sy), null);
        File sf              = new File(SCREEN_SHOT_PATH +"/"+  saveName+ ".png");
        Image zoomImage      = op.filter(bi, null);
        try {
            ImageIO.write((BufferedImage) zoomImage, suffix, sf); // 保存图片
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * <p>Title: cutImage</p>
     * <p>Description:  根据原图与裁切size截取局部图片</p>
     * @param srcImg    源图片
     * @param output    图片输出流
 * @param rect          需要截取部分的坐标和大小
     */
    public void cutImage(File srcImg, OutputStream output, java.awt.Rectangle rect){
        if(srcImg.exists()){
            java.io.FileInputStream fis = null;
            ImageInputStream iis        = null;
            try {
                fis                     = new FileInputStream(srcImg);
                // ImageIO 支持的图片类型 : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG, JPEG, WBMP, GIF, gif]
                String suffix           = "png";
                // 将FileInputStream 转换为ImageInputStream
                iis                     = ImageIO.createImageInputStream(fis);
                // 根据图片类型获取该种类型的ImageReader
                ImageReader reader      = ImageIO.getImageReadersBySuffix(suffix).next();
                reader.setInput(iis,true);
                ImageReadParam param    = reader.getDefaultReadParam();
                param.setSourceRegion(rect);
                BufferedImage bi        = reader.read(0, param);
                ImageIO.write(bi, suffix, output);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(fis != null) fis.close();
                    if(iis != null) iis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void cutImage(String srcImg, String output, int x, int y, int width, int height) throws Exception {
        File file         = new File(SCREEN_SHOT_PATH +"/"+  srcImg + ".png");
        OutputStream os   = new FileOutputStream(SCREEN_SHOT_PATH +"/"+output+ ".png");
        cutImage(file, os, new java.awt.Rectangle(x, y, width, height));
    }


    /**
     *     获取两张图片的不相似度
     */
    public  String  getPicDissimilarity(String image1,String image2 )  throws  Exception{
        CloseableHttpClient client       = HttpClients.createDefault();
        String url                       = "http://192.168.169.230:9900/opencv/dissimilarity";
        HttpPost httpPost                = new HttpPost(url);
        MultipartEntityBuilder builder   = MultipartEntityBuilder.create();
        builder.addBinaryBody("image1", new File("./screenshot/"+image1+".png"), ContentType.MULTIPART_FORM_DATA, "home.png");
        builder.addBinaryBody("image2", new File("./screenshot/"+image2+".png"), ContentType.MULTIPART_FORM_DATA,  "home_after.png");
        HttpEntity multipart             = builder.build();
        httpPost.setEntity(multipart);
        CloseableHttpResponse response   = client.execute(httpPost);
        System.out.println(response.getStatusLine().getStatusCode());
        String differentDegree           = "";
        try {
            differentDegree              = JSON.parseObject(EntityUtils.toString(response.getEntity())).get("dissimilarity").toString();
            System.out.println(differentDegree);
        } catch (IOException e) {
            e.printStackTrace();
        }
        client.close();
        return   differentDegree;
    }
}

