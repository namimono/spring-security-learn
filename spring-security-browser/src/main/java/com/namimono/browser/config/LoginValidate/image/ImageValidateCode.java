package com.namimono.browser.config.LoginValidate.image;

import com.namimono.browser.config.LoginValidate.ValidateCode;

import java.awt.image.BufferedImage;

public class ImageValidateCode extends ValidateCode {

    private BufferedImage image;

    public ImageValidateCode(BufferedImage image,String code) {
        super(code);
        this.image = image;
    }

}
