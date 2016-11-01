package fileupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.omg.CORBA.RepositoryIdHelper;

public class FileUp extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String method=request.getParameter("method");
		if("upload".equalsIgnoreCase(method)){
			upload(request, response);
		}
		
		if("downList".equalsIgnoreCase(method)){
			downList(request, response);
		}
		
		if("down".equalsIgnoreCase(method)){
			down(request, response);
		}
		
		
		
	}
	
	public void down(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fileName=request.getParameter("fileName");
//		fileName=new String(fileName.getBytes("ISO8859-1"),"utf-8");
		String basePath=getServletContext().getRealPath("upload");
		File file=new File(basePath,fileName);
		System.out.println(fileName);
		InputStream in=new FileInputStream(file);
		
		
		fileName=URLEncoder.encode(fileName,"utf-8");
		response.setHeader("content-disposition", "attachment;fileName=" + fileName);
		byte[] b=new byte[1024];
		int len=0;
		OutputStream out=response.getOutputStream();
		while((len=in.read(b))!=-1){
			out.write(b, 0, len);
		}
		out.close();
		in.close();
		

	}

	public void downList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String,String> map=new HashMap<String, String>();
		String basePath=getServletContext().getRealPath("upload");
		File file=new File(basePath);
		String[] list=file.list();
		if(list!=null&&list.length>0){
			for(int i=0;i<list.length;i++){
				String fileName=list[i];
				String shortName=fileName.substring(fileName.lastIndexOf("_")+1);
				map.put(fileName, shortName);
			}
		}
		request.setAttribute("fileNames", map);
		request.getRequestDispatcher("/downList.jsp").forward(request, response);
	}

	public void upload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			FileItemFactory factory=new DiskFileItemFactory();
			ServletFileUpload upload=new ServletFileUpload(factory);
			upload.setFileSizeMax(30*1024*1024);
			upload.setSizeMax(50*1024*1024);
			upload.setHeaderEncoding("utf-8");
			
			if(upload.isMultipartContent(request)){
				List<FileItem> list=upload.parseRequest(request);
				for(FileItem item:list){
					if(item.isFormField()){
						System.out.println("fieldname: "+item.getFieldName());
						System.out.println("value:"+item.getString());
					}else{
						String name=item.getName();
						String id=UUID.randomUUID().toString();
						name=id+"_"+name;
						String path=getServletContext().getRealPath("upload");
						File file=new File(path, name);
						item.write(file);
						item.delete();
					}
				}
			}
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
