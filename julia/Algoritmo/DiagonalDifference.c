#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int size;

/* int sum_dow(int matrix[][size]){
    for (int indexI = 0; indexI < size; indexI++)
    {
        printf("%d", abs((size-1) - indexI));
        
    }
    printf("%d", down_diag);
    return down_diag;
} */

int sum_upp(int matrix[][size]){
    int upp_diag = 0;
    int down_diag = 0;

    for (int indexI = 0; indexI < size; indexI++){
        upp_diag += matrix[indexI][indexI];
        down_diag += matrix[indexI][(size - 1) - indexI];
    }
    printf("%d", abs(upp_diag - down_diag));
    return upp_diag;
}

int main(int argc, char const *argv[])
{
    
    scanf("%d", &size);

    int matrix[size][size];

    for (int indexI = 0; indexI < size; indexI++)
    {
        for (int indexJ = 0; indexJ < size; indexJ++)
        {
           scanf("%d", &matrix[indexI][indexJ]);
        }
    }
    
    //print(matrix, size);
    sum_upp(matrix);
    //sum_dow(matrix);
    return 0;
}
