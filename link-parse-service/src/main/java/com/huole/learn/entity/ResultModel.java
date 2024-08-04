package com.huole.learn.entity;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * @author hanning.hn
 * @date 2024/8/3
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ResultModel<T> {

    private Integer status;


    private String message;


    private String devMessage;


    private T data;

    public ResultModel(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }


    @NonNull
    public static <T> ResultModel<T> success(@Nullable String message, @Nullable T data) {
        return new ResultModel<>(HttpStatus.OK.value(), message, data);
    }


    @NonNull
    public static <T> ResultModel<T> success(@Nullable String message) {
        return success(message, null);
    }


    public static <T> ResultModel<T> success(@Nullable T data) {
        return new ResultModel<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), data);
    }
}
