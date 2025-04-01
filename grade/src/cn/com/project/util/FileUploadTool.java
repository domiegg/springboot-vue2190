package cn.com.project.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 文件上传工具类
 * @author 
 * @ClassName: FileUploadTool
 * @Version 1.0
 * @ModifiedBy
 * @Copyright 
 * @date 2014-3-10 上午09:51:11
 * @description
 */
public class FileUploadTool {
	/**具有所有表单信息的请求*/
	private HttpServletRequest request;
	
	/**存放单个数值的表单数据的KV对,如：文本框，单选框等*/
	private Map<String, String> map;
	
	/**存放多个数值的表单数据的KV对，如：多选框*/
	private Map<String, List<String>> mapValues;
	
	/**文件的上传路径-项目的文件夹*/
	private String filePath;
	
	/**文件最终上传到服务器的位置*/
	private String fileServerUrl;
	
	/**
	 * 基本构造方法，默认上传文件的路径是 image
	 * @author  
	 * @date 2014-3-10 上午10:30:51
	 * @param request 具有表单数据的请求
	 */
	public FileUploadTool(HttpServletRequest request) {
		this(request, "image");
	}
	
	/**
	 * @author  
	 * @date 2014-3-10 上午10:30:51
	 * @param request 具有表单数据的请求
	 * @param filePath 上传文件的路径
	 */
	public FileUploadTool(HttpServletRequest request, String filePath) {
		this.request = request;
		this.filePath = filePath;
		
		map = new HashMap<String, String>();
		mapValues = new HashMap<String, List<String>>();
		
		upload();//上传文件
	}
	
	/**
	 * 指定上传到服务器上的文件名称
	 * @author  
	 * @title: getFileName 用户上传的文件名称
	 * @date 2014-3-10 上午10:26:05
	 * @param fileName 保存到服务器的文件名称
	 * @return String
	 */
	private String getFileName(String fileName) {
		return UUID.randomUUID() + fileName.substring(fileName.lastIndexOf(".")) ;
	}
	
	/**
	 * 执行上传文件
	 * @author  
	 * @title: upload
	 * @date 2014-3-10 下午12:13:46 void
	 */
	@SuppressWarnings("unchecked")
	public void upload() {
		//获取文件最终上传到服务器的位置-文件夹
		fileServerUrl = request.getSession().getServletContext().getRealPath(filePath);
		
		//如果此文件夹不存在，则新创建一个。
		File floder = new File(fileServerUrl);
		if(!floder.exists()) {
			floder.mkdir();
		}
		
		DiskFileItemFactory dff = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(dff);
		
		try {
			//把表单标签封装成FileItem对象
			List<FileItem> list = sfu.parseRequest(request);
			
			//用来处理多选框等多个数值的表单，存放一个表单控件的多个数据
			List<String> values;
			
			//遍历每个FileItem对象，即遍历每个表单标签
			for (int i = 0; i < list.size(); i++) {
				
				//获取当前所遍历的表单对象
				FileItem fileItem = list.get(i);
				
				//这里获取的是表单标签的name属性值，即Key值
				String targetName = fileItem.getFieldName();
				
				if(fileItem.isFormField()) {//是普通的表单标签
					//取出普通标签的值
					String value = fileItem.getString("UTF-8");
					
					//把此表单控件的name属性值，以及用户所填的数据，一起放到map中
					map.put(targetName, value);
					
					//获取多个同名控件的数值集合
					values = mapValues.get(targetName);
					
					//如果没有，即第一次添加
					if(values == null) {
						//则新创建一个集合
						values = new ArrayList<String>();
						
						//把此表单数值集合，放到多数值的map集合中
						mapValues.put(targetName, values);
						
					}
					
					//添加当前的数值到集合中。
					values.add(value);
					
				}else {//是文件标签
					String fileName = fileItem.getName();//获取文件的名称-用户上传的
					
					if(!"".equals(fileName)) {//如果用户已选择文件
						
						//获取上传到服务器上的文件名称
						fileName = getFileName(fileName);
						
						//把此控件的name属性值，及上传到服务器上的文件名称，一起放到map中
						map.put(targetName, fileName);
						
						//获取此多个文件的数值集合
						values = mapValues.get(targetName);
						
						//如果没有，即第一次添加
						if(values == null) {
							//则新创建一个集合
							values = new ArrayList<String>();
							
							//把此表单数值集合，放到多数值的map集合中
							mapValues.put(targetName, values);
							
						}
						
						//把此控件的上传到服务器的文件名称添加到当前的数值到集合中。
						values.add(fileName);
						
						//这是上传文件的关键操作
						fileItem.write(new File(fileServerUrl, fileName));
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取单数据表单中的内容
	 * @author  
	 * @title: getParameter
	 * @date 2014-3-10 上午10:30:48
	 * @param key
	 * @return String
	 */
	public String getParameter(String key) {
		return map.get(key);
	}
	
	/**
	 * 获取多数据表单控件中的内容
	 * @author  
	 * @title: getParamaterValues
	 * @date 2014-3-10 上午10:30:51
	 * @param key
	 * @return List<String>
	 */
	public List<String> getParamaterValues(String key) {
		return mapValues.get(key);
	}
}
