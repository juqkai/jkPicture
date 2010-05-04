/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.alanx.upload.tag;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/**
 *
 * @author alan.xiao
 */
public class AlanXUploadBodyTag implements Tag{
    private PageContext pageContext;
    private Tag parent;

    private void init() throws IOException{
    	
    	StringBuffer sb = new StringBuffer("");
    	sb.append("<div>");
    	sb.append("<div id=\"AlanX\">");
    	sb.append("<p>如果您看到这段文字，说明可能出现如下情况</p>");
    	sb.append("<p>1.flash插件版本太低，需要升级到至少9.0.0版本</p>");
    	sb.append("<p>2.参数配置有错�?/p>");
    	sb.append("</div>");
    	sb.append("</div>");
    	pageContext.getOut().write(sb.toString());
    }


    public int doStartTag() throws JspException {
        return Tag.SKIP_BODY;
    }


    
    public int doEndTag() throws JspException {
        try {
            this.init();
        } catch (IOException ex) {
            Logger.getLogger(AlanXUploadBodyTag.class.getName()).log(Level.SEVERE, "初始化组件失败", ex);
            try {
				pageContext.getOut().write("初始化组件失败，有任何问题，请在<a href=\"http://www.alanx.cn\" target=\"new\">http://www.alanx.cn</a>上留言");
			} catch (IOException e) {
				Logger.getLogger(AlanXUploadBodyTag.class.getName()).log(Level.SEVERE, "初始化组件失败", ex);
			}
			
			
        }
        return Tag.EVAL_PAGE;
    }


    public void release() {
        //todo
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
 
	public PageContext getPageContext() {
		return pageContext;
	}

}
