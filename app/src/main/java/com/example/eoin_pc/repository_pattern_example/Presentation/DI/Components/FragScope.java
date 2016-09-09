package com.example.eoin_pc.repository_pattern_example.Presentation.DI.Components;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by eoin_pc on 09/09/2016.
 */
@Scope
@Retention(value= RetentionPolicy.RUNTIME)
public @interface FragScope {
}
