**Programmer POST Get**
----
This method gets programmer as a serialized byte to the redis

* **URL**

  /programmer-set

* **Method:**

  `GET`
  
*  **URL Params**

  **Required:**
    None


* **Data Params**
  None

* **Success Response:**
  
   * **Code:** 200 <br />
    **Content:** `[{ 'id' : '12', 'name' : "praveen", 'company': 'xyz' }, { 'id' : '14', 'name' : "foo", 'company': 'bar' }]`

 
* **Error Response:**

  * **Code:** 404 File Not Found <br />
    **Content:** `{ error : "Bad Gateway" }`
    
  * **Code:** 500 Internal Server Error <br />
    **Content:** `{ error : "Error Report" }`
