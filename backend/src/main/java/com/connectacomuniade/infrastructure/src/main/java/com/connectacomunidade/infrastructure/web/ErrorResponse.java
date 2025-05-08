package com.connectacomunidade.infrastructure.web;

public record ErrorResponse(
        int status,
        String error,
        String message
) {
}
