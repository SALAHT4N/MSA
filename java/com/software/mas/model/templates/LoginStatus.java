package com.software.mas.model.templates;
/*
 * @param correct :
 * represent the status of the login action is it Correct or not.
 * @param lvl :
 * represent the user level for the one have pressed the login button.
 * 0 -> Customer. 1 -> User.
 * */
public record LoginStatus(boolean correct, int lvl){}
