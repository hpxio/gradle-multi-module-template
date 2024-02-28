package com.app.hpx.gradle_multi_module_template_app.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ApplicationExceptionCodes {
    APP_GENERIC_ERROR("Generic Server Exception", "Contact developer for more details"),
    APP_CLIENT_ERROR("Client Side Exception", "Client-side communication failure");

    private String errorMessage;
    private String feedbackDescription;
}
