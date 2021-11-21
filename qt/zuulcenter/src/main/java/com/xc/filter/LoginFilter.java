package com.xc.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.xc.utils.TokenUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFilter extends ZuulFilter {
    //filterType过滤的类型

    /**
     *  pre：请求在被路由之前执行
     *  route：在路由请求时调用
     *  post：在route和errror过滤器之后调用
     *  error：处理请求时发生错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }
    //可能会写很多个过滤器，这是过滤器的执行顺序，多个过滤器数字间隔大一些，为了两个相邻的过滤器还要执行其他过滤器
    @Override
    public int filterOrder() {
        return 10;
    }
    //是否执行过滤器
    //true，就会执行当前过滤器，false就不会执行
    @Override
    public boolean shouldFilter() {
        return true;
    }
    //就是执行过滤的功能，如果返回空可以理解为之前的放行
    @Override
    public Object run() throws ZuulException {

        RequestContext context=RequestContext.getCurrentContext();
        HttpServletRequest request=context.getRequest();
        String path=request.getRequestURI();
        System.out.println(path);
        //路径是叫login直接放行
        if(path.contains("login")||path.contains("regist")||path.contains("spu")){
            return null;
        }

        //判断 请求中是否携带token
        /* String token=request.getParameter("access-token");*/
        String token=request.getHeader("access-token");
        System.out.println(token);
        //如果不携带，肯定就是不能进行访问，就需要做一些不允许访问的操作
        if(StringUtils.isBlank(token)){
            // 过滤该请求，不对其进行路由
            context.setSendZuulResponse(false);
            // 设置响应状态码，401
            context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            // 设置响应信息
            context.setResponseBody("{\"status\":\"401\", \"text\":\"request error!\"}");
        }
        //如果携带了，还要判断携带的token是否过期
        if(!TokenUtil.verify(token)){
            // 过滤该请求，不对其进行路由
            context.setSendZuulResponse(false);
            // 设置响应状态码，401
            context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            // 设置响应信息
            context.setResponseBody("{\"status\":\"401\", \"text\":\"request error!\"}");

        }
        //如果过期了，也不能放行
        //如果没有问题才进行放行
        return null;
    }
}
