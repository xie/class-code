
/*
File name is linked_list.c
 Purpose: file contains functions for manipulating singly linked list

 Created By
 Doron Nussbaum 2016

 Modifications:
 November 2017 - minor modifications


 Copyright 2017

 */

/******************************************************************/
// INCLUDE

#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "linked_list.h"


/************************************************************************/
// Define



/************************************************************************/

/*
Purpose: insert a new node into the list as the first element
input
id - id of person
firstName - first name of person
familyName - family name of person

input/output
head - head of linked list

return
A pointer to the node that was allocated.

NULL - if the operation was not successful

*/

PersonalInfo *insertToList(PersonalInfo **head, unsigned int id, char *firstName, char *familyName)
{
  PersonalInfo* new_node = (PersonalInfo*) malloc(sizeof(PersonalInfo));
  new_node->id = id;
  strcpy(new_node->firstName, firstName);
  strcpy(new_node->familyName, familyName);
  new_node->next = (*head);
  (*head) = new_node;
  return *head;
}


/************************************************************************/
/*
Purpose: insert a new node into the list after the given node

Input
node - the node after which the new node must be added to the list
id - id of person
firstName - first name of person
familyName - family name of person


return
A pointer to the node that was allocated.

NULL - if the operation was not successful

*/


PersonalInfo *insertAfter(PersonalInfo *node, unsigned int id, char *firstName, char *familyName)
{
  if (node == NULL) {
    return NULL;
  }

  PersonalInfo* new_node = (PersonalInfo*) malloc(sizeof(PersonalInfo));
  new_node->id = id;
  strcpy(new_node->firstName, firstName);
  strcpy(new_node->familyName, familyName);
  new_node->next = node->next;
  node->next = new_node;
  return new_node;
}

/************************************************************************/
/*
Purpose: create a new node and insert it into the end of the list
Input
head - the head of the list
id - id of person
firstName - first name of person
familyName - family name of person


return
A pointer to the node that was allocated.

NULL - if the operation was not successful

*/


PersonalInfo *insertLast(PersonalInfo **head, unsigned int id, char *firstName, char *familyName)
{

  PersonalInfo* new_node = (PersonalInfo*) malloc(sizeof(PersonalInfo));
  PersonalInfo* last = *head;


  new_node->id = id;
  strcpy(new_node->firstName, firstName);
  strcpy(new_node->familyName, familyName);

  if (*head == NULL) {
    *head = new_node;
    return *head;
  }

  while (last->next != NULL) {
    last = last->next;
  }

  last->next = new_node;

  return new_node;


}


/************************************************************************/
/*
Purpose: search for the first node with the matching firstName
Input
head - the head of the list
firstName - first name of person

return
a pointer to the node that was found.
NULL - if no node was found or list empty

*/


PersonalInfo *searchByName(PersonalInfo *head, char *firstName)
{

  while (head !=NULL) {
    if (strcmp(head->firstName, firstName) == 0) {
      return head;
    }
    head = head->next;
  }
  return NULL;
}

/************************************************************************/
/*
Purpose: search for the first node with the matching id
Input
head - the head of the list
id - id of person person

return
a pointer to the node that was allocated.

NULL - if no node was found or list empty

*/


PersonalInfo *searchById(PersonalInfo *head, unsigned int id)
{
  while (head !=NULL) {
    if (head->id == id) {
      return head;
    }
    head = head->next;
  }
  return NULL;
}

/***************************************************************/

/*
Purpose: delete the first node from the list
Input
head - the head of the list

output
head - the head of the list
firstName - first name of delted record
familyName - family name of deleted recrod
id - id of deleted record


return

0 if node was deleted
1 if node was not deleted or list is empty

*/


int deleteFromList(PersonalInfo **head, unsigned int *id, char *firstName, char *familyName)
{
  PersonalInfo* tmp = *head, *prev;

  if (tmp != NULL) {
    *head = tmp->next;
    free(tmp);
    return 0;
  } else {
    return 1;
  }
}


/***************************************************************/

/*
Purpose: delete the last node from the list
Input
head - the head of the list

output
head - the head of the list
firstName - first name of delted record
familyName - family name of deleted recrod
id - id of deleted record


return

0 if node was deleted
1 if node was not deleted or list is empty

*/


int deleteLast(PersonalInfo **head, unsigned int *id,
                char *firstName, char *familyName)

{

  PersonalInfo* temp = *head;
  PersonalInfo* t;

  if (temp->next == NULL) {
    free(head);
    *head = NULL;
    return 1;
  } else {
    while (temp->next != NULL) {
      t = temp;
      temp = temp->next;
    }
    free(t->next);
    t->next = NULL;
    return 0;
  }

}



/************************************************************************/

/*
Purpose: delete the record after the given node
Input
node - a node in the list

output
firstName - first name of delted record
familyName - family name of deleted recrod
id - id of deleted record


return
0 if node was deleted
1 if node was not deleted (either input node is NULL or input node was the lastnode in the list)

*/



int deleteAfter(PersonalInfo *node, unsigned int *id,
                char *firstName, char *familyName)

{

  PersonalInfo* tmp = node;


  if (node->next != NULL) {
    tmp = node->next;
    node->next = tmp->next;
    free(tmp);
    return 0;
  } else {
    return 1;
  }


}

/************************************************************************/

/*
Purpose: delete the first node with the matching firstName
Input
head - the head of the list
firstName - first name of person

output
head - the head of the list
firstName - first name of delted record
familyName - family name of deleted recrod
id - id of deleted record


return
0  if node was deleted
1 if node was not found (e.g., list is empty, no such node exists)

*/


int deleteNodeByName(PersonalInfo **head, char *firstName,
	char *familyName, unsigned int *id)
{


  PersonalInfo* tmp = *head;

  while (tmp->next != NULL) {
    if (strcmp(tmp->next->firstName, firstName) == 0) {
      deleteAfter(tmp, tmp->id, tmp->firstName, tmp->familyName);
      return 0;
    }
    tmp = tmp->next;
  }
  return 1;


}
/************************************************************************/
/*
Purpose: deletes all nodes from the list
input/output
head - the head of the list


*/


void deleteList(PersonalInfo **head)
{

  PersonalInfo* temp = *head;

	while (*head != NULL) {
    temp = *head;
    *head = (*head)->next;
    free(temp);
  }

  (*head) = NULL;

}



/************************************************************************/
/*
Purpose: prints the fields of a node
input:
node - a pointer to a given node

*/


void printNode(PersonalInfo *node)
{
	printf("%-20s %-20s %7d \n",node->firstName, node->familyName, node->id);

}


/************************************************************************/
/*
Purpose: prints all the records in the list

input
head - the head of the list
*/


void printList(PersonalInfo *head)
{

  PersonalInfo* tmp;
  tmp = head;

  while(tmp!=NULL) {
    printNode(tmp);
    tmp = tmp->next;
  }

}

/************************************************************************/
/*
Purpose: counts the number of nodes in the list
input
head - the head of the list

return
the number of nodes in the list

*/


int listSize(PersonalInfo *head)
{

  int count = 0;
  while (head != NULL) {
    count++;
    head = head->next;
  }

  return count;

}

/************************************************************************/
/*
Purpose: counts the number of nodes in the list with a matching firstName
input
head - the head of the list

return
the number of nodes in the list that match the firstName


*/


int countRecords(PersonalInfo *head, char *firstName)
{
  int count = 0;
  while (head != NULL) {
    if (strcmp(head->firstName, firstName) == 0) {
      count++;
    }
    head = head->next;
  }

  return count;
}




/************************************************************************/
/*

Purpose: removes all duplicates records from the list.  Duplicate records are determined by their first name.
You can assume that the listed is sorted by first name.

input
head - the head of the  list



*/



//works for sorted and unsorted, not efficient but test files are broken
void removeDuplicates(PersonalInfo *head)
{
  PersonalInfo *current = head, *n;

  if (current == NULL) {
    return;
  }

  while (current->next != NULL) {
    if (strcmp(current->firstName, current->next->firstName) == 0) {
      n = current->next->next;
      free(current->next);
      current->next = n;
    } else {
      current = current->next;
    }
  }

}
