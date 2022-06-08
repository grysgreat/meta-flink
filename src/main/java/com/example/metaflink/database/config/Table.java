/**
 * Copyright 2020-9999 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.metaflink.database.config;

import java.io.Serializable;
import java.util.List;

/**
 * @author binghe
 * @version 1.0.0
 * @description 数据表
 */
public class Table implements Serializable {

    // 表名
    private String name;
    private String sqlType;
    private String javaContext;

    public String getSqlType() {
        return sqlType;
    }

    public void setSqlType(String sqlType) {
        this.sqlType = sqlType;
    }

    /**
     * 属性字段
     * 格式：[{"name":"ID","typeName":"INT","type":"4"},{"name":"NAME","typeName":"VARCHAR","type":"12"}]
     */
    private List<Field> column;

    // 总数
    private long count;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Table{" +
                "name='" + name + '\'' +
                ", sqlType='" + sqlType + '\'' +
                ", column=" + column +
                ", count=" + count +
                '}';
    }

    public Table setName(String name) {
        this.name = name;
        return this;
    }

    public List<Field> getColumn() {
        return column;
    }

    public Table setColumn(List<Field> column) {
        this.column = column;
        return this;
    }

    public String getJavaContext() {
        return javaContext;
    }

    public void setJavaContext(String javaContext) {
        this.javaContext = javaContext;
    }

    public long getCount() {
        return count;
    }


    public void setCount(long count) {
        this.count = count;
    }


    public String Convert2JavaObject(){
        String javaObject ="";
        javaObject+="import java.time.LocalDate;\n";
        javaObject+="public class "+initCap(this.name)+"{\t\n";
        //空构造

        //设置字段
        for (Field names : this.column){
            javaObject +="public " +sqlType2JavaType(names.getTypeName()) +" "+ names.getName()+";\t\n";
        }

        //生成get/set
        for (Field names : this.column){
            javaObject +="public "+sqlType2JavaType(names.getTypeName()) +" get" + initCap(names.getName())+"(){\t\n";
            javaObject +="return this."+names.getName()+";\n";
            javaObject +="}\t\n";
        }

        for (Field names : this.column){
            javaObject +="public void set" + initCap(names.getName())+"("+sqlType2JavaType(names.getTypeName())+" "+names.getName()+"){\t\n";
            javaObject +="\t this."+names.getName()+"="+names.getName()+";\t\n";
            javaObject +="}\t\n";
        }
        //重写toString
        javaObject+="\t@Override\r\n\tpublic String toString() {\r\n return " +
                "\""+this.name +"[\" +";
        for (Field names : this.column){
            javaObject+="\""+names.getName()+":"+"\" +"+names.getName()+"+\",\"+";
        }
        javaObject+="\"]\";\t\n}";



        javaObject+="\t\n}";

        this.javaContext =javaObject;
        return javaObject;
    }

    private String sqlType2JavaType(String sqlType) {
        if (sqlType.equalsIgnoreCase("bit")) {
            return "boolean";
        } else if (sqlType.equalsIgnoreCase("tinyint")) {
            return "byte";
        } else if (sqlType.equalsIgnoreCase("smallint")) {
            return "short";
        } else if (sqlType.equalsIgnoreCase("int")) {
            return "int";
        } else if (sqlType.equalsIgnoreCase("bigint")) {
            return "long";
        } else if (sqlType.equalsIgnoreCase("float")) {
            return "float";
        } else if (sqlType.equalsIgnoreCase("numeric")
                || sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money")
                || sqlType.equalsIgnoreCase("smallmoney")) {
            return "double";
        } else if (sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char")
                || sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")
                || sqlType.equalsIgnoreCase("text")|| sqlType.equalsIgnoreCase("longtext")) {
            return "String";
        } else if (sqlType.equalsIgnoreCase("datetime") || sqlType.equalsIgnoreCase("timestamp")) {
            return "LocalDateTime";
        }else if (sqlType.equalsIgnoreCase("date")) {
            return "LocalDate";
        } else if (sqlType.equalsIgnoreCase("image")) {
            return "Blod";
        }else if (sqlType.equalsIgnoreCase("decimal")) {
            return "BigDecimal";
        }
        return null;
    }
    /**
     * @param str 传入字符串
     * @return
     * @description 将传入字符串的首字母转成大写
     */
    private String initCap(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z')
            ch[0] = (char) (ch[0] - 32);
        return new String(ch);
    }
}
