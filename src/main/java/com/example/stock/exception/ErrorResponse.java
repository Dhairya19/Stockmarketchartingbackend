package com.example.stock.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse
{
    public ErrorResponse(String message, int value, long currentTimeMillis) {
		// TODO Auto-generated constructor stub
	}
	private String errorMessage;
    private int statusCode;
    private Long timeHappened;
}
