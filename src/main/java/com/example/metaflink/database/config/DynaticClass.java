package com.example.metaflink.database.config;

public class DynaticClass {
   public String ClassName;
   public String javacontext;
   public int id;
    public DynaticClass(){}

    public DynaticClass(String className, String javacontext, int id) {
        ClassName = className;
        this.javacontext = javacontext;
        this.id = id;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public String getJavacontext() {
        return javacontext;
    }

    public void setJavacontext(String javacontext) {
        this.javacontext = javacontext;
    }

    @Override
    public String toString() {
        return "DynaticClass{" +
                "ClassName='" + ClassName + '\'' +
                ", javacontext='" + javacontext + '\'' +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
