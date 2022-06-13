#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void sort(int *dados, int inicio, int fim)
{
    if (inicio < fim)
    {
        int medio = inicio + (fim - inicio) / 2;
        sort(dados, inicio, medio);
        sort(dados, medio + 1, fim);

        merge(dados, inicio, medio, fim);
    }
}

void merge(int *dados, int inicio, int medio, int fim)
{
    int dir[fim - medio];
    int esq[medio - inicio + 1];

    int sizeEsq = medio - inicio + 1;
    int sizeDir = fim - medio;

    for (int i = 0; i < sizeEsq; i++)
    {
        esq[i] = dados[inicio + i];
    }
    for (int j = 0; j < sizeDir; j++)
    {
        dir[j] = dados[medio + 1 + j];
    }

    int i = 0;
    int j = 0;
    int k = inicio;
    while ((i < sizeEsq) && (j < sizeDir))
    {
        if (esq[i] <= dir[j])
        {
            dados[k] = esq[i];
            i++;
        }
        else
        {
            dados[k] = dir[j];
            j++;
        }
        k++;
    }

    while (i < sizeEsq)
    {
        dados[k] = esq[i];
        i++;
        k++;
    }
    while (j < sizeDir)
    {
        dados[k] = dir[j];
        j++;
        k++;
    }
}

void mediana(int *dados)
{
    int size = len(dados);
    int index = (size - 1) / 2;
    sort(dados, 0, size - 1);

    if (size % 2 == 0)
    {
        printf("Mediana = %.1f", (float)(dados[index] + dados[index + 1]) / 2);
    }
    else
    {
        printf("Mediana = %d", dados[index]);
    }
}

main(int argc, char const *argv[])
{
    int size;
    scanf("%d", &size);

    int dados[size];

    for (int indexI = 0; indexI < size; indexI++)
    {
        dados[indexI] = scanf("%d", &dados[indexI]);
    }

    mediana(dados);
}