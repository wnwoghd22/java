#pragma warning(disable: 4996)
#define _CLT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main()
{
    FILE* f = fopen("in.txt", "r");
    FILE* out = fopen("out.txt", "w");
    
    //학생 수만큼 문장 읽기를 실행. 몇명이 될지 모른다.
    while(feof(f) == 0)
    {
        char str[100];
        fgets(str, 100, f); //한줄씩 입력을 받는다.
        
        //tab으로 구분된 학생의 이름을 입력받는다.
        char* temp = strtok(str, "\t");
        fputs(temp, out); //이름을 쓴다.
        fputs("\t", out);
        
        int sum = 0;
        int n = 0;
        temp = strtok(NULL, "\t");
        //과목 수만큼 입력받아 n에 과목 수를 저장, sum에 총합 저장.
        while(temp != NULL)
        {
            ++n;
            sum += atoi(temp);
            temp = strtok(NULL, "\t");
        };
        
        int result = sum / n;
        char m[5];
        sprintf(m, "%d", result);
        fputs(m, out); //평군 점수를 쓴다.
        fputs("\t", out);
        
        //등급을 쓴다.
        switch(result)
        {
            case 0 ... 59:
                fputs("F", out);
                break;
            case 60 ... 69:
                fputs("D", out);
                break;
            case 70 ... 79:
                fputs("C", out);
                break;
            case 80 ... 89:
                fputs("B", out);
                break;
            case 90 ... 100:
                fputs("A", out);
                break;
        }
            
        fputs("\n", out);
    }
    
    return 0;
}