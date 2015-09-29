package com.shelvin.test;

/**
 * Created by shelvin zhou on 2015/1/8.
 */
public class InitField {
    public static void main(String[] args) {
        SuperInitField p = new SuperInitField();
        SuperInitField c = new SubInitField();
        SuperInitField d = new ssSubInitField();
    }
}

class SuperInitField {

    private String par="parpar";

    public SuperInitField() {
        System.out.println("parent");
    }
    static {
        System.out.println("static parent");
    }

}

class SubInitField extends SuperInitField {

    private String chd="chdchd";

    public SubInitField() {
        System.out.println("child");
    }
    static {
        System.out.println("static child");
    }
}

class ssSubInitField extends SubInitField
{
    private String ll="yanjiao";
    public ssSubInitField() {
        System.out.println("grad");
    }
}
