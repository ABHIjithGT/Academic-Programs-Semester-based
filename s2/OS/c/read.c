#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>
sem_t mutex, wrt;
int read_count = 0;
void* reader(void* param) {
    int id = *(int*)param;
    while (1) {
        sem_wait(&mutex);
        read_count++;
        if (read_count == 1) sem_wait(&wrt);
        sem_post(&mutex);        
        printf("Reader %d is reading\n", id);
        sleep(1);
        sem_wait(&mutex);
        read_count--;
        if (read_count == 0) sem_post(&wrt);
        sem_post(&mutex);        
        sleep(1);
    }
}
void* writer(void* param) {
    int id = *(int*)param;
    while (1) {
        sem_wait(&wrt);
        printf("Writer %d is writing\n", id);
        sleep(2);
        sem_post(&wrt);
        sleep(1);
    }
}
int main() {
    pthread_t readers[5], writers[3];
    int reader_ids[5] = {1, 2, 3, 4, 5};
    int writer_ids[3] = {1, 2, 3};
    sem_init(&mutex, 0, 1);
    sem_init(&wrt, 0, 1);
    for (int i = 0; i < 5; i++) pthread_create(&readers[i], NULL, reader, &reader_ids[i]);
    for (int i = 0; i < 3; i++) pthread_create(&writers[i], NULL, writer, &writer_ids[i]);
    for (int i = 0; i < 5; i++) pthread_join(readers[i], NULL);
    for (int i = 0; i < 3; i++) pthread_join(writers[i], NULL);
    sem_destroy(&mutex);
    sem_destroy(&wrt);
    return 0;
}
