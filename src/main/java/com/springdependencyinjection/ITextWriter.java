package com.springdependencyinjection;

import org.springframework.stereotype.Component;

@Component
public interface ITextWriter {
	public String WriteText(String s);
}
