package info.zhiqing.forus.models;

/**
 * Created by zhiqing on 17-9-17.
 */
public class Response<T> {
    boolean error;
    String message;
    T result;
}
