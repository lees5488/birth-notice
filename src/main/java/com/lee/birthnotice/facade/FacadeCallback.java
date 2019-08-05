package com.lee.birthnotice.facade;


public interface FacadeCallback<Input, Output> {

	Output doService(Input input);

}