# spring-project

This API provides access to a collection of books and offers the following endpoints:

## **1. Add a Book**

Endpoint: _/api/books_

Method: `POST`

Request Body:

```json
{
  "title": "Alice in Wonderland",
  "author": "John Doe",
  "pageNo": 100,
  "description": "short description"
}
```

Description: Allows you to add a new book to the collection.

## **2. Get All Books**

Endpoint: _/api/books_

Method: `GET`

Description: Retrieves a list of all available books in the collection.

## **3. Update a Book**

Endpoint: _/api/books/{id}_

Method: `PUT`

Request Body:

```json
{
  "title": "New title",
  "author": "New author",
  "pageNo": 10,
  "description": "new description"
}
```

Description: Allows you to update the details of a specific book identified by its unique ID.

## **4. Delete a Book**

Endpoint: _/api/books/{id}_

Method: `DELETE`

Description: Removes a book from the collection based on its unique ID.