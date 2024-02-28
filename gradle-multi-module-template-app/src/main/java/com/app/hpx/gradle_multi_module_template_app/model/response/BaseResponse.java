package com.app.hpx.gradle_multi_module_template_app.model.response;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
    private ErrorResponse errorResponse;

    public boolean hasError() {
        return Objects.isNull(this.errorResponse);
    }
}
