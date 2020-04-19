**Is Programmer**
----
This method gets programmer as a serialized byte to the redis

* **URL**

  /isProgrammer

* **Method:**

  `POST`
  
*  **URL Params**

  **Required:**
    None


* **Data Params**
  Programmer

* **Success Response:**
  
   * **Code:** 200 <br />
    **Content:** `true` or `false`

 
* **Error Response:**

  * **Code:** 404 File Not Found <br />
    **Content:** `{ error : "Bad Gateway" }`
    
  * **Code:** 500 Internal Server Error <br />
    **Content:** `{ error : "Error Report" }`
* **Sample Call:**

  ```javascript
    $.ajax({
      url: "/isProgrammer",
      dataType: "json",
      data: "{ 'id' : '12', 'name' : "praveen", 'company': 'xyz' }"
      type : "POST",
      success : function() {
        console.log("Success");
      }
    });
  ```
