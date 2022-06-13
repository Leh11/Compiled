#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>

typedef struct p
{

    long bin;
    long dec;
    struct p *next;

} Fila;

typedef struct
{
    Fila *begin;
} Head;

void initP(Head *head)
{
    head->begin = NULL;
}

bool isEmpty(Head *head)
{

    return (head->begin == NULL);
}

void push(Head *head, int bin, int dec)
{
    Fila *auxFila = (Fila *)malloc(sizeof(Fila));
    auxFila->bin = bin;
    auxFila->dec = dec;
    auxFila->next = NULL;

    if (isEmpty(head))
    {
        head->begin = auxFila;
    }
    else
    {
        Fila *aux = head->begin;
        Fila *aux1;
        while (aux != NULL)
        {
            aux1 = aux;
            aux = aux->next;
        }
        aux1->next = auxFila;
    }
}

Fila *pop(Head *head)
{
    Fila *aux = head->begin;
    head->begin = aux->next;
    return aux;
}

int convert(Head *head)
{

    Fila *aux;
    int soma = 0;

    while (!isEmpty(head))
    {
        aux = pop(head);
        // printf("Fora: %d %d\n", aux->bin, aux->dec);
        if (aux->bin != 0)
        {
            soma += aux->dec;
            // printf("%d %d\n", aux->bin, aux->dec);
        }
    }
    return soma;
}

void read(Head *head, long num)
{

    long rest;
    long pot = 0;
    while (num != 0)
    {

        rest = num % 10;
        num = num / 10;
        push(head, rest, pow(2, pot++));
        // printf("%ld %ld %f\n", num, rest, pow(2, pot++));
    }
}

int main(int argc, char const *argv[])
{
    Head head;
    initP(&head);
    long num;
    int n;

    scanf("%d", &n);
    scanf("%ld", &num);
    read(&head, num);

    printf("%d\n", convert(&head));
    return 0;
}