package jxau.linhu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
* @author hemm
*用户没有登录的情况下就会转到登录页面
*/
public class AccessController implements Filter {

    /* (non-Javadoc)
    * @see javax.servlet.Filter#destroy()
    */
    public void destroy() {
        
        
    }

    /* (non-Javadoc)
    * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
    */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /** 
        * 1,doFilter方法的第�?个参数为ServletRequest对象。此对象给过滤器提供了对进入的信息（包括
        *�? 表单数据、cookie和HTTP请求头）的完全访问�?�第二个参数为ServletResponse，�?�常在简单的�?
        *�? 滤器中忽略此参数。最后一个参数为FilterChain，此参数用来调用servlet或JSP页�??
        */
        
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        /** 
        * 如果处理HTTP请求，并且需要访问诸如getHeader或getCookies等在ServletRequest�?
        *�?无法得到的方法，就要把此request对象构�?�成HttpServletRequest
        */
        HttpServletResponse response = (HttpServletResponse)servletResponse;
//        取得根目录所对应的绝对路�?
        String currentURL=request.getRequestURI();
        System.out.println("request.getRequestURI()="+request.getRequestURI()); 
        String targetURL=currentURL.substring(currentURL.indexOf("/",1));
        System.out.println("targetURL="+targetURL); 
        //截取到当前文件名用于比较
        currentURL.length();
        HttpSession session=request.getSession(false);
//      判断当前页是否是登录页面，如果不是就做session的判断，防止出现未经过登录验证的非法访问
        if(!"/index.jsp".equals(targetURL)){

            if(session==null||session.getAttribute("name")==null){
//                *用户登录以后�?手动添加session
                System.out.println("request.getContextPath()="+request.getContextPath());
                response.sendRedirect(request.getContextPath()+"/index.jsp");
//                如果session为空表示用户没有登录就重定向到login.jsp页面
                return;
            }
        }
//        加入filter 继续向下执行
        filterChain.doFilter(request, response);
        /**�?
        * 调用FilterChain对象的doFilter方法�?
        * Filter接口的doFilter方法取一个FilterChain对象作为�? 的一个参数�??
        * 在调用此对象的doFilter方法时，�?活下�?个相关的过滤器�??
        * 如果没有另一个过滤器与servlet或JSP页面关联，则servlet或JSP页面被激活�??
        */
    }

    /* (non-Javadoc)
    * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
    */
    public void init(FilterConfig filterConfig) throws ServletException {
        
        
    }
}
