package com.shanshuan.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangzifeng on 2019/11/21.
 */
@Component
public class MyZuulFillter extends ZuulFilter {
    private Logger logger=LoggerFactory.getLogger(MyZuulFillter.class);
    /**
     * 过滤类型
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;

    }


    /**
     * 过滤顺序
     * 越小 优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER-1;
    }

    /**
     * 要不要过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run()  {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        Map<String, String[]> parameterMap = request.getParameterMap();
        for(Map.Entry<String, String[]> one:parameterMap.entrySet()){
            logger.info(one.getKey()+"---"+ Arrays.toString(one.getValue()));
        }
        if(StringUtils.isBlank(request.getParameter("access_token"))){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(HttpStatus.SC_FORBIDDEN);
        }
        return null;
    }
}
