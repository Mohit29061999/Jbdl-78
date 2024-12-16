package org.example;

import com.mysql.cj.callback.MysqlCallback;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        MysqlCallback mysqlCallback = new MysqlCallback() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };

    }
}