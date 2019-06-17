package cn.yaminets.java_web_class.service;

public interface RedisService {

    //从redis中获取值
    public <T> T getValue(String key,Class<T> value);

    //从redis中设置某个值
    public <T> void setValue(String key,T value);


    public void removeKey(String key);

    public boolean existKey(String key);
}
