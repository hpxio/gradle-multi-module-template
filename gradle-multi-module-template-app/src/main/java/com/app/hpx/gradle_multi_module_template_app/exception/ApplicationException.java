package com.app.hpx.gradle_multi_module_template_app.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationException extends Exception {
    private int errorStatus; // HTTP Status Code
    private String errorMessage; // Error Message received from Exception/Throwable
    private String feedbackDescription; // Feedback or Next Step Description for Given Error

    public ApplicationException throwServerException(ApplicationExceptionCodes exceptionCode) {
        return new ApplicationException(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exceptionCode.getErrorMessage(),
                exceptionCode.getFeedbackDescription());
    }
}
