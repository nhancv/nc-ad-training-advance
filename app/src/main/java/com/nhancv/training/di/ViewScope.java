package com.nhancv.training.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by nhancao on 5/29/17.
 */

@Scope
@Retention(RUNTIME)
public @interface ViewScope {
}
