#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
#include <stdlib.h>
#include <unistd.h>

sem_t mutex, write_mutex;
int read_count = 0;

void* reader(void* arg)
{
    for (int i = 0; i < 5; i++) {
        sem_wait(&mutex);
        read_count++;
        if (read_count == 1) {
            sem_wait(&write_mutex);
        }
        sem_post(&mutex);

        printf("Reader %d is reading\n", *(int*)arg);
        sleep(1);

        sem_wait(&mutex);
        read_count--;
        if (read_count == 0) {
            sem_post(&write_mutex);
        }
        sem_post(&mutex);
    }
    return NULL;
}

void* writer(void* arg)
{
    for (int i = 0; i < 5; i++) {
        sem_wait(&write_mutex);

        printf("Writer %d is writing\n", *(int*)arg);
        sleep(2);

        sem_post(&write_mutex);
    }
    return NULL;
}

int main()
{
    pthread_t r1, r2, w1, w2;
    int reader_id1 = 1, reader_id2 = 2, writer_id1 = 1, writer_id2 = 2;

    sem_init(&mutex, 0, 1);
    sem_init(&write_mutex, 0, 1);

    pthread_create(&r1, NULL, reader, &reader_id1);
    pthread_create(&r2, NULL, reader, &reader_id2);
    pthread_create(&w1, NULL, writer, &writer_id1);
    pthread_create(&w2, NULL, writer, &writer_id2);

    pthread_join(r1, NULL);
    pthread_join(r2, NULL);
    pthread_join(w1, NULL);
    pthread_join(w2, NULL);

    sem_destroy(&mutex);
    sem_destroy(&write_mutex);

    return 0;
}










/*#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
#include <stdlib.h>
#include <unistd.h>

#define BUFFER_SIZE 5
#define PRODUCE_COUNT 10
#define CONSUME_COUNT 10

int buffer[BUFFER_SIZE]; 
int in = 0;  
int out = 0; 

sem_t empty;  
sem_t full;   
sem_t mutex;  

void* producer(void* arg)
{
    for (int i = 0; i < PRODUCE_COUNT; i++) {
        int item = rand() % 100; 
        sem_wait(&empty); 
        sem_wait(&mutex); 

        buffer[in] = item;
        printf("Produced: %d at index %d\n", item, in);
        in = (in + 1) % BUFFER_SIZE;

        sem_post(&mutex); 
        sem_post(&full);  

        sleep(1); 
    }
    return NULL;
}

void* consumer(void* arg)
{
    for (int i = 0; i < CONSUME_COUNT; i++) {
        sem_wait(&full);  
        sem_wait(&mutex); 

        int item = buffer[out];
        printf("Consumed: %d from index %d\n", item, out);
        out = (out + 1) % BUFFER_SIZE;

        sem_post(&mutex); 
        sem_post(&empty); 

        sleep(1);
    }
    return NULL;
}

int main()
{
    pthread_t prod_thread, cons_thread;

    sem_init(&empty, 0, BUFFER_SIZE);
    sem_init(&full, 0, 0); 
    sem_init(&mutex, 0, 1);

    pthread_create(&prod_thread, NULL, producer, NULL);
    pthread_create(&cons_thread, NULL, consumer, NULL);

    pthread_join(prod_thread, NULL);
    pthread_join(cons_thread, NULL);

    sem_destroy(&empty);
    sem_destroy(&full);
    sem_destroy(&mutex);

    return 0;
}
*/
