package com.example.metaflink;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MySQLGeneratorEntityUtil {
    private String tableName;
    private String[] colNames;
    private String[] colTypes;
    private int[] colSizes;
    private Map colNamesComment = new HashMap();
    private boolean needUtil = false;
    private boolean needSql = false;
    private boolean needBigDecimal = false;
    private boolean needEntityHelper = true;
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final String SQL = "SELECT * FROM ";
    private static final String URL = "jdbc:mysql://localhost:13306/test?useSSL=false";
    private static final String NAME = "root";
    private static final String PASS = "123456";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static String basePath = (new File("")).getAbsolutePath();
    private static String packageOutPath = "com.atguigu.mytestcalss";
    private String authorName = "FelixChan";
    private String[] generateTables = null;
    private static String pk;

    private MySQLGeneratorEntityUtil() {
    }

    private String parse() {
        StringBuffer sb = new StringBuffer();
        sb.append("package " + packageOutPath + ";\r\n");
        sb.append("\r\n");
        if (this.needUtil) {
            sb.append("import java.util.Date;\r\n");
            sb.append("import java.time.*;\r\n");
        }

        if (this.needSql) {
            sb.append("import java.sql.*;\r\n");
        }

        for(int i = 0; i < this.colNames.length; ++i) {
            String hasbd = this.sqlType2JavaType(this.colTypes[i]);
            if (hasbd == "BigDecimal" || "BigDecimal".equals(hasbd)) {
                this.needBigDecimal = true;
            }
        }

        if (this.needBigDecimal) {
            sb.append("import java.math.BigDecimal;\r\n");
        }

        sb.append("/**\r\n");
        sb.append(" * table name:  " + this.tableName + "\r\n");
        sb.append(" * author name: " + this.authorName + "\r\n");
        sb.append(" * create time: " + SDF.format(new Date()) + "\r\n");
        sb.append(" */ \r\n");
        String classExtends = "";
        if (this.needEntityHelper) {
            classExtends = " extends EntityHelper";
        }

        sb.append("public class " + this.under2camel(this.tableName, true) + classExtends + "{\r\n\r\n");
        this.processAllAttrs(sb);
        sb.append("\r\n");
        this.processConstructor(sb);
        this.processAllMethod(sb);
        this.processToString(sb);
        if (this.needEntityHelper) {
            this.processEntityHelper(sb, pk);
        }

        sb.append("}\r\n");
        return sb.toString();
    }

    private void processAllAttrs(StringBuffer sb) {
        for(int i = 0; i < this.colNames.length; ++i) {
            if (this.colNamesComment.get(this.colNames[i]) != null && !"".equals(this.colNamesComment.get(this.colNames[i]))) {
                sb.append("\t/*" + this.colNamesComment.get(this.colNames[i]) + "*/\r\n");
            }

            sb.append("\tprivate " + this.sqlType2JavaType(this.colTypes[i]) + " " + this.colNames[i] + ";\r\n");
        }

    }

    private void processEntityHelper(StringBuffer sb, String pk) {
        sb.append("\t@Override\r\n");
        sb.append("\tpublic String getPrimaryKey() {\r\n");
        sb.append("\t\treturn \"" + pk + "\";\r\n");
        sb.append("\t}\r\n");
    }

    private void processToString(StringBuffer sb) {
        sb.append("\t@Override\r\n\tpublic String toString() {\r\n");
        sb.append("\t\treturn \"" + this.tableName + "[\" + \r\n");

        for(int i = 0; i < this.colNames.length; ++i) {
            if (i != 0) {
                sb.append("\t\t\t\", ");
            }

            if (i == 0) {
                sb.append("\t\t\t\"");
            }

            sb.append(this.colNames[i] + "=\" + " + this.colNames[i]).append(" + \r\n");
            if (i == this.colNames.length - 1) {
                sb.append("\t\t\t\"]\";\r\n");
            }
        }

        sb.append("\t}\r\n");
    }

    private void processConstructor(StringBuffer sb) {
        StringBuffer p = new StringBuffer();
        StringBuffer v = new StringBuffer();

        for(int i = 0; i < this.colNames.length; ++i) {
            p.append(this.sqlType2JavaType(this.colTypes[i]) + " " + this.colNames[i]);
            if (i != this.colNames.length - 1) {
                p.append(",");
            }

            v.append("\t\tthis." + this.colNames[i] + "=" + this.colNames[i] + ";\r\n");
        }

        sb.append("\tpublic " + this.under2camel(this.tableName, true) + "() {\r\n");
        sb.append("\t\tsuper();\r\n");
        sb.append("\t}\r\n");
        sb.append("\tpublic " + this.under2camel(this.tableName, true) + "(" + p.toString() + ") {\r\n");
        sb.append(v.toString());
        sb.append("\t}\r\n");
    }

    private void processAllMethod(StringBuffer sb) {
        for(int i = 0; i < this.colNames.length; ++i) {
            sb.append("\tpublic void set" + this.initCap(this.colNames[i]) + "(" + this.sqlType2JavaType(this.colTypes[i]) + " " + this.colNames[i] + "){\r\n");
            sb.append("\t\tthis." + this.colNames[i] + "=" + this.colNames[i] + ";\r\n");
            sb.append("\t}\r\n");
            sb.append("\tpublic " + this.sqlType2JavaType(this.colTypes[i]) + " get" + this.initCap(this.colNames[i]) + "(){\r\n");
            sb.append("\t\treturn " + this.colNames[i] + ";\r\n");
            sb.append("\t}\r\n");
        }

    }

    private String initCap(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char)(ch[0] - 32);
        }

        return new String(ch);
    }

    private String under2camel(String s, boolean fistCharToUpperCase) {
        String separator = "_";
        String under = "";
        s = s.toLowerCase().replace(separator, " ");
        String[] sarr = s.split(" ");

        for(int i = 0; i < sarr.length; ++i) {
            String w = sarr[i].substring(0, 1).toUpperCase() + sarr[i].substring(1);
            under = under + w;
        }

        if (!fistCharToUpperCase) {
            under = under.substring(0, 1).toLowerCase() + under.substring(1);
        }

        return under;
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
        } else if (!sqlType.equalsIgnoreCase("numeric") && !sqlType.equalsIgnoreCase("real") && !sqlType.equalsIgnoreCase("money") && !sqlType.equalsIgnoreCase("smallmoney")) {
            if (!sqlType.equalsIgnoreCase("varchar") && !sqlType.equalsIgnoreCase("char") && !sqlType.equalsIgnoreCase("nvarchar") && !sqlType.equalsIgnoreCase("nchar") && !sqlType.equalsIgnoreCase("text") && !sqlType.equalsIgnoreCase("longtext")) {
                if (!sqlType.equalsIgnoreCase("datetime") && !sqlType.equalsIgnoreCase("timestamp")) {
                    if (sqlType.equalsIgnoreCase("date")) {
                        return "LocalDate";
                    } else if (sqlType.equalsIgnoreCase("image")) {
                        return "Blod";
                    } else {
                        return sqlType.equalsIgnoreCase("decimal") ? "BigDecimal" : null;
                    }
                } else {
                    return "LocalDateTime";
                }
            } else {
                return "String";
            }
        } else {
            return "double";
        }
    }

    private static String pkgDirName() {
        String dirName = basePath + "/src/" + packageOutPath.replace(".", "/");
        File dir = new File(dirName);
        if (!dir.exists()) {
            dir.mkdirs();
            System.out.println("mkdirs dir 【" + dirName + "】");
        }

        return dirName;
    }

    private void EntityHelper() {
        String dirName = pkgDirName();
        String javaPath = dirName + "/EntityHelper.java";

        try {
            StringBuffer sb = new StringBuffer();
            sb.append("package " + packageOutPath + ";\r\n");
            sb.append("\r\n");
            sb.append("public abstract class EntityHelper{\r\n\r\n");
            sb.append("\tpublic abstract String getPrimaryKey();\r\n");
            sb.append("\r\n");
            sb.append("}\r\n");
            FileWriter fw = new FileWriter(javaPath);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(sb.toString());
            pw.flush();
            if (pw != null) {
                pw.close();
            }

            System.out.println("create class 【EntityHelper】");
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }

    private void generate() throws Exception {
        PreparedStatement pStemt = null;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:13306/test?useSSL=false", "root", "123456");
        System.out.println("connect database success..." + con);
        DatabaseMetaData db = con.getMetaData();
        List<String> tableNames = new ArrayList();
        int j;
        if (this.generateTables == null) {
            ResultSet rs = db.getTables((String)null, (String)null, (String)null, new String[]{"TABLE"});

            while(rs.next()) {
                tableNames.add(rs.getString(3));
            }
        } else {
            String[] var16 = this.generateTables;
            int var6 = var16.length;

            for(j = 0; j < var6; ++j) {
                String tableName = var16[j];
                tableNames.add(tableName);
            }
        }

        if (this.needEntityHelper) {
            this.EntityHelper();
        }

        PrintWriter pw = null;

        for(j = 0; j < tableNames.size(); ++j) {
            this.tableName = (String)tableNames.get(j);
            String tableSql = "SELECT * FROM " + this.tableName;
            pStemt = con.prepareStatement(tableSql);
            ResultSetMetaData rsmd = pStemt.getMetaData();
            ResultSet rsk = con.getMetaData().getPrimaryKeys(con.getCatalog().toLowerCase(), (String)null, this.tableName);
            if (rsk.next()) {
                String primaryKey = rsk.getString("COLUMN_NAME");
                pk = primaryKey;
            }

            int size = rsmd.getColumnCount();
            this.colNames = new String[size];
            this.colTypes = new String[size];
            this.colSizes = new int[size];

            for(int i = 0; i < size; ++i) {
                this.colNames[i] = rsmd.getColumnName(i + 1);
                this.colTypes[i] = rsmd.getColumnTypeName(i + 1);
                if (this.colTypes[i].equalsIgnoreCase("datetime")) {
                    this.needUtil = true;
                }

                if (this.colTypes[i].equalsIgnoreCase("image") || this.colTypes[i].equalsIgnoreCase("text")) {
                    this.needSql = true;
                }

                this.colSizes[i] = rsmd.getColumnDisplaySize(i + 1);
            }

            ResultSet rsComment = pStemt.executeQuery("show full columns from " + this.tableName);

            while(rsComment.next()) {
                this.colNamesComment.put(rsComment.getString("Field"), rsComment.getString("Comment"));
            }

            String content = this.parse();
            String dirName = pkgDirName();
            String javaPath = dirName + "/" + this.under2camel(this.tableName, true) + ".java";
            FileWriter fw = new FileWriter(javaPath);
            pw = new PrintWriter(fw);
            pw.println(content);
            pw.flush();
            System.out.println("create class 【" + this.tableName + "】");
        }

        if (pw != null) {
            pw.close();
        }

    }

    public static void main(String[] args) {
        MySQLGeneratorEntityUtil instance = new MySQLGeneratorEntityUtil();

        try {
            instance.generate();
            System.out.println("generate Entity to classes successful!");
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }
}
