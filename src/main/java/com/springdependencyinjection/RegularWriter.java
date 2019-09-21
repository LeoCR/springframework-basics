package com.springdependencyinjection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("RegularWriter")
public class RegularWriter implements ITextWriter {

	@Override
	public String WriteText(String s) {
		// TODO Auto-generated method stub
		return s.toUpperCase();
	}

}
