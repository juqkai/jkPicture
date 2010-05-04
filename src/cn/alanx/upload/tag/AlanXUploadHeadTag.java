/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.alanx.upload.tag;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;


/**
 *
 * @author alan.xiao
 */
public class AlanXUploadHeadTag implements Tag{
	private static final long serialVersionUID = 1L;
	private static final String ALANX_UPLOAD_FOLDER = "AlanX_Upload_Folder";
	public  static final String ALANX_UPLOAD_SERVLET = "JuqccUploadServlet";
	
    private PageContext pageContext;
    private Tag parent;
    private String uploadUrl;
    private String extensionName;
    private String extensionDisp;
    private int maxFileN;
    private int maxFileSize;
    private int maxAllFileSize;
    private boolean waitForProgress = false;
    private boolean errorContinue = true;
    private boolean showLogoTxt = true;
    private String uploadPath;
   
    private void init() throws Exception{
    	HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
    	String contextPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
    	if(uploadUrl == null || uploadUrl.trim().equals("")){
    		uploadUrl = contextPath+ALANX_UPLOAD_SERVLET;
    	}
    	
    	String basePath = pageContext.getServletContext().getRealPath("/") + "/";
    	String alanxPath = basePath + "AlanX";
    	String alanxSwfPath = basePath + "AlanX/AlanX.swf";
    	String alanxJsPath = basePath + "AlanX/swfobject.js";
    	String expressInstallSwfPath = basePath + "AlanX/expressInstall.swf";
    	File alanxFolder = new File(alanxPath);
    	File alanxSwfFile = new File(alanxSwfPath);
    	File alanxJsFile = new File(alanxJsPath);
    	File expressInstallSwfFile = new File(expressInstallSwfPath);
    	if(!alanxFolder.exists()|| alanxFolder.isFile() || !alanxSwfFile.exists() || alanxSwfFile.isDirectory()
    			|| !alanxJsFile.exists() || alanxJsFile.isDirectory()
        		|| !expressInstallSwfFile.exists() || expressInstallSwfFile.isDirectory()
    		){	
    		throw new Exception("组件库不完整,没有在发现AlanX文件");
    	}
    	
    	StringBuffer sb = new StringBuffer("");
    	
    	sb.append("<script type=\"text/javascript\" src=\"AlanX/swfobject.js\"></script>");
    	sb.append("<script type=\"text/javascript\">");
    	
    	//设置传入flash中的参数
    	sb.append("var flashvars = {};");  
    	sb.append("flashvars.uploadUrl=\""+uploadUrl+"\";");	//上传的url;
    	sb.append("flashvars.extensionName=\""+(extensionName == null || extensionName.trim().equals("")?"*.*":extensionName)+"\";");	//允许扩展名，�?.xls;.doc";
    	sb.append("flashvars.extensionDisp=\""+(extensionDisp == null || extensionDisp.trim().equals("")?"AlanX上传组件":extensionDisp)+"\";");	//显示在扩展名�?
    	sb.append("flashvars.maxFileN="+ (maxFileN<=0 ? 100 : maxFileN)+";");//允许上传的最大文件个�?
    	sb.append("flashvars.maxFileSize="+(maxFileSize <=0 || maxFileSize > 104857600? 104857600:maxFileSize)+";");//允许上传的最大文件大�?byte);(10M)
    	sb.append("flashvars.maxAllFileSize="+(maxAllFileSize <=0 || maxAllFileSize >1048576000?1048576000:maxAllFileSize)+"1048576000;");//允许上传的�?文件�?���?byte);(100M)
    	sb.append("flashvars.waitForProgress = \""+waitForProgress+"\";");//上一个文件上传完毕后，是否马上开始上传下�?��文件(默认false)，还是等待业务�?辑处理完之后（比如可能需要解析文件等业务过程），再开始下�?��文件的上�?true)
    	sb.append("flashvars.errorContinue = \""+errorContinue+"\";");//上传某一个文件出错，是否继续上传其他文件默认为true
    	sb.append("flashvars.showLogoTxt = \""+showLogoTxt+"\";");//显示AlanX的logo及链接，默认为显示，当鼠标在组件右边悬停时，logo会显示，点击可以看到官方的帮助文�?�?    	sb.append("var params = {};");  
    	sb.append("var attributes = {};");  
    	sb.append("swfobject.embedSWF(\"AlanX/AlanX.swf\", \"AlanX\", \"500\", \"40\", \"9.0.0\",\"AlanX/expressInstall.swf\",flashvars, params, attributes);");  
    	
    	sb.append("</script>");
    	pageContext.getOut().write(sb.toString());
    }
    
    public int doStartTag() throws JspException {
        return Tag.SKIP_BODY;
    }


    
    public int doEndTag() throws JspException {
        try {
            this.init();
        } catch (Exception ex) {
            throw new JspException("组建初始化失败",ex);
        }
        return Tag.EVAL_PAGE;
    }


    public void release() {
        
    }


    public void setPageContext(PageContext pageContext) {
        this.pageContext = pageContext;
        
    }


    public void setParent(Tag parent) {
       this.parent = parent;
    }


    public Tag getParent() {
        return  parent;
    }
    
	public String getUploadUrl() {
		return uploadUrl;
	}


	public void setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
	}


	public String getExtensionName() {
		return extensionName;
	}


	public void setExtensionName(String extensionName) {
		this.extensionName = extensionName;
	}


	public String getExtensionDisp() {
		return extensionDisp;
	}


	public void setExtensionDisp(String extensionDisp) {
		this.extensionDisp = extensionDisp;
	}


	public int getMaxFileN() {
		return maxFileN;
	}


	public void setMaxFileN(int maxFileN) {
		this.maxFileN = maxFileN;
	}


	public int getMaxFileSize() {
		return maxFileSize;
	}


	public void setMaxFileSize(int maxFileSize) {
		this.maxFileSize = maxFileSize;
	}


	public int getMaxAllFileSize() {
		return maxAllFileSize;
	}


	public void setMaxAllFileSize(int maxAllFileSize) {
		this.maxAllFileSize = maxAllFileSize;
	}


	public boolean isWaitForProgress() {
		return waitForProgress;
	}


	public void setWaitForProgress(boolean waitForProgress) {
		this.waitForProgress = waitForProgress;
	}


	public boolean isErrorContinue() {
		return errorContinue;
	}


	public void setErrorContinue(boolean errorContinue) {
		this.errorContinue = errorContinue;
	}


	public boolean isShowLogoTxt() {
		return showLogoTxt;
	}


	public void setShowLogoTxt(boolean showLogoTxt) {
		this.showLogoTxt = showLogoTxt;
	}


	public PageContext getPageContext() {
		return pageContext;
	}


	public String getUploadPath() {
		return uploadPath;
	}


	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}



}
