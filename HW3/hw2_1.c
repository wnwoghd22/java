#include <stdio.h>

void main()
{
	char* color = "blue";
	char* favor = "sleeping";

	printf("My favorite color is %s. I like %s.\n", color, favor);
	printf("I love %s. \n", favor);

	int uncle_age = 50;
	int aunt_age = 45;

	printf("My uncle is %d years old. My aunt is %d years old.\n", uncle_age, aunt_age);
	printf("The sum of their ages is %d.", uncle_age + aunt_age);

	return 0;
}