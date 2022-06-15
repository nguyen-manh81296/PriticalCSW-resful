package com.example.priticalcswresful.resource;

import com.example.priticalcswresful.entity.Product;
import com.example.priticalcswresful.model.MysqlProductModel;
import com.example.priticalcswresful.model.ProductModel;

import javax.ws.rs.*;
import java.util.List;

@Path("/products")
@Produces("application/json")
@Consumes("application/json")
public class ProductResource {

    ProductModel productModel;

    public ProductResource() {
        productModel = new MysqlProductModel();
    }

    @GET
    public List<Product> fillAll(){
        return productModel.getProducts();
    }

    @POST
    public boolean addProducts(Product product){
        return productModel.addProducts(product);
    }

    @PUT
    @Path("{id}")
    public boolean updateProducts(@PathParam("id") int id, Product updateProduct){
        return productModel.updateProducts(updateProduct, id);
    }
}
