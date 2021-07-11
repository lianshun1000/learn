package com.learn.designPattern.principle.ocp.improve;

/**
 * @author lianshun
 * @date 2021/6/11 1:16 上午
 * @description
 */
public class Ocp {
    public static void main(String[] args) {

    }
}

class GraphicEditor{
    public void drawShape(Shape s){
        s.draw();
    }

}

abstract class Shape{
    int m_type;

    public abstract void draw();
}

class Rectangle extends Shape{
    Rectangle(){
        super.m_type = 1;
    }

    @Override
    public void draw() {
        System.out.println("矩形");
    }
}

class Circle extends Shape{
    Circle(){
        super.m_type = 2;
    }

    @Override
    public void draw() {
        System.out.println("圆形");
    }
}

class Triangle extends Shape{
    Triangle(){
        super.m_type = 3;
    }

    @Override
    public void draw() {
        System.out.println("三角形");
    }
}