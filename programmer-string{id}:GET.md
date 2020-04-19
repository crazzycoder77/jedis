**Programmer String Post**
----
This method saves programmer as a serialized byte to the redis

* **URL**

  /programmer-string/{id}

* **Method:**

  `GET`
  
*  **URL Params**

  **Required:**
  `id=[integer]`


* **Data Params**

  None

* **Success Response:**
  
   * **Code:** 200 <br />
    **Content:** `{ id : 12, name : "praveen", 'company': 'xyz' }`

 
* **Error Response:**

  * **Code:** 404 File Not Found <br />
    **Content:** `{ error : "Bad Gateway" }`
    
  * **Code:** 500 Internal Server Error <br />
    **Content:** `{ error : "Error Report" }`

