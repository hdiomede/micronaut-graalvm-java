package com.github.hdiomede.micronaut;

import com.fasterxml.jackson.annotation.JsonClassDescription;

@JsonClassDescription
public record TodoItem(
    Long id,
    String title
) {}
