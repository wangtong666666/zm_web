package cn.wt.zmweb.exception;

import cn.wt.zmweb.result.ResultEnum;

public class RunException extends RuntimeException{

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public RunException(ResultEnum re){
        super(re.getMessage());
        this.status = re.getStatus();
    }

    public RunException(Integer status,String message){
        super(message);
        this.status = status;
    }

    public RunException(ResultEnum re,Exception e){
        super((e.getMessage() !=null) ? (re.getMessage()+":"+e.getMessage()) : re.getMessage());
        this.status = re.getStatus();
    }

}
