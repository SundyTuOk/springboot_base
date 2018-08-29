package com.tt.utils.exception.handler;


import com.tt.utils.exception.TException;
import com.tt.utils.rusult.Result;
import com.tt.utils.rusult.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义全局异常处理类
 */
@ControllerAdvice
public class ExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    /**
     * 如果是web请求，下面是用于跳转错误页面的
     */
    private final String NOT_FOUND_PAGE = "errors/404";
    private final String INTERNAL_SERVER_ERROR_PAGE = "errors/500";

    /**
     *  一般异常处理类
     * @param e
     * @param request
     * @return 返回json的modelAndView,如果这里直接返回一个json对象，或者字符串<br/>
     *          会被thyemlef认为为view，然后报错找不到view
     *
     */
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ModelAndView handle(Exception e, HttpServletRequest request) {
        logger.error("发生错误: {}",e.getMessage());
        // ajax请求
        if (isAjax(request)) {
            return ajaxRequestHandle(e);
        }

        // 网页请求
        HttpStatus httpStatus = this.getStatus(request);
        return browserRequestHandle(httpStatus);
    }

    /**
     * 404错误 处理类
     * @param e
     * @param request
     * @return
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView noHandlerException(Exception e, HttpServletRequest request) {
        logger.error("发生错误: {}",e.getMessage());
        TException tException = new TException(Result.ResultEnum.NOT_FOUND);
        // ajax请求,写明详细信息，返回
        if (isAjax(request)) {
            return ajaxRequestHandle(tException);
        }
        // 网页请求404,直接返回到对应的错误页面，不用写详细信息
        return browserRequestHandle(HttpStatus.NOT_FOUND);
    }

    /**
     * 判断请求是否为ajax请求
     */
    public static boolean isAjax(HttpServletRequest request){
        return(request.getHeader("X-Requested-With") != null
                &&"XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }

    protected HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer)request.getAttribute("javax.servlet.errors.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        } else {
            try {
                return HttpStatus.valueOf(statusCode);
            } catch (Exception var4) {
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }
        }
    }

    /**
     * 浏览器请求异常，返回
     * @return
     */
    private ModelAndView browserRequestHandle(HttpStatus httpStatus) {
        if (httpStatus == HttpStatus.NOT_FOUND){
            return new ModelAndView(NOT_FOUND_PAGE);
        }
        if (httpStatus == HttpStatus.INTERNAL_SERVER_ERROR) {
            return new ModelAndView(INTERNAL_SERVER_ERROR_PAGE);
        }
        return new ModelAndView(NOT_FOUND_PAGE);
    }

    /**
     * ajax请求异常，返回
     * @param e
     * @return
     */
    private ModelAndView ajaxRequestHandle(Exception e) {
        MappingJackson2JsonView mj = new MappingJackson2JsonView();
        ModelAndView mv = new ModelAndView(mj);

        Result.ResultEnum resultEnum = null;
        if (e instanceof TException) {
            TException tException = (TException) e;
            resultEnum = tException.getResultEnum();
        } else {
            resultEnum = Result.ResultEnum.UNKNOW;
        }

        Result<Object> failedResult = ResultUtils.failed(resultEnum, null);
        mv.addAllObjects(ResultUtils.resultToMap(failedResult));
        return mv;
    }

}
