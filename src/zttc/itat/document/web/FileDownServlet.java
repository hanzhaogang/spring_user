package zttc.itat.document.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class FileDownServlet extends HttpServlet {

	private static final String CONTENT_TYPE = "text/html; charset=GBK";

    //Initialize global variables
    public void init() throws ServletException {
    }

    //Process the HTTP Get request
    public void doGet(HttpServletRequest request, 
    		          HttpServletResponse response) throws ServletException, IOException {

    	response.setContentType(CONTENT_TYPE);
    
    	//得到下载文件的名字
        //String filename=request.getParameter("filename");
       
        //解决中文乱码问题
        String filename=new String(request.getParameter("filename").getBytes("iso-8859-1"),"gbk");

        //创建file对象
        File file=new File(
        		"D://9.software/devEnv/springToolSuite/sts-3.5.0.RELEASE/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/spring_user/resources/upload//"+filename);
        
        //设置response的编码方式
        response.setContentType("application/x-msdownload");

        //写明要下载的文件的大小
        response.setContentLength((int)file.length());

        //设置附加文件名
        // response.setHeader("Content-Disposition","attachment;filename="+filename);
       
        //解决中文乱码
        response.setHeader("Content-Disposition","attachment;filename="+new String

        (filename.getBytes("gbk"),"iso-8859-1"));       

        //读出文件到i/o流
        FileInputStream fis=new FileInputStream(file);
        BufferedInputStream buff=new BufferedInputStream(fis);

        byte [] b=new byte[1024];//相当于我们的缓存

        long k=0;//该值用于计算当前实际下载了多少字节

        //从response对象中得到输出流,准备下载
        OutputStream myout=response.getOutputStream();

        //开始循环下载
        while(k<file.length()){
            int j=buff.read(b,0,1024);
            k+=j;

            //将b中的数据写到客户端的内存
            myout.write(b,0,j);
        }

        //将写入到客户端的内存的数据,刷新到磁盘
        myout.flush();
    }

    //Process the HTTP Post request
    public void doPost(
    		HttpServletRequest request,
    		HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    //Clean up resources
    public void destroy() {
    }
}

