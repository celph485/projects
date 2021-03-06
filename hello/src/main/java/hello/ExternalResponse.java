package hello;

public class ExternalResponse {

    private String result;

    private String msg;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ExternalResponse{" +
                "result='" + result + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
