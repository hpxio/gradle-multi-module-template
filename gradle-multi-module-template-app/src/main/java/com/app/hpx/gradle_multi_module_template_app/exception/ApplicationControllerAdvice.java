package com.app.hpx.gradle_multi_module_template_app.exception;

import com.app.hpx.gradle_multi_module_template_app.model.response.BaseResponse;
import com.app.hpx.gradle_multi_module_template_app.model.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class ApplicationControllerAdvice extends ResponseEntityExceptionHandler {

    private static final String GENERAL_FEEDBACK_DESC =
            "Unhandled exception occurred in application, please contact the developer.";

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<BaseResponse> applicationExceptionGlobalHandler(
            ApplicationException applicationException) {
        log.error("Exception occurred in application : ", applicationException);
        return getErrorBaseResponse(
                applicationException.getErrorStatus(),
                applicationException.getMessage(),
                applicationException.getFeedbackDescription());
    }

    /* TODO: MethodArginvalidExceptino + MethodNotAllowed Exception TBD */

    /* General uncaught types exception */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse> uncaughtGeneralApplicationExceptionGlobalHandler(
            Exception ex) {
        log.error("Unhandled exception occurred in application : ", ex);
        return getErrorBaseResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), GENERAL_FEEDBACK_DESC);
    }

    private ResponseEntity<BaseResponse> getErrorBaseResponse(
            int httpStatus, String message, String description) {
        BaseResponse baseResponse = new BaseResponse();
        ErrorResponse errorResponse = new ErrorResponse(message, description);

        baseResponse.setErrorResponse(errorResponse);
        return ResponseEntity.status(httpStatus).body(baseResponse);
    }
}
