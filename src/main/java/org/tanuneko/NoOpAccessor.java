package org.tanuneko;

/**
 * Created by neko32 on 2016/02/16.
 */
public class NoOpAccessor implements DBAccessor {

    public NoOpAccessor() {
        System.out.println("NOOP>>>");
    }

    @Override
    public void init() {
        // noop
    }

    @Override
    public void exec(String query) {
        // noop
    }

    @Override
    public String getCode(){ return "NOOPAccessor"; }
}
