package com.example.priticalcswresful.util;

public class SQLConfig {

    public static final String DATABASE_Product_INSERT = "insert into products ( name, price ) values (?,?)";
    public static final String DATABASE_Product_SELECT = "select * from products";
    public static final String DATABASE_Product_UPDATE = "update products set name = ?, price = ? where id = ?";
}
