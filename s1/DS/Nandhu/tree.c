#include <stdio.h>
#include <stdlib.h>

struct node {
    int item;
    struct node* left;
    struct node* right;
};

// Inorder traversal
void inorderTraversal(struct node* root) {
    if (root == NULL) return;
    inorderTraversal(root->left);
    printf("%d -> ", root->item);
    inorderTraversal(root->right);
}

// Preorder traversal
void preorderTraversal(struct node* root) {
    if (root == NULL) return;
    printf("%d -> ", root->item);
    preorderTraversal(root->left);
    preorderTraversal(root->right);
}

// Postorder traversal
void postorderTraversal(struct node* root) {
    if (root == NULL) return;
    postorderTraversal(root->left);
    postorderTraversal(root->right);
    printf("%d -> ", root->item);
}

// Create a new Node
struct node* createNode(int value) {
    struct node* newNode = (struct node*)malloc(sizeof(struct node));
    newNode->item = value;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

// Check for duplicates
int isDuplicate(struct node* root, int value) {
    if (root == NULL) return 0;
    if (root->item == value) return 1;
    
    return isDuplicate(root->left, value) || isDuplicate(root->right, value);
}

// Insert on the left of the node
struct node* insertLeft(struct node* root, int value) {
    if (root->left == NULL) {
        root->left = createNode(value);
        return root->left;
    } else {
        printf("Left child already exists. Use a different option.\n");
        return NULL;
    }
}

// Insert on the right of the node
struct node* insertRight(struct node* root, int value) {
    if (root->right == NULL) {
        root->right = createNode(value);
        return root->right;
    } else {
        printf("Right child already exists. Use a different option.\n");
        return NULL;
    }
}

// Find a node with a specific value
struct node* findNode(struct node* root, int value) {
    if (root == NULL) return NULL;
    if (root->item == value) return root;
    
    struct node* leftSearch = findNode(root->left, value);
    if (leftSearch != NULL) return leftSearch;
    
    return findNode(root->right, value);
}

void displayMenu() {
    printf("\nMenu:\n");
    printf("1. Insert Left\n");
    printf("2. Insert Right\n");
    printf("3. Inorder Traversal\n");
    printf("4. Preorder Traversal\n");
    printf("5. Postorder Traversal\n");
    printf("6. Exit\n");
}

int main() {
    struct node* root = NULL;
    int choice, value, parentValue;
    struct node* parentNode;

    while (1) {
        displayMenu();
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                if (root == NULL) {
                    printf("Tree is empty. Please create the root first.\n");
                    printf("Enter root value: ");
                    scanf("%d", &value);
                    root = createNode(value);
                }
                printf("Enter parent value to insert left: ");
                scanf("%d", &parentValue);
                parentNode = findNode(root, parentValue);
                if (parentNode != NULL) {
                    printf("Enter value to insert on left: ");
                    scanf("%d", &value);
                    if (!isDuplicate(root, value)) {
                        insertLeft(parentNode, value);
                    } else {
                        printf("Value %d already exists. Cannot insert duplicate.\n", value);
                    }
                } else {
                    printf("Parent node not found.\n");
                }
                break;

            case 2:
                if (root == NULL) {
                    printf("Tree is empty. Please create the root first.\n");
                    printf("Enter root value: ");
                    scanf("%d", &value);
                    root = createNode(value);
                }
                printf("Enter parent value to insert right: ");
                scanf("%d", &parentValue);
                parentNode = findNode(root, parentValue);
                if (parentNode != NULL) {
                    printf("Enter value to insert on right: ");
                    scanf("%d", &value);
                    if (!isDuplicate(root, value)) {
                        insertRight(parentNode, value);
                    } else {
                        printf("Value %d already exists. Cannot insert duplicate.\n", value);
                    }
                } else {
                    printf("Parent node not found.\n");
                }
                break;

            case 3:
                printf("Inorder traversal: ");
                inorderTraversal(root);
                printf("NULL\n");
                break;

            case 4:
                printf("Preorder traversal: ");
                preorderTraversal(root);
                printf("NULL\n");
                break;

            case 5:
                printf("Postorder traversal: ");
                postorderTraversal(root);
                printf("NULL\n");
                break;

            case 6:
                exit(0);

            default:
                printf("Invalid choice. Please try again.\n");
        }
    }

    return 0;
}

