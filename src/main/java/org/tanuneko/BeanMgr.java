package org.tanuneko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.*;

/**
 * Created by neko32 on 2016/02/16.
 */
@Component
public class BeanMgr {
    private Map<Integer,TanuBean> beans;
    private final DBAccessor persister;

    @Inject
    public BeanMgr(DBAccessor persister) {
        beans = new HashMap<>();
        this.persister = persister;
        System.out.println("Persister is set --- " + persister.getCode());
        sampleGen();
    }

    public Optional<TanuBean> get(int id) {
        return Optional.of(beans.get(id));
    }

    public void add(int id, String name) {
        beans.put(id, new TanuBean(id, name));
    }

    public void delete(int id) {
        beans.remove(id);
    }

    public boolean update(int id, String name) {
        if(!beans.containsKey(id)) return false;
        else {
            beans.put(id, new TanuBean(id, name));
            return true;
        }
    }

    public void sampleGen() {
        beans.put(1, new TanuBean(1, "Tanuchan"));
        beans.put(2, new TanuBean(2, "Ushichan"));
        beans.put(100, new TanuBean(100, "Torachan"));
        beans.put(101, new TanuBean(101, "Mikechan"));
    }
}
