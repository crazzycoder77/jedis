**Programmer LIST Count**
----
This method gets programmer as a serialized byte to the redis

* **URL**

  /programmer-list/count

* **Method:**

  `GET`
  
*  **URL Params**

  **Required:**
    None


* **Data Params**
  None

* **Success Response:**
  
   * **Code:** 200 <br />
    **Content:** `2`

 
* **Error Response:**

  * **Code:** 404 File Not Found <br />
    **Content:** `{ error : "Bad Gateway" }`
    
  * **Code:** 500 Internal Server Error <br />
    **Content:** `{ error : "Error Report" }`
