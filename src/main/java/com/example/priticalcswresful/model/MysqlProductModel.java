package com.example.priticalcswresful.model;

import com.example.priticalcswresful.entity.Product;
import com.example.priticalcswresful.util.ConnectionHelper;
import com.example.priticalcswresful.util.SQLConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MysqlProductModel implements ProductModel{
    @Override
    public List<Product> getProducts() {
        List<Product> listObj = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlSelect = SQLConfig.DATABASE_Product_SELECT;
            PreparedStatement statement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
               Product obj = new Product(id, name,price);
                listObj.add(obj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listObj;
    }

    @Override
    public boolean addProducts(Product e) {
        try
        {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConfig.DATABASE_Product_INSERT);
            preparedStatement.setString(1, e.getName());
            preparedStatement.setDouble(2, e.getPrice());
            preparedStatement.execute();
            return true;
        }catch(SQLException | ClassNotFoundException s){
            s.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateProducts(Product e, int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLConfig.DATABASE_Product_UPDATE);
            statement.setString(1, e.getName());
            statement.setDouble(2, e.getPrice());
            statement.setInt(3, id);
            statement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
        }
        return false;
    }

}
