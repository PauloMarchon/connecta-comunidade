package com.connectacomunidade.domain.person;

import com.connectacomunidade.domain.validation.ValidationHandler;
import com.connectacomunidade.domain.validation.Validator;

public class PersonValidator extends Validator {
    private final Person person;

    protected PersonValidator(final Person person, ValidationHandler handler) {
        super(handler);
        this.person = person;
    }

    @Override
    public void validate() {
        //TODO
    }
}
