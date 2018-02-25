/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw4.validator;

import com.hw4.pojo.Movie;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 *
 * @author lvsho
 */
public class MovieValidator implements Validator{
    @Override
    public boolean supports(Class<?> type) {
        return type.isAssignableFrom(Movie.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "empty-title", "title cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actor", "empty-actor", "actor cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actress", "empty-actress", "actress cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genre", "empty-genre", "genre cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "empty-year", "year cannot be blank");

    }
}
