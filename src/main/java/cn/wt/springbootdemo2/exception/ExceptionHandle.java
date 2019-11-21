package cn.wt.springbootdemo2.exception;

import cn.wt.springbootdemo2.exception.RunException;
import cn.wt.springbootdemo2.result.ResultEnum;
import cn.wt.springbootdemo2.result.ResultObject;
import cn.wt.springbootdemo2.result.ReturnResult;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);


    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultObject BindExceptionHandler(HttpServletRequest request, BindException e) {
        FieldError err = e.getFieldError();
        String message = "参数{" + err.getField() + "}有误,message:" + err.getDefaultMessage();
        return ReturnResult.param_error(message);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResultObject BindExceptionHandler(HttpServletRequest request, ConstraintViolationException e) {
        String message = "";
        Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) e).getConstraintViolations();

        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            PathImpl pathImpl = (PathImpl) constraintViolation.getPropertyPath();
            message =  "参数{"+pathImpl.getLeafNode().getName() + "}有误,message:" + constraintViolation.getMessage();
        }

        return ReturnResult.param_error(message);
    }


    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public ResultObject HttpRequestMethodNotSupportedExceptionHandler(HttpServletRequest request, HttpRequestMethodNotSupportedException e) {
        return ReturnResult.error(ResultEnum.METHOD_NOT_ALLOWED);
    }


    @ExceptionHandler(RunException.class)
    @ResponseBody
    public ResultObject RunExceptionHandler(HttpServletRequest request, RunException e) {
        RunException re = (RunException)e;
        StackTraceElement stackTraceElement= e.getStackTrace()[0];// 得到异常棧的首个元素
        return new ResultObject(re.getStatus(),re.getMessage());
    }




    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultObject defultExcepitonHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        return ReturnResult.error(ResultEnum.ERROR);
    }


}
