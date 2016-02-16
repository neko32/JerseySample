package org.tanuneko;

/**
 * Created by neko32 on 2016/02/16.
 */
public interface DBAccessor {

    public void init();
    public void exec(String query);
    public String getCode();
}
