package com.example.TM30;

import com.example.TM30.controller.productController.ProductController;
import com.example.TM30.product.dto.ProductRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
//@Transactional
public class ProductControllerTests {

    @Autowired
    private ProductController productController;

    private ProductRequestDto productRequestDto;

    @Autowired
    private MockMvc mockMvc;

    private static final int productId = 126;

    private static final String productName = "CloseUp Toothpaste";

    @Autowired
    private ObjectMapper objectMapper;


    @Before
    public void setUp(){
        productRequestDto = new ProductRequestDto(productId, productName);
    }

    private void performGetAllProducts(int expectedStatus) throws Exception {
        mockMvc.perform(get("/products")
                .contentType(MediaType.TEXT_PLAIN)
        ).andExpect(status().is(expectedStatus));
    }

    private void performGetProductWithId(int expectedStatus) throws Exception {
        mockMvc.perform(get("/products/123").contentType(MediaType.TEXT_PLAIN)).andExpect(status().is(expectedStatus));
    }

    private void performCreateNewProduct(int expectedStatus) throws Exception {
        mockMvc.perform(post("/products").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productRequestDto))
        ).andExpect(status().is(expectedStatus));
    }
    private void performUpdateProductWithId(int expectedStatus) throws Exception {
        mockMvc.perform(put("/products/123").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productRequestDto))
        ).andExpect(status().is(expectedStatus));
    }

    private void performDeleteProductWithId(int expectedStatus) throws Exception {
        mockMvc.perform(delete("/products/123").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productRequestDto))
        ).andExpect(status().is(expectedStatus));
    }

    @Test
    public void productControllerTest_getAllProduct() throws Exception{
        performGetAllProducts(200);
    }

    @Test
    public void productControllerTest_getProductWithId() throws Exception {
        performGetProductWithId(302);
    }

    @Test
    public void productControllerTest_createNewProduct() throws  Exception {
        performCreateNewProduct(201);
    }

    @Test
    public void productControllerTest_updateProductWithID() throws Exception {
        performUpdateProductWithId(202);
    }

    @Test
    public void productControllerTest_deleteProductWithID() throws Exception {
        performDeleteProductWithId(200);
    }

}
