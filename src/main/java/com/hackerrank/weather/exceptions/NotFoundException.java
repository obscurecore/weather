package com.hackerrank.weather.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class NotFoundException extends RuntimeException {
	private final String errorType;
	private String message;
}
