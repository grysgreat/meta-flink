package com.example.metaflink;

import com.itranswarp.compiler.JavaStringCompiler;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

//
//public class ClassRuner {
//
//    public static Object run(String source, String...args) throws Exception {
//
//// 声明类名
//        String className = "Main";
//        String packageName = "top.fomeiherz";
//// 声明包名：package top.fomeiherz;
//        String prefix = String.format("package %s;", packageName);
//// 全类名：top.fomeiherz.Main
//        String fullName = String.format("%s.%s", packageName, className);
//// 编译器
//        JavaStringCompiler compiler = new JavaStringCompiler();
//// 编译：compiler.compile("Main.java", source)
//        Map results = compiler.compile(className + ".java", prefix + source);
//// 加载内存中byte到Class>对象
//        Class clazz = compiler.loadClass(fullName, results);
//// 创建实例
//        Object instance = clazz.newInstance();
//        Method mainMethod = clazz.getMethod("main", String[].class);
//// String[]数组时必须使用Object[]封装
//// 否则会报错：java.lang.IllegalArgumentException: wrong number of arguments
//        return mainMethod.invoke(instance, new Object[]{args});
//    }
//
//    public static void main(String[] args) throws Exception {
//        // 传入String类型的代码
//        String sourcse = "import java.util.Arrays;" +
//                "public class Main" +
//                "{" +
//
//                "public static void main(String[] args) {" +
//
//                "System.out.println(Arrays.toString(args));" +
//
//                "}" +
//
//                "}";
//        ClassRuner.run(sourcse, "1", "2");
//    }
//
//
//
//}

