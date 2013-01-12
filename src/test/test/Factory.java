package test;

import java.util.ArrayList;
import java.util.List;

public class Factory {
    @SuppressWarnings("unchecked")
    public static List createTree() {
        // 生成国家
        Country cn = new Country("中国");
        Country us = new Country("美国");
        Country jp = new Country("日本");
        // 生成城市
        City beijing = new City("北京");
        City shanghai = new City("上海");
        City newyork = new City("纽约");
        City la = new City("洛杉矶");
        City tokyo = new City("东京");
        City osaka = new City("大阪");
        // 北京人
        ArrayList list = new ArrayList();
        list.add(new People("张三"));
        list.add(new People("李四"));
        list.add(new People("王五"));
        beijing.setChildren(list);
        // 上海人
        list = new ArrayList();
        list.add(new People("翠花"));
        list.add(new People("小红"));
        list.add(new People("小崔"));
        shanghai.setChildren(list);
        // 纽约人
        list = new ArrayList();
        list.add(new People("tom"));
        list.add(new People("rose"));
        list.add(new People("john"));
        newyork.setChildren(list);
        // 洛杉矶人
        list = new ArrayList();
        list.add(new People("Sofia"));
        list.add(new People("sarah"));
        list.add(new People("Jennifer"));
        la.setChildren(list);
        // 东京人
        list = new ArrayList();
        list.add(new People("渡边"));
        list.add(new People("鬼冢"));
        list.add(new People("山本"));
        tokyo.setChildren(list);
        // 大阪人
        list = new ArrayList();
        list.add(new People("奈奈子"));
        list.add(new People("菜菜子"));
        list.add(new People("新垣结衣"));
        osaka.setChildren(list);

        // 关联城市与国家
        // 中国
        ArrayList citys = new ArrayList();
        citys.add(beijing);
        citys.add(shanghai);
        cn.setChildren(citys);
        // 美国
        citys = new ArrayList();
        citys.add(newyork);
        citys.add(la);
        us.setChildren(citys);
        // 日本
        citys = new ArrayList();
        citys.add(tokyo);
        citys.add(osaka);
        jp.setChildren(citys);
        // 国家列表
        ArrayList countrys = new ArrayList();
        countrys.add(cn);
        countrys.add(us);
        countrys.add(jp);
        return countrys;
    }
}