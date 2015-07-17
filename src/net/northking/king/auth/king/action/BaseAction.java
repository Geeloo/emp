package net.northking.king.auth.king.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.northking.king.utils.GenericSuperClass;
import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class BaseAction <T> extends ActionSupport implements ServletRequestAware,ServletResponseAware,ModelDriven<T> {

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	@SuppressWarnings("unchecked")
	private Class entityClass = GenericSuperClass.getGenericSuperclass(this.getClass());
	protected T model;
	
	private JSONObject result;
    private String rows;
    private String page;
	
	@SuppressWarnings("unchecked")
	public BaseAction(){
		try {
			model = (T) entityClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setServletRequest(HttpServletRequest req) {
		this.request = req;
	}
	
	public void setServletResponse(HttpServletResponse res) {
		this.response = res;
	}
	
	public T getModel() {
		return model;
	}
	public HttpServletRequest getServletRequest() {
		return request;
	}
	public HttpServletResponse getServletResponse() {
		response.setCharacterEncoding("UTF-8"); 
		return response;
	}

    
    public JSONObject getResult() {  
        return result;  
    }  
    public void setResult(JSONObject result) {  
        this.result = result;  
    }  
   
    
    public String getRows() {  
    	return rows;  
    }  
    public void setRows(String rows) {  
        this.rows = rows;  
    }  
    public String getPage() {  
        return page;  
    }  
    public void setPage(String page) {  
        this.page = page;  
    }  
	
}
