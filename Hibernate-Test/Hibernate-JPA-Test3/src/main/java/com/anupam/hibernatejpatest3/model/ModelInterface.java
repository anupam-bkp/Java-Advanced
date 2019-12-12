package com.anupam.hibernatejpatest3.model;

public interface ModelInterface {

	int ID_COLUMN_SIZE = 36;

	int STANDARD_COLUMN_SIZE = 64;

	int PASSWORD_HASH_COLUMN_SIZE = 64;

	int TEXT_COLUMN_SIZE = 512;

	String ALPHANUM_PATTERN = "[A-Za-z0-9_.+-]*";

	String STRING_PATTERN = "[^.(),]*";

	String getId();

}
