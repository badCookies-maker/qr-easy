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
    public ResponseEntity<byte[]> generateQr(@PathVariable("id") int id, @RequestHeader("host") String host) {

        Product product = productService.getProductById(id);
        String url = "http://" + host + productService.getProductById(id);
        byte[] binaryData = QrCodeBuildHelper.createQrCode(product.getUrlPayload());
        return new ResponseEntity<>(binaryData, HttpStatus.OK);
    }

    @RequestMapping(value = "/decodeByte/{id:.+}", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE)
    public ResponseEntity<byte[]> getDecoderByte(@PathVariable("id")int id, HttpServletResponse response) {
        byte[] textBite = productService.getProductById(id).getFile();
        System.out.println(textBite);
        return ResponseEntity.ok(textBite);
    }

    @RequestMapping(value = "/Image/{id:.+}", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE)
    public void getImage(@PathVariable("id")int id, HttpServletResponse response) throws IOException {
        byte[] image = productService.getProductById(id).getFile();
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        response.getOutputStream().write(image);
    }


}
