package com.springboot.miaosha.exception;

import com.springboot.miaosha.result.CodeMsg;

/**
 * @Author: lei
 * @Description:
 * @Date: Created in 2019-02-27 20:56
 */
public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private CodeMsg codeMsg;

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }

    public GlobalException(CodeMsg codeMsg) {
        super((codeMsg.toString()));
        this.codeMsg = codeMsg;
    }

}
