# webserviceSOAP-springboot-adityo
Database mySql: 
db= new_schema123 
Table: employee

Endpoint: http://localhost:8080/adityoService

Request:
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:int="http://interfaces.soap.springboot.adityo.com">
   <soapenv:Header/>
   <soapenv:Body>
      <int:addEmployeeRequest>
         <int:employeeInfo>
            <int:employeeId>12345</int:employeeId>
            <int:name>adityo</int:name>
            <int:department>springboot</int:department>
            <int:phone>123456789</int:phone>
            <int:address>cempaka-putih</int:address>
         </int:employeeInfo>
      </int:addEmployeeRequest>
   </soapenv:Body>
</soapenv:Envelope>

Response/Result:
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:addEmployeeResponse xmlns:ns2="http://interfaces.soap.springboot.adityo.com">
         <ns2:serviceStatus>
            <ns2:status>SUCCESS</ns2:status>
            <ns2:message>Content Added Successfully</ns2:message>
         </ns2:serviceStatus>
      </ns2:addEmployeeResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
