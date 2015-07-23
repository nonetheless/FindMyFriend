package ServletController;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class UpheadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userID = (String) request.getSession().getAttribute("userID");
		ServletConfig config = this.getServletConfig();
        SmartUpload mySmartUpload = new SmartUpload();//上传图片的工具类
        mySmartUpload.initialize(config, request, response);// 初始化
        try {
            mySmartUpload.upload();
            com.jspsmart.upload.File f1 = mySmartUpload.getFiles().getFile(0);
            String imageName = f1.getFileName();
            int idx = imageName.lastIndexOf(".");
            String imageType = imageName.substring(idx, imageName.length());
            String newImageName = userID+imageType;
            String path = request.getRealPath("/headImage");
            File file = new File(path);
            if(!file.exists()){
                file.mkdirs();
            }
            String imagePath = path+File.separator+newImageName;
            this.reduceImageEqualProportion(imagePath, imagePath);
             
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void reduceImageEqualProportion(String srcImagePath,
			String toImagePath) throws IOException {
		int ratio1;
		int ratio2;
		FileOutputStream out = null;
		try {
			// 读入文件
			File file = new File(srcImagePath);
			// 构造Image对象
			BufferedImage src = javax.imageio.ImageIO.read(file);
			int width = src.getWidth();
			int height = src.getHeight();
			ratio1 = width/42;
			ratio2 = height/40;
			// 缩小边长
			BufferedImage tag = new BufferedImage(width / ratio1, height
					/ ratio2, BufferedImage.TYPE_INT_RGB);
			// 绘制 缩小 后的图片
			tag.getGraphics().drawImage(src, 0, 0, width / ratio1,
					height / ratio2, null);
			out = new FileOutputStream(toImagePath);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(tag);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
