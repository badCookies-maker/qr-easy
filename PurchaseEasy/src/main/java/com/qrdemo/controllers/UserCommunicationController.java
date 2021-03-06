package com.qrdemo.controllers;

import com.qrdemo.entities.Product;
import com.qrdemo.helpers.QrCodeBuildHelper;
import com.qrdemo.services.ProductServiceImpl;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("share")
public class UserCommunicationController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping(value = "qrcode/{id}", produces = {MediaType.IMAGE_JPEG_VALUE})
    public ResponseEntity<byte[]> generateQr(@PathVariable("id") int id) {
        Product product = productService.getProductById(id);
        byte[] binaryData = QrCodeBuildHelper.createQrCode(product.getUrlPayload());
        return new ResponseEntity<>(binaryData, HttpStatus.OK);
    }

}
