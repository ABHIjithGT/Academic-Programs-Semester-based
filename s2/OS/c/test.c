#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>

sem_t mutex;

void* process_0(void* arg)
{
    for (int i = 0; i < 5; i++) {
        sem_wait(&mutex);
        printf("Process 0 in critical section\n");
        sem_post(&mutex);
    }
    return NULL;
}

void* process_1(void* arg)
{
    for (int i = 0; i < 5; i++) {
        sem_wait(&mutex);
        printf("Process 1 in critical section\n");
        sem_post(&mutex);
    }
    return NULL;
}

int main()
{
    pthread_t thread_0, thread_1;

    sem_init(&mutex, 0, 1);

    pthread_create(&thread_0, NULL, process_0, NULL);
    pthread_create(&thread_1, NULL, process_1, NULL);

    pthread_join(thread_0, NULL);
    pthread_join(thread_1, NULL);

    sem_destroy(&mutex);

    return 0;
}













/*
#include <stdio.h>
#include <stdbool.h>
#include <pthread.h>
#define N 2
int turn;
bool flag[N];
void enter_critical_section(int process)
{
    int other = 1 - process;
    flag[process] = true;
    turn = other;
    while (flag[other] && turn == other);
}
void leave_critical_section(int process)
{
    flag[process] = false;
}
void* process_0(void* arg)
{
    for (int i = 0; i < 5; i++) {
        enter_critical_section(0);
        printf("Process 0 in critical section\n");
        leave_critical_section(0);
    }
    return NULL;
}
void* process_1(void* arg)
{
    for (int i = 0; i < 5; i++) {
        enter_critical_section(1);
        printf("Process 1 in critical section\n");
        leave_critical_section(1);
    }
    return NULL;
}
int main()
{
    pthread_t thread_0, thread_1;
    
    for (int i = 0; i < N; i++) {
        flag[i] = false;
    }

    pthread_create(&thread_0, NULL, process_0, NULL);
    pthread_create(&thread_1, NULL, process_1, NULL);

    pthread_join(thread_0, NULL);
    pthread_join(thread_1, NULL);
    return 0;
}
*/



















