package com.ssq.demo.wangyiClass.base.mediaCD;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 苏诗淇
 * @Date 2020/6/6 15:40
 * @Description: 媒体资料库:
 *                  记事本的原理:把字符串放进一个容器中进行解析
 *                  CD的原理:自定义一个类,来表达CD的内容,然后存放到一个容器中去
 *                      数据操作
 */
public class DataBase {
    private List<CD> cdList = new ArrayList<CD>();

    public void add(CD cd){
        cdList.add(cd);
    }


    public void list(){
        for (CD cd : cdList){
            cd.print();
        }
    }

    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        dataBase.add(new CD("张韶涵","张韶涵",4,5,true,"..."));
        dataBase.list();
    }


}
