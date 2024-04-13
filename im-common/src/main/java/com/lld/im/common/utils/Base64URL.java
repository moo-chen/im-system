package com.lld.im.common.utils;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @description: Base64 URL 编码解码工具类
 * @author: lld
 * @version: 1.0
 */
public class Base64URL {
    public static byte[] base64EncodeUrl(byte[] input) {
        byte[] base64 = Base64.getEncoder().encode(input);
        for (int i = 0; i < base64.length; ++i) {
            switch (base64[i]) {
                case '+':
                    base64[i] = '*';
                    break;
                case '/':
                    base64[i] = '-';
                    break;
                case '=':
                    base64[i] = '_';
                    break;
                default:
                    break;
            }
        }
        return base64;
    }

    public static byte[] base64EncodeUrlNotReplace(byte[] input) {
        byte[] base64 = Base64.getEncoder().encode(input);
        for (int i = 0; i < base64.length; ++i) {
            switch (base64[i]) {
                case '+':
                    base64[i] = '*';
                    break;
                case '/':
                    base64[i] = '-';
                    break;
                case '=':
                    base64[i] = '_';
                    break;
                default:
                    break;
            }
        }
        return base64;
    }

    public static byte[] base64DecodeUrlNotReplace(byte[] input) {
        byte[] base64 = input.clone();
        for (int i = 0; i < base64.length; ++i) {
            switch (base64[i]) {
                case '*':
                    base64[i] = '+';
                    break;
                case '-':
                    base64[i] = '/';
                    break;
                case '_':
                    base64[i] = '=';
                    break;
                default:
                    break;
            }
        }
        return Base64.getDecoder().decode(base64);
    }

    public static byte[] base64DecodeUrl(byte[] input) {
        byte[] base64 = input.clone();
        for (int i = 0; i < base64.length; ++i) {
            switch (base64[i]) {
                case '*':
                    base64[i] = '+';
                    break;
                case '-':
                    base64[i] = '/';
                    break;
                case '_':
                    base64[i] = '=';
                    break;
                default:
                    break;
            }
        }
        return Base64.getDecoder().decode(base64);
    }
}
