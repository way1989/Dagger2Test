package com.ape.dagger2;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by way on 2017/9/11.
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface ApplicationQualifier {
}
