package cn.wt.springbootdemo2.result;


public enum ResultEnum {
    SUCCESS(200,"处理成功"),
    NOFIND(0,"未查询到相关数据"),
    NOACCESS(403,"服务器拒绝请求"),
    ERROR(500,"服务器内部错误"),
    ERROR_TIMEOUT(503,"服务器处理超时"),
    ERROR_UNKNOW(555,"未知错误"),
    ERROR_TOKEN(511,"用户Token错误"),
    ERROR_PERMIT(512,"未授权访问"),
    ERROR_PARAM(513,"参数有误"),
    FAILED(-1,"处理失败"),
    METHOD_NOT_ALLOWED(405,"请求行中指定的请求方法不能被用于请求相应的资源"),
    ;
    private Integer status;
    private String message;


    private ResultEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }




}
