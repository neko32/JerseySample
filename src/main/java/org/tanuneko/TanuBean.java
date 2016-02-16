package org.tanuneko;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by neko32 on 2016/02/16.
 */
public class TanuBean {

    private int id;
    private String name;

    public TanuBean() {
        id = -1;
        name = "NA";
    }

    public TanuBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
