package test;

import java.util.List;

public interface Itree {
    public String getName();

    public void setName(String name);

    public void setChildren(List Children);

    public List getChildren();
}