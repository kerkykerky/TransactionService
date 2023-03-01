# TransactionService

I decided to make it in the style of an accountant has a client, for that client does multiple services each is charged a different amount in REST and JSON format it would look like this  
  
name: Name of client  
types: Types of services

    {
        "name": "Client name surname",
        "types": [
            "type1",
            "type3",
            "type4",
            "type5"
        ]
    }  
   

if it were only one service, like this  
    
    {
        "name": "Client name surname",
        "type": "type1"
    }  
    
Then each client is stored in the database under his name with the date of creation and the resulting amount for services

    [
        {
            "name": "client1",
            "localDate": "2023-03-01",
            "transactionResult": 40
        },
        {
            "name": "client2",
            "localDate": "2023-03-01",
            "transactionResult": 90
        },
        {
            "name": "client3",
            "localDate": "2023-03-01",
            "transactionResult": 45
        }
    ]
    
endpoints are for showing all fees, all results, searching fee by type, searching result by name, adding new fee...  
(of course, if necessary, there is no problem to make other endpoints for editing and deleting)  

JDBC URL : jdbc:h2:mem:fees  
JDBC USERNAME : sa
