package com.example.assetlogin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ResponseUI<T> {

    public enum Status {
        ERROR, LOADING, SUCCESS
    }

    @NonNull
    public final Status status;

    @Nullable
    public final String message;

    @Nullable
    public final T data;

    @Nullable
    public final List<T> dataList;


    public ResponseUI(@NonNull Status status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
        this.dataList = null;
    }

    public ResponseUI(@NonNull Status status, @Nullable List<T> dataList, @Nullable String message, @Nullable T data) {
        this.status = status;
        this.dataList = dataList;
        this.message = message;
        this.data = data;
    }

    public ResponseUI(Status status) {
        this.status = status;
        this.dataList = null;
        this.message = null;
        this.data = null;
    }

    public static <T> ResponseUI<T> success() {
        return new ResponseUI<>(Status.SUCCESS, null, null);
    }

    public static <T> ResponseUI<T> success(@Nullable T data) {
        return new ResponseUI<>(Status.SUCCESS, data, null);
    }

    public static <T> ResponseUI<T> success(@Nullable List<T> dataList) {
        return new ResponseUI<>(Status.SUCCESS, dataList, null, null);
    }

    public static <T> ResponseUI<T> error(String msg, @Nullable T data) {
        return new ResponseUI<>(Status.ERROR, data, msg);
    }

    public static <T> ResponseUI<T> error(String msg) {
        return new ResponseUI<>(Status.ERROR, null, msg);
    }

    public static <T> ResponseUI<T> loading(@Nullable T data) {
        return new ResponseUI<>(Status.LOADING, data, null);
    }

    public static <T> ResponseUI<T> loading() {
        return new ResponseUI<>(Status.LOADING);
    }

    public static <T> ResponseUI<T> success(String msg) {
        return new ResponseUI<>(Status.SUCCESS, null, msg);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ResponseUI<?> resource = (ResponseUI<?>) o;

        if (status != resource.status) {
            return false;
        }
        if (message != null ? !message.equals(resource.message) : resource.message != null) {
            return false;
        }
        return data != null ? data.equals(resource.data) : resource.data == null;
    }

    @Override
    public int hashCode() {
        int result = status.hashCode();
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

}

