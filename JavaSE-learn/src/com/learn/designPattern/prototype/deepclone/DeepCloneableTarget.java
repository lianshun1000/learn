package com.learn.designPattern.prototype.deepclone;

import java.io.Serializable;

/**
 * @author lianshun
 * @date 2021/7/11 2:25 下午
 * @description
 */
public class DeepCloneableTarget implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    private String cloneName;

    private String cloneClass;

    public DeepCloneableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    //因为该类的属性都是String，因此我们这边使用默认的clone完成即可
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
