**Programmer String Post**
----
This method saves programmer as a serialized byte to the redis

* **URL**

  /programmer-string

* **Method:**

  `POST`
  
*  **URL Params**
    None

* **Data Params**

  Programmer

* **Success Response:**
  
   * **Code:** 200 <br />
    **Content:** `No Response Body`

 
* **Error Response:**

  * **Code:** 404 File Not Found <br />
    **Content:** `{ error : "Bad Gateway" }`
    
  * **Code:** 500 Internal Server Error <br />
    **Content:** `{ error : "Error Report" }`

* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/programmer-string",
      dataType: "json",
      data: "{'id': '20', 'company': 'foo', 'name': 'baa'}"
      type : "POST",
      success : function() {
        console.log("Success");
      }
    });
  ```
