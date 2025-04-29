package com.connectacomunidade.application.usecases;

public interface UseCase<Input, Output> {
    Output execute(Input input);
}
