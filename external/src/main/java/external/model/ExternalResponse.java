package external.model;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExternalResponse response = (ExternalResponse) o;

        if (!result.equals(response.result)) return false;
        return msg.equals(response.msg);
    }

    @Override
    public int hashCode() {
        int result1 = result.hashCode();
        result1 = 31 * result1 + msg.hashCode();
        return result1;
    }
}
